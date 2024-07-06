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
    maven("https://maven.blamejared.com")
    maven("https://maven.ladysnake.org/releases")
    exclusiveContent {
        forRepository { maven("https://api.modrinth.com/maven") }
        filter { includeGroup("maven.modrinth") }
    }
}

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
    include(libs.cardinalcomponents.base)
    include(libs.cardinalcomponents.chunk)
    modImplementation(libs.cardinalcomponents.base)
    modImplementation(libs.cardinalcomponents.chunk)
}
