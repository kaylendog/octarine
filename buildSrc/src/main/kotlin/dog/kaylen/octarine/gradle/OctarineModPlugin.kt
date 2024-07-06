import org.gradle.api.Plugin
import org.gradle.api.Project

class OctarineModPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.diffplug.spotless")
            pluginManager.apply("org.jetbrains.kotlin.jvm")
            pluginManager.apply("org.quiltmc.loom")
        }
    }
}
