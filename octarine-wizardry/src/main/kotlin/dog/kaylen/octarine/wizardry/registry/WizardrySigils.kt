/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.wizardry.registry

import dog.kaylen.octarine.core.api.NamespacedRegistry
import dog.kaylen.octarine.wizardry.OctarineWizardryMod
import dog.kaylen.octarine.wizardry.sigil.Sigil

object WizardrySigils : NamespacedRegistry<Sigil>(OctarineWizardryMod.MOD_ID, "sigils")
