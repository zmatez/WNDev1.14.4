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
import com.matez.wildnature.world.gen.structures.nature.woods.baobab.*;
import com.matez.wildnature.world.gen.structures.nature.woods.citrus.*;
import com.matez.wildnature.world.gen.structures.nature.woods.ebony.*;
import com.matez.wildnature.world.gen.structures.nature.woods.eucalyptus.*;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle1;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle2;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle3;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle4;
import com.matez.wildnature.world.gen.structures.nature.woods.mahogany.*;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.oak1;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.oak2;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.oak3;
import com.matez.wildnature.world.gen.structures.nature.woods.palm.*;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.JungleTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNDaintreeForest extends WNBiome {
    public WNDaintreeForest(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(new CustomSurfaceBuilder(new CustomSurfaceBuilder.BlockCfg(WNSurfaceBuilders.OVERGROWN_STONE_CONFIG,10),new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.PODZOL_DIRT_GRAVEL_CONFIG,1)), WNSurfaceBuilders.OVERGROWN_STONE_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.JUNGLE)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.2F)
                .scale(0.15F)
                .temperature(0.95F)
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
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:cana_bulb_orange").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:cana_bulb_red").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:cana_bulb_pink").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:cana_bulb_yellow").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);

        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:leaf_pile").getDefaultState(),3);

        WNBiomeFeatures.addPlant(this, Main.getBlockByID("minecraft:blue_orchid").getDefaultState(),2);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:anthurium_red").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:anthurium_pink").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:orchis_purple").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);

        WNBiomeFeatures.addTree(this,new oak1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oak2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oak3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new jungle1(NoFeatureConfig::deserialize,true),10);
        WNBiomeFeatures.addTree(this,new jungle2(NoFeatureConfig::deserialize,true),10);
        WNBiomeFeatures.addTree(this,new jungle3(NoFeatureConfig::deserialize,true),10);
        WNBiomeFeatures.addTree(this,new jungle4(NoFeatureConfig::deserialize,true),10);
        WNBiomeFeatures.addTree(this,new JungleTreeFeature(NoFeatureConfig::deserialize, false, 4, Blocks.JUNGLE_LOG.getDefaultState(), Blocks.JUNGLE_LEAVES.getDefaultState(), true),15);
        WNBiomeFeatures.addTree(this,new shrub1(NoFeatureConfig::deserialize, false, Blocks.JUNGLE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(Blocks.JUNGLE_LEAVES)),20);
        WNBiomeFeatures.addTree(this,new ebony_shrub1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new ebony_shrub2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new tree_palm1(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm2(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm3(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm4(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm5(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm6(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm7(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm8(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm9(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm10(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm11(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm12(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm13(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm14(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm15(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm16(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_palm17(NoFeatureConfig::deserialize,true, Main.getBlockByID("wildnature:palm_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:palm_leaves"))),1);
        WNBiomeFeatures.addTree(this,new mahogany1(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:mahogany_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))),1);
        WNBiomeFeatures.addTree(this,new mahogany2(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:mahogany_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))),1);
        WNBiomeFeatures.addTree(this,new mahogany3(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:mahogany_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))),1);
        WNBiomeFeatures.addTree(this,new mahogany4(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:mahogany_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))),1);
        WNBiomeFeatures.addTree(this,new mahoganyshrub1(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:mahogany_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))),1);
        WNBiomeFeatures.addTree(this,new mahoganyshrub2(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:mahogany_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))),1);
        WNBiomeFeatures.addTree(this,new eucalyptus_1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new eucalyptus_2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new eucalyptus_3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new eucalyptus_4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new eucalyptus_5(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new eucalyptus_6(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new eucalyptus_7(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new eucalyptus_8(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new eucalyptus_9(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new eucalyptus_10(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new citrus1(NoFeatureConfig::deserialize,true, WNBlocks.CITRUS_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.POMEGRANATE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new citrus2(NoFeatureConfig::deserialize,true, WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.POMEGRANATE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new citrus3(NoFeatureConfig::deserialize,true, WNBlocks.CITRUS_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.ORANGE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new citrus4(NoFeatureConfig::deserialize,true, WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.ORANGE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new citrus1(NoFeatureConfig::deserialize,true, WNBlocks.CITRUS_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.PEACH_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new citrus4(NoFeatureConfig::deserialize,true, WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PEACH_LEAVES)),1);

        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(new WNBlobFeature(WNBlobConfig::deserialize), new WNBlobConfig(Blocks.PODZOL.getDefaultState(),2,true,false), Placement.FOREST_ROCK, new FrequencyConfig(8)));


        treeRate=12;

        applyPlants();
        applyTrees();


        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PARROT, 40, 1, 2));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PANDA, 3, 1, 2));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 45, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.HUSK, 35, 1, 3));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));

    }
}