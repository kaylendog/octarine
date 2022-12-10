/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.mixin

import dog.kaylen.octarine.component.OctarineComponents
import dog.kaylen.octarine.world.chunk.OctarineChunk
import net.minecraft.world.chunk.WorldChunk
import org.spongepowered.asm.mixin.Mixin

@Mixin(WorldChunk::class)
abstract class WorldChunkMixin : OctarineChunk {
    override var thaum: Double
        get() { return OctarineComponents.THAUM.get(this).thaum }
        set(value) { OctarineComponents.THAUM.get(this).thaum = value }

    override var thaumChange: Double
        get() { return OctarineComponents.THAUM.get(this).thaumChange }
        set(value) { OctarineComponents.THAUM.get(this).thaumChange = value }
}
