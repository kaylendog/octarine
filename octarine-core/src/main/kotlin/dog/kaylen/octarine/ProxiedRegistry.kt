package dog.kaylen.octarine

import dog.kaylen.octarine.proxy.Identifiable
import dog.kaylen.octarine.proxy.registry.OctarineRegistry

class ProxiedRegistry<T : Identifiable> : OctarineRegistry<T> {
    private val internal = Octarine.PROXY.createRegistry<T>()
}
