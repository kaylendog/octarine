plugins {
    java
    alias(libs.plugins.kotlin)
    alias(libs.plugins.quilt.loom)
    alias(libs.plugins.spotless)
}

allprojects {
    version = "${rootProject.extra["mod_version"]}+${rootProject.extra["minecraft_version"]}"
    group = "${rootProject.extra["maven_group"]}"

    dependencies {
        minecraft(libs.minecraft)
        mappings(variantOf(libs.quilt.mappings) {  })
        modImplementation(libs.quilt.loader)
    }

    tasks.processResources {
        filesMatching("fabric.mod.json") {
            expand(
                mutableMapOf(
                    "minecraft_version" to project.extra["minecraft_version"] as String,
                    "loader_version" to project.extra["loader_version"] as String,
                    "mod_version" to project.extra["mod_version"] as String,
                    "fabric_version" to project.extra["fabric_version"] as String,
                    "fabric_kotlin_version" to project.extra["fabric_kotlin_version"] as String,
                ),
            )
        }
    }

    tasks {
        compileJava {
            options.encoding = "UTF-8"
            sourceCompatibility = JavaVersion.VERSION_21.toString()
            targetCompatibility = JavaVersion.VERSION_21.toString()
            options.release.set(JavaVersion.VERSION_21.toString().toInt())
        }

        compileKotlin {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_21.toString()
            }
        }
    }

    java {
        withSourcesJar()
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
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
}

subprojects {
    dependencies {
        modImplementation(libs.quilted.fabric.api)
    }
}

dependencies
    include(project(":octarine-brewing"))
    include(project(":octarine-core"))
    include(project(":octarine-food"))
    include(project(":octarine-witchery"))
    include(project(":octarine-wizardry"))
}

loom {
    mods {
        create("octarine")
    }
}
