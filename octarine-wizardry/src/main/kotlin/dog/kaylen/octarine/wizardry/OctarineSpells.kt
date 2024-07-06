/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine

import dog.kaylen.octarine.core.OctarineRegistry
import dog.kaylen.octarine.content.magic.Spell
import net.minecraft.util.Identifier

object OctarineSpells : OctarineRegistry<Spell, Spell>("spell") {
    override fun identifierOfElement(element: Spell): Identifier {
        return element.identifier
    }
}
