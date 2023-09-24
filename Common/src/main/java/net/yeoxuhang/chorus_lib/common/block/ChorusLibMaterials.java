package net.yeoxuhang.chorus_lib.common.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.PushReaction;

public class ChorusLibMaterials {
    //Plants and Flowers
    public static Material OVERWORLD_PLANT = new Material(MaterialColor.PLANT, false, false, false, false, false, true, PushReaction.DESTROY);
    public static Material OVERWORLD_FLOWER = new Material(MaterialColor.PLANT, false, false, false, false, false, false, PushReaction.DESTROY);
    public static Material OVERWORLD_VINE = new Material(MaterialColor.PLANT, false, false, false, false, false, false, PushReaction.DESTROY);
    public static Material END_PLANT = new Material(MaterialColor.COLOR_PURPLE, false, false, false, false, false, true, PushReaction.DESTROY);
    public static Material END_FLOWER = new Material(MaterialColor.COLOR_PURPLE, false, false, false, false, false, false, PushReaction.DESTROY);
    public static Material END_VINE = new Material(MaterialColor.PLANT, false, false, false, false, false, false, PushReaction.DESTROY);
    public static Material NETHER_PLANT = new Material(MaterialColor.NETHER, false, false, false, false, false, true, PushReaction.DESTROY);
    public static Material NETHER_FLOWER = new Material(MaterialColor.NETHER, false, false, false, false, false, false, PushReaction.DESTROY);
    public static Material NETHER_VINE = new Material(MaterialColor.NETHER, false, false, false, false, false, false, PushReaction.DESTROY);

    //Woods
    public static Material WOOD = new Material(MaterialColor.WOOD, false, true, false, true, true, false, PushReaction.NORMAL);
    public static Material NETHER_WOOD = new Material(MaterialColor.NETHER, false, false, false, false, false, false, PushReaction.NORMAL);
    public static Material END_WOOD = new Material(MaterialColor.SAND, false, true, false, false, false, false, PushReaction.NORMAL);

    //Ores
    public static Material OVERWORLD_ORE = new Material(MaterialColor.STONE, false, true, false, true, false, false, PushReaction.NORMAL);
    public static Material NETHER_ORE = new Material(MaterialColor.NETHER, false, true, false, true, false, false, PushReaction.NORMAL);
    public static Material END_ORE = new Material(MaterialColor.SAND, false, true, false, true, false, false, PushReaction.NORMAL);

    //Stones
    public static Material STONE = new Material(MaterialColor.STONE, false, true, false, true, false, false, PushReaction.NORMAL);
    public static Material NETHER_STONE = new Material(MaterialColor.NETHER, true, false, false, true, false, false, PushReaction.NORMAL);
    public static Material END_STONE = new Material(MaterialColor.SAND, true, false, false, true, false, false, PushReaction.NORMAL);
}
