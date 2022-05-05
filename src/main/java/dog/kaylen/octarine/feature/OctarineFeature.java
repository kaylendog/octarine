/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.feature;

import dog.kaylen.octarine.util.Identifiable;
import java.util.function.Predicate;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

/** A utility interface implemented by features for ease of use. */
public abstract class OctarineFeature implements Identifiable {
    /**
     * @return This feature's `ConfiguredFeature` configuration.
     */
    public abstract ConfiguredFeature<?, ?> getConfiguredFeature();

    /**
     * @return This feature's `PlacedFeature` configuration.
     */
    public abstract PlacedFeature getPlacedFeature();

    /**
     * @return This feature's biome selector.
     */
    public abstract Predicate<BiomeSelectionContext> getBiomeSelector();

    /**
     * @return This feature's generation step.
     */
    public abstract GenerationStep.Feature getGenerationStep();
}
