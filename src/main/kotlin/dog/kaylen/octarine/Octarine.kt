/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine

import net.fabricmc.api.ModInitializer

class Octarine : ModInitializer {
    override fun onInitialize() {
        instance = this
        OctarineRegistries.registerAll()
    }

    companion object {
        /** The singleton instance of the mod.  */
        lateinit var instance: Octarine
    }
}
