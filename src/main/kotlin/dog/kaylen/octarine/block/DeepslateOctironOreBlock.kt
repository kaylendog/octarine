/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.block

import net.minecraft.item.ItemGroup
import net.minecraft.world.World
import java.util.*

class DeepslateOctironOreBlock :
    OctarineBlock(FabricBlockSettings.of(Material.METAL).hardness(50.0f).requiresTool().luminance(3)) {
    override val key: String?
        get() = "deepslate_octiron_ore"
    override val itemGroup: ItemGroup?
        get() = ItemGroup.MATERIALS

    override fun hasRandomTicks(state: BlockState): Boolean {
        return true
    }

    fun randomDisplayTick(state: BlockState?, world: World?, pos: BlockPos?, random: Random?) {}
}
