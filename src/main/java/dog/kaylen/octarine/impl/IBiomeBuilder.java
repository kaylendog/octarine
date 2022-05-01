/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.impl;

public interface IBiomeBuilder {
    /**
     * @return The magical field strength of this biome.
     */
    float getThaum();
    /**
     * Set the magical field strength of this biome.
     *
     * @param value The field strength.
     */
    void thaum(float value);
}
