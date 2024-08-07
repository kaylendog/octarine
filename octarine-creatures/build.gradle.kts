plugins {
    id("dog.kaylen.octarine.gradle")
}

dependencies {
    // minecraft
    minecraft(rootProject.libs.minecraft)
    mappings(variantOf(rootProject.libs.quilt.mappings) { classifier("intermediary-v2") })
    modImplementation(rootProject.libs.quilt.loader)

    // quilted fabric api
    modImplementation(rootProject.libs.quilted.fabric.api)

    // octarine core
    implementation(project(":octarine-core", configuration = "namedElements"))
}

loom {
    splitEnvironmentSourceSets()
    mods {
        create("octarine-creatures") {
            sourceSet("main")
            sourceSet("client")
        }
    }
}
