/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.world.biome;

import dog.kaylen.octarine.mixin.GenerationSettingsAccessor;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryEntryList;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;

public class GenerationSettingsUtil {
    /**
     * Create a `GenerationSettings.Builder` from an existing settings instance.
     *
     * @param settings The existing settings instance.
     * @return A new `GenerationSettings.Builder` instantiated with the properties of the settings
     *     provided.
     */
    public static GenerationSettings.Builder from(GenerationSettings settings) {
        GenerationSettings.Builder builder = new GenerationSettings.Builder();
        // set features
        List<RegistryEntryList<PlacedFeature>> features = settings.getFeatures();
        List<List<RegistryEntry<PlacedFeature>>> mappedFeatures =
                features.stream()
                        .map(entryList -> entryList.stream().toList())
                        .collect(Collectors.toList());
        mappedFeatures.forEach(
                featureStep -> {
                    int step = 0;
                    for (RegistryEntry<PlacedFeature> feature : featureStep) {
                        builder.feature(step, feature);
                        step += 1;
                    }
                });
        // set carvers
        GenerationSettingsAccessor mixinSettings = (GenerationSettingsAccessor) settings;
        Map<GenerationStep.Carver, List<RegistryEntry<ConfiguredCarver<?>>>> mappedCarvers =
                mixinSettings.getCarvers().entrySet().stream()
                        .map(entry -> Map.entry(entry.getKey(), entry.getValue().stream().toList()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        // append carvers to builder
        mappedCarvers.forEach(
                (carver, registryEntries) -> {
                    registryEntries.forEach(
                            entry -> {
                                builder.carver(carver, entry);
                            });
                });
        // return builder
        return (GenerationSettings.Builder) builder;
    }
}
