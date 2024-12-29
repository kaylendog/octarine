package dog.kaylen.octarine.core.entity

import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder

class OctarineEntityTypeBuilder<T : Entity>(
    spawnGroup: SpawnGroup,
    factory: EntityType.EntityFactory<T>
) : QuiltEntityTypeBuilder<T>(spawnGroup, factory) {
    companion object {
        fun <T : Entity> create(): OctarineEntityTypeBuilder<T> {
            QuiltEntityTypeBuilder.create<T>()
        }
    }
}
