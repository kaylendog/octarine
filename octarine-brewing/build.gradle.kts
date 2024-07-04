loom {
    mods {
        "octarine-brewing" {
            sourceSet("main")
            sourceSet("client")
        }
    }
}

dependencies {
    modImplementation(project(":octarine-core"))
}
