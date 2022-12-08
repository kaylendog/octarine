/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry

import dog.kaylen.octarine.spell.FireballSpell
import dog.kaylen.octarine.spell.Spell
import net.minecraft.util.Identifier

object OctarineSpellRegistry : OctarineRegistry<Spell, Spell>("spell", Spell::class.java) {
    val FIREBALL_SPELL = create(FireballSpell)
    override fun identifierOf(element: Spell): Identifier {
        return element.identifier
    }
}
