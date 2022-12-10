/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.component

import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentFactoryRegistry
import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentInitializer
import dev.onyxstudios.cca.api.v3.component.ComponentKey
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3
import dog.kaylen.octarine.LOGGER
import dog.kaylen.octarine.util.identifierOf
import dog.kaylen.octarine.world.chunk.ThaumChunkComponent
import kotlin.reflect.KClass

/**
 * Entrypoint for creating components.
 */
object OctarineComponents : ChunkComponentInitializer {
    // TODO: Make this work.
    // private val chunkComponents = mutableListOf<ComponentKey<*>>()

    val THAUM = declareChunkComponent("thaum", ThaumChunkComponent::class)

    /**
     * Create a chunk component
     */
    private fun <T : ChunkComponent> declareChunkComponent(key: String, component: KClass<T>): ComponentKey<T> {
        return ComponentRegistryV3.INSTANCE.getOrCreate(identifierOf(key), component.java)
        // chunkComponents.add(componentKey)
        // return componentKey
    }

    override fun registerChunkComponentFactories(registry: ChunkComponentFactoryRegistry) {
        LOGGER.info("Registering chunk components...")
        registry.register(THAUM) { ThaumChunkComponent(it) }
    }
}
