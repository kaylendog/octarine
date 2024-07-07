/*
 * (C) Copyright 2023 Kaylen Dart (https://www.kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.registry

import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentFactoryRegistry
import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentInitializer
import dev.onyxstudios.cca.api.v3.component.Component
import dev.onyxstudios.cca.api.v3.component.ComponentFactory
import dev.onyxstudios.cca.api.v3.component.ComponentKey
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry
import dog.kaylen.octarine.core.identifierOf
import dog.kaylen.octarine.core.component.ThaumComponent
import net.minecraft.world.chunk.Chunk

object OctarineComponents : ChunkComponentInitializer {
    val THAUM = registerChunkComponent("thaum", ThaumComponent::class.java, ::ThaumComponent)

    // stores
    private val chunkComponents = mutableMapOf<ComponentKey<out Component>, ComponentFactory<Chunk, out Component>>()

    fun <T : Component> registerChunkComponent(
        key: String,
        type: Class<T>,
        factory: ComponentFactory<Chunk, out Component>,
    ): ComponentKey<T> {
        val componentKey: ComponentKey<T> = ComponentRegistry.getOrCreate(identifierOf(key), type)
        chunkComponents[componentKey] = factory
        return componentKey
    }

    @Suppress("UNCHECKED_CAST") // i've checked it!
    override fun registerChunkComponentFactories(registry: ChunkComponentFactoryRegistry) {
        chunkComponents.forEach { (k, v) -> registry.register(k as ComponentKey<Component>, v) }
    }
}
