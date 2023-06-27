/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine

import dog.kaylen.octarine.common.OctarineBlock
import dog.kaylen.octarine.common.OctarineRegistry
import dog.kaylen.octarine.content.witchery.WitchesGuideItem
import dog.kaylen.octarine.content.wizardry.WizardsGuideItem
import dog.kaylen.octarine.common.OctarineItem
import dog.kaylen.octarine.content.materials.OctironScrapItem
import dog.kaylen.octarine.content.materials.RawOctironItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object xOctarineItems : OctarineRegistry<OctarineItem, Item>(Registry.ITEM) {
    val RAW_OCTIRON = register(RawOctironItem)
    val OCTIRON_SCRAP = register(OctironScrapItem)

    val WITCHES_GUIDE_ITEM = register(WitchesGuideItem)
    val WIZARDS_GUIDE_ITEM = register(WizardsGuideItem)

    val OCTIRON_ORE_BLOCK = registerBlockItem(OctarineBlocks.OCTIRON_ORE, FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS))
    val DEEPSLATE_OCTIRON_ORE_BLOCK = registerBlockItem(OctarineBlocks.DEEPSLATE_OCTIRON_ORE, FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS))

    override fun identifierOfElement(element: OctarineItem): Identifier {
        return element.identifier
    }

    fun registerBlockItem(block: OctarineBlock, settings: FabricItemSettings) {
        this.store[block.identifier] = BlockItem(block, settings)
    }
}
