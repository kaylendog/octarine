package dog.kaylen.octarine.creatures.entity.passive

import net.minecraft.entity.EntityType
import net.minecraft.entity.passive.GoatEntity
import net.minecraft.world.World

class WoollyGoatEntity(
    variant: EntityType<out GoatEntity>,
    world: World
) : GoatEntity(variant, world)
