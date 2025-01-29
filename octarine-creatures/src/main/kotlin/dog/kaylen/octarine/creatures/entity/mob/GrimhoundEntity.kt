package dog.kaylen.octarine.creatures.entity.mob

import creatures.registry.CreatureEntityTypes
import net.minecraft.entity.passive.WolfEntity
import net.minecraft.world.EntityView
import net.minecraft.world.World

class GrimhoundEntity(world: World) : WolfEntity(
    CreatureEntityTypes.GRIMHOUND, world
) {
    // get entity view
    override fun method_48926(): EntityView {
        TODO("Not yet implemented")
    }
}
