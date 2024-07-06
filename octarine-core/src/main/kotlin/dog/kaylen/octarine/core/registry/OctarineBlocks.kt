/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.registry

import dog.kaylen.octarine.core.OctarineBlock
import dog.kaylen.octarine.core.OctarineRegistry
import dog.kaylen.octarine.content.world.block.OctironOreBlock
import dog.kaylen.octarine.core.block.DeepslateOctironOre
import net.minecraft.block.Block
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

/**
 * The Octarine block registry.
 */
object OctarineBlocks : OctarineRegistry<OctarineBlock, Block>(Registries.BLOCK) {
    val OCTIRON_ORE = register(OctironOreBlock)
    val DEEPSLATE_OCTIRON_ORE = register(DeepslateOctironOre)

    override fun identifierOfElement(element: OctarineBlock): Identifier {
        return element.identifier
    }
}
