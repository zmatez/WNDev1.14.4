package com.matez.wildnature.world.gen.structures.nature.woods.minecraft;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class WNTallTaigaTreeFeature extends SchemFeature {

   public WNTallTaigaTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51429_1_, boolean p_i51429_2_) {
      super(p_i51429_1_, p_i51429_2_);
      setSapling((net.minecraftforge.common.IPlantable)Blocks.SPRUCE_SAPLING);
   }

   public WNTallTaigaTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51429_1_, BlockState log, BlockState leaves, boolean p_i51429_2_) {
      super(p_i51429_1_, p_i51429_2_);
      setSapling((net.minecraftforge.common.IPlantable)Blocks.SPRUCE_SAPLING);
      LOG=log;
      LEAVES=leaves;
   }

   @Override
   public Set<BlockPos> setBlocks() {
      int i = random.nextInt(4) + 6;
      int j = 1 + random.nextInt(2);
      int k = i - j;
      int l = 2 + random.nextInt(2);
      boolean flag = true;
      if (startBlockPos.getY() >= 1 && startBlockPos.getY() + i + 1 <= world.getMaxHeight()) {
         for(int i1 = startBlockPos.getY(); i1 <= startBlockPos.getY() + 1 + i && flag; ++i1) {
            int j1;
            if (i1 - startBlockPos.getY() < j) {
               j1 = 0;
            } else {
               j1 = l;
            }

            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            for(int k1 = startBlockPos.getX() - j1; k1 <= startBlockPos.getX() + j1 && flag; ++k1) {
               for(int l1 = startBlockPos.getZ() - j1; l1 <= startBlockPos.getZ() + j1 && flag; ++l1) {
                  if (i1 >= 0 && i1 < world.getMaxHeight()) {
                     blockpos$mutableblockpos.setPos(k1, i1, l1);
                     if (!isAirOrLeaves(world, blockpos$mutableblockpos)) {
                        flag = false;
                     }
                  } else {
                     flag = false;
                  }
               }
            }
         }

         if (!flag) {
            return null;
         } else if (isSoil(world, startBlockPos.down(), getSapling()) && startBlockPos.getY() < world.getMaxHeight() - i - 1) {
            this.setDirtAt(world, startBlockPos.down(), startBlockPos);
            int i3 = random.nextInt(2);
            int j3 = 1;
            int k3 = 0;

            for(int l3 = 0; l3 <= k; ++l3) {
               int j4 = startBlockPos.getY() + i - l3;

               for(int i2 = startBlockPos.getX() - i3; i2 <= startBlockPos.getX() + i3; ++i2) {
                  int j2 = i2 - startBlockPos.getX();

                  for(int k2 = startBlockPos.getZ() - i3; k2 <= startBlockPos.getZ() + i3; ++k2) {
                     int l2 = k2 - startBlockPos.getZ();
                     if (Math.abs(j2) != i3 || Math.abs(l2) != i3 || i3 <= 0) {
                        BlockPos blockpos = new BlockPos(i2, j4, k2);
                        if (isAirOrLeaves(world, blockpos) || func_214576_j(world, blockpos)) {
                           setBlockState(world, blockpos, LEAVES);
                        }
                     }
                  }
               }

               if (i3 >= j3) {
                  i3 = k3;
                  k3 = 1;
                  ++j3;
                  if (j3 > l) {
                     j3 = l;
                  }
               } else {
                  ++i3;
               }
            }

            int i4 = random.nextInt(3);

            for(int k4 = 0; k4 < i - i4; ++k4) {
               if (isAirOrLeaves(world, startBlockPos.up(k4))) {
                  setBlockState(world, startBlockPos.up(k4), LOG);
               }
            }

            return super.setBlocks();
         } else {
            return null;
         }
      } else {
         return null;
      }
   }
}