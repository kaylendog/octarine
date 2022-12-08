/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.client
import dog.kaylen.octarine.LOGGER
import net.fabricmc.api.ClientModInitializer

class OctarineClientMod : ClientModInitializer {
    override fun onInitializeClient() {
        LOGGER.info("Initializing clientside features...")
    }
}
