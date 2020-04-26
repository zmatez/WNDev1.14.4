package com.matez.wildnature.world.gen.biomes.setup;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.world.gen.feature.WNFruitFeature;
import com.matez.wildnature.world.gen.feature.WNVegeFeature;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.EmptyCarverConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.LakeChanceConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.ArrayList;
import java.util.List;

public class WNGlobalBiomeFeatures {

    public static void setup(){
        WNFruitFeature.init();
        WNVegeFeature.init();

        Registry.BIOME.forEach(biome -> {
            WNBiomeFeatures.addMushrooms(biome);
            if(CommonConfig.generateVines.get()){
                WNBiomeFeatures.addCaveVines(biome);
            }
            if(CommonConfig.generateCrystals.get()){
                WNBiomeFeatures.addCrystals(biome);
            }
            if(CommonConfig.generateStalagmites.get()){
                WNBiomeFeatures.addStalagmites(biome);
            }
            if(CommonConfig.generatePebbles.get()){
                WNBiomeFeatures.addPebbles(biome);
            }
            if(CommonConfig.generateCobweb.get()){
                WNBiomeFeatures.addCobweb(biome);
            }
            if(CommonConfig.generateRockFormations.get()){
                WNBiomeFeatures.addRockFormations(biome);
            }
            if(CommonConfig.generateFruitBushes.get()){
                WNBiomeFeatures.addFruits(biome);
            }
            if(CommonConfig.generateVegeCrops.get()){
                WNBiomeFeatures.addVeggies(biome);
            }
            if(CommonConfig.generatePoisonIves.get()){
                WNBiomeFeatures.addPoisonIves(biome);
            }
            if(CommonConfig.generateOres.get()){
                WNBiomeFeatures.addNewOres(biome);
            }
            if(CommonConfig.generateUndergroundPlants.get()){
                WNBiomeFeatures.addCavePlants(biome);
            }
            if(CommonConfig.generateRiverCanes.get()){
                WNBiomeFeatures.addRiverCane(biome);
            }
            if(CommonConfig.generateSmallCacti.get()){
                WNBiomeFeatures.addSmallCacti(biome);
            }
            if(CommonConfig.replaceDefaultTrees.get()){
                replaceDefaultFeatures(biome);
            }
            if(CommonConfig.generateShells.get()){
                WNBiomeFeatures.addShells(biome);
            }
            if(CommonConfig.generateMoss.get()){
                WNBiomeFeatures.addMoss(biome);
            }
            WNBiomeFeatures.addGlowingCaveOaks(biome);

            //carvers
            if(CommonConfig.generateUndergroundRivers.get()){
                //biome.addCarver(GenerationStage.Carving.LIQUID,Biome.createCarver(new RiverCarver(null,256),new EmptyCarverConfig()));
            }

            //removeLakesAndSprings(biome);

        });
    }

    private static void replaceDefaultFeatures(Biome biome){
        for (ConfiguredFeature<?> feature : biome.getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION)) {
            //Main.LOGGER.info("B " +biome.getRegistryName() + " | " + ((DecoratedFeatureConfig)feature.config).feature.feature.getClass());
            if(((DecoratedFeatureConfig)feature.config).feature.feature.getClass()==Feature.BIRCH_TREE.getClass()){
                //Main.LOGGER.info("--> Found same feature on biome " + biome.getRegistryName());
            }
        }
    }

    private static void removeLakesAndSprings(Biome biome){
        int index = 0;
        ArrayList<Integer> toRemove = new ArrayList<>();
        for (ConfiguredFeature<?> feature : biome.getFeatures(GenerationStage.Decoration.LOCAL_MODIFICATIONS)) {
            if(((DecoratedFeatureConfig)feature.config).feature.feature==Feature.LAKE){
                if((((DecoratedFeatureConfig)feature.config).decorator).config instanceof LakesConfig){
                    if(((LakesConfig)(((DecoratedFeatureConfig)feature.config).decorator).config).state==Blocks.WATER.getDefaultState() && CommonConfig.waterLakeGeneration.get()){
                        toRemove.add(index);
                    }
                    if(((LakesConfig)(((DecoratedFeatureConfig)feature.config).decorator).config).state==Blocks.LAVA.getDefaultState() && CommonConfig.lavaLakeGeneration.get()){
                        toRemove.add(index);
                    }
                }

                if((((DecoratedFeatureConfig)feature.config).decorator).config instanceof LiquidsConfig){
                    if(((LiquidsConfig)(((DecoratedFeatureConfig)feature.config).decorator).config).state== Fluids.WATER.getDefaultState() && CommonConfig.waterSpringGeneration.get()){
                        toRemove.add(index);
                    }
                    if(((LiquidsConfig)(((DecoratedFeatureConfig)feature.config).decorator).config).state== Fluids.LAVA.getDefaultState() && CommonConfig.lavaSpringGeneration.get()){
                        toRemove.add(index);
                    }
                }
            }
            index++;
        }

        for (int integer : toRemove) {
            biome.getFeatures(GenerationStage.Decoration.LOCAL_MODIFICATIONS).remove(integer);
        }

    }


}
