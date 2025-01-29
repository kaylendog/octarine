package dog.kaylen.octarine.brewing

import dog.kaylen.octarine.core.registry.OctarineRegistries
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class OctarineBrewingMod : ModInitializer {
    override fun onInitialize(mod: ModContainer) {
        INSTANCE = this
        OctarineRegistries.initAll()
    }

    companion object {
        /** The singleton instance of the mod.  */
        lateinit var INSTANCE: OctarineBrewingMod

        /** The mod ID **/
        const val MOD_ID = "octarine_brewing"

        /** The Octarine logger. */
        val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
    }
}
