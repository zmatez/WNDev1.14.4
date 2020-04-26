package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.biomes.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.feature.WNBlobConfig;
import com.matez.wildnature.world.gen.feature.WNBlobFeature;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.baobab.*;
import com.matez.wildnature.world.gen.structures.nature.woods.citrus.citrus1;
import com.matez.wildnature.world.gen.structures.nature.woods.citrus.citrus2;
import com.matez.wildnature.world.gen.structures.nature.woods.ebony.*;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle1;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle2;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle3;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle4;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class WNMadagascarValley extends WNBiome {
    public WNMadagascarValley(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.DEFAULT, WNSurfaceBuilders.TROPICAL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.JUNGLE)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(0.2F)
                .scale(0.1F)
                .temperature(0.95F)
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
        WNBiomeFeatures.addGrass(this,25);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addJunglePlants(this);
        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(new WNBlobFeature(WNBlobConfig::deserialize), new WNBlobConfig(Blocks.PODZOL.getDefaultState(),2,true,false), Placement.FOREST_ROCK, new FrequencyConfig(5)));

        WNBiomeFeatures.addPlant(this, Main.getBlockByID("minecraft:blue_orchid").getDefaultState(),2);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:orchis_white").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:peace_lily").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DOUBLE_PLANT,new DoublePlantConfig(Main.getBlockByID("wildnature:bird_of_paradise").getDefaultState()), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(3)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DOUBLE_PLANT,new DoublePlantConfig(Main.getBlockByID("wildnature:bird_of_paradise").getDefaultState()), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(2)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DOUBLE_PLANT,new DoublePlantConfig(Main.getBlockByID("wildnature:bird_of_paradise").getDefaultState()), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(1)));



        WNBiomeFeatures.addTree(this,new citrus1(NoFeatureConfig::deserialize,true, WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.LIME_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new citrus2(NoFeatureConfig::deserialize,true, WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.LIME_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new citrus1(NoFeatureConfig::deserialize,true, WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PEACH_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new citrus2(NoFeatureConfig::deserialize,true, WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PEACH_LEAVES)),1);

        plantRate=1;
        treeRate=1;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 20, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.OCELOT, 2, 1, 1));

    }


    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0x7EF8F3;
    }
}