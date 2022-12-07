/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry

import dog.kaylen.octarine.WithOctarine

/**
 * Generic registry class.
 *
 * @param <T> The type stored in the registry.
</T> */
abstract class OctarineRegistry<T> : WithOctarine {
    /** List of entries in this registry.  */
    @JvmField
    protected val entries: MutableList<T> = ArrayList()

    /** Internal boolean to prevent double registration.  */
    @JvmField
    protected var hasRegistered = false

    /**
     * Create an entry in this registry.
     *
     * @param entry The entry to create.
     * @return The entry that was created.
     */
    protected fun <U : T?> create(entry: U): U {
        entries.add(entry)
        return entry
    }

    /** Register all entries in this registry with minecraft.  */
    fun registerAll() {
        if (hasRegistered) {
            this.logger.warn("OctarineRegistry.registerAll() called more than once!")
        }
        registerAllInternal()
    }

    /** Internal `registerAll` implementation.  */
    protected abstract fun registerAllInternal()
}
