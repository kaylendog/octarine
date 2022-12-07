/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry

import dog.kaylen.octarine.biome.MagicalForest
import dog.kaylen.octarine.biome.OctarineBiome
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryKey
import java.util.function.Consumer

class OctarineBiomeRegistry : OctarineRegistry<OctarineBiome?>() {
    val MAGICAL_FOREST_BIOME = create(MagicalForest())
    override fun registerAllInternal() {
        entries.forEach(
            Consumer { entry: OctarineBiome ->
                this.logger
                    .debug("Registering biome 'octarine/biome:{}'...", entry.key)
                val biomeKey = RegistryKey.of(Registry.BIOME_KEY, entry.identifier)
                Registry.register(BuiltinRegistries.BIOME, biomeKey, entry.biome)
            }
        )
    }
}
