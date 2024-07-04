package dog.kaylen.octarine.extension

import dog.kaylen.octarine.content.world.chunk.OctarineChunk
import net.minecraft.world.chunk.Chunk

fun Chunk.octarine(): OctarineChunk {
    return this as OctarineChunk
}
