/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.biome;

import java.util.Objects;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;

public class MagicalForest implements GenericBiome {
    @Override
    public Biome getBiome() {
        // copy defaults from forest
        Biome.Builder builder =
                Biome.Builder.copy(
                        Objects.requireNonNull(
                                BuiltinRegistries.BIOME.get(
                                        new Identifier("minecraft", "forest"))));
        // setup biome effects
        builder.effects(
                new BiomeEffects.Builder()
                        .fogColor(0x65406b)
                        .skyColor(0xc45fd4)
                        .grassColor(0x59c9b6)
                        .waterColor(0x7e59c9)
                        .waterFogColor(0x3f2770)
                        .build());
        // build
        return builder.build();
    }

    @Override
    public String getKey() {
        return "magical_forest";
    }
}
