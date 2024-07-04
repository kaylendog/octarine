package dog.kaylen.octarine.mixin

import dog.kaylen.octarine.content.world.chunk.OctarineChunk
import net.minecraft.world.chunk.Chunk
import org.spongepowered.asm.mixin.Mixin

@Mixin(Chunk::class)
abstract class OctarineChunkMixin : OctarineChunk
