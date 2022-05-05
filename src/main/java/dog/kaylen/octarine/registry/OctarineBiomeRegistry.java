/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry;

import dog.kaylen.octarine.biome.MagicalForest;
import dog.kaylen.octarine.biome.OctarineBiome;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class OctarineBiomeRegistry extends OctarineRegistry<OctarineBiome> {

    public final MagicalForest MAGICAL_FOREST_BIOME = create(new MagicalForest());

    @Override
    protected void registerAllInternal() {
        this.entries.forEach(
                (entry) -> {
                    this.getLogger()
                            .debug("Registering biome 'octarine/biome:{}'...", entry.getKey());
                    RegistryKey<Biome> biomeKey =
                            RegistryKey.of(Registry.BIOME_KEY, entry.getIdentifier());
                    Registry.register(BuiltinRegistries.BIOME, biomeKey, entry.getBiome());
                });
    }
}
