/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://www.kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.registry

import dog.kaylen.octarine.core.OctarineBlock
import dog.kaylen.octarine.core.item.OctarineItem
import dog.kaylen.octarine.core.OctarineRegistry
import dog.kaylen.octarine.content.world.block.OctironScrapItem
import dog.kaylen.octarine.content.world.block.RawOctironItem
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryKey
import net.minecraft.util.Identifier
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings

object OctarineItems : OctarineRegistry<OctarineItem, Item>(Registries.ITEM) {
    val RAW_OCTIRON = register(RawOctironItem)
    val OCTIRON_SCRAP = register(OctironScrapItem)

    val OCTIRON_ORE_BLOCK = registerBlockItem(OctarineBlocks.OCTIRON_ORE, QuiltItemSettings(), ItemGroups.BUILDING_BLOCKS)
    val DEEPSLATE_OCTIRON_ORE_BLOCK =
        registerBlockItem(OctarineBlocks.DEEPSLATE_OCTIRON_ORE, QuiltItemSettings(), ItemGroups.BUILDING_BLOCKS)

    override fun identifierOfElement(element: OctarineItem): Identifier {
        return element.identifier
    }

    private fun registerBlockItem(
        blockItem: OctarineBlock,
        settings: QuiltItemSettings,
        group: RegistryKey<ItemGroup>
    ) {
        ItemGroupEvents.modifyEntriesEvent(group).register {
            it.addItem(blockItem)
        }
        this.store[blockItem.identifier] = BlockItem(blockItem, settings)
    }
}
