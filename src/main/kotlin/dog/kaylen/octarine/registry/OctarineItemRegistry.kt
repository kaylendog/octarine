/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry

import dog.kaylen.octarine.item.OctarineItem
import dog.kaylen.octarine.item.OctironScrapItem
import dog.kaylen.octarine.item.RawOctironItem
import dog.kaylen.octarine.item.book.WitchesGuideItem
import dog.kaylen.octarine.item.book.WizardsGuideItem
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object OctarineItemRegistry : OctarineRegistry<OctarineItem, Item>(Registry.ITEM) {
    val RAW_OCTIRON = create(RawOctironItem)
    val OCTIRON_SCRAP = create(OctironScrapItem)

    val WITCHES_GUIDE_ITEM = create(WitchesGuideItem)
    val WIZARDS_GUIDE_ITEM = create(WizardsGuideItem)
    override fun identifierOf(element: OctarineItem): Identifier {
        return element.identifier
    }
}
