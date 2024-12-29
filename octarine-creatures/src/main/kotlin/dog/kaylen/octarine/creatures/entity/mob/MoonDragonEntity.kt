package dog.kaylen.octarine.creatures.entity.mob

import net.minecraft.entity.EntityType
import net.minecraft.entity.boss.dragon.EnderDragonEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.world.World

class MoonDragonEntity(
    variant: EntityType<out EnderDragonEntity>,
    world: World
) : EnderDragonEntity(variant, world) {
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
