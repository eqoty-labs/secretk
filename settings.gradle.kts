import de.fayard.refreshVersions.core.StabilityLevel

rootProject.name = "secretk"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    plugins {
        // See https://jmfayard.github.io/refreshVersions
        id("de.fayard.refreshVersions") version "0.60.6"
    }
}

dependencyResolutionManagement {
    repositories {
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
