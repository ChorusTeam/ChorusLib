package net.yeoxuhang.chorus_lib.mixin.biome;

import com.google.common.base.Preconditions;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.synth.ImprovedNoise;
import net.yeoxuhang.chorus_lib.impl.biome.MultiNoiseSamplerHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Climate.Sampler.class)
public class MultiNoiseUtilMultiNoiseSamplerMixin implements MultiNoiseSamplerHooks {
    @Unique
    private Long seed = null;

    @Unique
    private ImprovedNoise endBiomesSampler = null;

    @Override
    public void setSeed(long seed) {
        this.seed = seed;
    }

    @Override
    public ImprovedNoise getEndBiomesSampler() {
        if (endBiomesSampler == null) {
            Preconditions.checkState(seed != null, "MultiNoiseSampler doesn't have a seed set, created using different method?");
            endBiomesSampler = new ImprovedNoise(new WorldgenRandom(new LegacyRandomSource(seed)));
        }

        return endBiomesSampler;
    }
}
