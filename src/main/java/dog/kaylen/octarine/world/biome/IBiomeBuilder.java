package dog.kaylen.octarine.world.biome;

import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Biome.Builder.class)
public interface IBiomeBuilder {
    float getThaum();
    IBiomeBuilder thaum(float value);
}
