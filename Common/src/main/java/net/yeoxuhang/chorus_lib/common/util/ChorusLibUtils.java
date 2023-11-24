package net.yeoxuhang.chorus_lib.common.util;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.yeoxuhang.chorus_lib.ChorusLib;
import net.yeoxuhang.chorus_lib.mixin.BiomeSourceAccess;
import net.yeoxuhang.chorus_lib.mixin.NoiseBasedChunkGeneratorAccess;
import net.yeoxuhang.chorus_lib.mixin.NoiseGeneratorSettingsAccess;

public class ChorusLibUtils {

    public static class BLOCKS {
        public static final TagKey<Block> END_STONES = create("end_stones");
        private static TagKey<Block> create(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(ChorusLib.MOD_ID, name));
        }
    }

    public static void addSurfaceRule(RegistryAccess registryAccess, ResourceKey<LevelStem> levelStemKey, SurfaceRules.RuleSource ruleSource) {
        LevelStem levelStem = registryAccess.registryOrThrow(Registries.LEVEL_STEM).get(levelStemKey);
        if (levelStem == null) {
            ChorusLib.logError(String.format("Unable to find level stem/dimension \"%s\", this is most likely due to a world being moved across minecraft versions, ChorusLib cannot support this operation.\nNot adding surface rules....", levelStemKey));
            return;
        }
        ChunkGenerator chunkGenerator = levelStem.generator();
        if (chunkGenerator instanceof NoiseBasedChunkGenerator) {
            NoiseGeneratorSettings noiseGeneratorSettings = ((NoiseBasedChunkGeneratorAccess) chunkGenerator).byg_getSettings().value();
            ((NoiseGeneratorSettingsAccess) (Object) noiseGeneratorSettings).setSurfaceRule(SurfaceRules.sequence(ruleSource, noiseGeneratorSettings.surfaceRule()));
        }

        Codec<? extends BiomeSource> biomeSourceCodec = ((BiomeSourceAccess) chunkGenerator.getBiomeSource()).invokeCodec();
        ChorusLib.logInfo(String.format("Loading dimension \"%s\" with biome source: \"%s\".", levelStemKey.location().toString(), BuiltInRegistries.BIOME_SOURCE.getKey(biomeSourceCodec).toString()));
    }
}
