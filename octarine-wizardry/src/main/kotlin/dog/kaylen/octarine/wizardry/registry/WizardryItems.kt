package dog.kaylen.octarine.wizardry.registry

import dog.kaylen.octarine.core.api.NamespacedRegistry
import dog.kaylen.octarine.wizardry.OctarineWizardryMod
import dog.kaylen.octarine.wizardry.item.book.WizardsGuideItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries

object WizardryItems : NamespacedRegistry<Item>(OctarineWizardryMod.MOD_ID, Registries.ITEM) {
    val WIZARDS_GUIDE = create("wizards_guide", WizardsGuideItem)
}
