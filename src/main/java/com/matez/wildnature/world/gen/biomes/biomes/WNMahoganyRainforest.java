package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.CoffeeBush;
import com.matez.wildnature.world.gen.biomes.biomes.surface.NormalPodzolSurfaceBuilder;
import com.matez.wildnature.world.gen.biomes.biomes.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.mahogany.*;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.gen.structures.nature.woods.mahogany.*;
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
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNMahoganyRainforest extends WNBiome {
    public WNMahoganyRainforest(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(new NormalPodzolSurfaceBuilder(SurfaceBuilderConfig::deserialize), WNSurfaceBuilders.TROPICAL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.TAIGA)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(0.2F)
                .scale(0.1F)
                .temperature(0.7F)
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
        WNBiomeFeatures.addDefaultFlowers(this);
        WNBiomeFeatures.addGrass(this,20);
        WNBiomeFeatures.addMushrooms(this);
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this, Main.getBlockByID("minecraft:blue_orchid").getDefaultState(),10);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:coffee_sapling").getDefaultState(),1);
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DOUBLE_PLANT,new DoublePlantConfig(Main.getBlockByID("wildnature:coffee_bush").getDefaultState().with(CoffeeBush.STAGE,0)), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(3)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DOUBLE_PLANT,new DoublePlantConfig(Main.getBlockByID("wildnature:coffee_bush").getDefaultState().with(CoffeeBush.STAGE,1)), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(2)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DOUBLE_PLANT,new DoublePlantConfig(Main.getBlockByID("wildnature:coffee_bush").getDefaultState().with(CoffeeBush.STAGE,2)), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(1)));

        WNBiomeFeatures.addTree(this,new mahogany1(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:mahogany_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))),2);
        WNBiomeFeatures.addTree(this,new mahogany2(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:mahogany_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))),2);
        WNBiomeFeatures.addTree(this,new mahogany3(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:mahogany_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))),2);
        WNBiomeFeatures.addTree(this,new mahogany4(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:mahogany_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))),1);
        WNBiomeFeatures.addTree(this,new mahoganyshrub1(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:mahogany_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))),2);
        WNBiomeFeatures.addTree(this,new mahoganyshrub2(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:mahogany_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))),2);
        WNBiomeFeatures.addTree(this,new shrub1(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:mahogany_log").getDefaultState(), SchemFeature.notDecayingLeaf(Main.getBlockByID("minecraft:mahogany_leaves"))),3);
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BAMBOO, new ProbabilityConfig(0.0F), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(16)));


        plantRate=2;
        treeRate=15;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PARROT, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 10, 4, 4));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 20, 8, 8));
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
        return customColor(noise,-0.1D,0x89D036, 0x81D417);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos)
    {
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return customColor(noise,-0.1D,0x72D624, 0x92DD29);
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature) {
        return 0xB1EB7D;
    }
}