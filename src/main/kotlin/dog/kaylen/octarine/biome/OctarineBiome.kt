/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.biome

import dog.kaylen.octarine.util.Identifiable
import dog.kaylen.octarine.world.biome.GenerationSettingsUtil
import net.minecraft.util.math.MathHelper
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeEffects
import net.minecraft.world.biome.GenerationSettings

/** Utility interface providing methods to biome classes.  */
abstract class OctarineBiome : Identifiable {
    /**
     * @return The constructed biome confiugration.
     */
    @JvmField
    abstract val biome: Biome?

    companion object {
        // // Source method: TerrestriaBiomes.java
        // // Copyright (C) 2022 TerraformersMC and contributors.
        // Copied from Traverse
        fun createDefaultBiomeEffects(): BiomeEffects.Builder {
            return BiomeEffects.Builder()
                .waterColor(0x3F76E4)
                .waterFogColor(0x50533)
                .skyColor(getSkyColor(0.2f))
                .fogColor(0xC0D8FF)
        }

        // Copied from Minecraft
        @JvmStatic
        fun getSkyColor(temperature: Float): Int {
            var f = temperature / 3.0f
            f = MathHelper.clamp(f, -1.0f, 1.0f)
            return MathHelper.hsvToRgb(0.62222224f - f * 0.05f, 0.5f + f * 0.1f, 1.0f)
        }

        /**
         * Create a `Biome.Builder` instance initialized with the properties of an existing biome.
         *
         * @param key The key of the biome in the `BIOME` registry.
         * @return A new `Biome.Builder` instance initialized with the biome's existing properties.
         */
        fun builderFromBiome(key: RegistryKey<Biome?>?): Biome.Builder {
            return Biome.Builder.copy(BuiltinRegistries.BIOME.entryOf(key).value())
        }

        /**
         * Create a `GenerationSettings.Builder` instance initialized with the generation settings of an
         * existing biome.
         *
         * @param key The key of the biome in the `BIOME` registry.
         * @return A new `GenerationSettings.Builder` instance initialized with the biome's generation
         * settings.
         */
        fun generationSettingsBuilderFromBiome(key: RegistryKey<Biome?>?): GenerationSettings.Builder? {
            return GenerationSettingsUtil.from(
                BuiltinRegistries.BIOME.entryOf(key).value().generationSettings
            )
        }
    }
}
