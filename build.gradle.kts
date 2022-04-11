plugins {
    kotlin("multiplatform") version "1.6.20"
    kotlin("plugin.serialization") version "1.6.20"
}

group = "io.eqoty"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
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
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
        binaries.executable()
    }
    macosX64()
    macosArm64()
    iosX64()
    iosArm64()
//    linuxX64()

    sourceSets {
        all {
            languageSettings.optIn("kotlin.ExperimentalUnsignedTypes")
            languageSettings.optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
        }
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:_")
                implementation("io.ktor:ktor-client-json:_")
                implementation("io.ktor:ktor-serialization-kotlinx-json:_")
                implementation("io.ktor:ktor-client-content-negotiation:_")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:_")
                implementation("com.squareup.okio:okio:_")
                implementation("com.ionspin.kotlin:multiplatform-crypto-libsodium-bindings:_")
                implementation("com.ionspin.kotlin:bignum:0.3.4")
                implementation("com.ionspin.kotlin:bignum-serialization-kotlinx:0.3.2")
                implementation("cash.z.ecc.android:kotlin-bip39:1.0.2-SNAPSHOT")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:_")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("org.slf4j:slf4j-simple:1.8.0-beta4")
                implementation("io.ktor:ktor-client-okhttp:_")
                implementation("org.cryptomator:siv-mode:_")
            }
        }
        val jvmTest by getting
        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:_")
                implementation(npm("path-browserify", "1.0.1"))
                implementation(npm("crypto-browserify", "3.12.0"))
                implementation(npm("buffer", "6.0.3"))
                implementation(npm("stream-browserify", "3.0.0"))
                implementation(npm("os-browserify", "0.3.0"))
                implementation(npm("miscreant", "0.3.2"))
                implementation(npm("libsodium-wrappers-sumo", "0.7.10"))
            }
        }
        val jsTest by getting
        val nativeMain by creating {
            dependsOn(commonMain)
        }
        val nativeTest by creating
        val desktopMain by creating {
            dependsOn(nativeMain)
            dependencies {
                implementation("io.ktor:ktor-client-curl:_")
            }
        }
        val iosMain by creating {
            dependsOn(nativeMain)
            dependencies {
                implementation("io.ktor:ktor-client-ios:_")
            }
        }
        val macosX64Main by getting {
            dependsOn(desktopMain)
        }
//        val macosArm64Main by getting {
//            dependsOn(desktopMain)
//        }
//        val linuxX64Main by getting {
//            dependsOn(desktopMain)
//        }
        val iosArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosX64Main by getting {
            dependsOn(iosMain)
        }
    }
}