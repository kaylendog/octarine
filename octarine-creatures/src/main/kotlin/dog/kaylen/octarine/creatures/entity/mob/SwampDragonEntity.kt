package dog.kaylen.octarine.creatures.entity.mob

import creatures.registry.CreatureEntityTypes
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.boss.dragon.EnderDragonEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.world.World

class SwampDragonEntity(world: World) : EnderDragonEntity(
    CreatureEntityTypes.SWAMP_DRAGON, world
) {
    override fun initDataTracker() {
        TODO("Not yet implemented")
    }

    override fun readCustomDataFromNbt(nbt: NbtCompound?) {
        TODO("Not yet implemented")
    }

    override fun writeCustomDataToNbt(nbt: NbtCompound?) {
        TODO("Not yet implemented")
    }
}
