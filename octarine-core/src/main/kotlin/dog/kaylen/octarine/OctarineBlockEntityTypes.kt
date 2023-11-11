/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine

import dog.kaylen.octarine.common.OctarineBlockEntity
import dog.kaylen.octarine.common.OctarineBlockWithEntity
import dog.kaylen.octarine.common.OctarineRegistry
import dog.kaylen.octarine.common.identifierOf
import dog.kaylen.octarine.content.brewing.StilBlockEntity
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object OctarineBlockEntityTypes : OctarineRegistry<
    BlockEntityType<OctarineBlockEntity>,
    BlockEntityType<OctarineBlockEntity>,
    >(
    Registry.BLOCK_ENTITY_TYPE,
) {
    // brewing
    val STIL = register("stil", ::StilBlockEntity, OctarineBlockWithEntities.STIL)

    private val identifiers = mutableMapOf<BlockEntityType<OctarineBlockEntity>, Identifier>()

    private fun register(
        name: String,
        blockEntity: FabricBlockEntityTypeBuilder.Factory<OctarineBlockEntity>,
        block: OctarineBlockWithEntity,
    ): BlockEntityType<OctarineBlockEntity> {
        val type = FabricBlockEntityTypeBuilder.create(blockEntity, block).build()
        identifiers[type] = identifierOf(name)
        return register(type)
    }

    override fun identifierOfElement(element: BlockEntityType<OctarineBlockEntity>): Identifier {
        return identifiers[element]!!
    }
}
