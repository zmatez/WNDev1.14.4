package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.world.gen.biomes.biomes.surface.PodzolSurfaceBuilder;
import com.matez.wildnature.world.gen.biomes.biomes.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.another_spruce.tree_spruce_big1;
import com.matez.wildnature.world.gen.structures.nature.woods.another_spruce.tree_spruce_big2;
import com.matez.wildnature.world.gen.structures.nature.woods.another_spruce.tree_spruce_big3;
import com.matez.wildnature.world.gen.structures.nature.woods.another_spruce.tree_spruce_big4;
import com.matez.wildnature.world.gen.structures.nature.woods.beech.*;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch1;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch10;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch8;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir6;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir7;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir9;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga11;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNForestedMountains extends WNBiome {
    public WNForestedMountains(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(new PodzolSurfaceBuilder(SurfaceBuilderConfig::deserialize), WNSurfaceBuilders.OVERGROWN_STONE_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.TAIGA)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(1F)
                .scale(1.2F)
                .temperature(0.4F)
                .downfall(0.3F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .parent(null));



        this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        this.addStructure(Feature.VILLAGE, new VillageConfig("village/taiga/town_centers", 3));
        this.addStructure(Feature.VILLAGE, new VillageConfig("village/plains/town_centers", 3));
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

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:heather_white").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_pink").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_purple").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:bluebell").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:perennial_blue").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:perennial_pink").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:perennial_violet").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:iris_purple").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:iris_violet").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:iris_pink").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:pasque_white").getDefaultState().with(FloweringBushBase.FLOWERING,true),3);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:pasque_yellow").getDefaultState().with(FloweringBushBase.FLOWERING,true),3);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:pasque_purple").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:pasque_pink").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);

        WNBiomeFeatures.addTree(this,new tree_spruce_big1(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),3);
        WNBiomeFeatures.addTree(this,new tree_spruce_big2(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),3);
        WNBiomeFeatures.addTree(this,new tree_spruce_big3(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),3);
        WNBiomeFeatures.addTree(this,new tree_spruce_big4(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"))),3);
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

        WNBiomeFeatures.addTree(this,new tree_birch10(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:oak_log").getDefaultState(), tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:poplar_leaves"))),6);
        WNBiomeFeatures.addTree(this,new tree_birch1(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:oak_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:poplar_leaves"))),4);

        WNBiomeFeatures.addTree(this,new tree_fir6(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:fir_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_fir7(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:fir_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_fir9(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:fir_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_taiga11(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:fir_leaves"))),1);

        WNBiomeFeatures.addTree(this,new tree_birch8(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:birch_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("minecraft:birch_leaves"))),1);

        WNBiomeFeatures.addTaigaLargeFerns(this);
        WNBiomeFeatures.addTaigaRocks(this);
        WNBiomeFeatures.addBerryBushes(this);

        plantRate=1;
        treeRate=15;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 5, 4, 4));
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
        return customColor(noise,-0.1D,0x81C46A,0x95CF65);
    }



}