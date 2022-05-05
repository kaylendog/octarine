/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.item;

import dog.kaylen.octarine.util.Identifiable;
import net.minecraft.item.Item;

/** A generic item placeholder class. */
public abstract class OctarineItem extends Item implements Identifiable {
    public OctarineItem(Settings settings) {
        super(settings);
    }
}
