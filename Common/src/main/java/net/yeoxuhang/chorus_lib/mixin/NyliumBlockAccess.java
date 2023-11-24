package net.yeoxuhang.chorus_lib.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.yeoxuhang.chorus_lib.ChorusLib;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(NyliumBlock.class)
public interface NyliumBlockAccess {

    @Invoker("canBeNylium")
    static boolean canBeNylium(BlockState state, LevelReader worldReader, BlockPos pos) {
        throw new Error(ChorusLib.MOD_ID +": Mixin didn't apply");
    }
}