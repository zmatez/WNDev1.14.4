package com.matez.wildnature.blocks.colors;

import com.matez.wildnature.Main;
import com.matez.wildnature.other.Utilities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.chunk.ChunkRenderCache;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.CubeCoordinateIterator;
import net.minecraft.world.IEnviromentBlockReader;
import net.minecraft.world.Region;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WNBiomeColors {
   private static final WNBiomeColors.IColorResolver GRASS_COLOR = (biome, pos, seed) -> biome.getGrassColor(pos);
   private static final WNBiomeColors.IColorResolver FOLIAGE_COLOR = (biome, pos, seed) -> biome.getFoliageColor(pos);
   private static final WNBiomeColors.IColorResolver WATER_COLOR = (biome, pos, seed) -> {
      if(pos.getY()>20) {
         return biome.getWaterColor();
      }
      return 0;
   };
   private static final WNBiomeColors.IColorResolver WATER_FOG_COLOR = (biome, pos, seed) -> {
      if(pos.getY()>20) {
         return biome.getWaterColor();
      }
      return 0;
   };

   private static int getColor(IEnviromentBlockReader reader, BlockPos pos, WNBiomeColors.IColorResolver resolver) {
      int i = 0;
      int j = 0;
      int k = 0;
      int l = Minecraft.getInstance().gameSettings.biomeBlendRadius;
      if(Utilities.rint(0,10)==0) {
         Main.LOGGER.info((reader instanceof World) + " " + (reader instanceof Region) + " " + (reader instanceof ChunkRenderCache) + " " + (reader instanceof WorldGenRegion));
      }
      if (l == 0) {
         return resolver.getColor(reader.getBiome(pos), pos,0);
      } else {
         int i1 = (l * 2 + 1) * (l * 2 + 1);
         CubeCoordinateIterator cubecoordinateiterator = new CubeCoordinateIterator(pos.getX() - l, pos.getY(), pos.getZ() - l, pos.getX() + l, pos.getY(), pos.getZ() + l);

         int j1;
         for(BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(); cubecoordinateiterator.hasNext(); k += j1 & 255) {
            blockpos$mutableblockpos.setPos(cubecoordinateiterator.getX(), cubecoordinateiterator.getY(), cubecoordinateiterator.getZ());
            j1 = resolver.getColor(reader.getBiome(blockpos$mutableblockpos), blockpos$mutableblockpos,0);
            i += (j1 & 16711680) >> 16;
            j += (j1 & '\uff00') >> 8;
         }

         return (i / i1 & 255) << 16 | (j / i1 & 255) << 8 | k / i1 & 255;
      }
   }

   public static int getGrassColor(IEnviromentBlockReader reader, BlockPos pos) {
      return getColor(reader, pos, GRASS_COLOR);
   }

   public static int getFoliageColor(IEnviromentBlockReader reader, BlockPos pos) {
      return getColor(reader, pos, FOLIAGE_COLOR);
   }

   public static int getWaterColor(IEnviromentBlockReader reader, BlockPos pos) {
      return getColor(reader, pos, WATER_COLOR);
   }

   @OnlyIn(Dist.CLIENT)
   interface IColorResolver {
      int getColor(Biome p_getColor_1_, BlockPos p_getColor_2_, long seed);
   }
}