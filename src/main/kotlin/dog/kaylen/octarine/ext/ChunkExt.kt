/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.ext

import dog.kaylen.octarine.world.chunk.OctarineChunk
import net.minecraft.world.chunk.Chunk
import net.minecraft.world.chunk.ChunkStatus
import net.minecraft.world.chunk.WorldChunk

/**
 * Get the Octarine chunk representation.
 */
fun Chunk.octarine(): OctarineChunk {
    return this as OctarineChunk
}

/**
 * Get the WorldChunk representation.
 */
fun Chunk.worldChunk(): WorldChunk {
    return this as WorldChunk
}

/**
 * Get a list of adjacent loaded chunks.
 */
fun <T : WorldChunk> T.adjacents(): List<WorldChunk> {
    val north = this.world.getChunk(this.pos.x, this.pos.z - 1, ChunkStatus.NOISE, true)?.worldChunk()
    val south = this.world.getChunk(this.pos.x, this.pos.z + 1, ChunkStatus.NOISE, true)?.worldChunk()
    val east = this.world.getChunk(this.pos.x + 1, this.pos.z, ChunkStatus.NOISE, true)?.worldChunk()
    val west = this.world.getChunk(this.pos.x - 1, this.pos.z, ChunkStatus.NOISE, true)?.worldChunk()
    return listOfNotNull(north, east, south, west)
}
