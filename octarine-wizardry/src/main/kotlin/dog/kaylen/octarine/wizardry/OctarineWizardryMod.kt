package dog.kaylen.octarine.wizardry

import dog.kaylen.octarine.core.registry.OctarineRegistries
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class OctarineWizardryMod : ModInitializer {
    override fun onInitialize() {
        INSTANCE = this
        OctarineRegistries.initAll()
    }

    companion object {
        /** The singleton instance of the mod.  */
        lateinit var INSTANCE: OctarineWizardryMod

        /** The mod ID **/
        const val MOD_ID = "octarine_wizardry"

        /** The Octarine logger. */
        val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
    }
}
