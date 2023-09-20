package net.yeoxuhang.chorus_lib.mixin.biome;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

@Mixin(BiomeSource.class)
public class BiomeSourceMixin {
    @Redirect(method = "possibleBiomes", at = @At(value = "INVOKE", target = "Ljava/util/function/Supplier;get()Ljava/lang/Object;"))
    private Object getBiomes(Supplier<Set<Holder<Biome>>> instance) {
        var biomes = new HashSet<>(instance.get());
        modifyBiomeSet(biomes);
        return Collections.unmodifiableSet(biomes);
    }

    protected void modifyBiomeSet(Set<Holder<Biome>> biomes) {
    }
}
