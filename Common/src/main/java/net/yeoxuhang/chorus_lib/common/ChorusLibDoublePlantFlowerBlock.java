package net.yeoxuhang.chorus_lib.common;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ChorusLibDoublePlantFlowerBlock extends DoublePlantBlock implements TallFlower {
    private final TagKey<Block> mayPlaceOn;

    public ChorusLibDoublePlantFlowerBlock(Properties properties, TagKey<Block> mayPlaceOn) {
        super(properties);
        this.mayPlaceOn = mayPlaceOn;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.is(this.mayPlaceOn);
    }
}
