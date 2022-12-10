/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry

import dog.kaylen.octarine.LOGGER
import dog.kaylen.octarine.util.identifierOf
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

/**
 * A wrapper around a registry allowing the specified types.
 */
abstract class OctarineRegistry<T : U, U>(protected val internal: Registry<U>) {
    protected val preinitializedStore = hashMapOf<Identifier, U>()

    /**
     * Create a new registry for a specific class type.
     */
    constructor(key: String, clazz: Class<U>) : this(
        FabricRegistryBuilder.createSimple(clazz, identifierOf(key)).buildAndRegister()
    )

    /**
     * Create a new entry in this registry and return it.
     */
    fun create(element: T): T {
        LOGGER.info("Registering ${this.identifierOf(element)} in registry ${this.internal.key.value}...")

        this.preinitializedStore[this.identifierOf(element)] = element
        return element
    }

    /**
     * Register all elements declared to this registry.
     */
    fun registerAll() {
        preinitializedStore.entries.forEach {
            Registry.register(this.internal, it.key, it.value)
        }
    }

    /**
     * Get the element's identifier.
     */
    protected abstract fun identifierOf(element: T): Identifier
}
