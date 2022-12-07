/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.biome

import dog.kaylen.octarine.util.OnceCell
import dog.kaylen.octarine.world.biome.GenerationSettingsUtil
import net.minecraft.util.Identifier
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeEffects
import java.util.*

class MagicalForest : OctarineBiome() {
    override val biome = OnceCell<Biome>()
        get() = field.getOrInit {

            // copy defaults from forest
            val forest = BuiltinRegistries.BIOME[Identifier("minecraft", "forest")]
            val builder: Biome.Builder = Biome.Builder.copy(Objects.requireNonNull(forest))
            // setup biome effects
            builder.effects(
                BiomeEffects.Builder()
                    .fogColor(0xc45fd4)
                    .skyColor(0xfdbfff)
                    .grassColor(0x59c9b6)
                    .waterColor(0x7e59c9)
                    .waterFogColor(0x3f2770)
                    .build()
            )
            // build
            builder.generationSettings(
                GenerationSettingsUtil.from(forest!!.generationSettings).build()
            )
            builder.build()
        }
    override val key: String?
        get() = "magical_forest"
}
