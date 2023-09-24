package net.yeoxuhang.chorus_lib.util;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.storage.WorldData;
import net.yeoxuhang.chorus_lib.ChorusLib;
import net.yeoxuhang.chorus_lib.mixin.access.NoiseGeneratorSettingsAccess;

public class ChorusLibUtils {
    public static void addSurfaceRules(WorldData worldData, ResourceKey<LevelStem> levelStemKey, SurfaceRules.RuleSource ruleSource) {

        LevelStem levelStem = worldData.worldGenSettings().dimensions().get(levelStemKey);
        ChunkGenerator chunkGenerator = levelStem.generator();
        if (worldData == null) { // For some reason mods can make world data null as seen in some user crash logs, this makes that issue clearer for us.
            throw new NullPointerException("Minecraft server's world data is null, this should be impossible...");
        }
        if (levelStem == null) {
            ChorusLib.logError(String.format("Unable to find level stem/dimension \"%s\", this is most likely due to a world being moved across minecraft versions, ChorusLib cannot support this operation.\nNot adding surface rules....", levelStemKey));
            return;
        }
        if (chunkGenerator instanceof NoiseBasedChunkGenerator) {
            NoiseGeneratorSettings noiseGeneratorSettings = ((NoiseBasedChunkGenerator) chunkGenerator).generatorSettings().value();
            ((NoiseGeneratorSettingsAccess) (Object)noiseGeneratorSettings).addSurfaceRule(SurfaceRules.sequence(ruleSource, noiseGeneratorSettings.surfaceRule()));
        }
    }
}
