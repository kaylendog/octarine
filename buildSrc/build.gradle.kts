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
    api(libs.kotlin.gradlePlugin)
    api(libs.fabric.loom.gradlePlugin)
    api(libs.spotless.gradlePlugin)
}


gradlePlugin {
    plugins {
        register("mod") {
            id = "dog.kaylen.octarine.gradle"
            implementationClass = "OctarineModPlugin"
        }
    }
}
