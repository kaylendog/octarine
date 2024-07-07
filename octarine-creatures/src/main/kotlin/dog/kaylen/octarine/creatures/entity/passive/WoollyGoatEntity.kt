package dog.kaylen.octarine.creatures.entity.passive

import creatures.registry.CreatureEntityTypes
import net.minecraft.entity.passive.GoatEntity
import net.minecraft.world.World

class WoollyGoatEntity(world: World) : GoatEntity(
    CreatureEntityTypes.WOOLLY_GOAT,
    world
)
