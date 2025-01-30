package dog.kaylen.octarine.witchery

import dog.kaylen.octarine.witchery.registry.WitcheryRegistries
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class OctarineWitcheryMod : ModInitializer {
    override fun onInitialize() {
        INSTANCE = this
        WitcheryRegistries.initAll()
    }

    companion object {
        /** The singleton instance of the mod.  */
        lateinit var INSTANCE: OctarineWitcheryMod

        /** The mod ID **/
        const val MOD_ID = "octarine_witchery"

        /** The Octarine logger. */
        val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
    }
}
