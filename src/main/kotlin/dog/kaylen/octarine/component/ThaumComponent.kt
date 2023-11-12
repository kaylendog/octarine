/*
 * (C) Copyright 2023 Kaylen Dart (https://www.kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.component

import dev.onyxstudios.cca.api.v3.component.Component
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent
import net.minecraft.nbt.NbtCompound
import net.minecraft.world.chunk.Chunk
import net.minecraft.world.chunk.WorldChunk
import kotlin.math.max
import dog.kaylen.octarine.OctarineComponents

class ThaumComponent(private val chunk: Chunk) : Component, ServerTickingComponent {
    companion object {
        const val OVERFLOW = 15F
    }

    var value: Float = 0F
    var delta: Float = 0F
    var delta2: Float = 0F

    override fun readFromNbt(tag: NbtCompound) {
        this.value = tag.getFloat("value")
        this.delta = tag.getFloat("delta")
    }

    override fun writeToNbt(tag: NbtCompound) {
        tag.putFloat("value", this.value)
        tag.putFloat("delta", this.delta)
    }

    override fun serverTick() {
        if (this.chunk !is WorldChunk) {
            return
        }

        value = max(value + delta, 0F)
        // overflow logic
        if (value < 15F) {
            return
        }

        // get diagonals
        val north = this.chunk.world.chunkManager.getWorldChunk(this.chunk.pos.x, this.chunk.pos.z - 1)
        val east = this.chunk.world.chunkManager.getWorldChunk(this.chunk.pos.x + 1, this.chunk.pos.z)
        val south = this.chunk.world.chunkManager.getWorldChunk(this.chunk.pos.x, this.chunk.pos.z + 1)
        val west = this.chunk.world.chunkManager.getWorldChunk(this.chunk.pos.x - 1, this.chunk.pos.z)

        val diagonals = listOf(north, east, south, west).filter { it != null && !it.isEmpty }

        val outflow =
    }

    fun computeD2xNorthSouth(chunk: WorldChunk) {
        val north = chunk.world.chunkManager.getWorldChunk(chunk.pos.x, chunk.pos.z - 1)
        val south = chunk.world.chunkManager.getWorldChunk(chunk.pos.x, chunk.pos.z + 1)

        return OctarineComponents.THAUM
    }
}
