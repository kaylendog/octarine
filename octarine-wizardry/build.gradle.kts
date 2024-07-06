plugins {
    id("dog.kaylen.octarine.gradle")
}

group = "dog.kaylen.octarine"
version = "${rootProject.extra["mod_version"]}+${rootProject.libs.versions.minecraft}"

dependencies {
    // minecraft
    minecraft(rootProject.libs.minecraft)
    mappings(variantOf(rootProject.libs.quilt.mappings) { classifier("intermediary-v2") })
    modImplementation(rootProject.libs.quilt.loader)

    // quilted fabric api
    modImplementation(rootProject.libs.quilted.fabric.api)

    // octarine core
    modImplementation(project(":octarine-core"))
}

loom {
    splitEnvironmentSourceSets()
    mods {
        create("octarine-wizardry") {
            sourceSet("main")
            sourceSet("client")
        }
    }
}
