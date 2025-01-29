plugins {
    id("dog.kaylen.octarine.gradle")
}

dependencies {
    // minecraft
    minecraft(rootProject.libs.minecraft)
    mappings(rootProject.libs.yarn.mappings)
    modImplementation(rootProject.libs.fabric.loader)

    // quilted fabric api
    modImplementation(rootProject.libs.fabric.api)

    // octarine core
    implementation(project(":octarine-core", configuration = "namedElements"))
}

loom {
    splitEnvironmentSourceSets()
    mods {
        create("octarine-brewing") {
            sourceSet("main")
            sourceSet("client")
        }
    }
}
