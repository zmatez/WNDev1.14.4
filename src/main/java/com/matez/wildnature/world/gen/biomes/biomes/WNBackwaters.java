package com.matez.wildnature.world.gen.biomes.biomes;

import com.google.common.collect.Lists;
import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.biomes.biomes.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.woods.mangrove.*;
import com.matez.wildnature.world.gen.structures.nature.woods.willow.*;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNBackwaters extends WNBiome {
    public WNBackwaters(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.SWAMP, WNSurfaceBuilders.MOLD_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.MOIST_TROPICAL)
                .depth(-0.2F)
                .scale(0.1F)
                .temperature(0.5F)
                .downfall(0.9F)
                .waterColor(4159204)
                .waterFogColor(329011)
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
        WNBiomeFeatures.addWaterlilies(this, Main.getBlockByID("wildnature:green_waterlily"),200);
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, createDecoratedFeature(Feature.SEAGRASS, new SeaGrassConfig(128, 0.6D), Placement.TOP_SOLID_HEIGHTMAP, IPlacementConfig.NO_PLACEMENT_CONFIG));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.DISK, new SphereReplaceConfig(Blocks.CLAY.getDefaultState(), 4, 1, Lists.newArrayList(Main.getBlockByID("wildnature:mold_dirt").getDefaultState())), Placement.COUNT_TOP_SOLID, new FrequencyConfig(1)));
        //this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(new WNBlobFeature(WNBlobConfig::deserialize), new WNBlobConfig(WNBlocks.MUD.getDefaultState(),2,true,false), Placement.FOREST_ROCK, new FrequencyConfig(5)));


        WNBiomeFeatures.addTree(this,new pointy_willow_1(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new pointy_willow_2(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new pointy_willow_3(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new pointy_willow_4(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new small_willow1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new small_willow2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new small_willow3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new small_willow4(NoFeatureConfig::deserialize,true),1);

        plantRate=4;
        treeRate=10;

        applyPlants();
        applyTrees();
        this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.SALMON, 5, 1, 5));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 10, 4, 4));
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
}