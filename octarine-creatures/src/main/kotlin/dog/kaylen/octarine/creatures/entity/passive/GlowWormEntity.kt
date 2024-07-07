package dog.kaylen.octarine.creatures.entity.passive

import creatures.registry.CreatureEntityTypes
import net.minecraft.entity.mob.SilverfishEntity
import net.minecraft.world.World

class GlowWormEntity(world: World) : SilverfishEntity(
    CreatureEntityTypes.GLOW_WORM,
    world
)
