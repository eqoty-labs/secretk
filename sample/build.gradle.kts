import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.compose.experimental.dsl.IOSDevices
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    @Suppress("DSL_SCOPE_VIOLATION")
    val libs = libs
    // https://youtrack.jetbrains.com/issue/KTIJ-19369
    alias(libs.plugins.org.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.org.jetbrains.compose)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.com.android.application)
}

version = "1.0-SNAPSHOT"

kotlin {
    android()
    jvm("desktop")
    js(IR) {
        browser()
        binaries.executable()
    }
    macosX64 {
        binaries {
            executable {
                entryPoint = "main"
                freeCompilerArgs += listOf(
                    "-linker-option", "-framework", "-linker-option", "Metal"
                )
            }
        }
    }
    macosArm64 {
        binaries {
            executable {
                entryPoint = "main"
                freeCompilerArgs += listOf(
                    "-linker-option", "-framework", "-linker-option", "Metal"
                )
            }
        }
    }
    iosX64("uikitX64") {
        binaries {
            executable {
                entryPoint = "main"
                freeCompilerArgs += listOf(
                    "-linker-option", "-framework", "-linker-option", "Metal",
                    "-linker-option", "-framework", "-linker-option", "CoreText",
                    "-linker-option", "-framework", "-linker-option", "CoreGraphics"
                )
            }
        }
    }
    iosArm64("uikitArm64") {
        binaries {
            executable {
                entryPoint = "main"
                freeCompilerArgs += listOf(
                    "-linker-option", "-framework", "-linker-option", "Metal",
                    "-linker-option", "-framework", "-linker-option", "CoreText",
                    "-linker-option", "-framework", "-linker-option", "CoreGraphics"
                )
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":secretk"))
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)
                implementation(compose.animation)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.json)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependsOn(commonMain)
            kotlin.srcDirs("src/jvmMain/kotlin")
            dependencies {
                implementation(libs.androidx.appcompat)
                implementation(libs.androidx.activity.compose)
            }
        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(libs.kotlinx.coroutines.swing)
            }
        }

        val jsMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(compose.web.core)
                implementation(npm("@metamask/detect-provider", "^1.2.0"))
                implementation(npm("web3", "^1.7.0"))
                implementation(npm("@walletconnect/web3-provider", "^1.8.0"))
                implementation(npm("@walletconnect/client", "^1.8.0"))
                implementation(npm("@keplr-wallet/wc-client", "^0.11.17"))
                implementation(npm("@keplr-wallet/wc-qrcode-modal", "^0.11.17"))
                implementation(npm("@babel/core", "^7.18.13"))
                implementation(npm("events", "^3.3.0"))

                implementation(npm("assert", "^2.0.0"))
                implementation(npm("stream-http", "^3.2.0"))
                implementation(npm("https-browserify", "^1.0.0"))
                implementation(npm("vm-browserify", "^1.1.2"))
                implementation(npm("url", "^0.11.0"))

            }
        }

        val nativeMain by creating {
            dependsOn(commonMain)
        }
        val macosMain by creating {
            dependsOn(nativeMain)
        }
        val macosX64Main by getting {
            dependsOn(macosMain)
        }
        val macosArm64Main by getting {
            dependsOn(macosMain)
        }
        val uikitMain by creating {
            dependsOn(nativeMain)
        }
        val uikitX64Main by getting {
            dependsOn(uikitMain)
        }
        val uikitArm64Main by getting {
            dependsOn(uikitMain)
        }
    }
}

compose.desktop {
    application {
        mainClass = "Main_desktopKt"
    }
}

compose.experimental {
    web.application {}
    uikit.application {
        bundleIdPrefix = "io.eqoty.secretk"
        projectName = "secretk sample"
        deployConfigurations {
            simulator("IPhone8") {
                //Usage: ./gradlew iosDeployIPhone8Debug
                device = IOSDevices.IPHONE_8
            }
            simulator("IPad") {
                //Usage: ./gradlew iosDeployIPadDebug
                device = IOSDevices.IPAD_MINI_6th_Gen
            }
            connectedDevice("Device") {
                //First need specify your teamId here, or in local.properties (compose.ios.teamId=***)
                //teamId="***"
                //Usage: ./gradlew iosDeployDeviceRelease
            }
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

compose.desktop.nativeApplication {
    targets(kotlin.targets.getByName("macosArm64"))
    distributions {
        targetFormats(TargetFormat.Dmg)
        packageName = "secretk sample"
        packageVersion = "1.0.0"
    }
}

// TODO: remove when https://youtrack.jetbrains.com/issue/KT-50778 fixed
project.tasks.withType(org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile::class.java).configureEach {
    kotlinOptions.freeCompilerArgs += listOf(
        "-Xir-dce-runtime-diagnostic=log"
    )
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }
}

tasks.findByName("jsProcessResources")!!.dependsOn("unpackSkikoWasmRuntimeJs")
tasks.findByName("jsBrowserDevelopmentRun")!!.dependsOn("jsDevelopmentExecutableCompileSync")
