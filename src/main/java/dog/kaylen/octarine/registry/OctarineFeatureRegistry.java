/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry;

import dog.kaylen.octarine.feature.DeepslateOctironOreVein;
import dog.kaylen.octarine.feature.OctarineFeature;
import dog.kaylen.octarine.feature.OctironOreVein;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public class OctarineFeatureRegistry extends OctarineRegistry<OctarineFeature> {

    public final DeepslateOctironOreVein DEEPSLATE_OCTIRON_ORE_VEIN =
            create(new DeepslateOctironOreVein());
    public final OctironOreVein OCTIRON_ORE_VEIN = create(new OctironOreVein());

    @Override
    protected void registerAllInternal() {
        this.entries.forEach(
                (entry) -> {
                    this.getLogger()
                            .debug("Registering feature 'octarine/feature:{}'...", entry.getKey());
                    Registry.register(
                            BuiltinRegistries.CONFIGURED_FEATURE,
                            entry.getIdentifier(),
                            entry.getConfiguredFeature());
                    Registry.register(
                            BuiltinRegistries.PLACED_FEATURE,
                            entry.getIdentifier(),
                            entry.getPlacedFeature());
                    BiomeModifications.addFeature(
                            entry.getBiomeSelector(),
                            entry.getGenerationStep(),
                            RegistryKey.of(Registry.PLACED_FEATURE_KEY, entry.getIdentifier()));
                });
    }
}
