package com.matez.wildnature.world.gen.structures.nature.woods.minecraft;

import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class WNPointyTaigaTreeFeature extends SchemFeature {

   public WNPointyTaigaTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51429_1_, boolean p_i51429_2_) {
      super(p_i51429_1_, p_i51429_2_);
      setSapling((net.minecraftforge.common.IPlantable)Blocks.SPRUCE_SAPLING);
   }

   public WNPointyTaigaTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51429_1_, BlockState log, BlockState leaves, boolean p_i51429_2_) {
      super(p_i51429_1_, p_i51429_2_);
      setSapling((net.minecraftforge.common.IPlantable)Blocks.SPRUCE_SAPLING);
      LOG=log;
      LEAVES=leaves;
   }

   @Override
   public Set<BlockPos> setBlocks() {
      int i = random.nextInt(5) + 7;
      int j = i - random.nextInt(2) - 3;
      int k = i - j;
      int l = 1 + random.nextInt(k + 1);
      if (startBlockPos.getY() >= 1 && startBlockPos.getY() + i + 1 <= world.getMaxHeight()) {
         boolean flag = true;

         for(int i1 = startBlockPos.getY(); i1 <= startBlockPos.getY() + 1 + i && flag; ++i1) {
            int j1 = 1;
            if (i1 - startBlockPos.getY() < j) {
               j1 = 0;
            } else {
               j1 = l;
            }

            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            for(int k1 = startBlockPos.getX() - j1; k1 <= startBlockPos.getX() + j1 && flag; ++k1) {
               for(int l1 = startBlockPos.getZ() - j1; l1 <= startBlockPos.getZ() + j1 && flag; ++l1) {
                  if (i1 >= 0 && i1 < world.getMaxHeight()) {
                     if (!func_214587_a(world, blockpos$mutableblockpos.setPos(k1, i1, l1))) {
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
            int j2 = 0;

            for(int k2 = startBlockPos.getY() + i; k2 >= startBlockPos.getY() + j; --k2) {
               for(int i3 = startBlockPos.getX() - j2; i3 <= startBlockPos.getX() + j2; ++i3) {
                  int j3 = i3 - startBlockPos.getX();

                  for(int k3 = startBlockPos.getZ() - j2; k3 <= startBlockPos.getZ() + j2; ++k3) {
                     int i2 = k3 - startBlockPos.getZ();
                     if (Math.abs(j3) != j2 || Math.abs(i2) != j2 || j2 <= 0) {
                        BlockPos blockpos = new BlockPos(i3, k2, k3);
                        if (isAirOrLeaves(world, blockpos)) {
                           setBlockState(world, blockpos, LEAVES);
                        }
                     }
                  }
               }

               if (j2 >= 1 && k2 == startBlockPos.getY() + j + 1) {
                  --j2;
               } else if (j2 < l) {
                  ++j2;
               }
            }

            for(int l2 = 0; l2 < i - 1; ++l2) {
               if (isAirOrLeaves(world, startBlockPos.up(l2))) {
                  setBlockState(world, startBlockPos.up(l2), LOG);
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