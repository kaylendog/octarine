/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.block;

import java.util.Random;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DeepslateOctironOreBlock extends OctarineBlock {
    public DeepslateOctironOreBlock() {
        super(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool().luminance(3));
    }

    @Override
    public String getKey() {
        return "deepslate_octiron_ore";
    }

    @Override
    public ItemGroup getItemGroup() {
        return ItemGroup.MATERIALS;
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {}
}
