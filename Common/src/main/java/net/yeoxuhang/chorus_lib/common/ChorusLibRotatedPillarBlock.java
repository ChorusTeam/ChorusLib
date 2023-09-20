package net.yeoxuhang.chorus_lib.common;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class ChorusLibRotatedPillarBlock extends RotatedPillarBlock implements BonemealableBlock {
    public static final IntegerProperty AGE;

    public static final EnumProperty<Direction.Axis> AXIS;
    public ChorusLibRotatedPillarBlock(Properties $$0) {
        super($$0);
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getAge(), 0).setValue(AXIS, Direction.Axis.Y));
    }

    public IntegerProperty getAge(){
        return AGE;
    }

    public BlockState getAge(int age) {
        return this.defaultBlockState().setValue(this.getAge(), age);
    }

    public int getMaxAge() {
        return 2;
    }

    public boolean isMaxAge(BlockState $$0) {
        return $$0.getValue(this.getAge()) >= this.getMaxAge();
    }

    protected int getAge(BlockState $$0) {
        return $$0.getValue(this.getAge());
    }

    static {
        AGE = IntegerProperty.create("variant", 0, 2);
    }

    public void randomTick(BlockState $$0, ServerLevel $$1, BlockPos $$2, RandomSource $$3) {
        int $$4 = this.getAge($$0);
        if ($$4 < this.getMaxAge()) {
            float $$5 = getGrowthSpeed(this, $$1, $$2);
            if ($$3.nextInt((int)(25.0F / $$5) + 1) == 0) {
                $$1.setBlock($$2, this.getAge($$4 + 1), 2);
            }
        }
    }

    protected static float getGrowthSpeed(Block $$0, BlockGetter $$1, BlockPos $$2) {
        return 1.0F;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader blockGetter, BlockPos blockPos, BlockState blockState, boolean b) {
        return false;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return !this.isMaxAge(blockState);
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        this.growCrops(serverLevel, blockPos, blockState);
    }

    protected int getBonemealAgeIncrease(Level $$0) {
        return Mth.nextInt($$0.random, 2, 5);
    }

    public void growCrops(Level $$0, BlockPos $$1, BlockState $$2) {
        int $$3 = this.getAge($$2) + this.getBonemealAgeIncrease($$0);
        int $$4 = this.getMaxAge();
        if ($$3 > $$4) {
            $$3 = $$4;
        }
        $$0.setBlock($$1, this.getAge($$3), 2);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> $$0) {
        $$0.add(new Property[]{AGE}).add(AXIS);
    }

    public BlockState getStateForPlacement(BlockPlaceContext $$0) {
        return this.defaultBlockState().setValue(AXIS, $$0.getClickedFace().getAxis());
    }

    static {
        AXIS = BlockStateProperties.AXIS;
    }
}
