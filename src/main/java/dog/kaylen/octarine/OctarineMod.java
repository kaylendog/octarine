/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine;

import dog.kaylen.octarine.biome.MagicalForest;
import dog.kaylen.octarine.block.DeepslateOctironOreBlock;
import dog.kaylen.octarine.block.OctironOreBlock;
import dog.kaylen.octarine.feature.DeepslateOctironOreVein;
import dog.kaylen.octarine.feature.OctironOreVein;
import dog.kaylen.octarine.item.RawOctironItem;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OctarineMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("octarine");

    // blocks
    public static final OctironOreBlock OCTIRON_ORE_BLOCK = new OctironOreBlock();
    public static final DeepslateOctironOreBlock DEEPSLATE_OCTIRON_ORE_BLOCK =
            new DeepslateOctironOreBlock();

    // items
    public static final RawOctironItem RAW_OCTIRON_ITEM = new RawOctironItem();

    // features
    public static final OctironOreVein OCTIRON_ORE_VEIN = new OctironOreVein();
    public static final DeepslateOctironOreVein DEEPSLATE_OCTIRON_ORE_VEIN =
            new DeepslateOctironOreVein();

    // biomes
    public static final MagicalForest MAGICAL_FOREST = new MagicalForest();

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Octarine...");
        // add blocks to registry
        OCTIRON_ORE_BLOCK.register();
        DEEPSLATE_OCTIRON_ORE_BLOCK.register();
        // add features to registry
        OCTIRON_ORE_VEIN.register();
        DEEPSLATE_OCTIRON_ORE_VEIN.register();
        // register biomes
        MAGICAL_FOREST.register();
    }
}
