package com.matez.wildnature.blocks;

import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.other.Utilities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireWeedBush extends DoubleBushBaseFlowering {
    public FireWeedBush(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if(state.getBlock() instanceof DoubleBushBaseFlowering && state.get(FLOWERING) && !(entityIn instanceof ItemEntity)){
            worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(FLOWERING,false));
            worldIn.playSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS,0.3F,(float) Utilities.rdoub(0.7,1.3),false);
            if(CommonConfig.poisonIvyPoisons.get()) {
                ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.WITHER, Utilities.rint(40, 300), 1, true, false));
            }
        }
    }
}