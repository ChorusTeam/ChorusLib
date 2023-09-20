package net.yeoxuhang.chorus_lib.mixin.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.yeoxuhang.chorus_lib.impl.biome.MultiNoiseSamplerHooks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RandomState.class)
public class NoiseConfigMixin {
    @Shadow
    @Final
    private Climate.Sampler sampler;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void init(NoiseGeneratorSettings chunkGeneratorSettings, HolderGetter<NormalNoise.NoiseParameters> arg, long seed, CallbackInfo ci) {
        ((MultiNoiseSamplerHooks) (Object) sampler).fabric_setSeed(seed);
    }
}