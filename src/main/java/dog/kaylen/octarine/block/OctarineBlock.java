/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.block;

import dog.kaylen.octarine.util.Identifiable;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;

public abstract class OctarineBlock extends Block implements Identifiable {
    /**
     * Get the item group of this block.
     *
     * @return The item group of this block
     */
    public abstract ItemGroup getItemGroup();

    public OctarineBlock(Settings settings) {
        super(settings);
    }
}
