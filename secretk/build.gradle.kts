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
        setupCinterop(Target.MacosX64)
    }
    macosArm64 {
        darwinTargets.add(this)
        setupCinterop(Target.MacosArm64)
    }
    iosX64 {
        darwinTargets.add(this)
        setupCinterop(Target.IosSimulatorX64)
    }
    iosArm64 {
        darwinTargets.add(this)
        setupCinterop(Target.IosArm64)
    }
    iosSimulatorArm64 {
        darwinTargets.add(this)
        setupCinterop(Target.IosSimulatorArm64)
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
                implementation(npm("secretjs", "^1.4.3"))
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

fun KotlinNativeTarget.setupCinterop(target: Target) =
    apply {
        compilations.getByName("main") {
            cinterops {
                val libAesSiv by creating {
                    defFile(project.file("src/nativeInterop/cinterop/libaes_siv.def"))
                    includeDirs.allHeaders(project.file("$projectDir/nativelibs/libaes_siv/"))
                }
            }
            val buildFolderName = target.buildName
            val releaseFolderName = target.releaseFolderName
            val opensslTargetName = target.opensslTargetName
            kotlinOptions.freeCompilerArgs = listOf(
                "-include-binary",
                "$projectDir/nativelibs/libaes_siv_build/$buildFolderName/$releaseFolderName/libaes_siv.a",
                "-include-binary",
                "$projectDir/nativelibs/darwinopenssl/$opensslTargetName/lib/libcrypto.a"
            )
        }
    }

enum class Target(
    val taskSuffix: String,
    val buildName: String,
    val releaseFolderName: String,
    val opensslTargetName: String
) {
    MacosArm64("MacosArm64", "MAC_ARM64", "Release", "macosx"),
    MacosX64("MacosX64", "MAC", "Release", "macosx"),
    IosArm64("IosArm64", "OS64", "Release-iphoneos", "iphoneos"),
    IosSimulatorX64("IosX64", "SIMULATOR64", "Release-iphonesimulator", "iphonesimulator"),
    IosSimulatorArm64("IosSimulatorArm64", "SIMULATORARM64", "Release-iphonesimulator", "iphonesimulator")
}

fun makeLibAesSivTask(target: Target): Task =
    target.run {
        task<Exec>("makeLibAesSiv$taskSuffix") {
            workingDir = File("./nativelibs")
            commandLine("./make-libaes_siv.sh", buildName)
        }.apply {
            onlyIf {
                !file("./nativelibs/libaes_siv_build/$buildName/$releaseFolderName/libaes_siv.a").exists()
            }
        }
    }


tasks.findByName("cinteropLibAesSivMacosArm64")!!.dependsOn(makeLibAesSivTask(Target.MacosArm64))
tasks.findByName("cinteropLibAesSivMacosX64")!!.dependsOn(makeLibAesSivTask(Target.MacosX64))
tasks.findByName("cinteropLibAesSivIosArm64")!!.dependsOn(makeLibAesSivTask(Target.IosArm64))
tasks.findByName("cinteropLibAesSivIosX64")!!.dependsOn(makeLibAesSivTask(Target.IosSimulatorX64))
tasks.findByName("cinteropLibAesSivIosSimulatorArm64")!!.dependsOn(makeLibAesSivTask(Target.IosSimulatorArm64))

tasks.clean {
    doFirst {
        val libAesSivBuild = File("$projectDir/nativelibs/libaes_siv_build")
        libAesSivBuild.deleteRecursively()
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
