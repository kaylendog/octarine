/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry

import dog.kaylen.octarine.block.DeepslateOctironOreBlock
import dog.kaylen.octarine.block.OctarineBlock
import dog.kaylen.octarine.block.OctironOreBlock
import net.minecraft.block.Block
import net.minecraft.util.registry.Registry
import java.util.function.Consumer

class OctarineBlockRegistry : OctarineRegistry<OctarineBlock?>() {
    val DEEPSLATE_OCTIRON_ORE_BLOCK = create(DeepslateOctironOreBlock())
    val OCTIRON_ORE_BLOCK = create(OctironOreBlock())
    override fun registerAllInternal() {
        entries.forEach(
            Consumer { entry: OctarineBlock -> Registry.register(Registry.BLOCK, entry.identifier, entry as Block) }
        )
    }
}
