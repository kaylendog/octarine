/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.util

import net.minecraft.util.Identifier

/** Utility interface implementing `getKey` and `getIdentifier` methods.  */
interface Identifiable {
    @JvmField
    @get:NonNull
    val key: String?
    val identifier: Identifier?
        /**
         * Get the identifier of this object.
         *
         * @return The identifier of this object.
         */
        get() = Identifier("dog/kaylen/octarine", key)
}
