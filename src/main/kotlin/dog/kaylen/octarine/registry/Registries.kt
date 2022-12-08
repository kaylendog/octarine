/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry

/**
 * Utility object to mitigate runtime registry initialization issues.
 */
object Registries {
    private val registries = mutableListOf<OctarineRegistry<*, *>>()

    val BLOCKS = include(OctarineBlockRegistry)
    val ITEMS = include(OctarineItemRegistry)

    val SPELLS = include(OctarineSpellRegistry)

    /**
     * Include this registry in the registry object.
     */
    fun <T : OctarineRegistry<*, *>> include(registry: T): T {
        registries.add(registry)
        return registry
    }

    /**
     * Register all objectsd declared to every registry.
     */
    fun registerAll() {
        this.registries.forEach { it.registerAll() }
    }
}
