package dog.kaylen.octarine.core.registry

import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.EntityType.EntityFactory
import net.minecraft.entity.LivingEntity
import net.minecraft.registry.Registries
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder

object OctarineEntityTypes : OctarineRegistry<EntityType<*>>(
    Registries.ENTITY_TYPE
) {
    fun <T : Entity> create(
        name: String,
        factory: EntityFactory<T>,
        block: QuiltEntityTypeBuilder<T>.() -> Unit
    ): EntityType<T> {
        return create(
            name,
            QuiltEntityTypeBuilder.create<T>().entityFactory(factory).apply(block).build()
        ) as EntityType<T>
    }

    fun <T : LivingEntity> createLiving(
        name: String,
        factory: EntityFactory<T>,
        block: QuiltEntityTypeBuilder<T>.() -> Unit
    ): EntityType<T> {
        return create(
            name,
            QuiltEntityTypeBuilder.createLiving<>()<T>().entityFactory(factory).apply(block).build()
        ) as EntityType<T>
    }

    fun <T : Entity> createMob(
        name: String,
        factory: EntityFactory<T>,
        block: QuiltEntityTypeBuilder<T>.() -> Unit
    ): EntityType<T> {
        return create(
            name,
            QuiltEntityTypeBuilder.createMob<>()<T>().entityFactory(factory).apply(block).build()
        ) as EntityType<T>
    }
}
