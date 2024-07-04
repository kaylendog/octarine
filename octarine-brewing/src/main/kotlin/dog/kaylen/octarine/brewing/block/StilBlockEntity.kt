/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.content.brewing.block

import dog.kaylen.octarine.OctarineBlockEntityTypes
import dog.kaylen.octarine.common.OctarineBlockEntity
import net.minecraft.block.BlockState
import net.minecraft.util.math.BlockPos

class StilBlockEntity(pos: BlockPos, state: BlockState) : OctarineBlockEntity(
    OctarineBlockEntityTypes.STIL,
    pos,
    state,
) {
    val inventory = StilBlockInventory()
}
