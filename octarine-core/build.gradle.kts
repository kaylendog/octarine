plugins {
    id("dog.kaylen.octarine.gradle")
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

repositories {
    maven("https://jitpack.io")
    maven("https://api.modrinth.com/maven")
    maven("https://maven.blamejared.com")
}

dependencies {
    // minecraft
    minecraft(rootProject.libs.minecraft)
    mappings(variantOf(rootProject.libs.quilt.mappings) { classifier("intermediary-v2") })
    modImplementation(rootProject.libs.quilt.loader)

    // lodestone
    include(libs.lodestone)
    modApi(libs.lodestone)

    // patchouli
    modImplementation(libs.patchouli)
    include(libs.patchouli)
}
