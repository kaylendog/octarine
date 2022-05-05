/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.item.book;

import dog.kaylen.octarine.item.OctarineItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import vazkii.patchouli.api.PatchouliAPI;
import vazkii.patchouli.common.base.PatchouliSounds;
import vazkii.patchouli.common.book.Book;
import vazkii.patchouli.common.book.BookRegistry;

public class WizardsGuideItem extends OctarineItem {
    public WizardsGuideItem() {
        super(new FabricItemSettings());
    }

    @Override
    public String getKey() {
        return "wizards_guide";
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user instanceof ServerPlayerEntity serverPlayer) {
            Book book = BookRegistry.INSTANCE.books.get(Registry.ITEM.getId(this));
            PatchouliAPI.get().openBookGUI(serverPlayer, book.id);
            user.playSound(
                    PatchouliSounds.getSound(book.openSound, PatchouliSounds.BOOK_OPEN),
                    1,
                    (float) (0.7 + Math.random() * 0.4));
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
