/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.block

import dog.kaylen.octarine.core.util.Identifiable
import dog.kaylen.octarine.core.util.identifierOf
import net.minecraft.block.BlockWithEntity
import net.minecraft.util.Identifier

abstract class OctarineBlockWithEntity(private val name: String, settings: Settings) : BlockWithEntity(settings),
    Identifiable {
    override val identifier: Identifier
        get() = identifierOf(name)
}
