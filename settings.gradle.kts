pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven(
            url = uri("https://repo1.maven.org/maven2")
        )
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "TinySA"