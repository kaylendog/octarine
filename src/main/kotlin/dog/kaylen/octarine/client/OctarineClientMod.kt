/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.client

import org.slf4j.LoggerFactory

class OctarineClientMod : ClientModInitializer {
    override fun onInitializeClient() {
        LOGGER.info("Initializing clientside features...")
        CrowdinTranslate.downloadTranslations("dog/kaylen/octarine", "dog/kaylen/octarine")
    }

    companion object {
        @JvmField
        val LOGGER = LoggerFactory.getLogger("dog/kaylen/octarine")
    }
}
