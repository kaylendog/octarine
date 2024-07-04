loom {
    mods {
        "octarine-witchery" {
            sourceSet("main")
            sourceSet("client")
        }
    }
}

dependencies {
    modImplementation(project(":octarine-core"))
}
