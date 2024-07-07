package dog.kaylen.octarine.creatures.entity.passive

import creatures.registry.CreatureEntityTypes
import net.minecraft.entity.passive.VillagerEntity
import net.minecraft.world.World

class GoblinEntity(world: World) : VillagerEntity(
    CreatureEntityTypes.GOBLIN, world
)
