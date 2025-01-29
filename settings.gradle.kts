pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.fabricmc.net")
    }
}

include(
    "octarine",
    "octarine-core",
    "octarine-brewing",
    "octarine-creatures",
    "octarine-food",
    "octarine-witchery",
    "octarine-wizardry",
)
