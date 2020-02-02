package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.world.gen.biomes.biomes.surface.PodzolSurfaceBuilder;
import com.matez.wildnature.world.gen.biomes.biomes.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.another_spruce.*;
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

public class WNSnowyTucholaValley extends WNBiome {
    public WNSnowyTucholaValley(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(new PodzolSurfaceBuilder(SurfaceBuilderConfig::deserialize), WNSurfaceBuilders.BROWN_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.TAIGA)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(0.2F)
                .scale(0.1F)
                .temperature(-0.5F)
                .downfall(0.3F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .parent(null));



        this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        this.addStructure(Feature.VILLAGE, new VillageConfig("village/spruce/town_centers", 6));
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
        WNBiomeFeatures.addMushrooms(this);
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addFreezeTopLayer(this);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:heather_white").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_pink").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_purple").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:bluebell").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:perennial_blue").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:perennial_pink").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:perennial_violet").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:yew_bush").getDefaultState(),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:grass_fernsprout").getDefaultState(),2);


        WNBiomeFeatures.addTree(this,new tree_spruce_m1(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_spruce_m2(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_spruce_m3(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_spruce_m4(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_spruce_m5(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_spruce_m6(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_spruce_m7(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_spruce_m8(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_spruce_m9(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:larch_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("wildnature:larch_leaves"))),2);



        WNBiomeFeatures.addTaigaLargeFerns(this);
        WNBiomeFeatures.addTaigaRocks(this);
        WNBiomeFeatures.addBerryBushes(this);

        plantRate=1;
        treeRate=4;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
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

    @Override
    public int getGrassColor(BlockPos pos) {
        return 0x559D4F;
    }
}