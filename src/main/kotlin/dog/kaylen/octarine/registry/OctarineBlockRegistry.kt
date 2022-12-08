/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry

import dog.kaylen.octarine.block.DeepslateOctironOre
import dog.kaylen.octarine.block.OctarineBlock
import dog.kaylen.octarine.block.OctironOreBlock
import net.minecraft.block.Block
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

/**
 * The Octarine block registry.
 */
object OctarineBlockRegistry : OctarineRegistry<OctarineBlock, Block>(Registry.BLOCK) {
    val OCTIRON_ORE = create(OctironOreBlock)
    val DEEPSLATE_OCTIRON_ORE = create(DeepslateOctironOre)

    override fun identifierOf(element: OctarineBlock): Identifier {
        return element.identifier
    }
}
