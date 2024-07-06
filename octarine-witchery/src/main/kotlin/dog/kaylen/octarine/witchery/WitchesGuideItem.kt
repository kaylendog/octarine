/*
 * (C) Copyright 2022-2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.witchery

import dog.kaylen.octarine.core.item.OctarineItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.registry.Registry
import net.minecraft.world.World
import vazkii.patchouli.api.PatchouliAPI
import vazkii.patchouli.common.base.PatchouliSounds
import vazkii.patchouli.common.book.BookRegistry

object WitchesGuideItem : OctarineItem("witches_guide", FabricItemSettings()) {
    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        val stack = user.getStackInHand(hand)
        // check user is player
        if (user !is ServerPlayerEntity) {
            return TypedActionResult.pass(user.getStackInHand(hand))
        }
        // open gui
        val book = BookRegistry.INSTANCE.books[Registries.ITEM.getId(this)] ?: return TypedActionResult.fail(stack)
        PatchouliAPI.get().openBookGUI(user, book.id)
        user.playSound(PatchouliSounds.BOOK_OPEN, 1F, ((0.7 + Math.random() * 0.4).toFloat()))
        // return success
        return TypedActionResult.success(stack)
    }
}
