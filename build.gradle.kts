plugins {
    java
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.quilt.loom)
    alias(libs.plugins.spotless)
}

group = "dog.kaylen"
version = "${rootProject.extra["mod_version"]}+${rootProject.libs.versions.minecraft}"

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
}

loom {
    mods {
        create("octarine")
    }
}
