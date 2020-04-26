package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.biomes.biomes.surface.CustomSurfaceBuilder;
import com.matez.wildnature.world.gen.biomes.biomes.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch1;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch10;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch3;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch4;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak15;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak24;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak28;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.*;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga17;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga5;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.*;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNForest extends WNBiome {
    public WNForest(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(new CustomSurfaceBuilder(new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.BROWN_CONFIG,3),new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.BROWN_PODZOL_CONFIG,1)), SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.15F)
                .scale(0.05F)
                .temperature(0.6F)
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
        WNBiomeFeatures.addGrass(this);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:heather_yellow").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_white").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:yew_bush").getDefaultState(),4);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:pasque_white").getDefaultState().with(FloweringBushBase.FLOWERING,true),3);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:clover").getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:leaf_pile").getDefaultState(),3);


        WNBiomeFeatures.addTree(this,new tree_pine1(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_pine2(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_pine3(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_pine4(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_pine5(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_pine6(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_pine1(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_birch1(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:oak_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:poplar_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_birch10(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:birch_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:aspen_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_birch3(NoFeatureConfig::deserialize,true, Blocks.BIRCH_LOG.getDefaultState(),tree_birch1.notDecayingLeaf(Blocks.BIRCH_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_birch4(NoFeatureConfig::deserialize,true, Blocks.BIRCH_LOG.getDefaultState(),tree_birch1.notDecayingLeaf(Blocks.BIRCH_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_taiga5(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:fir_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_taiga17(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:fir_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_oak15(NoFeatureConfig::deserialize,true, Blocks.OAK_LOG.getDefaultState(),tree_birch1.notDecayingLeaf(Blocks.OAK_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_oak24(NoFeatureConfig::deserialize,true, Blocks.OAK_LOG.getDefaultState(),tree_birch1.notDecayingLeaf(Blocks.OAK_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_oak28(NoFeatureConfig::deserialize,true, Blocks.OAK_LOG.getDefaultState(),tree_birch1.notDecayingLeaf(Blocks.OAK_LEAVES)),1);


        WNBiomeFeatures.addTree(this,new shrub1(NoFeatureConfig::deserialize,true),10);

        treeRate=18;

        applyPlants();
        applyTrees();


        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
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
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return customColor(noise,-0.1D,0x75B420,0x6DAE00);
    }


}