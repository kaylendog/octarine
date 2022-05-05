/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry;

import dog.kaylen.octarine.WithOctarine;
import java.util.ArrayList;
import java.util.List;

/**
 * Generic registry class.
 *
 * @param <T> The type stored in the registry.
 */
abstract class OctarineRegistry<T> implements WithOctarine {
    /** List of entries in this registry. */
    protected final List<T> entries = new ArrayList<>();
    /** Internal boolean to prevent double registration. */
    protected boolean hasRegistered = false;

    /**
     * Create an entry in this registry.
     *
     * @param entry The entry to create.
     * @return The entry that was created.
     */
    protected <U extends T> U create(U entry) {
        this.entries.add(entry);
        return entry;
    }

    /** Register all entries in this registry with minecraft. */
    public void registerAll() {
        if (hasRegistered) {
            this.getLogger().warn("OctarineRegistry.registerAll() called more than once!");
        }
        this.registerAllInternal();
    }

    /** Internal `registerAll` implementation. */
    protected abstract void registerAllInternal();
}
