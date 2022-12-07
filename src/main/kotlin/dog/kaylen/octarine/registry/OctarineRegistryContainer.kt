/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry

import java.util.function.Consumer

/**
 * Registry of Octarine registries. Not named `OctarineRegistryRegistry` because that'd be stupid.
 */
class OctarineRegistryContainer : OctarineRegistry<OctarineRegistry<*>?>() {
    /** The biome registry.  */
    val BIOME = create(OctarineBiomeRegistry())

    /** The block registry.  */
    val BLOCK = create(OctarineBlockRegistry())

    /** The feature registry.  */
    var FEATURE = create(OctarineFeatureRegistry())

    /** The item registry.  */
    val ITEM = create(OctarineItemRegistry())
    override fun registerAllInternal() {
        entries.forEach(Consumer { obj: OctarineRegistry<*>? -> obj!!.registerAll() })
    }

    companion object {
        /** Internal registries list.  */
        private val registries: List<OctarineRegistry<*>> = ArrayList()
    }
}
