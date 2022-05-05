/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry;

import dog.kaylen.octarine.block.DeepslateOctironOreBlock;
import dog.kaylen.octarine.block.OctarineBlock;
import dog.kaylen.octarine.block.OctironOreBlock;
import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;

public class OctarineBlockRegistry extends OctarineRegistry<OctarineBlock> {

    public final DeepslateOctironOreBlock DEEPSLATE_OCTIRON_ORE_BLOCK =
            create(new DeepslateOctironOreBlock());
    public final OctironOreBlock OCTIRON_ORE_BLOCK = create(new OctironOreBlock());

    @Override
    protected void registerAllInternal() {
        this.entries.forEach(
                (entry) -> Registry.register(Registry.BLOCK, entry.getIdentifier(), (Block) entry));
    }
}
