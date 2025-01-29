plugins {
    java
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.fabric.loom)
    alias(libs.plugins.spotless)
}

group = "dog.kaylen"
version = "${rootProject.extra["mod_version"]}+${rootProject.libs.versions.minecraft.get()}"

dependencies {
    minecraft(libs.minecraft)
    mappings(libs.yarn.mappings)
    modImplementation(libs.fabric.loader)

    // transitive common dependencies
    modImplementation(rootProject.libs.fabric.language.kotlin)
    modImplementation(rootProject.libs.fabric.api)

    // bundle mods
    implementation(project(path = ":octarine-core", configuration = "namedElements"))
    implementation(project(path = ":octarine-brewing", configuration = "namedElements"))
    implementation(project(path = ":octarine-food", configuration = "namedElements"))
    implementation(project(path = ":octarine-witchery", configuration = "namedElements"))
    implementation(project(path = ":octarine-wizardry", configuration = "namedElements"))

    include(project(":octarine-core"))
    include(project(":octarine-brewing"))
    include(project(":octarine-food"))
    include(project(":octarine-witchery"))
    include(project(":octarine-wizardry"))
}

loom {
    runConfigs.configureEach {
        ideConfigGenerated(true)
    }
    mods {
        create("octarine")
    }
}

tasks.processResources {
    inputs.property("version", project.version)
    inputs.property("group", project.group)
    filesMatching("fabric.mod.json") {
        expand(
            mutableMapOf(
                "version" to project.version,
                "group" to project.group,
                "minecraft" to libs.versions.minecraft.get(),
                "fabric_loader" to
                    libs.versions.fabric.loader
                        .get(),
            ),
        )
    }
}

spotless {
    ratchetFrom("origin/main")
    encoding("UTF-8")

    java {
        googleJavaFormat().aosp().reflowLongStrings()
        licenseHeaderFile(project.file("LICENSE_HEADER"))
    }
    kotlin {
        ktlint()
        licenseHeaderFile(project.file("LICENSE_HEADER"))
    }
    kotlinGradle {
        ktlint()
    }
}
