plugins {
    id("dog.kaylen.octarine.gradle")
}

group = "dog.kaylen"
version = "${rootProject.extra["mod_version"]}+${rootProject.libs.versions.minecraft.get()}"

dependencies {
    minecraft(libs.minecraft)
    mappings(libs.yarn.mappings)
    modImplementation(libs.fabric.loader)

    // dependencies
    modImplementation(rootProject.libs.fabric.language.kotlin)
    modImplementation(rootProject.libs.fabric.api)

    // bundle mods
    implementation(project(path = ":octarine-core", configuration = "namedElements"))
    implementation(project(path = ":octarine-brewing", configuration = "namedElements"))
    implementation(project(path = ":octarine-food", configuration = "namedElements"))
    implementation(project(path = ":octarine-witchery", configuration = "namedElements"))
    implementation(project(path = ":octarine-wizardry", configuration = "namedElements"))

    include(project(":octarine-core"))
    include(project(":octarine-brewing"))
    include(project(":octarine-food"))
    include(project(":octarine-witchery"))
    include(project(":octarine-wizardry"))
}

loom {
    runConfigs.configureEach {
        ideConfigGenerated(true)
    }
    mods {
        create("octarine")
    }
}
