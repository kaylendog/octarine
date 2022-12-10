/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.ext

import net.minecraft.util.math.random.Random

/**
 * Generate a boolean based on a given probability. This boolean will be true with a probability of `p`, and false with a
 * probability of `1 - p`.
 */
fun Random.nextBoolean(probability: Double): Boolean { return this.nextDouble() < probability }
