package net.yeoxuhang.chorus_lib.api.biome;

import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.yeoxuhang.chorus_lib.common.util.ChorusLibUtils;

public class AddSurfaceRules {
    static RegistryAccess worldData;

    private AddSurfaceRules() {
    }

    public static void addEndSurfaceRules(SurfaceRules.RuleSource ruleSource) {
        ChorusLibUtils.addSurfaceRule(worldData, LevelStem.END, ruleSource);
    }

    public static void addNetherSurfaceRules(SurfaceRules.RuleSource ruleSource) {
        ChorusLibUtils.addSurfaceRule(worldData, LevelStem.NETHER, ruleSource);
    }
    public static void addOverWorldSurfaceRules(SurfaceRules.RuleSource ruleSource) {
        ChorusLibUtils.addSurfaceRule(worldData, LevelStem.OVERWORLD, ruleSource);
    }
}

