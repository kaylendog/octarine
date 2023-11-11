package dog.kaylen.octarine.proxy.registry

import dog.kaylen.octarine.proxy.Identifiable
import dog.kaylen.octarine.proxy.Identifier

abstract class OctarineRegistry<T: Identifiable> : GenericRegistry<T> {
    private val inner = mutableMapOf<Identifier, T>()

    fun register(instance: T): T {
        inner[instance.identifier] = instance
        return instance
    }
}
