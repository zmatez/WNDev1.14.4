package com.matez.wildnature.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class HorizontalBase extends BlockBase{
    public static final DirectionProperty FACING;

    public HorizontalBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
        this.setDefaultState((BlockState)((BlockState)this.getStateContainer().getBaseState()).with(FACING, Direction.NORTH));
    }

    public HorizontalBase(Properties properties, Item.Properties builder, String drop, int min, int max, int exp, ResourceLocation regName) {
        super(properties, builder, drop, min, max, exp, regName);
        this.setDefaultState((BlockState)((BlockState)this.getStateContainer().getBaseState()).with(FACING, Direction.NORTH));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return (BlockState)this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    static {
        FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
    }
}
