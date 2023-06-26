/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.common

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryKey

/**
 * Create an identifier with the given key.
 */
fun identifierOf(key: String): Identifier {
    return Identifier(OCTARINE_MOD_ID, key)
}

/**
 * Create and return a registry key for the given registry and key.
 */
fun <T> registryKeyOf(registryKey: RegistryKey<Registry<T>>, key: String): RegistryKey<T> {
    return RegistryKey.of(registryKey, identifierOf(key))
}
