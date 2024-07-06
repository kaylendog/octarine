package dog.kaylen.octarine.brewing.block

import com.mojang.datafixers.types.Type
import net.minecraft.block.Block
import net.minecraft.block.entity.BlockEntityType

class StilBlockEntityType(
    factory: BlockEntityFactory<out StilBlockEntity>?,
    blocks: MutableSet<Block>?,
    type: Type<*>?
) : BlockEntityType<StilBlockEntity>(factory, blocks, type)
