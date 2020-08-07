package com.matez.wildnature.world.gen.biomes.biomes;

import com.google.common.collect.Lists;
import com.matez.wildnature.Main;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import com.matez.wildnature.world.gen.feature.FeatureRegistry;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.woods.mangrove.*;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNMangroveBayou extends WNBiome {
    public WNMangroveBayou(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.SWAMP, SurfaceRegistry.TROPICAL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.MOIST_TROPICAL)
                .depth(-0.2F)
                .scale(0.1F)
                .temperature(0.8F)
                .downfall(0.9F)
                .waterColor(6388580)
                .waterFogColor(2302743)
                .parent(null));



        this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addDoubleFlowers(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addDefaultFlowers(this);
        WNBiomeFeatures.addGrass(this,18);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addSwampVegetation(this);
        WNBiomeFeatures.func_222329_ae(this);
        WNBiomeFeatures.addWaterlilies(this, WNBlocks.GREEN_WATERLILY,200);
        WNBiomeFeatures.addWaterlilies(this, WNBlocks.DUCKWEED,100);
        WNBiomeFeatures.addWaterlilies(this, WNBlocks.RED_WATERLILY,2);
        WNBiomeFeatures.addFloodedForestDecorations(this);


        WNBiomeFeatures.addTree(this,new mangrove1(),1);
        WNBiomeFeatures.addTree(this,new mangrove2(),1);
        WNBiomeFeatures.addTree(this,new mangrove3(),1);
        WNBiomeFeatures.addTree(this,new mangrove4(),1);
        WNBiomeFeatures.addTree(this,new mangrove5(),1);
        WNBiomeFeatures.addTree(this,new mangrove_shrub1(),2);
        WNBiomeFeatures.addTree(this,new mangrove_shrub2(),2);
        WNBiomeFeatures.addTree(this,new mangrove_shrub3(),2);
        WNBiomeFeatures.addTree(this,new mangrove_shrub4(),2);

        plantRate=4;
        treeRate=10;

        applyPlants();
        applyTrees();
        this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.SQUID, 2, 1, 4));
        this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.DOLPHIN, 1, 1, 1));
        this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.TROPICAL_FISH, 5, 1, 5));
        this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.PUFFERFISH, 3, 1, 5));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));

    }


    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(BlockPos pos)
    {
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return customColor(noise,-0.1D,0x7DAD51,0x66AD47);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos)
    {
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return customColor(noise,-0.1D,0x9DDD66, 0x92DD6D);
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0xB1CD9F;
    }
}