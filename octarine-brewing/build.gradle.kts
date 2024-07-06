plugins {
    id("dog.kaylen.octarine.gradle")
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

dependencies {
    // minecraft
    minecraft(rootProject.libs.minecraft)
    mappings(variantOf(rootProject.libs.quilt.mappings) { classifier("intermediary-v2") })
    modImplementation(rootProject.libs.quilt.loader)

    // quilted fabric api
    modImplementation(rootProject.libs.quilted.fabric.api)

    // octarine core
    modImplementation(project(":octarine-core"))
}
