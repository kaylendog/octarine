/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine;

import dog.kaylen.octarine.registry.OctarineRegistryContainer;
import org.slf4j.Logger;

/** Utility interface to easily access octarine features. */
public interface WithOctarine {
    /**
     * @return A reference to the plugin singleton.
     */
    default OctarineMod getInstance() {
        return OctarineMod.getInstance();
    }

    /**
     * @return A reference to the plugin logger.
     */
    default Logger getLogger() {
        return this.getInstance().getLogger();
    }

    /**
     * @return A reference to the plugin registries.
     */
    default OctarineRegistryContainer getRegistries() {
        return this.getInstance().getRegistries();
    }
}
