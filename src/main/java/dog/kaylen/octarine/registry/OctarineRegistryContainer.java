/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.registry;

import java.util.ArrayList;
import java.util.List;

/**
 * Registry of Octarine registries. Not named `OctarineRegistryRegistry` because that'd be stupid.
 */
public class OctarineRegistryContainer extends OctarineRegistry<OctarineRegistry<?>> {
    /** Internal registries list. */
    private static final List<OctarineRegistry<?>> registries = new ArrayList<>();

    /** The biome registry. */
    public final OctarineBiomeRegistry BIOME = create(new OctarineBiomeRegistry());
    /** The block registry. */
    public final OctarineBlockRegistry BLOCK = create(new OctarineBlockRegistry());
    /** The feature registry. */
    public OctarineFeatureRegistry FEATURE = create(new OctarineFeatureRegistry());
    /** The item registry. */
    public final OctarineItemRegistry ITEM = create(new OctarineItemRegistry());

    @Override
    protected void registerAllInternal() {
        this.entries.forEach(OctarineRegistry::registerAll);
    }
}
