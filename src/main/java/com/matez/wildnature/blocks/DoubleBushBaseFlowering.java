package com.matez.wildnature.blocks;

import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;

import java.util.List;
import java.util.Random;

public class DoubleBushBaseFlowering extends TallFlowerBlock {
    private Item item;
    public static final BooleanProperty FLOWERING = FloweringBushBase.FLOWERING;
    private static Properties Properties(Properties properties){

        return properties.doesNotBlockMovement().sound(SoundType.SWEET_BERRY_BUSH);

    }

    public DoubleBushBaseFlowering(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(Properties(properties));

        this.setRegistryName(regName);
        item = new BlockItem(this,builder).setRegistryName(regName);
        setDefaultState(this.getDefaultState().with(FLOWERING,false));

        WNBlocks.BLOCKS.add(this);
        WNBlocks.ITEMBLOCKS.add(item);
    }

    public Item getItem() {
        return item;
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FLOWERING);
        super.fillStateContainer(builder);

    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        boolean silkTouch = false;
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && !silkTouch){
            list.add(new ItemStack(item, 1));
        }

        return list;
    }

    @Override
    public void randomTick(BlockState state, World worldIn, BlockPos pos, Random random) {
        if(Utilities.chance(ConfigSettings.floweringChance)){
            worldIn.setBlockState(pos,state.with(FLOWERING,true));
        }
    }


    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(state.getBlock() instanceof DoubleBushBaseFlowering && state.get(FLOWERING)){
            worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(FLOWERING,false));
            worldIn.playSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS,0.3F,(float) Utilities.rdoub(0.7,1.3),false);

        }
    }
}
