/*
 * (C) Copyright 2023 Kaylen Dart (https://www.kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.component

import dev.onyxstudios.cca.api.v3.component.Component
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent
import net.minecraft.nbt.NbtCompound
import net.minecraft.world.chunk.Chunk
import net.minecraft.world.chunk.WorldChunk
import dog.kaylen.octarine.extension.octarine
import kotlin.math.pow
import kotlin.random.Random

class ThaumComponent(private val chunk: Chunk) : Component, ServerTickingComponent {
    companion object {
        const val SPEED = 0.5F
        const val DAMPING = 0.1F
        const val NOISE_FACTOR = 0.01F
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

        val north = this.chunk.world.chunkManager.getWorldChunk(this.chunk.pos.x, this.chunk.pos.z - 1)
        val east = this.chunk.world.chunkManager.getWorldChunk(this.chunk.pos.x + 1, this.chunk.pos.z)
        val south = this.chunk.world.chunkManager.getWorldChunk(this.chunk.pos.x, this.chunk.pos.z + 1)
        val west = this.chunk.world.chunkManager.getWorldChunk(this.chunk.pos.x - 1, this.chunk.pos.z)

        // compute D2T
        val southNorthD2X = computeD2X(south, north)
        val eastWestD2X = computeD2X(east, west)

        this.delta2 = SPEED.pow(2) * (southNorthD2X + eastWestD2X) - DAMPING * this.delta
        val avgDelta = (this.delta + (this.delta2 + delta2 / 20)) / 2 // slightly better approx
        this.value += avgDelta / 20 + (Random.nextFloat() - 1/2) * NOISE_FACTOR
        this.delta += this.delta2 / 20
    }

    fun computeD2X(x1: Chunk?, x3: Chunk?): Float {
        val x1_v = x1?.octarine()?.thaum?.value ?: 0F
        val x3_v = x3?.octarine()?.thaum?.value ?: 0F
        return x1_v - 2 * this.value + x3_v
    }
}
