package dog.kaylen.octarine.core.registry

import net.minecraft.entity.EntityType
import net.minecraft.registry.Registries

object OctarineEntityTypes : OctarineRegistry<EntityType<*>>(
    Registries.ENTITY_TYPE
)
