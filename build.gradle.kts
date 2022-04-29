import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("io.github.luca992.multiplatform-swiftpackage")
}

group = project.property("GROUP") as String
version = project.property("VERSION_NAME") as String

repositories {
    maven("./tempMavenRepo/repository")
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
    val darwinTargets = mutableListOf<KotlinNativeTarget>()
    macosX64{
        darwinTargets.add(this)
        setupCinterop(Target.MacosX64)
    }
    macosArm64{
        darwinTargets.add(this)
        setupCinterop(Target.MacosArm64)
    }
    iosX64{
        darwinTargets.add(this)
        setupCinterop(Target.IosSimulatorX64)
    }
    iosArm64{
        darwinTargets.add(this)
        setupCinterop(Target.IosArm64)
    }
    iosSimulatorArm64{
        darwinTargets.add(this)
        setupCinterop(Target.IosSimulatorArm64)
    }
    darwinTargets.forEach{
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
                implementation("co.touchlab:kermit:_")
                implementation("io.ktor:ktor-client-core:_")
                implementation("io.ktor:ktor-client-json:_")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:_")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:_")
                implementation("io.ktor:ktor-serialization-kotlinx-json:_")
                implementation("io.ktor:ktor-client-content-negotiation:_")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:_")
                implementation("com.squareup.okio:okio:_")
                implementation("com.ionspin.kotlin:multiplatform-crypto-libsodium-bindings:_")
                implementation("com.ionspin.kotlin:bignum:_")
                implementation("com.ionspin.kotlin:bignum-serialization-kotlinx:_")
                implementation("cash.z.ecc.android:kotlin-bip39:1.0.2-SNAPSHOT")
                implementation("KHash:ripemd160:unspecified")

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
                implementation("org.slf4j:slf4j-simple:_")
                implementation("io.ktor:ktor-client-okhttp:_")
                implementation("org.cryptomator:siv-mode:_")
            }
        }
        val jvmTest by getting
        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:_")
                implementation(npm("path-browserify", "^1.0.1"))
                implementation(npm("crypto-browserify", "^3.12.0"))
                implementation(npm("buffer", "^6.0.3"))
                implementation(npm("stream-browserify", "^3.0.0"))
                implementation(npm("os-browserify", "^0.3.0"))
                implementation(npm("miscreant", "^0.3.2"))
                implementation(npm("libsodium-wrappers-sumo", "^0.7.10"))
            }
        }
        val jsTest by getting
        val nativeMain by creating {
            dependsOn(commonMain)
        }
        val nativeTest by creating
        val darwinMain by creating {
            dependsOn(nativeMain)
            dependencies {
                implementation("io.ktor:ktor-client-darwin:_")
            }
        }
        val macosX64Main by getting {
            dependsOn(darwinMain)
        }
        val iosMain by creating {
            dependsOn(darwinMain)
        }
        val macosArm64Main by getting {
            dependsOn(darwinMain)
        }
        val iosArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosX64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
    }
}

multiplatformSwiftPackage {
    outputDirectory(projectDir)
    packageName(rootProject.name)
    swiftToolsVersion("5.3")
    targetPlatforms {
        iOS { v("13") }
        macOS { v("10_11") }
    }
}

fun KotlinNativeTarget.setupCinterop(target: Target) =
    apply{
        compilations.getByName("main") {
            cinterops {
                val libAesSiv by creating {
                    defFile(project.file("src/nativeInterop/cinterop/libaes_siv.def"))
                    includeDirs.allHeaders(project.file("${project.rootDir}/nativelibs/libaes_siv/"))
                }
            }
            val buildFolderName = target.buildName
            val releaseFolderName = target.releaseFolderName
            val opensslTargetName = target.opensslTargetName
            kotlinOptions.freeCompilerArgs = listOf(
                "-include-binary", "${project.rootDir}/nativelibs/libaes_siv_build/$buildFolderName/$releaseFolderName/libaes_siv.a",
                "-include-binary", "$projectDir/nativelibs/darwinopenssl/$opensslTargetName/lib/libcrypto.a"
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
        val libAesSivBuild = File("./nativelibs/libaes_siv_build")
        libAesSivBuild.deleteRecursively()
    }
}