/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine

import dog.kaylen.octarine.registry.OctarineRegistryContainer
import org.slf4j.Logger

/** Utility interface to easily access octarine features.  */
interface WithOctarine {
    val instance: OctarineMod
        /**
         * @return A reference to the plugin singleton.
         */
        get() = OctarineMod.getInstance()
    val logger: Logger?
        /**
         * @return A reference to the plugin logger.
         */
        get() = instance.getLogger()
    val registries: OctarineRegistryContainer?
        /**
         * @return A reference to the plugin registries.
         */
        get() = instance.getRegistries()
}
