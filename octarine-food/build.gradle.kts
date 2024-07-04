loom {
    mods {
        "octarine-food" {
            sourceSet("main")
            sourceSet("client")
        }
    }
}

dependencies {
    modImplementation(project(":octarine-core"))
}
