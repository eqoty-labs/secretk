rootProject.name = "secretk"

pluginManagement {
    repositories {
        maven ("https://s01.oss.sonatype.org/content/repositories/releases/")
        gradlePluginPortal()
        mavenCentral()
    }
    val kotlinVersion : String by settings
    val refreshVersionsVersion: String by settings
    val multiplatformSwiftPackageVersion: String by settings
    plugins {
        // See https://jmfayard.github.io/refreshVersions
        id("de.fayard.refreshVersions") version refreshVersionsVersion
        kotlin("multiplatform") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        id("io.github.luca992.multiplatform-swiftpackage") version multiplatformSwiftPackageVersion
    }
}

plugins {
    id("de.fayard.refreshVersions")
}


refreshVersions { // Optional: configure the plugin
    // ...
}