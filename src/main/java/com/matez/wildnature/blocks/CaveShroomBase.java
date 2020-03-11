package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
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

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos) && worldIn.getLightSubtracted(pos, 0) < 10;
    }
    @Override
    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        //Main.LOGGER.info("VALID: " + block.getTranslationKey() + " " + ((BlockTags.getCollection().getOrCreate(new ResourceLocation("forge","stone")).contains(block) || block == Blocks.GRAVEL || block == Blocks.PACKED_ICE)&& ((IWorldReader)worldIn).getLightSubtracted(pos, 0) < 10));
        return ((BlockTags.getCollection().getOrCreate(new ResourceLocation("forge","stone")).contains(block) || block == Blocks.GRAVEL || block == Blocks.PACKED_ICE)&& ((IWorldReader)worldIn).getLightSubtracted(pos, 0) <= 10);
    }

}
