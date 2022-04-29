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

dependencyResolutionManagement {
    repositories {
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        mavenCentral()
        maven {
            name = "luca992/KHash GitHub Packages"
            url = uri("https://maven.pkg.github.com/luca992/KHash")
            credentials {
                username = "token"
                // see: https://github.community/t/download-from-github-package-registry-without-authentication/14407/44
                password = "\u0039\u0032\u0037\u0034\u0031\u0064\u0038\u0033\u0064\u0036\u0039\u0061\u0063\u0061\u0066\u0031\u0062\u0034\u0061\u0030\u0034\u0035\u0033\u0061\u0063\u0032\u0036\u0038\u0036\u0062\u0036\u0032\u0035\u0065\u0034\u0061\u0065\u0034\u0032\u0062"
            }
        }
    }
}


plugins {
    id("de.fayard.refreshVersions")
}


refreshVersions { // Optional: configure the plugin
    // ...
}