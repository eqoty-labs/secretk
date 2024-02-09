import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.org.jetbrains.kotlin.multiplatform) apply false
    alias(libs.plugins.org.jetbrains.kotlin.plugin.serialization) apply false
    alias(libs.plugins.io.github.luca992.multiplatform.swiftpackage) apply false
    alias(libs.plugins.com.vanniktech.maven.publish) apply false
    alias(libs.plugins.org.jetbrains.compose) apply false
    alias(libs.plugins.com.android.application) apply false
}


allprojects {
    tasks.withType<KotlinCompile> {
        compilerOptions.jvmTarget = JvmTarget.JVM_1_8
    }
}

/**
 * Select a NodeJS version with WASI and WASM GC.
 * https://github.com/Kotlin/kotlin-wasm-examples/blob/main/wasi-example/build.gradle.kts
 */
plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
    extensions.getByType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().apply {
        nodeVersion = "21.0.0-v8-canary20231019bd785be450"
        nodeDownloadBaseUrl = "https://nodejs.org/download/v8-canary"
    }
    // Suppress an error because yarn doesn't like our Node version string.
    //   warning You are using Node "21.0.0-v8-canary202309143a48826a08" which is not supported and
    //   may encounter bugs or unexpected behavior.
    //   error typescript@5.0.4: The engine "node" is incompatible with this module.
    tasks.withType<org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask>().all {
        args += "--ignore-engines"
    }
}