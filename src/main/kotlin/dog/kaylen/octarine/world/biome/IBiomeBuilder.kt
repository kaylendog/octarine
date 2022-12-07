/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.world.biome

interface IBiomeBuilder {
    /**
     * @return The magical field strength in this biome.
     */
    val thaum: Float

    /**
     * Set the magical field strength in this biome.
     *
     * @param value The magical field strength.
     * @return The biome builder.
     */
    fun thaum(value: Float): IBiomeBuilder?
}
