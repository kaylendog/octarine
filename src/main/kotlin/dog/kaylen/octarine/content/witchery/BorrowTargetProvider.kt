/*
 * (C) Copyright 2023 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.content.witchery

import dog.kaylen.octarine.common.identifierOf
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.entity.EntityType
import net.minecraft.tag.TagKey
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryKey

class BorrowTargetProvider(dataGenerator: FabricDataGenerator) : FabricTagProvider.EntityTypeTagProvider(dataGenerator) {
    companion object {
        val BORROW_TARGETS: TagKey<EntityType<*>> = TagKey.of(RegistryKey.ofRegistry(Registry.ENTITY_TYPE_KEY.value), identifierOf("borrowable"))
    }

    override fun generateTags() {
        getOrCreateTagBuilder(BORROW_TARGETS).add(
            EntityType.BAT,
            EntityType.BEE,
            EntityType.CAT,
            EntityType.COD,
            EntityType.AXOLOTL,
            EntityType.CAVE_SPIDER,
            EntityType.CHICKEN,
            EntityType.COW,
        )
    }
}
