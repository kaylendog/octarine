/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.item.book

import dog.kaylen.octarine.item.OctarineItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.util.registry.Registry
import net.minecraft.world.World
import vazkii.patchouli.api.PatchouliAPI
import vazkii.patchouli.common.base.PatchouliSounds
import vazkii.patchouli.common.book.BookRegistry

class WizardsGuideItem : OctarineItem(FabricItemSettings()) {
    override val key: String?
        get() = "wizards_guide"

    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        if (user is ServerPlayerEntity) {
            val book = BookRegistry.INSTANCE.books[Registry.ITEM.getId(this)]
            PatchouliAPI.get().openBookGUI(user, book!!.id)
            user.playSound(
                PatchouliSounds.getSound(book.openSound, PatchouliSounds.BOOK_OPEN),
                1f,
                (0.7 + Math.random() * 0.4).toFloat()
            )
        }
        return TypedActionResult.success(user.getStackInHand(hand))
    }
}
