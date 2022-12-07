/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.mixin

import dog.kaylen.octarine.world.biome.IBiomeBuilder
import net.minecraft.world.biome.Biome
import org.spongepowered.asm.mixin.Mixin

@Mixin(Biome.Builder::class)
abstract class MixinBiomeBuilder : IBiomeBuilder {
    override var thaum = 0f
        private set

    override fun thaum(value: Float): IBiomeBuilder {
        thaum = value
        return this
    }
}
