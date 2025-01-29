/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.brewing.block

import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.math.BlockPos
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings

object StilBlock : BlockWithEntity(QuiltBlockSettings.create()) {
    override fun createBlockEntity(pos: BlockPos, state: BlockState): StilBlockEntity {
        return StilBlockEntity(pos, state)
    }
}
