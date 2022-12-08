/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.spell

import dog.kaylen.octarine.registry.Identifiable
import dog.kaylen.octarine.util.identifierOf

abstract class Spell(val key: String) : Identifiable {
    override val identifier = identifierOf(key)
}
