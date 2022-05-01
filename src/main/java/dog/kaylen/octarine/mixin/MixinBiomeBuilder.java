/*
 * (C) Copyright 2022 Kaylen Dart (https://kaylen.dog) and others.
 * This project is licensed under the GNU General Public License v3.0.
 * See the LICENSE file in the project root for more information.
 */
package dog.kaylen.octarine.mixin;

import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Biome.Builder.class)
public abstract class MixinBiomeBuilder implements ThaumBiomeBuilder {
    private float thaum;

    @Override
    public ThaumBiomeBuilder thaum(float value) {
        this.thaum = value;
        return this;
    }

    @Override
    public float getThaum() {
        return thaum;
    }
}
