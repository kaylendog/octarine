/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine

import dog.kaylen.octarine.registry.Registries
import net.fabricmc.api.ModInitializer

class OctarineMod : ModInitializer {
    override fun onInitialize() {
        LOGGER.info("Initializing Octarine...")
        // setup singleton instance
        instance = this
        // initialize registries
        Registries.registerAll()
    }

    companion object {
        /** The singleton instance of the mod.  */
        lateinit var instance: OctarineMod
    }
}
