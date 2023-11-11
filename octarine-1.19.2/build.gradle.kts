plugins {
    java
    kotlin("jvm")
    id("com.diffplug.spotless")
    id("fabric-loom") version "1.4-SNAPSHOT"
}

dependencies {
    // To change the versions see the gradle.properties file
    minecraft("com.mojang", "minecraft", project.extra["minecraft_version"] as String)
    mappings("net.fabricmc", "yarn", project.extra["yarn_mappings"] as String, null, "v2")
    modImplementation("net.fabricmc", "fabric-loader", project.extra["loader_version"] as String)

    // Fabric
    modImplementation("net.fabricmc.fabric-api", "fabric-api", project.extra["fabric_version"] as String)
    modImplementation("net.fabricmc", "fabric-language-kotlin", "${project.extra["fabric_kotlin_version"]}+kotlin.${rootProject.extra["kotlinVersion"]}")

    implementation(project(":octarine-proxy"))
    implementation(project(":octarine-core"))
}
