/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core

import net.minecraft.util.Identifier

/**
 * A utility annotation for cleanly specifying the key of various objects.
 */
interface Identifiable {
    /**
     * The identifier of this object.
     */
    val identifier: Identifier
}
