/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;

public class OctironOreBlock extends OctarineBlock {
    public OctironOreBlock() {
        super(FabricBlockSettings.of(Material.METAL).hardness(50.0f).requiresTool().luminance(3));
    }

    @Override
    public String getKey() {
        return "octiron_ore";
    }

    @Override
    public ItemGroup getItemGroup() {
        return ItemGroup.MATERIALS;
    }
}
