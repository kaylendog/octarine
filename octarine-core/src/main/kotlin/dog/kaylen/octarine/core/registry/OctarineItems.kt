/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://www.kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.core.registry

import dog.kaylen.octarine.core.OctarineMod
import dog.kaylen.octarine.core.api.NamespacedRegistry
import dog.kaylen.octarine.core.block.OctironScrapItem
import dog.kaylen.octarine.core.block.RawOctironItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryKey

object OctarineItems : NamespacedRegistry<Item>(OctarineMod.MOD_ID, Registries.ITEM) {
    val RAW_OCTIRON = create("raw_octiron", RawOctironItem)
    val OCTIRON_SCRAP = create("octiron_scrap", OctironScrapItem)

    val OCTIRON_ORE_BLOCK = createBlockItem("octiron_ore", OctarineBlocks.OCTIRON_ORE, ItemGroups.BUILDING_BLOCKS) {}
    val DEEPSLATE_OCTIRON_ORE_BLOCK =
        createBlockItem("deepslate_octiron_ore", OctarineBlocks.DEEPSLATE_OCTIRON_ORE, ItemGroups.BUILDING_BLOCKS) {}

    private fun createBlockItem(
        name: String,
        block: Block,
        group: RegistryKey<ItemGroup>,
        settingsBlock: FabricItemSettings.() -> Unit
    ) {
        val blockItem = BlockItem(
            block,
            FabricItemSettings().apply(settingsBlock)
        )
        ItemGroupEvents.modifyEntriesEvent(group).register {
            it.add(blockItem)
        }
        this.create(name, blockItem as Item)
    }
}
