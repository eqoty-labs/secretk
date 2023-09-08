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
        id("de.fayard.refreshVersions") version "0.60.2"
    }
}

dependencyResolutionManagement {
    repositories {
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenCentral()
        google()
//        maven {
//            name = "komputing/KHash GitHub Packages"
//            url = uri("https://maven.pkg.github.com/komputing/KHash")
//            credentials {
//                username = "token"
//                // see: https://github.community/t/download-from-github-package-registry-without-authentication/14407/44
//                password =
//                    "\u0039\u0032\u0037\u0034\u0031\u0064\u0038\u0033\u0064\u0036\u0039\u0061\u0063\u0061\u0066\u0031\u0062\u0034\u0061\u0030\u0034\u0035\u0033\u0061\u0063\u0032\u0036\u0038\u0036\u0062\u0036\u0032\u0035\u0065\u0034\u0061\u0065\u0034\u0032\u0062"
//            }
//        }
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
