rootProject.name = "octarine"

include("octarine-core")
include("octarine-proxy")
include("octarine-1.19.2")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.fabricmc.net")
    }

    // plugin version from config
    val spotlessVersion: String by settings
    val kotlinVersion: String by settings

    plugins {
        id("com.diffplug.spotless") version "$spotlessVersion"
        kotlin("jvm") version "$kotlinVersion"
    }
}
