/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry

import dog.kaylen.octarine.feature.DeepslateOctironOreVein
import dog.kaylen.octarine.feature.OctarineFeature
import dog.kaylen.octarine.feature.OctironOreVein
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryKey
import java.util.function.Consumer

class OctarineFeatureRegistry : OctarineRegistry<OctarineFeature?>() {
    val DEEPSLATE_OCTIRON_ORE_VEIN = create(DeepslateOctironOreVein())
    val OCTIRON_ORE_VEIN = create(OctironOreVein())
    override fun registerAllInternal() {
        entries.forEach(
            Consumer { entry: OctarineFeature ->
                this.logger
                    .debug("Registering feature 'octarine/feature:{}'...", entry.key)
                Registry.register(
                    BuiltinRegistries.CONFIGURED_FEATURE,
                    entry.identifier,
                    entry.configuredFeature
                )
                Registry.register<PlacedFeature, PlacedFeature>(
                    BuiltinRegistries.PLACED_FEATURE,
                    entry.identifier,
                    entry.placedFeature
                )
                BiomeModifications.addFeature(
                    entry.biomeSelector,
                    entry.generationStep,
                    RegistryKey.of<PlacedFeature>(Registry.PLACED_FEATURE_KEY, entry.identifier)
                )
            }
        )
    }
}
