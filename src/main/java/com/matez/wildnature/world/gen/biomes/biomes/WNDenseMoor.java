package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.biomes.surface.CustomSurfaceBuilder;
import com.matez.wildnature.world.gen.biomes.biomes.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.feature.WNBlobConfig;
import com.matez.wildnature.world.gen.feature.WNBlobFeature;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.beech.*;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.thin_birch1;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.thin_birch2;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.thin_birch3;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.thin_birch4;
import com.matez.wildnature.world.gen.structures.nature.woods.boreal.*;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.*;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.gen.structures.nature.woods.willow.small_willow1;
import com.matez.wildnature.world.gen.structures.nature.woods.willow.small_willow2;
import com.matez.wildnature.world.gen.structures.nature.woods.willow.small_willow3;
import com.matez.wildnature.world.gen.structures.nature.woods.willow.small_willow4;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNDenseMoor extends WNBiome {
    public WNDenseMoor(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(new CustomSurfaceBuilder(new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.BROWN_PODZOL_CONFIG,5),new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.BROWN_CONFIG,1)), SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.15F)
                .scale(0.03F)
                .temperature(0.25F)
                .downfall(0.7F)
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
        WNBiomeFeatures.addGrass(this,8);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this,WNBlocks.HEATH_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING,true),7);
        WNBiomeFeatures.addPlant(this,WNBlocks.HEATH_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING,true),7);
        WNBiomeFeatures.addPlant(this,WNBlocks.HEATH_PINK.getDefaultState().with(FloweringBushBase.FLOWERING,true),7);
        WNBiomeFeatures.addPlant(this,WNBlocks.HEATHER_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING,true),3);
        WNBiomeFeatures.addPlant(this,WNBlocks.HEATHER_PINK.getDefaultState().with(FloweringBushBase.FLOWERING,true),4);
        WNBiomeFeatures.addPlant(this,WNBlocks.HEATHER_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING,true),4);
        WNBiomeFeatures.addPlant(this,WNBlocks.HEATHER_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING,true),4);
        WNBiomeFeatures.addPlant(this,Blocks.FERN.getDefaultState(),4);
        WNBiomeFeatures.addPlant(this,WNBlocks.BLUEBELL.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,WNBlocks.FORGET_ME_NOT_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.THUJA.getDefaultState(),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.THUJA_LARGE.getDefaultState(),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.PERENNIAL_BLUE.getDefaultState(),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.PERENNIAL_VIOLET.getDefaultState(),1);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:clover").getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:leaf_pile").getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,WNBlocks.VIBURNUM_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.IRIS_VIOLET.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);

        WNBiomeFeatures.addTree(this,new tree_pine1(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_pine2(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_pine3(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_pine4(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_pine5(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_pine6(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_bpine1(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_bpine2(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_bpine3(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_bpine4(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_bpine5(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_bpine6(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),2);

        WNBiomeFeatures.addTree(this,new tall_pine1(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new tall_pine2(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new tall_pine3(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new tall_pine4(NoFeatureConfig::deserialize,true),3);

        WNBiomeFeatures.addTree(this,new thin_birch1(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new thin_birch2(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new thin_birch3(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new thin_birch4(NoFeatureConfig::deserialize,true),5);

        WNBiomeFeatures.addTree(this,new beech1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new beech2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new beech3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new beech4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new beech5(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new beech6(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new beech7(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new beech8(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new beech9(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new beech10(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new beech11(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new beech12(NoFeatureConfig::deserialize,true),1);

        WNBiomeFeatures.addTree(this,new small_willow1(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new small_willow2(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new small_willow3(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new small_willow4(NoFeatureConfig::deserialize,true),2);

        WNBiomeFeatures.addTree(this,new shrub1(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),2);

        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(new WNBlobFeature(WNBlobConfig::deserialize), new WNBlobConfig(WNBlocks.BROWN_GRASS_BLOCK.getDefaultState(),2,true,false), Placement.FOREST_ROCK, new FrequencyConfig(3)));
        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(new WNBlobFeature(WNBlobConfig::deserialize), new WNBlobConfig(Blocks.COARSE_DIRT.getDefaultState(),2,true,false), Placement.FOREST_ROCK, new FrequencyConfig(1)));
        plantRate=3;
        treeRate=14;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 2, 1, 3));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 1, 1, 3));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 10, 4, 4));
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
        return customColor(noise,-0.1D,0xC4A28A,0xC4B78E);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos)
    {
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return customColor(noise,-0.1D,0xA0C18D,0x9CC179);
    }



}