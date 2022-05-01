/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.mixin;

import java.util.List;
import java.util.Map;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(GenerationSettings.Builder.class)
public interface GenerationSettingsBuilderAccessor {
    @Accessor("features")
    void setFeatures(List<List<RegistryEntry<PlacedFeature>>> features);

    @Accessor("carvers")
    void setCarvers(Map<GenerationStep.Carver, List<RegistryEntry<ConfiguredCarver<?>>>> carvers);
}
