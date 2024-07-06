package dog.kaylen.octarine.content.world.chunk

import dog.kaylen.octarine.core.registry.OctarineComponents
import dog.kaylen.octarine.core.component.ThaumComponent
import net.minecraft.world.chunk.Chunk

interface OctarineChunk {
    val thaum: ThaumComponent
        get() = OctarineComponents.THAUM.get(this)
}

fun Chunk.octarine(): OctarineChunk {
    return this as OctarineChunk
}
