/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.biome;

import dog.kaylen.octarine.OctarineMod;
import dog.kaylen.octarine.util.Identifiable;
import dog.kaylen.octarine.world.biome.GenerationSettingsUtil;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;

/** Utility interface providing methods to biome classes. */
public interface GenericBiome extends Identifiable {
    //// Source method: TerrestriaBiomes.java
    //// Copyright (C) 2022 TerraformersMC and contributors.
    // Copied from Traverse
    static BiomeEffects.Builder createDefaultBiomeEffects() {
        return new BiomeEffects.Builder()
                .waterColor(0x3F76E4)
                .waterFogColor(0x50533)
                .skyColor(getSkyColor(0.2F))
                .fogColor(0xC0D8FF);
    }
    // Copied from Minecraft
    static int getSkyColor(float temperature) {
        float f = temperature / 3.0F;
        f = MathHelper.clamp(f, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    /**
     * Create a `Biome.Builder` instance initialized with the properties of an existing biome.
     *
     * @param key The key of the biome in the `BIOME` registry.
     * @return A new `Biome.Builder` instance initialized with the biome's existing properties.
     */
    static Biome.Builder builderFromBiome(RegistryKey<Biome> key) {
        return Biome.Builder.copy(BuiltinRegistries.BIOME.entryOf(key).value());
    }

    /**
     * Create a `GenerationSettings.Builder` instance initialized with the generation settings of an
     * existing biome.
     *
     * @param key The key of the biome in the `BIOME` registry.
     * @return A new `GenerationSettings.Builder` instance initialized with the biome's generation
     *     settings.
     */
    static GenerationSettings.Builder generationSettingsBuilderFromBiome(RegistryKey<Biome> key) {
        return GenerationSettingsUtil.from(
                BuiltinRegistries.BIOME.entryOf(key).value().getGenerationSettings());
    }

    /**
     * @return The constructed biome confiugration.
     */
    Biome getBiome();

    /** Register the biome with Minecraft's registries. */
    default void register() {
        OctarineMod.LOGGER.debug("Registering biome 'octarine/biome:{}'...", this.getKey());
        RegistryKey<Biome> biomeKey = RegistryKey.of(Registry.BIOME_KEY, this.getIdentifier());
        Registry.register(BuiltinRegistries.BIOME, biomeKey, this.getBiome());
    }
}
