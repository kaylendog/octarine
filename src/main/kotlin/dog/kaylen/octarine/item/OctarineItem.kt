/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.item

import dog.kaylen.octarine.registry.Identifiable
import dog.kaylen.octarine.util.identifierOf
import net.minecraft.item.Item

/**
 * A wrapper around the Minecraft item type.
 */
abstract class OctarineItem(private val key: String, settings: Settings) : Item(settings), Identifiable {
    /**
     * This item's identifier.
     */
    override val identifier get() = identifierOf(this.key)
}
