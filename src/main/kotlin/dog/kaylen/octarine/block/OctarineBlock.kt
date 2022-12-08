/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.block

import dog.kaylen.octarine.registry.Identifiable
import dog.kaylen.octarine.util.identifierOf
import net.minecraft.block.Block

/**
 * A wrapper around the Minecraft block type.
 */
abstract class OctarineBlock(private val key: String, settings: Settings) : Block(settings), Identifiable {
    /**
     * This block's identifier.
     */
    override val identifier get() = identifierOf(this.key)
}
