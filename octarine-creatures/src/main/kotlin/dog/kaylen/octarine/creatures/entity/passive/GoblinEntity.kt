package dog.kaylen.octarine.creatures.entity.passive

import net.minecraft.entity.EntityType
import net.minecraft.entity.passive.VillagerEntity
import net.minecraft.world.World

class GoblinEntity(
    variant: EntityType<out VillagerEntity>,
    world: World
) : VillagerEntity(variant, world)
