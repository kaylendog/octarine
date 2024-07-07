import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.*
import org.gradle.language.jvm.tasks.ProcessResources

class OctarineModPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("java")
            pluginManager.apply("org.jetbrains.kotlin.jvm")
            pluginManager.apply("org.quiltmc.loom")
            pluginManager.apply("com.diffplug.spotless")

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

            tasks.withType<ProcessResources>() {
                inputs.property("version", project.version)
                inputs.property("group", project.group)
                filesMatching("quilt.mod.json") {
                    expand(mutableMapOf(
                        "version" to project.version,
                        "group" to project.group,
                        "flk_version" to "${libs.findVersion("fabric-language-kotlin").get()}"
                    ))
                }
            }

            // figure out why this isn't working
//            extensions.getByType<SpotlessExtension>().apply {
//                ratchetFrom("origin/main")
//                encoding("UTF-8")
//
//                java {
//                    googleJavaFormat().aosp().reflowLongStrings()
//                    licenseHeaderFile(rootProject.file("LICENSE_HEADER"))
//                }
//                kotlin {
//                    ktlint()
//                    licenseHeaderFile(rootProject.file("LICENSE_HEADER"))
//                }
//                kotlinGradle {
//                    ktlint()
//                }
//            }
        }
    }
}
