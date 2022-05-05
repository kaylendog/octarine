/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;

public class RawOctironItem extends OctarineItem {
    public RawOctironItem() {
        super(new FabricItemSettings().group(ItemGroup.MATERIALS));
    }

    @Override
    public String getKey() {
        return "raw_octiron";
    }
}
