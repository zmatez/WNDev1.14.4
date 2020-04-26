package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.world.gen.biomes.biomes.surface.PodzolSurfaceBuilder;
import com.matez.wildnature.world.gen.biomes.biomes.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch1;
import com.matez.wildnature.world.gen.structures.nature.woods.def.BigTree;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak10;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak11;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak8;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak9;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class WNMapleForest extends WNBiome {
    public WNMapleForest(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(new PodzolSurfaceBuilder(SurfaceBuilderConfig::deserialize), WNSurfaceBuilders.BROWN_CONFIG)
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
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_yellow").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_white").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:yew_bush").getDefaultState(),4);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:leaf_pile").getDefaultState(),3);

        WNBiomeFeatures.addTree(this,new tree_oak8(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:maple_log").getDefaultState(), tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:maple_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_oak9(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:maple_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:maple_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_oak10(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:maple_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:maple_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_oak11(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:maple_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:maple_leaves"))),2);
        WNBiomeFeatures.addTree(this,new shrub1(NoFeatureConfig::deserialize,true),30);
        WNBiomeFeatures.addTree(this,new BigTree(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:maple_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:maple_leaves"))),18);

        treeRate=9;

        applyPlants();
        applyTrees();


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




}