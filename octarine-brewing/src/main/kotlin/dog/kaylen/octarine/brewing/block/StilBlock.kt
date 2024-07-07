/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.brewing.block

import dog.kaylen.octarine.brewing.block.StilBlockEntity
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.util.math.BlockPos
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings

object StilBlock : OctarineBlockWithEntity("stil", QuiltBlockSettings.copy(Blocks.BREWING_STAND)) {
    override fun createBlockEntity(pos: BlockPos, state: BlockState): StilBlockEntity {
        return StilBlockEntity(pos, state)
    }
}
