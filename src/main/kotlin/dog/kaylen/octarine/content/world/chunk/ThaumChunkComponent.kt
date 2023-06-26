/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.content.world.chunk

import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent
import dog.kaylen.octarine.component.ChunkComponent
import dog.kaylen.octarine.ext.adjacents
import dog.kaylen.octarine.ext.octarine
import dog.kaylen.octarine.ext.worldChunk
import net.minecraft.nbt.NbtCompound
import net.minecraft.world.chunk.Chunk

/**
 * Stores the thaum strength for a given chunk.
 */
class ThaumChunkComponent(val chunk: Chunk) : ChunkComponent(chunk), ServerTickingComponent {
    var thaum = 0.0
    var thaumChange = 0.0

    override fun readFromNbt(tag: NbtCompound) {
        this.thaum = tag.getDouble("thaum")
        this.thaumChange = tag.getDouble("thamChange")
    }

    override fun writeToNbt(tag: NbtCompound) {
        tag.putDouble("thaum", this.thaum)
        tag.putDouble("thaumChange", this.thaumChange)
    }

    override fun serverTick() {
        // distribute thaum every 5 seconds
        if (chunk.worldChunk().world.time % 100 != 0L) {
            return
        }
        // only distribute if thaum rises over 15
        if (this.thaum < 15) {
            return
        }
        // compute adjacents and distribute
        val thaum = this.chunk.octarine().thaum
        val thaumToDistribute = thaum * 0.02
        this.thaum -= thaumToDistribute

        val adjacents = this.chunk.worldChunk().adjacents()
        val adjacentCount = adjacents.size

        adjacents.forEach {
            it.octarine().thaum += thaumToDistribute / adjacentCount
        }
    }
}
