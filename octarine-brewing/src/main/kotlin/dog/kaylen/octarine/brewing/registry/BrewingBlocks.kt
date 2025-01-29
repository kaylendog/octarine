package dog.kaylen.octarine.brewing.registry

import dog.kaylen.octarine.brewing.OctarineBrewingMod
import dog.kaylen.octarine.brewing.block.StilBlock
import dog.kaylen.octarine.core.api.NamespacedRegistry
import net.minecraft.block.Block
import net.minecraft.registry.Registries

object BrewingBlocks : NamespacedRegistry<Block>(
    OctarineBrewingMod.MOD_ID,
    Registries.BLOCK
) {
    val STIL = create("stil", StilBlock)
}
