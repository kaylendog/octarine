/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine;

import dog.kaylen.octarine.registry.OctarineRegistryContainer;
import lombok.Getter;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OctarineMod implements ModInitializer {
    /** The singleton instance of the mod. */
    @Getter private static OctarineMod instance;

    /** The plugin logger instance. */
    @Getter private final Logger logger = LoggerFactory.getLogger("octarine");

    /** The plugin registries. */
    @Getter private final OctarineRegistryContainer registries = new OctarineRegistryContainer();

    @Override
    public void onInitialize() {
        this.logger.info("Initializing Octarine...");
        instance = this;
        // register all
        this.registries.registerAll();
    }
}
