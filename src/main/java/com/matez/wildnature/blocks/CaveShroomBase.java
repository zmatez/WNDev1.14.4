package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class CaveShroomBase extends MushroomBase {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
    public CaveShroomBase(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        BlockState blockstate = worldIn.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block != Blocks.MYCELIUM && block != Blocks.PODZOL && block != WNBlocks.BROWN_PODZOL&& block != WNBlocks.BROWN_MYCELIUM && block != Blocks.STONE) {
            return worldIn.getLightSubtracted(pos, 0) < 10 && blockstate.isSolid();
        } else {
            return true;
        }
    }

}
