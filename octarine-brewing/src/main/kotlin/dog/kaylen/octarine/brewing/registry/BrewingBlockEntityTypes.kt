package dog.kaylen.octarine.brewing.registry

import dog.kaylen.octarine.brewing.OctarineBrewingMod
import dog.kaylen.octarine.brewing.block.StilBlockEntity
import dog.kaylen.octarine.core.api.NamespacedRegistry
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.registry.Registries

object BrewingBlockEntityTypes : NamespacedRegistry<BlockEntityType<*>>(
    OctarineBrewingMod.MOD_ID,
    Registries.BLOCK_ENTITY_TYPE,
) {
    val STIL = create("stil",  BlockEntityType.Builder.create(::StilBlockEntity, BrewingBlocks.STIL).build(null))
}
