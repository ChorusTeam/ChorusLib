package net.yeoxuhang.chorus_lib.api.biome;

import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.storage.WorldData;
import net.yeoxuhang.chorus_lib.util.ChorusLibUtils;

public class SurfaceRule {

    public static void addEndSurfaceRules(WorldData worldData, SurfaceRules.RuleSource ruleSource) {
        ChorusLibUtils.addSurfaceRules(worldData, LevelStem.END, ruleSource);
    }

    public static void addNetherSurfaceRules(WorldData worldData, SurfaceRules.RuleSource ruleSource) {
        ChorusLibUtils.addSurfaceRules(worldData, LevelStem.NETHER, ruleSource);
    }
    public static void addOverWorldSurfaceRules(WorldData worldData, SurfaceRules.RuleSource ruleSource) {
        ChorusLibUtils.addSurfaceRules(worldData, LevelStem.OVERWORLD, ruleSource);
    }
}

