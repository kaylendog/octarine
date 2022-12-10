plugins {
    java
    kotlin("jvm") version "1.7.20"
    id("fabric-loom")
    id("com.diffplug.spotless") version "6.12.0"
}

version = "0.1.0"
group = "dog.kaylen"

repositories {
    maven("https://minecraft.guntram.de/maven/")
    maven("https://maven.blamejared.com")
    maven("https://ladysnake.jfrog.io/artifactory/mods")
}

dependencies {
    // Minecraft
    minecraft("com.mojang", "minecraft", project.extra["minecraft_version"] as String)
    mappings("net.fabricmc", "yarn", project.extra["yarn_mappings"] as String, null, "v2")
    modImplementation("net.fabricmc", "fabric-loader", project.extra["loader_version"] as String)

    // Fabric
    modImplementation("net.fabricmc.fabric-api", "fabric-api", project.extra["fabric_version"] as String)
    modImplementation("net.fabricmc", "fabric-language-kotlin", project.extra["fabric_language_kotlin_version"] as String)

    // Cardinal Components
     modImplementation("dev.onyxstudios.cardinal-components-api:cardinal-components-base:5.0.0")
     include("dev.onyxstudios.cardinal-components-api:cardinal-components-base:5.0.0")
     modImplementation("dev.onyxstudios.cardinal-components-api:cardinal-components-chunk:5.0.0")
     include("dev.onyxstudios.cardinal-components-api:cardinal-components-chunk:5.0.0")

    // Patchouli Docs
    modImplementation("vazkii.patchouli:Patchouli:${project.extra["patchouli_version"] as String}")
    include("vazkii.patchouli:Patchouli:${project.extra["patchouli_version"] as String}")
}

tasks {
    val javaVersion = JavaVersion.toVersion((project.extra["java_version"] as String).toInt())

    compileJava {
        options.encoding = "UTF-8"
        sourceCompatibility = javaVersion.toString()
        targetCompatibility = javaVersion.toString()
        options.release.set(javaVersion.toString().toInt())
    }

    jar { from("LICENSE") }

    processResources {
        filesMatching("fabric.mod.json") {
            expand(
                mutableMapOf(
                    "version" to project.extra["mod_version"] as String,
                    "fabricloader" to project.extra["loader_version"] as String,
                    "fabric_api" to project.extra["fabric_version"] as String,
                    "fabric_language_kotlin" to project.extra["fabric_language_kotlin_version"] as String,
                    "minecraft" to project.extra["minecraft_version"] as String,
                    "java" to project.extra["java_version"] as String
                )
            )
        }
        filesMatching("*.mixins.json") {
            expand(mutableMapOf("java" to project.extra["java_version"] as String))
        }
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
    json {
        target("src/**/*.json")
        // ignore fabric.mod.json
        targetExclude("fabric.mod.json")
        simple().indentWithSpaces(4)
    }
}
