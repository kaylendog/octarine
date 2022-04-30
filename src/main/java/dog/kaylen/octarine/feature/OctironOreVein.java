/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.feature;

import dog.kaylen.octarine.OctarineMod;
import java.util.Arrays;
import java.util.function.Predicate;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class OctironOreVein implements GenericFeature {
    @Override
    public String getKey() {
        return "octiron_ore_vein";
    }

    private static final ConfiguredFeature<?, ?> configuredFeature =
            new ConfiguredFeature(
                    Feature.ORE,
                    new OreFeatureConfig(
                            OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                            OctarineMod.OCTIRON_ORE_BLOCK.getDefaultState(),
                            9));

    @Override
    public ConfiguredFeature<?, ?> getConfiguredFeature() {
        return configuredFeature;
    }

    private static final PlacedFeature placedFeature =
            new PlacedFeature(
                    RegistryEntry.of(configuredFeature),
                    Arrays.asList(
                            CountPlacementModifier.of(20),
                            SquarePlacementModifier.of(),
                            HeightRangePlacementModifier.uniform(
                                    YOffset.getBottom(), YOffset.fixed(64))));

    @Override
    public PlacedFeature getPlacedFeature() {
        return placedFeature;
    }

    @Override
    public Predicate<BiomeSelectionContext> getBiomeSelector() {
        return BiomeSelectors.foundInOverworld();
    }

    @Override
    public GenerationStep.Feature getGenerationStep() {
        return GenerationStep.Feature.UNDERGROUND_ORES;
    }
}
