/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry;

import dog.kaylen.octarine.item.OctarineItem;
import dog.kaylen.octarine.item.OctironScrapItem;
import dog.kaylen.octarine.item.RawOctironItem;
import dog.kaylen.octarine.item.book.WitchesGuideItem;
import dog.kaylen.octarine.item.book.WizardsGuideItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class OctarineItemRegistry extends OctarineRegistry<OctarineItem> {

    public final OctironScrapItem OCTIRON_SCRAP_ITEM = create(new OctironScrapItem());
    public final RawOctironItem RAW_OCTIRON_ITEM = create(new RawOctironItem());

    public final WitchesGuideItem WITCHES_GUIDE_ITEM = create(new WitchesGuideItem());
    public final WizardsGuideItem WIZARDS_GUIDE_ITEM = create(new WizardsGuideItem());

    @Override
    protected void registerAllInternal() {
        this.entries.forEach(
                (entry) -> Registry.register(Registry.ITEM, entry.getIdentifier(), (Item) entry));
    }
}
