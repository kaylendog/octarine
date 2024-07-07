package dog.kaylen.octarine.creatures.entity.passive

import creatures.registry.CreatureEntityTypes
import net.minecraft.entity.passive.AxolotlEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.world.World

class SalamanderEntity(world: World) : AxolotlEntity(
    CreatureEntityTypes.SALAMANDER,
    world
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
