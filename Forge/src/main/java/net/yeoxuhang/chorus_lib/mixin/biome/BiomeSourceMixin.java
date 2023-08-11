package net.yeoxuhang.chorus_lib.mixin.biome;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;
import java.util.function.Supplier;

@Mixin(BiomeSource.class)
public abstract class BiomeSourceMixin {


    @Shadow @Final private Supplier<Set<Holder<Biome>>> lazyPossibleBiomes;

    @Inject(method = "possibleBiomes", at = @At("RETURN"))
    public void addPossibleBiomes(CallbackInfoReturnable<Set<Holder<Biome>>> ci) {
        modifyBiomeSet(this.lazyPossibleBiomes.get());
    }

    protected void modifyBiomeSet(Set<Holder<Biome>> biomes) {
    }
}