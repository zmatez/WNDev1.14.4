package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;

import javax.annotation.Nullable;
import java.util.List;

public class PodzolBase extends BlockBase {
    public Item item;
    private String dirt;

    public PodzolBase(Properties properties, Item.Properties builder, ResourceLocation regName, String dirt) {
        super(properties,builder,regName);
    }

    public Item getItem() {
        return item;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);

        //System.out.println("biome: " + BiomeColors.getGrassColor(worldIn, pos) + " foliage: " + GrassColors.get(0.5,0.5));


    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        boolean silkTouch = false;
        List<ItemStack> list = super.getDrops(state, builder);
        if(list.isEmpty() && !silkTouch){
            list.add(new ItemStack(Item.getItemFromBlock(Main.getBlockByID(dirt)), 1));
        }

        return list;
    }
}
