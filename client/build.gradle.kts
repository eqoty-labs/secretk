@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.org.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.io.github.luca992.multiplatform.swiftpackage)
    alias(libs.plugins.com.vanniktech.maven.publish)
}

group = project.property("GROUP") as String
version = project.property("VERSION_NAME") as String

kotlin {
    jvm()
    js(IR) {
        browser {
            testTask {
                useMocha {
                    timeout = "20s"
                }
            }
        }
        nodejs {
            testTask {
                useMocha {
                    timeout = "20s"
                }
            }
        }
    }
    wasmJs {
        browser()
        nodejs()
    }

    iosArm64(); iosX64(); iosSimulatorArm64()
    tvosArm64(); tvosSimulatorArm64()
    watchosArm32(); watchosArm64(); watchosSimulatorArm64()
    macosArm64()
    linuxX64()
    mingwX64()

    targets.filterIsInstance<KotlinNativeTarget>().filter { it.konanTarget.family.isAppleFamily }.forEach {
        it.binaries.framework()
    }

    applyDefaultHierarchyTemplate()
    sourceSets {
        all {
            languageSettings.optIn("kotlin.ExperimentalUnsignedTypes")
            languageSettings.optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
            languageSettings.optIn("kotlinx.serialization.ExperimentalSerializationApi")
            languageSettings.optIn("kotlin.time.ExperimentalTime")
        }
        commonMain {
            dependencies {
                api(project(":cosmwasm-std-types"))
                api(project(":secret-std-types"))
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
                implementation(libs.dev.whyoleg.cryptography.random)
                implementation(libs.io.github.luca992.cash.z.ecc.android.kotlinBip39)
//                implementation(libs.com.github.komputing.khash.ripemd160)
                implementation(libs.io.eqoty.kryptools.aessiv)
                implementation(libs.io.eqoty.kryptools.bech32)
                implementation(libs.io.eqoty.kryptools.axlsign)
                implementation(libs.io.eqoty.kryptools.secp256k1)
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.kotlinx.coroutines.test)
            }
        }
        jvmMain {
            dependencies {
                implementation(libs.org.slf4j.slf4jSimple)
                implementation(libs.ktor.client.okhttp)
                implementation(libs.org.cryptomator.sivMode)
            }
        }
        jsMain {
            dependencies {
                implementation(libs.ktor.client.js)
                implementation(npm("file-system", "^2.2.2"))
                implementation(npm("path-browserify", "^1.0.1"))
                implementation(npm("crypto-browserify", "^3.12.0"))
                implementation(npm("buffer", "^6.0.3"))
                implementation(npm("stream-browserify", "^3.0.0"))
                implementation(npm("os-browserify", "^0.3.0"))
                implementation(npm("miscreant", "^0.3.2"))
                implementation(npm("secretjs", "^1.4.5"))
                implementation(npm("google-protobuf", "^3.21.0"))
                implementation(npm("@cosmjs/amino", "^0.29.3"))
                implementation(npm("@keplr-wallet/types", "^0.11.13"))
            }
        }
        jsTest {
            dependencies {
                implementation(libs.com.squareup.okio.nodefilesystem)
                implementation(devNpm("@peculiar/webcrypto", "^1.4.0"))
                implementation(devNpm("@happy-dom/global-registrator", "^7.5.2"))
            }
        }
        wasmJsTest {
            dependencies {
                implementation(libs.com.squareup.okio.fakefilesystem)
            }
        }

        appleMain {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }

        linuxMain {
            dependencies {
                implementation(libs.ktor.client.curl)
            }
        }

        mingwMain {
            dependencies {
                implementation(libs.ktor.client.winhttp)
            }
        }
    }
}

multiplatformSwiftPackage {
    outputDirectory(projectDir.parentFile)
    packageName(rootProject.name)
    swiftToolsVersion("6.0")
    targetPlatforms {
        iOS { v("13") }
        macOS { v("10_11") }
        // https://github.com/luca992/multiplatform-swiftpackage/issues/18
//        watchOS { v("4") }
        tvOS { v("9") }
    }
}
