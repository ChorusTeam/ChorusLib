package net.yeoxuhang.chorus_lib.impl.biome;

import net.minecraft.world.level.levelgen.synth.ImprovedNoise;

public interface MultiNoiseSamplerHooks {
    ImprovedNoise getEndBiomesSampler();

    void setSeed(long seed);
}
