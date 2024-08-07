package dog.kaylen.octarine.brewing.registry

import dog.kaylen.octarine.brewing.block.StilBlockEntity
import dog.kaylen.octarine.brewing.recipe.StilRecipeType
import dog.kaylen.octarine.brewing.block.StilBlock
import dog.kaylen.octarine.core.registry.OctarineBlockEntityTypes
import dog.kaylen.octarine.core.registry.OctarineBlockWithEntities
import dog.kaylen.octarine.core.registry.OctarineRecipeTypes

object BrewingRegistries {
    object BlockWithEntities {
        val STIL = OctarineBlockWithEntities.register(StilBlock)
    }

    object BlockEntityTypes {
        val STIL = OctarineBlockEntityTypes.register(
            "stil", ::StilBlockEntity, listOf(BlockWithEntities.STIL))
    }

    object RecipeTypes {
        val STIL = OctarineRecipeTypes.register(StilRecipeType)
    }
}
