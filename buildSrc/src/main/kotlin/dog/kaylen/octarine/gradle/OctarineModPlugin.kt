import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.*
import org.gradle.language.jvm.tasks.ProcessResources
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class OctarineModPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("java")
            pluginManager.apply("org.jetbrains.kotlin.jvm")
            pluginManager.apply("fabric-loom")
            pluginManager.apply("com.diffplug.spotless")

            // Loom requires the build to run on JVM 21+, but Minecraft 1.20.1 runs on
            // Java 17 — so pin the compile target to 17 to keep the jar runnable there
            // regardless of the JDK building it.
            extensions.configure<JavaPluginExtension> {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
            tasks.withType<KotlinCompile>().configureEach {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_17)
                }
            }

            // Code style: ktlint for Kotlin sources + build scripts, prettier for JSON.
            extensions.configure<SpotlessExtension>("spotless") {
                val ktlintVersion = "1.8.0"
                kotlin {
                    target("src/**/*.kt")
                    targetExclude("**/build/**")
                    ktlint(ktlintVersion)
                }
                kotlinGradle {
                    target("*.gradle.kts")
                    ktlint(ktlintVersion)
                }
                json {
                    target("src/**/*.json")
                    targetExclude("**/build/**")
                    prettier().configFile(rootProject.file(".prettierrc.json"))
                }
            }

            // TODO: figure out if we can create custom configuration for sub-modules
            // https://fabricmc.net/wiki/documentation:fabric_loom#depending_on_sub_projects

            // access libs
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            group = "dog.kaylen.octarine"
            version = "${rootProject.extra["mod_version"]}+${libs.findVersion("minecraft").get()}"

            // apply all repositories
            repositories.apply {
                maven("https://maven.blamejared.com")
                maven("https://maven.ladysnake.org/releases")
                exclusiveContent {
                    forRepository { maven("https://api.modrinth.com/maven") }
                    filter { includeGroup("maven.modrinth") }
                }
            }

            tasks.withType<ProcessResources> {
                inputs.property("version", project.version)
                inputs.property("group", project.group)

                inputs.property("minecraft", "${libs.findVersion("minecraft").get()}")
                inputs.property("fabric_loader", "${libs.findVersion("fabric_loader").get()}")

                filesMatching("fabric.mod.json") {
                    expand(mutableMapOf(
                        "version" to project.version,
                        "group" to project.group,
                        "minecraft" to "${libs.findVersion("minecraft").get()}",
                        "fabric_loader" to "${libs.findVersion("fabric_loader").get()}"
                    ))
                }
            }
        }
    }
}
