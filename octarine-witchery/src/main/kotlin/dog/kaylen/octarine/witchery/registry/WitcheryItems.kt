package dog.kaylen.octarine.witchery.registry

import dog.kaylen.octarine.core.api.NamespacedRegistry
import dog.kaylen.octarine.witchery.OctarineWitcheryMod
import dog.kaylen.octarine.witchery.item.book.WitchesGuideItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries

object WitcheryItems : NamespacedRegistry<Item>(OctarineWitcheryMod.MOD_ID, Registries.ITEM) {
    val WITCHES_GUIDE = create("witches_guide", WitchesGuideItem)
}
