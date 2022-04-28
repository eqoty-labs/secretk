rootProject.name = "secretk"

pluginManagement {
    repositories {
        maven ("https://s01.oss.sonatype.org/content/repositories/releases/")
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    // See https://jmfayard.github.io/refreshVersions
    id("de.fayard.refreshVersions") version "0.40.1"
}

refreshVersions { // Optional: configure the plugin
    // ...
}