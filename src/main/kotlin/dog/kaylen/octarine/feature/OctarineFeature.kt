/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.feature

import dog.kaylen.octarine.WithOctarine
import dog.kaylen.octarine.util.Identifiable
import java.util.function.Predicate

/** A utility interface implemented by features for ease of use.  */
abstract class OctarineFeature : Identifiable, WithOctarine {
    /**
     * @return This feature's `ConfiguredFeature` configuration.
     */
    @JvmField
    abstract val configuredFeature: ConfiguredFeature<*, *>?

    /**
     * @return This feature's `PlacedFeature` configuration.
     */
    @JvmField
    abstract val placedFeature: PlacedFeature?

    /**
     * @return This feature's biome selector.
     */
    @JvmField
    abstract val biomeSelector: Predicate<Any?>?

    /**
     * @return This feature's generation step.
     */
    @JvmField
    abstract val generationStep: GenerationStep.Feature?
}
