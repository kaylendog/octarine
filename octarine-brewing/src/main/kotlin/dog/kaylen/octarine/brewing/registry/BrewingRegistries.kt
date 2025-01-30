package dog.kaylen.octarine.brewing.registry

import dog.kaylen.octarine.core.api.RegistrySet

object BrewingRegistries : RegistrySet() {
    val BLOCK = include(BrewingBlocks)
    val ENTITY_TYPE = include(BrewingBlockEntityTypes)
}
