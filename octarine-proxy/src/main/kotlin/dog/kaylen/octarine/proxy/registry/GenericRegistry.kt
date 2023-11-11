package dog.kaylen.octarine.proxy.registry

import dog.kaylen.octarine.proxy.Identifiable

interface GenericRegistry<T: Identifiable> {
    fun <T> register(instance: T): T
}
