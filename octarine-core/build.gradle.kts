plugins {
    id("com.diffplug.spotless")
    kotlin("jvm")
    java
}

version = project.extra["modVersion"] as String
group = "dog.kaylen"

dependencies {
    implementation(project(":octarine-proxy"))
}
