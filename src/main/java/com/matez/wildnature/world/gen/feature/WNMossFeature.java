package com.matez.wildnature.world.gen.feature;

import com.matez.wildnature.blocks.CornPlant;
import com.matez.wildnature.blocks.GreenBeansBush;
import com.matez.wildnature.lists.WNBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.BushConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.CountConfig;

import java.util.Random;
import java.util.function.Function;

public class WNMossFeature extends Feature<CountConfig> {
   public WNMossFeature(Function<Dynamic<?>, ? extends CountConfig> p_i49908_1_) {
      super(p_i49908_1_);
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, CountConfig config) {
      int i = 0;

      for (int j = 0; j < config.count; ++j) {
         BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
         if (worldIn.isAirBlock(blockpos) && (!worldIn.getDimension().isNether() || blockpos.getY() < worldIn.getWorld().getDimension().getHeight()) && worldIn.getBlockState(blockpos.down()).isSolid() && !BlockTags.SAND.contains(worldIn.getBlockState(blockpos.down()).getBlock())) {
            worldIn.setBlockState(blockpos, WNBlocks.MOSS.getDefaultState(), 2);
            ++i;
         }
      }
      return i>0;
   }
}