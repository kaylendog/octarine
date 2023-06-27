/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.content.brewing

import dog.kaylen.octarine.OctarineBlockEntityTypes
import dog.kaylen.octarine.common.OctarineBlockEntity
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos

class StilBlockEntity(pos: BlockPos, state: BlockState) : OctarineBlockEntity(
    OctarineBlockEntityTypes.STIL,
    pos,
    state
), Inventory {
    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun size(): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getStack(slot: Int): ItemStack {
        TODO("Not yet implemented")
    }

    override fun removeStack(slot: Int, amount: Int): ItemStack {
        TODO("Not yet implemented")
    }

    override fun removeStack(slot: Int): ItemStack {
        TODO("Not yet implemented")
    }

    override fun setStack(slot: Int, stack: ItemStack?) {
        TODO("Not yet implemented")
    }

    override fun canPlayerUse(player: PlayerEntity?): Boolean {
        TODO("Not yet implemented")
    }
}
