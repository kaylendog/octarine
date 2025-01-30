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
    val BLOCK = include(OctarineBlocks)
    val BLOCK_ENTITY_TYPE = include(OctarineBlockEntityTypes)
    val ITEM = include(OctarineItems)
    val RECIPE_TYPE = include(OctarineRecipeTypes)
}
