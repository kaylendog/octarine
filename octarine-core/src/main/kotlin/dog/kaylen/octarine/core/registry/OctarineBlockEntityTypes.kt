/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.registry

import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.registry.Registries

object OctarineBlockEntityTypes : OctarineRegistry<BlockEntityType<BlockEntity>, >(
    Registries.BLOCK_ENTITY_TYPE,
)
