package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.biomes.surface.NormalPodzolSurfaceBuilder;
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
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle1;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle2;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle3;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle4;
import com.matez.wildnature.world.gen.structures.nature.woods.palm.*;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNMadagascar extends WNBiome {
    public WNMadagascar(String name) {
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
        this.addStructure(Feature.JUNGLE_TEMPLE, IFeatureConfig.NO_FEATURE_CONFIG);

        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addLakes(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addDoubleFlowers(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addDefaultFlowers(this);
        WNBiomeFeatures.addGrass(this,20);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addBambooJungleVegetation(this);
        WNBiomeFeatures.addJunglePlants(this);
        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(new WNBlobFeature(WNBlobConfig::deserialize), new WNBlobConfig(Blocks.PODZOL.getDefaultState(),2,true,false), Placement.FOREST_ROCK, new FrequencyConfig(5)));

        WNBiomeFeatures.addPlant(this, Main.getBlockByID("minecraft:blue_orchid").getDefaultState(),2);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:anthurium_white").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:anthurium_red").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:anthurium_pink").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:orchis_white").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:peace_lily").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DOUBLE_PLANT,new DoublePlantConfig(Main.getBlockByID("wildnature:bird_of_paradise").getDefaultState()), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(3)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DOUBLE_PLANT,new DoublePlantConfig(Main.getBlockByID("wildnature:bird_of_paradise").getDefaultState()), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(2)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DOUBLE_PLANT,new DoublePlantConfig(Main.getBlockByID("wildnature:bird_of_paradise").getDefaultState()), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(1)));



        WNBiomeFeatures.addTree(this,new jungle1(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new jungle2(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new jungle3(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new jungle4(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new JungleTreeFeature(NoFeatureConfig::deserialize, false, 4, Blocks.JUNGLE_LOG.getDefaultState(), Blocks.JUNGLE_LEAVES.getDefaultState(), true),8);
        WNBiomeFeatures.addTree(this,new shrub1(NoFeatureConfig::deserialize, false, Blocks.JUNGLE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(Blocks.JUNGLE_LEAVES)),15);
        WNBiomeFeatures.addTree(this,new baobab1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new baobab2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new baobab3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new baobab4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new baobab5(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new ebony1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new ebony2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new ebony3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new ebony4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new ebony_shrub1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new ebony_shrub2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new banana1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new banana2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new banana3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new banana4(NoFeatureConfig::deserialize,true),1);

        WNBiomeFeatures.addTree(this,new citrus1(NoFeatureConfig::deserialize,true, WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MANGO_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new citrus2(NoFeatureConfig::deserialize,true, WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MANGO_LEAVES)),1);

        plantRate=2;
        treeRate=10;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PARROT, 40, 1, 2));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PANDA, 5, 1, 4));
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