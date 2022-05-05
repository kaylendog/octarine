/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.util;

import lombok.NonNull;
import net.minecraft.util.Identifier;

/** Utility interface implementing `getKey` and `getIdentifier` methods. */
public interface Identifiable {
    /**
     * Get the registry key of this object.
     *
     * @return The registry key of this object.
     */
    @NonNull
    String getKey();

    /**
     * Get the identifier of this object.
     *
     * @return The identifier of this object.
     */
    default Identifier getIdentifier() {
        return new Identifier("octarine", this.getKey());
    }
}
