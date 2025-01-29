/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.brewing.block

import dog.kaylen.octarine.brewing.registry.BrewingBlockEntityTypes
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.math.BlockPos

class StilBlockEntity(pos: BlockPos, state: BlockState) : BlockEntity(
    BrewingBlockEntityTypes.STIL,
    pos,
    state,
) {
    val inventory = StilBlockInventory()
}
