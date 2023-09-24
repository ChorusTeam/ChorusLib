package net.yeoxuhang.chorus_lib.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.lighting.LayerLightEngine;

import java.util.function.Supplier;

public class ChorusLibNyliumBlock extends Block implements BonemealableBlock, Nylium {
    private final Supplier<ConfiguredFeature<?, ?>> feature;
    private final Block stone;
    public ChorusLibNyliumBlock(BlockBehaviour.Properties pProperties, Supplier<ConfiguredFeature<?, ?>> feature, Block stone) {
        super(pProperties);
        this.feature = feature;
        this.stone = stone;
    }

    private static boolean canBeNylium(BlockState pState, LevelReader pReader, BlockPos pPos) {
        BlockPos $$3 = pPos.above();
        BlockState $$4 = pReader.getBlockState($$3);
        int $$5 = LayerLightEngine.getLightBlockInto(pReader, pState, pPos, $$4, $$3, Direction.UP, $$4.getLightBlock(pReader, $$3));
        return $$5 < pReader.getMaxLightLevel();
    }

    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!canBeNylium(pState, pLevel, pPos)) {
            pLevel.setBlockAndUpdate(pPos, stone.defaultBlockState());
        }

    }

    public boolean isValidBonemealTarget(BlockGetter pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return pLevel.getBlockState(pPos.above()).isAir();
    }

    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        BlockPos $$5 = pPos.above();
        ChunkGenerator $$6 = pLevel.getChunkSource().getGenerator();
        ConfiguredFeature<?, ?> configuredFeature = this.feature.get();
        configuredFeature.place(pLevel, $$6, pRandom, $$5);
    }
}
