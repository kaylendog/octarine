/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.component

import dev.onyxstudios.cca.api.v3.component.ComponentV3
import dog.kaylen.octarine.registry.Identifiable
import dog.kaylen.octarine.util.identifierOf

/**
 * A component.
 */
abstract class OctarineComponent(key: String) : ComponentV3, Identifiable {
    override val identifier = identifierOf(key)
}
