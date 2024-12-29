package dog.kaylen.octarine.creatures.entity.passive

import net.minecraft.entity.EntityType
import net.minecraft.entity.passive.AxolotlEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.world.World

class SalamanderEntity(
    variant: EntityType<out AxolotlEntity>,
    world: World
) : AxolotlEntity(variant, world) {
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
