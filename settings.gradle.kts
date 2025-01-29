pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.fabricmc.net")
    }
}

rootProject.name = "octarine"

include(
    "octarine-core",
    "octarine-brewing",
    "octarine-creatures",
    "octarine-food",
    "octarine-witchery",
    "octarine-wizardry",
)
