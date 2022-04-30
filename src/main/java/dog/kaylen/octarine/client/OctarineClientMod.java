/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.client;

import de.guntram.mcmod.crowdintranslate.CrowdinTranslate;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OctarineClientMod implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("octarine");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing clientside features...");
        CrowdinTranslate.downloadTranslations("octarine", "octarine");
    }
}
