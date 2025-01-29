/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.wizardry.registry

import dog.kaylen.octarine.core.api.NamespacedRegistry
import dog.kaylen.octarine.wizardry.OctarineWizardryMod
import dog.kaylen.octarine.wizardry.spell.Spell
import net.minecraft.util.Identifier

object WizardrySpells : NamespacedRegistry<Spell>(OctarineWizardryMod.MOD_ID, "spell")

