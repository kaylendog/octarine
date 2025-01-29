import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

group = "dog.kaylen.octarine"

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net")
}

dependencies {
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.fabric.loom.gradlePlugin)
    compileOnly(libs.spotless.gradlePlugin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

gradlePlugin {
    plugins {
        register("mod") {
            id = "dog.kaylen.octarine.gradle"
            implementationClass = "OctarineModPlugin"
        }
    }
}
