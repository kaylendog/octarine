package dog.kaylen.octarine.creatures.entity.mob

import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.nbt.NbtCompound
import net.minecraft.world.World

class BalrogEntity(
    variant: EntityType<*>,
    world: World
) : Entity(variant, world) {
    override fun initDataTracker() {
        TODO("Not yet implemented")
    }

    override fun readCustomDataFromNbt(nbt: NbtCompound) {
        TODO("Not yet implemented")
    }

    override fun writeCustomDataToNbt(nbt: NbtCompound) {
        TODO("Not yet implemented")
    }
}
