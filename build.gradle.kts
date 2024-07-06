import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    java
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.quilt.loom)
    alias(libs.plugins.spotless)
}

version = "${rootProject.extra["mod_version"]}+${rootProject.libs.versions.minecraft}"
group = "${rootProject.extra["maven_group"]}"

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
//    include(project(":octarine-brewing"))
//    include(project(":octarine-core"))
//    include(project(":octarine-food"))
//    include(project(":octarine-witchery"))
//    include(project(":octarine-wizardry"))
}

loom {
    mods {
        create("octarine")
    }
}
