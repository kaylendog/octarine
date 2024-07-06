/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.registry

import dog.kaylen.octarine.core.OctarineBlockWithEntity
import dog.kaylen.octarine.core.OctarineRegistry
import net.minecraft.block.BlockWithEntity
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier

object OctarineBlockWithEntities : OctarineRegistry<OctarineBlockWithEntity, BlockWithEntity>(Registries.BLOCK) {
    override fun identifierOfElement(element: OctarineBlockWithEntity): Identifier {
        return element.identifier
    }
}
