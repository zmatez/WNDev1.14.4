package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;

import static net.minecraft.state.properties.DoubleBlockHalf.UPPER;

public class BelladonnaBlock extends DoubleBushBase{
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 3);

    public BelladonnaBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        super.fillStateContainer(p_206840_1_);
        p_206840_1_.add(STAGE);
    }

    public void setBlock(IWorld world, BlockPos pos, int stage){
        BlockPos bp = pos;
        if(world.getBlockState(pos).getBlock() instanceof BelladonnaBlock && world.getBlockState(pos).get(HALF)==UPPER) {
            bp = bp.down();
        }
        world.setBlockState(pos, this.getDefaultState().with(STAGE, stage).with(HALF, DoubleBlockHalf.LOWER), 2);
        if (world.getBlockState(pos.up()).getBlock() instanceof BelladonnaBlock) {
            world.setBlockState(pos.up(), this.getDefaultState().with(STAGE, stage).with(HALF, UPPER), 2);
        }else if(world.isAirBlock(bp.up())){
            world.setBlockState(pos.up(), this.getDefaultState().with(STAGE, stage).with(HALF, UPPER), 2);
        }
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        if(placer instanceof PlayerEntity && ((PlayerEntity)placer).isCreative()){
            setBlock(worldIn, pos, 3);
        }else {
            setBlock(worldIn, pos, state.get(STAGE));
        }
    }

    @Override
    public void placeAt(IWorld p_196390_1_, BlockPos p_196390_2_, int p_196390_3_) {
        setBlock(p_196390_1_,p_196390_2_,0);
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        if(state.get(STAGE)<3) {
            setBlock(worldIn, pos, worldIn.getBlockState(pos).get(STAGE) + 1);
        }else{
            super.grow(worldIn, rand, pos, state);
        }
    }

    @Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity entity, Hand hand, BlockRayTraceResult rayTraceResult) {
        if(state.getBlock()== WNBlocks.BELLADONNA && state.get(STAGE)==3){
            world.setBlockState(pos,state.with(STAGE,Utilities.rint(0,1)));
            spawnAsEntity(world, pos, new ItemStack(Main.getItemByID("wildnature:belladonna_fruit"), 1));
            world.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + world.rand.nextFloat() * 0.4F);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
    }

    @Override
    public void randomTick(BlockState state, World worldIn, BlockPos pos, Random random) {
        if(Utilities.chance(ConfigSettings.floweringChance) && state.get(STAGE)<3){
            setBlock(worldIn,pos,state.get(STAGE)+1);
            worldIn.notifyBlockUpdate(pos,state,worldIn.getBlockState(pos),2);
        }
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return state.get(STAGE)<=3;
    }
}
