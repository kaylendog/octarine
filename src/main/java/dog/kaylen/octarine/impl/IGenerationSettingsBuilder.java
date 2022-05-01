/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryEntryList;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;

public interface IGenerationSettingsBuilder {
    /**
     * Create a `GenerationSettings.Builder` from an existing settings instance.
     *
     * @param settings The existing settings instance.
     * @return A new `GenerationSettings.Builder` instantiated with the properties of the settings
     *     provided.
     */
    static GenerationSettings.Builder from(GenerationSettings settings) {
        IGenerationSettingsBuilder builder =
                (IGenerationSettingsBuilder) new GenerationSettings.Builder();
        // set features
        List<RegistryEntryList<PlacedFeature>> features = settings.getFeatures();
        List<List<RegistryEntry<PlacedFeature>>> mappedFeatures =
                features.stream()
                        .map(entryList -> entryList.stream().toList())
                        .collect(Collectors.toList());
        builder.setFeatures(mappedFeatures);
        // set carvers
        IGenerationSettings mixinSettings = (IGenerationSettings) settings;
        Map<GenerationStep.Carver, List<RegistryEntry<ConfiguredCarver<?>>>> mappedCarvers =
                mixinSettings.getCarvers().entrySet().stream()
                        .map(entry -> Map.entry(entry.getKey(), entry.getValue().stream().toList()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        builder.setCarvers(mappedCarvers);
        // return builder
        return (GenerationSettings.Builder) builder;
    }

    void setFeatures(List<List<RegistryEntry<PlacedFeature>>> features);

    void setCarvers(Map<GenerationStep.Carver, List<RegistryEntry<ConfiguredCarver<?>>>> carvers);
}
