package dog.kaylen.octarine.wizardry.registry

import dog.kaylen.octarine.core.api.RegistrySet

object WizardryRegistries : RegistrySet() {
    val RUNE = include(WizardryRunes)
    val SIGIL = include(WizardrySigils)
    val SPELL = include(WizardrySpells)
}
