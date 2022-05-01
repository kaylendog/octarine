/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.block;

import dog.kaylen.octarine.util.Identifiable;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

interface GenericBlock extends Identifiable {
    /**
     * Get the item group of this block.
     *
     * @return The item group of this block
     */
    ItemGroup getItemGroup();

    /** Register this block with the Minecraft block and item registries. */
    default void register() {
        Registry.register(Registry.BLOCK, this.getIdentifier(), (Block) this);
        Registry.register(
                Registry.ITEM,
                this.getIdentifier(),
                new BlockItem((Block) this, new Item.Settings().group(ItemGroup.MATERIALS)));
    }
}
