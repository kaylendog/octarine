/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core

import dog.kaylen.octarine.core.registry.OctarineRegistries
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class OctarineMod : ModInitializer {
    override fun onInitialize() {
        INSTANCE = this
        OctarineRegistries.initAll()
    }

    companion object {
        /** The singleton instance of the mod.  */
        lateinit var INSTANCE: OctarineMod

        /** The mod ID **/
        const val MOD_ID = "octarine"

        /** The Octarine logger. */
        val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
    }
}
