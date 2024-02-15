import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.org.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.org.jetbrains.compose)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.com.android.application)
}

version = "1.0-SNAPSHOT"

kotlin {
    androidTarget()
    jvm("desktop")
    js(IR) {
        browser {
            commonWebpackConfig {
                val currentDir = System.getProperty("user.dir")
                println(currentDir)
                println(file("webpack.config.d.js"))
                configDirectory = file("webpack.config.d.js/")
            }
        }
        binaries.executable()
    }
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
        applyBinaryen {
            binaryenArgs = mutableListOf(
                "--enable-nontrapping-float-to-int",
                "--enable-gc",
                "--enable-reference-types",
                "--enable-exception-handling",
                "--enable-bulk-memory",
                "--inline-functions-with-loops",
                "--traps-never-happen",
                "--fast-math",
                "--closed-world",
                "--metrics",
                "-O3", "--gufa", "--metrics",
                "-O3", "--gufa", "--metrics",
                "-O3", "--gufa", "--metrics",
            )
        }
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
                implementation(project(":client"))
                implementation(project(":secret-std-msgs"))
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.datetime)
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
            }
        }

        val jsMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(compose.html.core)
                implementation(npm("@metamask/detect-provider", "^1.2.0"))
                implementation(npm("web3", "^1.7.0"))
                implementation(npm("@walletconnect/web3-provider", "^1.8.0"))
                implementation(npm("@walletconnect/client", "^1.8.0"))
                implementation(npm("@keplr-wallet/wc-client", "^0.11.63"))
                implementation(npm("@keplr-wallet/wc-qrcode-modal", "^0.11.63"))
                implementation(npm("@cosmostation/wc-modal", "^0.0.5"))
                implementation(npm("@babel/core", "^7.18.13"))

                implementation(npm("stream-browserify", "^3.0.0"))
                implementation(npm("assert", "^2.0.0"))
                implementation(npm("stream-http", "^3.2.0"))
                implementation(npm("https-browserify", "^1.0.0"))
                implementation(npm("os-browserify", "^0.3.0"))
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
//    uikit.application {
//        bundleIdPrefix = "io.eqoty.secretk"
//        projectName = "secretk sample"
//        deployConfigurations {
//            simulator("IPhone8") {
//                //Usage: ./gradlew iosDeployIPhone8Debug
//                device = IOSDevices.IPHONE_8
//            }
//            simulator("IPad") {
//                //Usage: ./gradlew iosDeployIPadDebug
//                device = IOSDevices.IPAD_MINI_6th_Gen
//            }
//            connectedDevice("Device") {
//                //First need specify your teamId here, or in local.properties (compose.ios.teamId=***)
//                //teamId="***"
//                //Usage: ./gradlew iosDeployDeviceRelease
//            }
//        }
//    }
}

compose.desktop.nativeApplication {
    targets(kotlin.targets.getByName("macosArm64"))
    distributions {
        targetFormats(TargetFormat.Dmg)
        packageName = "secretk sample"
        packageVersion = "1.0.0"
    }
}

//compose {
//    // workaround to use kotlin 1.8.22
//    // https://github.com/JetBrains/compose-jb/blob/master/VERSIONING.md#using-jetpack-compose-compiler
//    kotlinCompilerPlugin.set("androidx.compose.compiler:compiler:1.4.8")
//}

android {
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }
    namespace = "io.eqoty.secretk.sample"
}
