package dog.kaylen.octarine.brewing.registry

import dog.kaylen.octarine.core.api.RegistrySet

object BrewingRegistries : RegistrySet() {
    val ENTITY_TYPES = include(BrewingBlockEntityTypes)
}
