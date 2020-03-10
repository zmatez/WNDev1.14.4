package com.matez.wildnature.world.gen.biomes.layer;

import com.matez.wildnature.world.gen.biomes.setup.WNBiomes;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum WNShoreLayer implements ICastleTransformer {
   INSTANCE;

   private static final int BEACH = Registry.BIOME.getId(Biomes.BEACH);
   private static final int SNOWY_BEACH = Registry.BIOME.getId(Biomes.SNOWY_BEACH);
   private static final int DESERT = Registry.BIOME.getId(Biomes.DESERT);
   private static final int MOUNTAINS = Registry.BIOME.getId(Biomes.MOUNTAINS);
   private static final int WOODED_MOUNTAINS = Registry.BIOME.getId(Biomes.WOODED_MOUNTAINS);
   private static final int FOREST = Registry.BIOME.getId(Biomes.FOREST);
   private static final int JUNGLE = Registry.BIOME.getId(Biomes.JUNGLE);
   private static final int JUNGLE_EDGE = Registry.BIOME.getId(Biomes.JUNGLE_EDGE);
   private static final int JUNGLE_HILLS = Registry.BIOME.getId(Biomes.JUNGLE_HILLS);
   private static final int BADLANDS = Registry.BIOME.getId(Biomes.BADLANDS);
   private static final int WOODED_BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.WOODED_BADLANDS_PLATEAU);
   private static final int BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.BADLANDS_PLATEAU);
   private static final int ERODED_BADLANDS = Registry.BIOME.getId(Biomes.ERODED_BADLANDS);
   private static final int MODIFIED_WOODED_BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU);
   private static final int MODIFIED_BADLANDS_PLATEAU = Registry.BIOME.getId(Biomes.MODIFIED_BADLANDS_PLATEAU);
   private static final int MUSHROOM_FIELDS = Registry.BIOME.getId(Biomes.MUSHROOM_FIELDS);
   private static final int MUSHROOM_FIELD_SHORE = Registry.BIOME.getId(Biomes.MUSHROOM_FIELD_SHORE);
   private static final int RIVER = Registry.BIOME.getId(Biomes.RIVER);
   private static final int MOUNTAIN_EDGE = Registry.BIOME.getId(Biomes.MOUNTAIN_EDGE);
   private static final int STONE_SHORE = Registry.BIOME.getId(Biomes.STONE_SHORE);
   private static final int SWAMP = Registry.BIOME.getId(Biomes.SWAMP);
   private static final int TAIGA = Registry.BIOME.getId(Biomes.TAIGA);
   private static final int WHITE_BEACH = Registry.BIOME.getId(WNBiomes.WhiteBeach);
   private static final int MAHOGANY_RAINFOREST = Registry.BIOME.getId(WNBiomes.MahoganyRainforest);
   private static final int TROPICAL_ISLAND = Registry.BIOME.getId(WNBiomes.TropicalIsland);
   private static final int MADAGASCAR = Registry.BIOME.getId(WNBiomes.Madagascar);
   private static final int TROPICAL_CLIFFS = Registry.BIOME.getId(WNBiomes.TropicalCliffs);

   public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
      Biome biome = Registry.BIOME.getByValue(center);
      if (center == MUSHROOM_FIELDS) {
         if (WNLayerUtil.isShallowOcean(north) || WNLayerUtil.isShallowOcean(west) || WNLayerUtil.isShallowOcean(south) || WNLayerUtil.isShallowOcean(east)) {
            return MUSHROOM_FIELD_SHORE;
         }
      }else if (center == MAHOGANY_RAINFOREST || center == TROPICAL_ISLAND || center == TROPICAL_CLIFFS || center == MADAGASCAR) {
         if (WNLayerUtil.isShallowOcean(north) || WNLayerUtil.isShallowOcean(west) || WNLayerUtil.isShallowOcean(south) || WNLayerUtil.isShallowOcean(east)) {
            return WHITE_BEACH;
         }
      } else if (biome != null && biome.getCategory() == Biome.Category.JUNGLE) {
         if (!isJungleCompatible(north) || !isJungleCompatible(west) || !isJungleCompatible(south) || !isJungleCompatible(east)) {
            return JUNGLE_EDGE;
         }

         if (WNLayerUtil.isOcean(north) || WNLayerUtil.isOcean(west) || WNLayerUtil.isOcean(south) || WNLayerUtil.isOcean(east)) {
            return BEACH;
         }
      } else if (center != MOUNTAINS && center != WOODED_MOUNTAINS && center != MOUNTAIN_EDGE) {
         if (biome != null && biome.getPrecipitation() == Biome.RainType.SNOW) {
            if (!WNLayerUtil.isOcean(center) && (WNLayerUtil.isOcean(north) || WNLayerUtil.isOcean(west) || WNLayerUtil.isOcean(south) || WNLayerUtil.isOcean(east))) {
               return SNOWY_BEACH;
            }
         } else if (center != BADLANDS && center != WOODED_BADLANDS_PLATEAU) {
            if (!WNLayerUtil.isOcean(center) && center != RIVER && center != SWAMP && (WNLayerUtil.isOcean(north) || WNLayerUtil.isOcean(west) || WNLayerUtil.isOcean(south) || WNLayerUtil.isOcean(east))) {
               return BEACH;
            }
         } else if (!WNLayerUtil.isOcean(north) && !WNLayerUtil.isOcean(west) && !WNLayerUtil.isOcean(south) && !WNLayerUtil.isOcean(east) && (!this.isMesa(north) || !this.isMesa(west) || !this.isMesa(south) || !this.isMesa(east))) {
            return DESERT;
         }
      } else if (!WNLayerUtil.isOcean(center) && (WNLayerUtil.isOcean(north) || WNLayerUtil.isOcean(west) || WNLayerUtil.isOcean(south) || WNLayerUtil.isOcean(east))) {
         return STONE_SHORE;
      }

      return center;
   }

   private static boolean isJungleCompatible(int p_151631_0_) {
      if (Registry.BIOME.getByValue(p_151631_0_) != null && Registry.BIOME.getByValue(p_151631_0_).getCategory() == Biome.Category.JUNGLE) {
         return true;
      } else {
         return p_151631_0_ == JUNGLE_EDGE || p_151631_0_ == JUNGLE || p_151631_0_ == JUNGLE_HILLS || p_151631_0_ == FOREST || p_151631_0_ == TAIGA || WNLayerUtil.isOcean(p_151631_0_);
      }
   }

   private boolean isMesa(int p_151633_1_) {
      return p_151633_1_ == BADLANDS || p_151633_1_ == WOODED_BADLANDS_PLATEAU || p_151633_1_ == BADLANDS_PLATEAU || p_151633_1_ == ERODED_BADLANDS || p_151633_1_ == MODIFIED_WOODED_BADLANDS_PLATEAU || p_151633_1_ == MODIFIED_BADLANDS_PLATEAU;
   }
}