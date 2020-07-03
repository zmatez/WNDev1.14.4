package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.biomes.surface.PodzolSurfaceBuilder;
import com.matez.wildnature.world.gen.biomes.biomes.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.feature.WNBlobConfig;
import com.matez.wildnature.world.gen.feature.WNBlobFeature;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.beech.*;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir6;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir9;
import com.matez.wildnature.world.gen.structures.nature.woods.larch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.*;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan3;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan4;
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
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNSnowyTatraLowerForest extends WNBiome {
    public WNSnowyTatraLowerForest(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(new PodzolSurfaceBuilder(SurfaceBuilderConfig::deserialize), WNSurfaceBuilders.BROWN_CONFIG)
                .precipitation(RainType.SNOW)
                .category(Category.EXTREME_HILLS)
                .topography(WNBiomeBuilder.Topography.HIGH_MOUNTAINS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(1.2F)
                .scale(0.5F)
                .temperature(-0.6F)
                .downfall(0.9F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .parent(null));



        this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        this.addStructure(Feature.VILLAGE, new VillageConfig("village/taiga/town_centers", 6));
        WNBiomeFeatures.addFreezeTopLayer(this);
        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addLakes(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addDoubleFlowers(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addDefaultFlowers(this);
        WNBiomeFeatures.addGrass(this,10);
        WNBiomeFeatures.addGrass(this,5, WNBlocks.MEDIUM_GRASS.getDefaultState());
        WNBiomeFeatures.addGrass(this,15, Blocks.TALL_GRASS.getDefaultState(), true);
        WNBiomeFeatures.addGrass(this,5, Blocks.FERN.getDefaultState());
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:bluebell").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this, WNBlocks.PASQUE_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this, WNBlocks.CROCUS_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this, WNBlocks.PRIMROSE_PINK.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this, WNBlocks.FIRE_WEED.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_PINK.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATH_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(new WNBlobFeature(WNBlobConfig::deserialize), new WNBlobConfig(WNBlocks.BROWN_PODZOL.getDefaultState(),2,true,false), Placement.FOREST_ROCK, new FrequencyConfig(3)));
        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(new WNBlobFeature(WNBlobConfig::deserialize), new WNBlobConfig(WNBlocks.GRANITE_COBBLE_MOSSY.getDefaultState(),3,false,true), Placement.FOREST_ROCK, new FrequencyConfig(1)));

        WNBiomeFeatures.addTree(this,new tree_fir9(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),8);
        WNBiomeFeatures.addTree(this,new tree_fir6(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),8);
        WNBiomeFeatures.addTree(this,new tree_taiga12(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(Blocks.SPRUCE_LEAVES)),7);
        WNBiomeFeatures.addTree(this,new tree_taiga11(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(Blocks.SPRUCE_LEAVES)),7);

        WNBiomeFeatures.addTree(this,new thin_pine1(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new thin_pine2(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new thin_pine3(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new thin_pine4(NoFeatureConfig::deserialize,true),3);

        WNBiomeFeatures.addTree(this,new beech1(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new beech2(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new beech3(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new beech4(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new leafy_beech_1(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new leafy_beech_2(NoFeatureConfig::deserialize,true),3);
        WNBiomeFeatures.addTree(this,new leafy_beech_3(NoFeatureConfig::deserialize,true),3);

        WNBiomeFeatures.addTree(this,new tree_pine1(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_pine2(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_pine3(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_pine4(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_pine5(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_pine6(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),1);

        WNBiomeFeatures.addTree(this,new tree_larch1(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch2(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch3(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch4(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch5(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch6(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch7(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch8(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_larch9(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),1);

        WNBiomeFeatures.addTree(this,new rowan3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new rowan4(NoFeatureConfig::deserialize,true),1);
        plantRate=4;
        treeRate=16;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 3, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 5, 4, 4));
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
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0065D, (double)pos.getZ() * 0.0065D);
        return customColor(noise,-0.1D,0x87C250,0x72C248);
    }



}