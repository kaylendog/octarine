/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.mixin;

import dog.kaylen.octarine.impl.IGenerationSettings;
import java.util.Map;
import net.minecraft.util.registry.RegistryEntryList;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(GenerationSettings.class)
public abstract class MixinGenerationSettings implements IGenerationSettings {
    @Accessor("carvers")
    public abstract Map<GenerationStep.Carver, RegistryEntryList<ConfiguredCarver<?>>> getCarvers();
}
