package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.*;
import net.minecraft.block.trees.Tree;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;

public class SaplingBase extends BushBlock implements IGrowable {
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    private final Tree tree;
    private Item item;

    public SaplingBase(Tree tree, Block.Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties);
        this.tree=tree;
        this.setRegistryName(regName);
        this.setDefaultState(this.stateContainer.getBaseState().with(STAGE, Integer.valueOf(0)));

        if(builder==null){

        }else {
            item = new BlockItem(this, builder).setRegistryName(regName);
        }
        WNBlocks.SAPLINGS.add(this);
        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }

    public Tree getTrees() {
        return tree;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
        super.tick(state, worldIn, pos, random);
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getLight(pos.up()) >= 9 && random.nextInt(7) == 0) {
            this.grow(worldIn, pos, state, random);
        }

    }

    public void grow(IWorld worldIn, BlockPos pos, BlockState state, Random rand) {
        if (state.get(STAGE) == 0) {
            worldIn.setBlockState(pos, state.cycle(STAGE), 4);
        } else {
            if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(worldIn, rand, pos)) return;
            worldIn.setBlockState(pos,Blocks.AIR.getDefaultState(),1);
            this.tree.spawn(worldIn, pos, state, rand);
            //System.out.println("growing " + tree.toString());

        }

    }

    /**
     * Whether this IGrowable can grow
     */
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        this.grow(worldIn, pos, state, rand);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }
}
