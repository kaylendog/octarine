pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.quiltmc.org/repository/release")
        maven("https://maven.fabricmc.net")
    }
}

rootProject.name = "octarine"

include(
    "octarine-core",
//    "octarine-brewing",
//    "octarine-food",
//    "octarine-witchery",
//    "octarine-wizardry"
)

