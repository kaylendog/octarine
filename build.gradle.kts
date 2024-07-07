plugins {
    java
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.quilt.loom)
    alias(libs.plugins.spotless)
}

group = "dog.kaylen"
version = "${rootProject.extra["mod_version"]}+${rootProject.libs.versions.minecraft.get()}"

dependencies {
    minecraft(libs.minecraft)
    mappings(variantOf(libs.quilt.mappings) { classifier("intermediary-v2") })
    modImplementation(libs.quilt.loader)

    // bundle mods
    implementation(project(":octarine-core", configuration = "namedElements"))
    implementation(project(":octarine-brewing", configuration = "namedElements"))
    implementation(project(":octarine-food", configuration = "namedElements"))
    implementation(project(":octarine-witchery", configuration = "namedElements"))
    implementation(project(":octarine-wizardry", configuration = "namedElements"))

    include(project(":octarine-core"))
    include(project(":octarine-brewing"))
    include(project(":octarine-food"))
    include(project(":octarine-witchery"))
    include(project(":octarine-wizardry"))
}

loom {
    mods {
        create("octarine")
    }
}

tasks.processResources {
    inputs.property("version", project.version)
    inputs.property("group", project.group)
    filesMatching("quilt.mod.json") {
        expand(
            mutableMapOf(
                "version" to project.version,
                "group" to project.group,
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
