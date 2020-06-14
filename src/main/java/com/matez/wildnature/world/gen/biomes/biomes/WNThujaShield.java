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
import com.matez.wildnature.world.gen.feature.WNWaterFeature;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.beech.*;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.boreal.*;
import com.matez.wildnature.world.gen.structures.nature.woods.larch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.*;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.*;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan3;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.spruce1;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.spruce2;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.spruce3;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.spruce4;
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
import net.minecraft.world.gen.placement.CountConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNThujaShield extends WNBiome {
    public WNThujaShield(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(new CustomSurfaceBuilder(new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.BROWN_CONFIG,3),new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.BROWN_PODZOL_CONFIG,1)), SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.TAIGA)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.15F)
                .scale(0.03F)
                .temperature(0.201F)
                .downfall(0.9F)
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
        WNBiomeFeatures.addGrass(this,18);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this,WNBlocks.BLUEBELL.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,WNBlocks.HEATH_PINK.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.HEATH_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.THUJA.getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,WNBlocks.THUJA_LARGE.getDefaultState(),5);
        WNBiomeFeatures.addPlant(this,WNBlocks.BOXWOOD.getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,WNBlocks.THUJA_LIMEGREEN_LARGE.getDefaultState(),5);
        WNBiomeFeatures.addPlant(this,WNBlocks.PERENNIAL_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.PERENNIAL_VIOLET.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:yew_bush").getDefaultState(),4);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:clover").getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:leaf_pile").getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:grass_wheat").getDefaultState().with(FloweringBushBase.FLOWERING,true),4);
        WNBiomeFeatures.addPlant(this,WNBlocks.VIBURNUM_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,WNBlocks.VIBURNUM_PINK.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,WNBlocks.CHRYSANTHEMUM_LIGHT_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,WNBlocks.CHRYSANTHEMUM_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,WNBlocks.CHRYSANTHEMUM_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,WNBlocks.PASQUE_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,WNBlocks.SHRUB.getDefaultState(),4);
        WNBiomeFeatures.addPlant(this,WNBlocks.SHRUB_TALL.getDefaultState(),4);


        WNBiomeFeatures.addTree(this,new tree_pine1(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_pine2(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_pine3(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_pine4(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_pine5(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_pine6(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_bpine1(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_bpine2(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_bpine3(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_bpine4(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_bpine5(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_bpine6(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_larch1(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch2(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch3(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch4(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch5(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch6(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch7(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch8(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch9(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new high_beech_1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new high_beech_2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new high_beech_3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new high_beech_4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new high_beech_5(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new bald_high_oak_1(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new bald_high_oak_2(NoFeatureConfig::deserialize,true),2);

        WNBiomeFeatures.addTree(this,new spiky_birch_1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new spiky_birch_2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new spiky_birch_3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new spiky_birch_4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_birch1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_birch2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_birch3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_birch4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oak1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oak2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new weeping_beech_1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new weeping_beech_2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new weeping_beech_3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new weeping_beech_4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new big_birch_1(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new big_birch_2(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new big_birch_3(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new big_birch_4(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new big_birch_5(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new big_birch_6(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new leafy_beech_1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new leafy_beech_2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new leafy_beech_3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new spruce1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new spruce2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new spruce3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new spruce4(NoFeatureConfig::deserialize,true),1);

        WNBiomeFeatures.addTree(this,new high_oak_1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new high_oak_2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new high_oak_3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new high_oak_4(NoFeatureConfig::deserialize,true),1);


        WNBiomeFeatures.addTree(this,new rowan3(NoFeatureConfig::deserialize,true),1);

        WNBiomeFeatures.addTree(this,new shrub1(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new shrub1(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),2);

        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(new WNBlobFeature(WNBlobConfig::deserialize), new WNBlobConfig(Blocks.STONE.getDefaultState(),4,true,false), Placement.FOREST_ROCK, new FrequencyConfig(2)));
        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(new WNWaterFeature(CountConfig::deserialize),new CountConfig(24), Placement.COUNT_BIASED_RANGE, new CountRangeConfig(50, 60, 0, 150)));

        plantRate=3;
        treeRate=17;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
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
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.002D, (double)pos.getZ() * 0.002D);
        return customColor(noise,-0.3D,0x6BC44E,0xC0D457);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos)
    {
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return customColor3x(noise,-0.1D,0.1d,0xDFDE59,0xD46450,0x61D455);
    }



}