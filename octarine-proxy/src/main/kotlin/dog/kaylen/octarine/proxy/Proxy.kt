package dog.kaylen.octarine.proxy

import dog.kaylen.octarine.proxy.registry.ProxiedRegistries
import dog.kaylen.octarine.proxy.registry.ProxiedRegistry

interface Proxy {
    fun <T : Identifiable> getProxiedRegistry(type: ProxiedRegistries): ProxiedRegistry<T>
}
