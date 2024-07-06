package dog.kaylen.octarine.content.world.chunk

import dog.kaylen.octarine.OctarineComponents
import dog.kaylen.octarine.core.component.ThaumComponent

interface OctarineChunk {
    val thaum: ThaumComponent
        get() = OctarineComponents.THAUM.get(this)
}
