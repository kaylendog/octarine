/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.item;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public interface GenericItem {
    /**
     * Get the registry key of this block.
     *
     * @return The registry key of this block.
     */
    String getKey();

    /**
     * Get the identifier of this block.
     *
     * @return The identifier of this block.
     */
    default Identifier getIdentifier() {
        return new Identifier("octarine", this.getKey());
    }

    /** Register this item with Minecraft's item registry. */
    default void register() {
        Registry.register(Registry.ITEM, this.getIdentifier(), (Item) this);
    }
}
