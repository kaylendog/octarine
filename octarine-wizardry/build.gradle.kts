loom {
    mods {
        "octarine-wizardry" {
            sourceSet("main")
            sourceSet("client")
        }
    }
}

dependencies {
    modImplementation(project(":octarine-core"))
}
