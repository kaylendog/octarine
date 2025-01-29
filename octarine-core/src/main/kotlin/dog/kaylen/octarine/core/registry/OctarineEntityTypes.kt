package dog.kaylen.octarine.core.registry

import dog.kaylen.octarine.core.OctarineMod
import dog.kaylen.octarine.core.api.NamespacedRegistry
import net.minecraft.entity.EntityType
import net.minecraft.registry.Registries

object OctarineEntityTypes : NamespacedRegistry<EntityType<*>>(
    OctarineMod.MOD_ID,
    Registries.ENTITY_TYPE
)
