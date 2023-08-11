package net.yeoxuhang.chorus_lib.common;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.yeoxuhang.chorus_lib.mixin.NyliumBlockAccess;

import java.util.function.Supplier;

public class ChorusLibNylium extends NyliumBlock {

    private final Supplier<ConfiguredFeature<?, ?>> feature;
    private final Block nyliumBlock;

    public ChorusLibNylium(Properties properties, Supplier<ConfiguredFeature<?, ?>> feature, Block nyliumBlock) {
        super(properties);
        this.feature = feature;
        this.nyliumBlock = nyliumBlock;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!NyliumBlockAccess.canBeNylium(state, world, pos)) {
            world.setBlockAndUpdate(pos, this.nyliumBlock.defaultBlockState());
        }
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return this.feature.get() != null;
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter getter, BlockPos pos, BlockState state, boolean canBonemeal) {
        return this.feature.get() != null;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource rand, BlockPos pos, BlockState state) {
        ConfiguredFeature<?, ?> configuredFeature = this.feature.get();
        configuredFeature.place(world, world.getChunkSource().getGenerator(), rand, pos);
    }
}
