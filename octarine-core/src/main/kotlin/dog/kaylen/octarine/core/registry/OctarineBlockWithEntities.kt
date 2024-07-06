/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine

import dog.kaylen.octarine.core.OctarineBlockWithEntity
import dog.kaylen.octarine.core.OctarineRegistry
import dog.kaylen.octarine.content.brewing.block.StilBlock
import net.minecraft.block.BlockWithEntity
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object OctarineBlockWithEntities : OctarineRegistry<OctarineBlockWithEntity, BlockWithEntity>(Registry.BLOCK) {
    val STIL = register(StilBlock)

    override fun identifierOfElement(element: OctarineBlockWithEntity): Identifier {
        return element.identifier
    }
}
