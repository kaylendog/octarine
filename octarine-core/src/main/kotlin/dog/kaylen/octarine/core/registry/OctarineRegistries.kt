/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.registry

/**
 * Utility object to mitigate runtime registry initialization issues.
 */
object OctarineRegistries {
    private val registries = mutableListOf<OctarineRegistry<*, *>>()

    val BLOCKS = include(OctarineBlocks)
    val BLOCK_ENTITY_TYPES = include(OctarineBlockEntityTypes)
    val ITEMS = include(OctarineItems)
    val RECIPE_TYPES = include(OctarineRecipeTypes)

    /**
     * Include this registry in the registry object.
     */
    private fun <T : OctarineRegistry<*, *>> include(registry: T): T {
        registries.add(registry)
        return registry
    }

    /**
     * Register all objects declared to every registry.
     */
    fun registerAll() {
        registries.forEach { it.registerAll() }
    }
}
