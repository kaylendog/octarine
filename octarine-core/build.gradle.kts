plugins {
    id("dog.kaylen.octarine.gradle")
}

dependencies {
    // minecraft
    minecraft(rootProject.libs.minecraft)
    mappings(rootProject.libs.yarn.mappings)
    modImplementation(rootProject.libs.fabric.loader)

    // kotlin
    modImplementation(rootProject.libs.fabric.language.kotlin)

    // quilted fabric api
    modImplementation(rootProject.libs.fabric.api)

    // lodestone
    modApi(rootProject.libs.lodestone)

    // patchouli
    include(libs.patchouli)
    modApi(libs.patchouli)

    // cardinal components
    include(libs.cca.base)
    include(libs.cca.chunk)
    modImplementation(libs.cca.base)
    modImplementation(libs.cca.chunk)
}

fabricApi {
    configureDataGeneration()
}

loom {
    splitEnvironmentSourceSets()

    mods {
        create("octarine-core") {
            sourceSet("main")
            sourceSet("client")
        }
    }
}
