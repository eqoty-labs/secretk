import com.vanniktech.maven.publish.SonatypeHost
import java.util.*

plugins {
    @Suppress("DSL_SCOPE_VIOLATION")
    val libs = libs
    alias(libs.plugins.org.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.com.vanniktech.maven.publish)
}

group = project.property("GROUP") as String
version = project.property("VERSION_NAME") as String

object Targets {
    val iosTargets = arrayOf<String>()
    val macosTargets = arrayOf("macosX64", "macosArm64")
    val darwinTargets = iosTargets + macosTargets
    val linuxTargets = arrayOf<String>()
    val mingwTargets = arrayOf<String>()
    val nativeTargets = linuxTargets + darwinTargets + mingwTargets
}

kotlin {
    jvm()
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
                implementation(project(":client"))
                implementation(project(":secret-std-msgs"))
                implementation(libs.com.squareup.okio)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.client.core)
                implementation(libs.co.touchlab.kermit)
                implementation(libs.bignum)
                implementation(libs.bignum.serialization.kotlinx)
                implementation(libs.io.github.luca992.getenv)
            }
        }
        val commonTest by getting
        val jvmMain by getting {
            dependsOn(commonMain)
        }
        val jvmTest by getting {
            dependsOn(commonTest)
        }
        val nativeMain by creating {
            dependsOn(commonMain)
        }
        val nativeTest by creating {
            dependsOn(commonTest)
        }
        Targets.nativeTargets.forEach { target ->
            getByName("${target}Main") {
                dependsOn(nativeMain)
            }
            getByName("${target}Test") {
                dependsOn(nativeTest)
            }
        }
    }
}

//// https://youtrack.jetbrains.com/issue/KT-46466
//val dependsOnTasks = mutableListOf<String>()
//tasks.withType<AbstractPublishToMaven>().configureEach {
//    dependsOnTasks.add(this.name.replace("publish", "sign").replaceAfter("Publication", ""))
//    dependsOn(dependsOnTasks)
//}

plugins.withId("com.vanniktech.maven.publish") {
    mavenPublishing {
        publishToMavenCentral(SonatypeHost.S01)
        signAllPublications()
    }
}
