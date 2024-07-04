loom {
    mods {
        "octarine-core" {
            sourceSet("main")
            sourceSet("client")
        }
    }
}

repositories {
    jitpack()
}

dependencies {
    // lodestone
    include(libs.lodestone)
    modApi(libs.lodestone)

    // veil
    include(libs.veil)
    modApi(libs.veil)

    // patchouli
    modImplementation(libs.patchouli)
    include(libs.patchouli)
}
