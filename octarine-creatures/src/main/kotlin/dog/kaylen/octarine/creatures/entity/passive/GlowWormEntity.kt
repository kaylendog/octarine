package dog.kaylen.octarine.creatures.entity.passive

import net.minecraft.entity.EntityType
import net.minecraft.entity.mob.SilverfishEntity
import net.minecraft.world.World

class GlowWormEntity(
    variant: EntityType<out SilverfishEntity>,
    world: World
) : SilverfishEntity(variant, world)
