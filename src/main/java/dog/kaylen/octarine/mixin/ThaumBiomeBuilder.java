package dog.kaylen.octarine.mixin;

import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Biome.Builder.class)
public interface ThaumBiomeBuilder {
    float getThaum();
    ThaumBiomeBuilder thaum(float value);
}
