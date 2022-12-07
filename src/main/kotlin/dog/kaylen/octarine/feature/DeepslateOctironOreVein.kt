/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.feature

import dog.kaylen.octarine.OctarineMod
import dog.kaylen.octarine.util.OnceCell
import net.minecraft.world.gen.feature.Feature
import java.util.*
import java.util.function.Predicate
import java.util.function.Supplier

class DeepslateOctironOreVein : OctarineFeature() {
    override val key: String?
        get() = "deepslate_octiron_ore_vein"
    override val configuredFeature: ConfiguredFeature<*, *>
        get() = Companion.configuredFeature.getOrInit(
            Supplier {
                ConfiguredFeature<Any?, Any?>(
                    Feature.ORE,
                    OreFeatureConfig(
                        OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                        OctarineMod.getInstance()
                            .getRegistries().BLOCK.DEEPSLATE_OCTIRON_ORE_BLOCK
                            .getDefaultState(),
                        3
                    )
                )
            }
        )
    override val placedFeature: PlacedFeature
        get() = Companion.placedFeature.getOrInit(
            Supplier {
                PlacedFeature(
                    RegistryEntry.of<ConfiguredFeature<*, *>>(Companion.configuredFeature.get()),
                    Arrays.asList<PlacementModifier>(
                        CountPlacementModifier.of(6),
                        SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.trapezoid(
                            YOffset.aboveBottom(-64),
                            YOffset.belowTop(0)
                        )
                    )
                )
            }
        )
    override val biomeSelector: Predicate<Any?>?
        get() = BiomeSelectors.foundInOverworld()
    override val generationStep: GenerationStep.Feature
        get() = GenerationStep.Feature.UNDERGROUND_ORES

    companion object {
        private val configuredFeature: OnceCell<ConfiguredFeature<*, *>> = OnceCell<ConfiguredFeature<*, *>>()
        private val placedFeature: OnceCell<PlacedFeature> = OnceCell<PlacedFeature>()
    }
}
