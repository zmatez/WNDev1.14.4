package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.biomes.surface.CustomSurfaceBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.feature.WNBlobConfig;
import com.matez.wildnature.world.gen.feature.WNBlobFeature;
import com.matez.wildnature.world.gen.feature.WNTreeVinesFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.cherry.wild_cherry2;
import com.matez.wildnature.world.gen.structures.nature.woods.oaklands.*;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan1;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan4;
import com.matez.wildnature.world.gen.structures.nature.woods.sequoia.*;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BushConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNSequoiaHills extends WNBiome {
    public WNSequoiaHills(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(new CustomSurfaceBuilder(new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG,4),new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.PODZOL_DIRT_GRAVEL_CONFIG,1)), SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.8F)
                .scale(0.4F)
                .temperature(0.5F)
                .downfall(0.8F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .parent(null));



        this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addLakes(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addDoubleFlowers(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addDefaultFlowers(this);
        WNBiomeFeatures.addGrass(this,6);
        WNBiomeFeatures.addGrass(this,10, Blocks.FERN.getDefaultState());
        WNBiomeFeatures.addGrass(this,4, WNBlocks.MOSS.getDefaultState());
        WNBiomeFeatures.addGrass(this,30, Blocks.LARGE_FERN.getDefaultState(),true);
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:yew_bush").getDefaultState(),4);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:clover").getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:leaf_pile").getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,WNBlocks.PASQUE_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING,true),3);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:grass_flower").getDefaultState().with(FloweringBushBase.FLOWERING,true),4);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:grass_wheat").getDefaultState().with(FloweringBushBase.FLOWERING,true),4);
        WNBiomeFeatures.addPlant(this,WNBlocks.HEPATICA_VIOLET.getDefaultState().with(FloweringBushBase.FLOWERING,true),3);
        WNBiomeFeatures.addPlant(this,WNBlocks.HYDRANGEA_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.HYDRANGEA_PINK.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);

        WNBiomeFeatures.addTree(this,new sequoia1(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new sequoia2(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new sequoia3(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new sequoia4(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new sequoia5(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new sequoia6(NoFeatureConfig::deserialize,true),5);

        WNBiomeFeatures.addTree(this,new oaklands_oak1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oaklands_oak2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oaklands_oak3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oaklands_oak4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oaklands_oak5(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oaklands_oak6(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oaklands_oak7(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oaklands_oak8(NoFeatureConfig::deserialize,true),1);

        WNBiomeFeatures.addTree(this,new rowan1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new rowan4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new wild_cherry2(NoFeatureConfig::deserialize,true),1);

        WNBiomeFeatures.addTree(this,new oaklands_smallshrub1(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new oaklands_smallshrub2(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new oaklands_smallshrub3(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new shrub1(NoFeatureConfig::deserialize,true),10);

        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(new WNBlobFeature(WNBlobConfig::deserialize), new WNBlobConfig(Blocks.PODZOL.getDefaultState(),2,true,false), Placement.FOREST_ROCK, new FrequencyConfig(3)));
        this.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Biome.createDecoratedFeature(new WNTreeVinesFeature(BushConfig::deserialize), new BushConfig(WNBlocks.GRAPE_VINE_PURPLE.getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(1, 65, 0, 80)));

        plantRate=2;
        treeRate=12;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 5, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 2, 1, 3));
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
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.007D, (double)pos.getZ() * 0.007D);
        return customColor(noise,-0.1D,0x90E265,0x91DA53);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos)
    {
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return customColor(noise,-0.1D,0x8CD660,0x9DE549);
    }



}