package dog.kaylen.octarine

import dog.kaylen.octarine.proxy.Identifiable
import dog.kaylen.octarine.proxy.Proxy
import dog.kaylen.octarine.proxy.registry.ProxiedRegistries
import dog.kaylen.octarine.proxy.registry.ProxiedRegistry
import net.minecraft.util.registry.Registry

object Proxy_1_19_2 : Proxy {
    override fun <T : Identifiable> getProxiedRegistry(type: ProxiedRegistries): ProxiedRegistry<T> {
        return when(type) {
            ProxiedRegistries.BLOCK -> Registry.BLOCK
            ProxiedRegistries.ITEM -> Registry.ITEM
            ProxiedRegistries.BLOCK_ENTITY_TYPE -> Registry.BLOCK_ENTITY_TYPE
        }
    }
}
