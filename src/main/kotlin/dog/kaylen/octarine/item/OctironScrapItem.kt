/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.ItemGroup

class OctironScrapItem : OctarineItem(FabricItemSettings().group(ItemGroup.MATERIALS)) {
    @get:NonNull
    override val key: String?
        get() = "octiron_scrap"
}
