/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.util

import dog.kaylen.octarine.core.OctarineMod
import net.minecraft.util.Identifier
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey

/**
 * Create an identifier with the given key.
 */
fun identifierOf(key: String): Identifier {
    return Identifier(OctarineMod.MOD_ID, key)
}

/**
 * Create and return a registry key for the given registry and key.
 */
fun <T> registryKeyOf(registryKey: RegistryKey<Registry<T>>, key: String): RegistryKey<T> {
    return RegistryKey.of(registryKey, identifierOf(key))
}
