package com.matez.wildnature.world.gen.feature.features;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.BushConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class LavalilyFeature extends Feature<BushConfig> {
   public LavalilyFeature(Function<Dynamic<?>, ? extends BushConfig> p_i51416_1_) {
      super(p_i51416_1_);
      setRegistryName("wildnature","lavalily_feature");
   }

   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, BushConfig config) {
      if(!worldIn.getDimension().isSurfaceWorld()){
         return false;
      }
      BlockPos blockpos1;
      for(BlockPos blockpos = pos; blockpos.getY() > 0; blockpos = blockpos1) {
         blockpos1 = blockpos.down();
         if (!worldIn.isAirBlock(blockpos1)) {
            break;
         }
      }

      for(int i = 0; i < 10; ++i) {
         BlockPos blockpos2 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
         BlockState blockstate = config.state;
         if (worldIn.isAirBlock(blockpos2) && blockstate.isValidPosition(worldIn, blockpos2)) {
            worldIn.setBlockState(blockpos2, blockstate, 2);
         }
      }

      return true;
   }
}