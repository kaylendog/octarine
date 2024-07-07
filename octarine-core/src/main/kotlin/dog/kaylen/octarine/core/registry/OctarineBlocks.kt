/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.registry

import dog.kaylen.octarine.core.block.DeepslateOctironOre
import dog.kaylen.octarine.core.block.OctironOreBlock
import net.minecraft.block.Block
import net.minecraft.registry.Registries

/**
 * The Octarine block registry.
 */
object OctarineBlocks : OctarineRegistry<Block>(Registries.BLOCK) {
    val OCTIRON_ORE = create("octiron_ore", OctironOreBlock)
    val DEEPSLATE_OCTIRON_ORE = create("deepslate_octiron_ore", DeepslateOctironOre)
}
