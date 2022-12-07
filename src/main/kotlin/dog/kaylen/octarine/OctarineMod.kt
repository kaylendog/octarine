/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine

import dog.kaylen.octarine.registry.OctarineRegistryContainer
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

class OctarineMod : ModInitializer {
    /** The plugin logger instance.  */
    @Getter
    private val logger = LoggerFactory.getLogger("octarine")

    /** The plugin registries.  */
    @Getter
    private val registries = OctarineRegistryContainer()
    override fun onInitialize() {
        logger.info("Initializing Octarine...")
        instance = this
        // register all
        registries.registerAll()
    }

    companion object {
        /** The singleton instance of the mod.  */
        @Getter
        private var instance: OctarineMod? = null
    }
}
