/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine;

import dog.kaylen.octarine.registry.OctarineRegistryContainer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OctarineMod implements ModInitializer {
    /** The singleton instance of the mod. */
    static OctarineMod INSTANCE;

    /** The plugin logger instance. */
    final Logger LOGGER = LoggerFactory.getLogger("octarine");

    /** The plugin registries. */
    public final OctarineRegistryContainer registries = new OctarineRegistryContainer();

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Octarine...");
        INSTANCE = this;
        // register all
        this.registries.registerAll();
    }
}
