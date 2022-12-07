/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.world.biome

import dog.kaylen.octarine.mixin.GenerationSettingsAccessor
import lombok.experimental.UtilityClass
import java.util.function.BiConsumer
import java.util.function.Consumer
import java.util.function.Function
import java.util.stream.Collectors

@UtilityClass
object GenerationSettingsUtil {
    /**
     * Create a `GenerationSettings.Builder` from an existing settings instance.
     *
     * @param settings The existing settings instance.
     * @return A new `GenerationSettings.Builder` instantiated with the properties of the settings
     * provided.
     */
    fun from(settings: GenerationSettings): GenerationSettings.Builder {
        val builder: GenerationSettings.Builder = GenerationSettings.Builder()
        // set features
        val features: List<RegistryEntryList<PlacedFeature>> = settings.getFeatures()
        val mappedFeatures: List<List<RegistryEntry<PlacedFeature>>> = features.stream()
            .map<List<RegistryEntry<PlacedFeature>>>(
                Function<RegistryEntryList<PlacedFeature>, List<RegistryEntry<PlacedFeature>>> { entryList: RegistryEntryList<PlacedFeature> ->
                    entryList.stream().toList()
                }
            )
            .collect(Collectors.toList<List<RegistryEntry<PlacedFeature>>>())
        mappedFeatures.forEach(
            Consumer<List<RegistryEntry<PlacedFeature>>> { featureStep: List<RegistryEntry<PlacedFeature>> ->
                var step = 0
                for (feature in featureStep) {
                    builder.feature(step, feature)
                    step += 1
                }
            }
        )
        // set carvers
        val mixinSettings = settings as GenerationSettingsAccessor
        val mappedCarvers: Map<GenerationStep.Carver, List<RegistryEntry<ConfiguredCarver<*>>>> =
            mixinSettings.carvers.entries.stream()
                .map<Map.Entry<GenerationStep.Carver, List<RegistryEntry<ConfiguredCarver<*>>?>>>(
                    Function<Map.Entry<GenerationStep.Carver, RegistryEntryList<ConfiguredCarver<*>?>>, Map.Entry<GenerationStep.Carver, List<RegistryEntry<ConfiguredCarver<*>>?>>> { (key, value): Map.Entry<GenerationStep.Carver, RegistryEntryList<ConfiguredCarver<*>?>> ->
                        java.util.Map.entry<GenerationStep.Carver, List<RegistryEntry<ConfiguredCarver<*>>?>>(
                            key,
                            value.stream().toList()
                        )
                    }
                )
                .collect(
                    Collectors.toMap<Map.Entry<GenerationStep.Carver, List<RegistryEntry<ConfiguredCarver<*>>?>>, GenerationStep.Carver, List<RegistryEntry<ConfiguredCarver<*>>>>(
                        Function<Map.Entry<GenerationStep.Carver, List<RegistryEntry<ConfiguredCarver<*>>?>>, GenerationStep.Carver> { (key, value) -> java.util.Map.Entry.key },
                        Function<Map.Entry<GenerationStep.Carver, List<RegistryEntry<ConfiguredCarver<*>>?>>, List<RegistryEntry<ConfiguredCarver<*>>>> { (key, value) -> java.util.Map.Entry.value }
                    )
                )
        // append carvers to builder
        mappedCarvers.forEach(
            BiConsumer<GenerationStep.Carver, List<RegistryEntry<ConfiguredCarver<*>?>?>> { carver: GenerationStep.Carver?, registryEntries: List<RegistryEntry<ConfiguredCarver<*>?>?> ->
                registryEntries.forEach(
                    Consumer<RegistryEntry<ConfiguredCarver<*>?>> { entry: RegistryEntry<ConfiguredCarver<*>?>? ->
                        builder.carver(
                            carver,
                            entry
                        )
                    }
                )
            }
        )
        // return builder
        return builder as GenerationSettings.Builder
    }
}
