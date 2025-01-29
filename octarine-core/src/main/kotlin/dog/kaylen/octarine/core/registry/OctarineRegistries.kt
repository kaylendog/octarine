/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.registry

import dog.kaylen.octarine.core.api.RegistrySet

/**
 * Utility object to mitigate runtime registry initialization issues.
 */
object OctarineRegistries : RegistrySet() {
    val BLOCKS = include(OctarineRegistry)
    val BLOCK_ENTITY_TYPES = include(OctarineBlockEntityTypes)
    val ITEMS = include(OctarineItems)
    val RECIPE_TYPES = include(OctarineRecipeTypes)
}
