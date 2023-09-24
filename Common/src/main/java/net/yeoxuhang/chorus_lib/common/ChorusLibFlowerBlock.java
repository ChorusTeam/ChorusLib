package net.yeoxuhang.chorus_lib.common;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ChorusLibFlowerBlock extends FlowerBlock implements SmallFlower {
    private final TagKey<Block> mayPlaceOn;

    public ChorusLibFlowerBlock(Properties properties, TagKey<Block> mayPlaceOn) {
        super(MobEffects.SATURATION, 7, properties);
        this.mayPlaceOn = mayPlaceOn;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return state.is(mayPlaceOn);
    }
}
