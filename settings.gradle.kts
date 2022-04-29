rootProject.name = "secretk"

pluginManagement {
    repositories {
        maven ("https://s01.oss.sonatype.org/content/repositories/releases/")
        gradlePluginPortal()
        mavenCentral()
    }
    val versions = java.util.Properties().apply {
        load(File("versions.properties").reader())
    }
    plugins {
        // See https://jmfayard.github.io/refreshVersions
        id("de.fayard.refreshVersions") version versions["version.refreshVersions"] as String
        kotlin("multiplatform") version versions["version.kotlin"] as String
        kotlin("plugin.serialization") version versions["version.kotlin"] as String
        id("io.github.luca992.multiplatform-swiftpackage") version versions["version.multiplatformSwiftPackage"] as String
        id("com.vanniktech.maven.publish") version versions["version.gradleMavenPublishPlugin"] as String
    }
}

plugins {
    id("de.fayard.refreshVersions")
}


refreshVersions { // Optional: configure the plugin
    // ...
}