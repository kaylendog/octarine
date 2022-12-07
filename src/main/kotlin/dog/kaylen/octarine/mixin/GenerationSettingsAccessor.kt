/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.mixin

import net.minecraft.world.biome.GenerationSettings
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.gen.Accessor

@Mixin(GenerationSettings::class)
interface GenerationSettingsAccessor {
    @JvmField
    @get:Accessor("carvers")
    val carvers: Map<Any?, Any?>?
}
