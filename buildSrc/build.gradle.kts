import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "dog.kaylen.octarine.build"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(libs.plugins.kotlin.gradlePlugin)
//    compileOnly(libs.plugins.quilt.loom.gradlePlugin)
//    compileOnly(libs.plugins.spotless.gradlePlugin)
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
            id = "octarine.mod"
            implementationClass = "OctarineModPlugin"
        }
    }
}
