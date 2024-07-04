plugins {
    java
    kotlin("jvm") version "1.9.20"
    id("fabric-loom") version "1.4-SNAPSHOT"
    id("com.diffplug.spotless") version "6.22.0"
}

version = project.extra["mod_version"] as String
group = project.extra["maven_group"] as String

base {
    archivesName.set(project.extra["archives_base_name"] as String)
}

repositories {
    maven("https://minecraft.guntram.de/maven/")
    maven("https://maven.blamejared.com")
    maven("https://maven.ladysnake.org/releases")
}

loom {
    runs {
        register("datagen") {
            server()
            vmArg("-Dfabric-api.datagen")
            vmArg("-Dfabric-api.datagen.output-dir=${file("src/main/generated")}")
            vmArg("-Dfabric-api.datagen.modid=octarine")
            runDir = "build/datagen"
        }
    }

    splitEnvironmentSourceSets()

    mods {
        create("octarine") {
            sourceSet("main")
            sourceSet("client")
        }
    }
}

sourceSets {
    main {
        resources {
            srcDirs("src/main/generated")
        }
    }
}

dependencies {
    // To change the versions see the gradle.properties file
    minecraft("com.mojang", "minecraft", project.extra["minecraft_version"] as String)
    mappings("net.fabricmc", "yarn", project.extra["yarn_mappings"] as String, null, "v2")
    modImplementation("net.fabricmc", "fabric-loader", project.extra["loader_version"] as String)

    // Fabric
    modImplementation("net.fabricmc.fabric-api", "fabric-api", project.extra["fabric_version"] as String)
    modImplementation("net.fabricmc", "fabric-language-kotlin", project.extra["fabric_kotlin_version"] as String)

    // Cardinal Components
    modImplementation(
        "dev.onyxstudios.cardinal-components-api",
        "cardinal-components-base",
        project.extra["cardinal_components_version"] as String,
    )
    include("dev.onyxstudios.cardinal-components-api", "cardinal-components-base", project.extra["cardinal_components_version"] as String)
    modImplementation(
        "dev.onyxstudios.cardinal-components-api",
        "cardinal-components-chunk",
        project.extra["cardinal_components_version"] as String,
    )
    include("dev.onyxstudios.cardinal-components-api", "cardinal-components-chunk", project.extra["cardinal_components_version"] as String)

    // Patchouli Docs
    modImplementation("vazkii.patchouli:Patchouli:${project.extra["patchouli_version"] as String}")
    include("vazkii.patchouli:Patchouli:${project.extra["patchouli_version"] as String}")
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

tasks.compileJava {
    options.encoding = "UTF-8"
    sourceCompatibility = JavaVersion.VERSION_17.toString()
    targetCompatibility = JavaVersion.VERSION_17.toString()
    options.release.set(JavaVersion.VERSION_17.toString().toInt())
}

tasks.compileKotlin {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

java {
    withSourcesJar()
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.jar {
    from("license") {
        rename { "${it}_${project.extra["archives_base_name"]}" }
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
//    json {
//        target("src/**/*.json")
//        prettier().nodeExecutable(File("${System.getenv("NVM_BIN")}/node"))
//    }
}
