import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.maven

class OctarineModPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("java")
            pluginManager.apply("org.jetbrains.kotlin.jvm")
            pluginManager.apply("org.quiltmc.loom")
            pluginManager.apply("com.diffplug.spotless")

            // apply all repositories
            repositories.apply {
                maven("https://maven.blamejared.com")
                maven("https://maven.ladysnake.org/releases")
                exclusiveContent {
                    forRepository { maven("https://api.modrinth.com/maven") }
                    filter { includeGroup("maven.modrinth") }
                }
            }
        }
    }
}
