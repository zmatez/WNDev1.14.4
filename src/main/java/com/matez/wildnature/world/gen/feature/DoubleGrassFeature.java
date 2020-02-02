package com.matez.wildnature.world.gen.feature;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.Half;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.DoublePlantConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class DoubleGrassFeature extends Feature<DoublePlantConfig> {
   public DoubleGrassFeature(Function<Dynamic<?>, ? extends DoublePlantConfig> p_i49884_1_) {
      super(p_i49884_1_);
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, DoublePlantConfig config) {
      boolean flag = false;

      for(int i = 0; i < 128; ++i) {
         BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
         if (worldIn.isAirBlock(blockpos) && blockpos.getY() < worldIn.getWorld().getDimension().getHeight() - 2 && config.state.isValidPosition(worldIn, blockpos)) {
            worldIn.setBlockState(blockpos,config.state.with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER),2);
            worldIn.setBlockState(blockpos.up(),config.state.with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER),2);
            flag = true;
         }
      }

      return flag;
   }
}