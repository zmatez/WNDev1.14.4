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
import com.matez.wildnature.world.gen.structures.nature.woods.another_spruce.*;
import com.matez.wildnature.world.gen.structures.nature.woods.beech.*;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.boreal.*;
import com.matez.wildnature.world.gen.structures.nature.woods.larch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.*;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan3;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga11;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga12;
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

public class WNTaigaHills extends WNBiome {
    public WNTaigaHills(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(new CustomSurfaceBuilder(new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.BROWN_PODZOL_CONFIG,5),new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.BROWN_CONFIG,1)), SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.TAIGA)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(1F)
                .scale(0.6F)
                .temperature(0.21F)
                .downfall(0.5F)
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
        WNBiomeFeatures.addGrass(this,5,Blocks.FERN.getDefaultState());
        WNBiomeFeatures.addGrass(this,15,Blocks.LARGE_FERN.getDefaultState(),true);
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addBerryBushes(this);
        WNBiomeFeatures.addTaigaRocks(this);

        WNBiomeFeatures.addPlant(this,WNBlocks.BLUEBELL.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,WNBlocks.HEATH_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.FORGET_ME_NOT_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.THUJA.getDefaultState(),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.THUJA_LARGE.getDefaultState(),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.PERENNIAL_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.HEATHER_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.PRIMROSE_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.PRIMROSE_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:yew_bush").getDefaultState(),4);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:clover").getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:leaf_pile").getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:grass_wheat").getDefaultState().with(FloweringBushBase.FLOWERING,true),4);
        WNBiomeFeatures.addPlant(this,WNBlocks.VIBURNUM_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,WNBlocks.GRASS_FERNSPROUT.getDefaultState(),2);
        WNBiomeFeatures.addPlant(this,WNBlocks.BUSH_WILD_BLUEBERRY.getDefaultState(),1);

        WNBiomeFeatures.addTree(this,new tree_pine1(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),4);
        WNBiomeFeatures.addTree(this,new tree_pine2(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),4);
        WNBiomeFeatures.addTree(this,new tree_pine3(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),4);
        WNBiomeFeatures.addTree(this,new tree_pine4(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),4);
        WNBiomeFeatures.addTree(this,new tree_pine5(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),4);
        WNBiomeFeatures.addTree(this,new tree_pine6(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),4);
        WNBiomeFeatures.addTree(this,new tree_bpine1(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),4);
        WNBiomeFeatures.addTree(this,new tree_bpine2(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),4);
        WNBiomeFeatures.addTree(this,new tree_bpine3(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),4);
        WNBiomeFeatures.addTree(this,new tree_bpine4(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),4);
        WNBiomeFeatures.addTree(this,new tree_bpine5(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),4);
        WNBiomeFeatures.addTree(this,new tree_bpine6(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),4);
        WNBiomeFeatures.addTree(this,new tree_larch1(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch2(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch3(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch4(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch5(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch6(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch7(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch8(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch9(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_spruce_big1(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),5);
        WNBiomeFeatures.addTree(this,new tree_spruce_big2(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),5);
        WNBiomeFeatures.addTree(this,new tree_spruce_big3(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),5);
        WNBiomeFeatures.addTree(this,new tree_spruce_big4(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),5);
        WNBiomeFeatures.addTree(this,new tree_spruce_m1(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_spruce_m2(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_spruce_m3(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_spruce_m4(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_spruce_m5(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_spruce_m6(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_spruce_m7(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_spruce_m8(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_spruce_m9(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);

        WNBiomeFeatures.addTree(this,new tree_taiga11(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:spruce_leaves"))),10);
        WNBiomeFeatures.addTree(this,new tree_taiga12(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:spruce_leaves"))),10);

        WNBiomeFeatures.addTree(this,new thin_pine1(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new thin_pine2(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new thin_pine3(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new thin_pine4(NoFeatureConfig::deserialize,true),3);

        WNBiomeFeatures.addTree(this,new tall_pine1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new tall_pine2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new tall_pine3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new tall_pine4(NoFeatureConfig::deserialize,true),1);

        WNBiomeFeatures.addTree(this,new thin_birch1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new thin_birch2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new thin_birch3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new thin_birch4(NoFeatureConfig::deserialize,true),1);

        WNBiomeFeatures.addTree(this,new spiky_birch_1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new spiky_birch_2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new spiky_birch_3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new spiky_birch_4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_birch1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_birch2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_birch3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_birch4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new weeping_beech_1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new weeping_beech_2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new weeping_beech_3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new weeping_beech_4(NoFeatureConfig::deserialize,true),1);

        WNBiomeFeatures.addTree(this,new leafy_beech_1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new thick_beech2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new thick_beech3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new thick_beech4(NoFeatureConfig::deserialize,true),1);

        WNBiomeFeatures.addTree(this,new thick_beech1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new thick_beech2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new thick_beech3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new thick_beech4(NoFeatureConfig::deserialize,true),1);

        WNBiomeFeatures.addTree(this,new leafy_beech_1(NoFeatureConfig::deserialize,true,null,SchemFeature.notDecayingLeaf(WNBlocks.PURPLE_BEECH_LEAVES)),1);

        WNBiomeFeatures.addTree(this,new rowan3(NoFeatureConfig::deserialize,true),1);

        WNBiomeFeatures.addTree(this,new shrub1(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new shrub1(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),2);

        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(new WNBlobFeature(WNBlobConfig::deserialize), new WNBlobConfig(WNBlocks.BROWN_GRASS_BLOCK.getDefaultState(),2,true,false), Placement.FOREST_ROCK, new FrequencyConfig(3)));

        plantRate=2;
        treeRate=14;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 2, 1, 3));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 2, 1, 3));
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
        return customColor(noise,-0.1D,0x63C47D,0x77C45B);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos)
    {
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return customColor(noise,-0.1D,0x5DB259,0x7FBC70);
    }



}