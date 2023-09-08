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