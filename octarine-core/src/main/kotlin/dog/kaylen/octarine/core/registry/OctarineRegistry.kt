/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.registry

import dog.kaylen.octarine.core.util.identifierOf
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.util.Identifier

/**
 * A wrapper around a [Registry] allowing the specified types.
 */
abstract class OctarineRegistry<T>(private val parent: Registry<in T>) {
    private val internal = mutableMapOf<Identifier, T>()

    /**
     * Create a new registry for a specific class type.
     */
    constructor(key: String) : this(
        FabricRegistryBuilder.createSimple<T>(RegistryKey.ofRegistry(identifierOf(key))).buildAndRegister(),
    )

    /**
     * Create a new entry in this registry and return it.
     */
    fun create(name: String, element: T): T {
        return element
    }

    /**
     * Initialize this registry.
     */
    fun init() {
        internal.forEach { Registry.register(parent, it.key, it.value) }
    }
}
