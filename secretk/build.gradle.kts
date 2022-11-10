import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    @Suppress("DSL_SCOPE_VIOLATION")
    val libs = libs
    alias(libs.plugins.org.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.io.github.luca992.multiplatform.swiftpackage)
    alias(libs.plugins.com.vanniktech.maven.publish)
}

group = project.property("GROUP") as String
version = project.property("VERSION_NAME") as String

object Targets {

    val iosTargets = arrayOf(
        "iosArm64", "iosX64", "iosSimulatorArm64",
    )
    val macosTargets = arrayOf(
        "macosX64", "macosArm64",
    )
    val darwinTargets = iosTargets + macosTargets
    val linuxTargets = arrayOf<String>()
    val mingwTargets = arrayOf<String>()
    val nativeTargets = linuxTargets + darwinTargets + mingwTargets

}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
    }
    js(IR) {
        browser {
            testTask {
                useMocha {
                    timeout = "20s"
                }
            }
        }
    }
    val darwinTargets = mutableListOf<KotlinNativeTarget>()
    macosX64 {
        darwinTargets.add(this)
    }
    macosArm64 {
        darwinTargets.add(this)
    }
    iosX64 {
        darwinTargets.add(this)
    }
    iosArm64 {
        darwinTargets.add(this)
    }
    iosSimulatorArm64 {
        darwinTargets.add(this)
    }
    darwinTargets.forEach {
        it.apply {
            binaries.framework()
        }
    }
//    linuxX64()

    sourceSets {
        all {
            languageSettings.optIn("kotlin.ExperimentalUnsignedTypes")
            languageSettings.optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
            languageSettings.optIn("kotlinx.serialization.ExperimentalSerializationApi")
        }
        val commonMain by getting {
            dependencies {
                implementation(libs.co.touchlab.kermit)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.serialization.protobuf)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.json)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.ktor.client.contentNegotiation)
                implementation(libs.com.squareup.okio)
                implementation(libs.bignum)
                implementation(libs.bignum.serialization.kotlinx)
                implementation(libs.com.ionspin.kotlin.multiplatformCryptoLibsodiumBindings)
                implementation(libs.io.github.luca992.cash.z.ecc.android.kotlinBip39)
                implementation(libs.com.github.luca992.khash.ripemd160)
                implementation(libs.io.eqoty.kryptools.aessiv)
                implementation(libs.io.eqoty.kryptools.bech32)
                implementation(libs.io.eqoty.kryptools.axlsign)
                implementation(libs.io.eqoty.kryptools.secp256k1)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.kotlinx.coroutines.test)
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(libs.org.slf4j.slf4jSimple)
                implementation(libs.ktor.client.okhttp)
                implementation(libs.org.cryptomator.sivMode)
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(libs.ktor.client.js)
                implementation(npm("file-system", "^2.2.2"))
                implementation(npm("path-browserify", "^1.0.1"))
                implementation(npm("crypto-browserify", "^3.12.0"))
                implementation(npm("buffer", "^6.0.3"))
                implementation(npm("stream-browserify", "^3.0.0"))
                implementation(npm("os-browserify", "^0.3.0"))
                implementation(npm("miscreant", "^0.3.2"))
                implementation(npm("libsodium-wrappers-sumo", "^0.7.10"))
                implementation(npm("secretjs", "^1.4.5"))
                implementation(npm("google-protobuf", "^3.21.0"))
                implementation(npm("@cosmjs/amino", "^0.29.3"))
                implementation(npm("@keplr-wallet/types", "^0.11.13"))
            }
        }
        val jsTest by getting {
            dependsOn(commonTest)
            dependencies {
                implementation(libs.com.squareup.okio.nodefilesystem)
                implementation(devNpm("@peculiar/webcrypto", "^1.4.0"))
                implementation(devNpm("@happy-dom/global-registrator", "^7.5.2"))
            }
        }
        val nativeMain by creating {
            dependsOn(commonMain)
        }
        val nativeTest by creating {
            dependsOn(commonTest)
        }
        val darwinMain by creating {
            dependsOn(nativeMain)
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
        val darwinTest by creating {
            dependsOn(nativeTest)
        }
        Targets.macosTargets.forEach { target ->
            getByName("${target}Main") {
                dependsOn(darwinMain)
            }
            getByName("${target}Test") {
                dependsOn(darwinTest)
            }
        }
        val iosMain by creating {
            dependsOn(darwinMain)
        }
        val iosTest by creating {
            dependsOn(darwinTest)
        }
        Targets.iosTargets.forEach { target ->
            getByName("${target}Main") {
                dependsOn(iosMain)
            }
            getByName("${target}Test") {
                dependsOn(iosTest)
            }
        }
    }
}

multiplatformSwiftPackage {
    outputDirectory(projectDir.parentFile)
    packageName(rootProject.name)
    swiftToolsVersion("5.3")
    targetPlatforms {
        iOS { v("13") }
        macOS { v("10_11") }
    }
}

// https://youtrack.jetbrains.com/issue/KT-46466
val dependsOnTasks = mutableListOf<String>()
tasks.withType<AbstractPublishToMaven>().configureEach {
    dependsOnTasks.add(this.name.replace("publish", "sign").replaceAfter("Publication", ""))
    dependsOn(dependsOnTasks)
}

plugins.withId("com.vanniktech.maven.publish.base") {
    mavenPublishing {
        publishToMavenCentral(SonatypeHost.S01)
        signAllPublications()
        pomFromGradleProperties()
    }
}
