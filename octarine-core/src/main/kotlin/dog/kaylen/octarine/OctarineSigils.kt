/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine

import dog.kaylen.octarine.common.OctarineRegistry
import dog.kaylen.octarine.content.magic.Sigil
import net.minecraft.util.Identifier

object OctarineSigils : OctarineRegistry<Sigil, Sigil>("sigils", Sigil::class.java) {
    override fun identifierOfElement(element: Sigil): Identifier {
        return element.identifier
    }
}
