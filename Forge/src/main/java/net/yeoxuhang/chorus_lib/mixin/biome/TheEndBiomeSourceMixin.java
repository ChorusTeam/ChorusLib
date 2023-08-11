package net.yeoxuhang.chorus_lib.mixin.biome;

import java.util.Set;
import java.util.function.Supplier;

import com.google.common.base.Suppliers;
import net.minecraft.world.level.biome.*;
import net.yeoxuhang.chorus_lib.impl.biome.TheEndBiomeData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;


@Mixin(TheEndBiomeSource.class)
public class TheEndBiomeSourceMixin extends BiomeSourceMixin {
    @Unique
    private Supplier<TheEndBiomeData.Overrides> overrides;

    @Unique
    private boolean biomeSetModified = false;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void init(Registry<Biome> biomeRegistry, CallbackInfo ci) {
        overrides = Suppliers.memoize(() -> TheEndBiomeData.createOverrides(biomeRegistry));
    }

    @Inject(method = "getNoiseBiome", at = @At("RETURN"), cancellable = true)
    private void getWeightedEndBiome(int biomeX, int biomeY, int biomeZ, Climate.Sampler noise, CallbackInfoReturnable<Holder<Biome>> cir) {
        cir.setReturnValue(overrides.get().pick(biomeX, biomeY, biomeZ, noise, cir.getReturnValue()));
    }

    @Override
    public void modifyBiomeSet(Set<Holder<Biome>> biomes) {
        if (!biomeSetModified) {
            biomeSetModified = true;
            biomes.addAll(overrides.get().customBiomes);
        }
    }
}
