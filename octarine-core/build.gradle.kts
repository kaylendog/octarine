plugins {
    id("dog.kaylen.octarine.gradle")
}

group = "dog.kaylen.octarine"
version = "${rootProject.extra["mod_version"]}+${rootProject.libs.versions.minecraft.get()}"

dependencies {
    // minecraft
    minecraft(rootProject.libs.minecraft)
    mappings(variantOf(rootProject.libs.quilt.mappings) { classifier("intermediary-v2") })
    modImplementation(rootProject.libs.quilt.loader)

    // quilted fabric api
    modImplementation(rootProject.libs.quilted.fabric.api)

    // lodestone
    include(rootProject.libs.lodestone)
    modApi(rootProject.libs.lodestone)

    // patchouli
    modImplementation(libs.patchouli)
    include(libs.patchouli)

    // cardinal components
    include(libs.cca.base)
    include(libs.cca.chunk)
    modImplementation(libs.cca.base)
    modImplementation(libs.cca.chunk)
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
