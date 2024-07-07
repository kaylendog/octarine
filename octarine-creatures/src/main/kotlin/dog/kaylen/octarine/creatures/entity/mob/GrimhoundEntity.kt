package dog.kaylen.octarine.creatures.entity.mob

import creatures.registry.CreatureEntityTypes
import net.minecraft.entity.passive.WolfEntity
import net.minecraft.world.EntityView
import net.minecraft.world.World

class GrimhoundEntity(world: World) : WolfEntity(
    CreatureEntityTypes.GRIMHOUND, world
) {
    override fun getEntityView(): EntityView {
        TODO("Not yet implemented")
    }
}
