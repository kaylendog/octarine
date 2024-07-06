/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.registry

import dog.kaylen.octarine.core.OctarineBlockEntity
import dog.kaylen.octarine.core.OctarineBlockWithEntity
import dog.kaylen.octarine.core.OctarineRegistry
import dog.kaylen.octarine.core.identifierOf
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityTypeBuilder

object OctarineBlockEntityTypes : OctarineRegistry<
    BlockEntityType<OctarineBlockEntity>,
    BlockEntityType<OctarineBlockEntity>,
    >(
    Registries.BLOCK_ENTITY_TYPE,
) {
    private val identifiers = mutableMapOf<BlockEntityType<OctarineBlockEntity>, Identifier>()

    private fun register(
        name: String,
        blockEntity: QuiltBlockEntityTypeBuilder<OctarineBlockEntity>,
        block: OctarineBlockWithEntity,
    ): BlockEntityType<OctarineBlockEntity> {
        val type = blockEntity.addBlocks(block).build()
        identifiers[type] = identifierOf(name)
        return register(type)
    }

    override fun identifierOfElement(element: BlockEntityType<OctarineBlockEntity>): Identifier {
        return identifiers[element]!!
    }
}
