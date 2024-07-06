/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

/**
 * A wrapper around a registry allowing the specified types.
 */
abstract class OctarineRegistry<T : U, U>(private val internal: Registry<in U>) {
    protected val store = hashMapOf<Identifier, U>()

    /**
     * Create a new registry for a specific class type.
     */
    constructor(key: String, clazz: Class<U>) : this(
        FabricRegistryBuilder.createSimple(clazz, identifierOf(key)).buildAndRegister(),
    )

    /**
     * Create a new entry in this registry and return it.
     */
    fun register(element: T): T {
        this.store[this.identifierOfElement(element)] = element
        return element
    }

    /**
     * Register all elements declared to this registry.
     */
    fun registerAll() {
        store.entries.forEach {
            Registry.register(this.internal, it.key, it.value)
        }
    }

    /**
     * Get the element's identifier.
     */
    protected abstract fun identifierOfElement(element: T): Identifier
}
