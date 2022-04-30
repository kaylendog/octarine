/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.feature;

import java.util.function.Predicate;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

/** A utility interface implemented by features for ease of use. */
public interface GenericFeature {
    /**
     * Get the registry key of this block.
     *
     * @return The registry key of this block.
     */
    String getKey();

    /**
     * Get the identifier of this block.
     *
     * @return The identifier of this block.
     */
    default Identifier getIdentifier() {
        return new Identifier("octarine", this.getKey());
    }

    /**
     * @return This feature's `ConfiguredFeature` configuration.
     */
    ConfiguredFeature<?, ?> getConfiguredFeature();

    /**
     * @return This feature's `PlacedFeature` configuration.
     */
    PlacedFeature getPlacedFeature();

    /**
     * @return This feature's biome selector.
     */
    Predicate<BiomeSelectionContext> getBiomeSelector();

    /**
     * @return This feature's generation step.
     */
    GenerationStep.Feature getGenerationStep();

    /** Register this feature with Minecraft. */
    default void register() {
        Registry.register(
                BuiltinRegistries.CONFIGURED_FEATURE,
                this.getIdentifier(),
                this.getConfiguredFeature());
        Registry.register(
                BuiltinRegistries.PLACED_FEATURE, this.getIdentifier(), this.getPlacedFeature());
        BiomeModifications.addFeature(
                this.getBiomeSelector(),
                this.getGenerationStep(),
                RegistryKey.of(Registry.PLACED_FEATURE_KEY, this.getIdentifier()));
    }
}
