import de.fayard.refreshVersions.core.StabilityLevel

rootProject.name = "secretk"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
        maven("https://s01.oss.sonatype.org/content/repositories/releases/")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    plugins {
        // See https://jmfayard.github.io/refreshVersions
        id("de.fayard.refreshVersions") version "0.60.5"
    }
}

dependencyResolutionManagement {
    repositories {
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
        maven("https://s01.oss.sonatype.org/content/repositories/releases/")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenCentral()
        google()
    }
}


plugins {
    id("de.fayard.refreshVersions")
}


refreshVersions {
    rejectVersionIf {
        candidate.stabilityLevel >= StabilityLevel.ReleaseCandidate
    }
}

include(":client")
include(":secret-std-msgs")
include(":secret-std-types")
include(":cosmwasm-std-types")
include(":deploy-utils")
include(":sample")
