import com.vanniktech.maven.publish.SonatypeHost
import java.util.*


plugins {
    alias(libs.plugins.org.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.com.vanniktech.maven.publish)
}

group = project.property("GROUP") as String
version = project.property("VERSION_NAME") as String

object Targets {
    val iosTargets = arrayOf(
        "iosArm64", "iosX64", "iosSimulatorArm64",
    )
    val macosTargets = arrayOf("macosX64", "macosArm64")
    val darwinTargets = iosTargets + macosTargets
    val linuxTargets = arrayOf<String>()
    val mingwTargets = arrayOf<String>()
    val nativeTargets = linuxTargets + darwinTargets + mingwTargets
}

kotlin {
    jvm()
    js(IR) {
        browser()
        nodejs()
    }
    for (target in Targets.nativeTargets) {
        targets.add(presets.getByName(target).createTarget(target))
    }
    sourceSets {
        all {
            languageSettings.optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
            languageSettings.optIn("kotlin.ExperimentalUnsignedTypes")
        }
        val commonMain by getting {
            dependencies {
                implementation(project(":secret-std-types"))
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.bignum)
                implementation(libs.bignum.serialization.kotlinx)
            }
        }
    }
}

plugins.withId("com.vanniktech.maven.publish") {
    mavenPublishing {
        publishToMavenCentral(SonatypeHost.S01)
        signAllPublications()
    }
}
