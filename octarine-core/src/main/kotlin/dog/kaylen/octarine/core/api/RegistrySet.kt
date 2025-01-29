package dog.kaylen.octarine.core.api

abstract class RegistrySet {
    private val registries = mutableListOf<NamespacedRegistry<*>>()

    /**
     * Include a registry in this set.
     */
    protected fun <T : NamespacedRegistry<*>> include(registry: T): T {
        registries.add(registry)
        return registry
    }

    /**
     * Initialise all sub-registries.
     */
    fun initAll() {
        registries.forEach { it.init() }
    }
}
