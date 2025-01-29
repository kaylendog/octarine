plugins {
    id("dog.kaylen.octarine.gradle")
}

dependencies {
    // minecraft
    minecraft(rootProject.libs.minecraft)
    mappings(rootProject.libs.yarn.mappings)
    modImplementation(rootProject.libs.fabric.loader)

    // fabric api
    modImplementation(rootProject.libs.fabric.language.kotlin)
    modImplementation(rootProject.libs.fabric.api)

    // octarine core
    implementation(project(path = ":octarine-core", configuration = "namedElements"))
}

loom {
    splitEnvironmentSourceSets()
    mods {
        create("octarine-witchery") {
            sourceSet("main")
            sourceSet("client")
        }
    }
}
