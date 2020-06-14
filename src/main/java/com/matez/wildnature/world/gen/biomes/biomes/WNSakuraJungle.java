package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.BelladonnaBlock;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.biomes.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch1;
import com.matez.wildnature.world.gen.structures.nature.woods.cherry.*;
import com.matez.wildnature.world.gen.structures.nature.woods.citrus.citrus1;
import com.matez.wildnature.world.gen.structures.nature.woods.citrus.citrus2;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle1;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle2;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle3;
import com.matez.wildnature.world.gen.structures.nature.woods.jungle.jungle4;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak2;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak5;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNSakuraJungle extends WNBiome {
    public WNSakuraJungle(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.DEFAULT, WNSurfaceBuilders.TROPICAL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.2F)
                .scale(0.1F)
                .temperature(0.777F)
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
        WNBiomeFeatures.addGrass(this,16);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addPlant(this, WNBlocks.TAMARISK.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);

        WNBiomeFeatures.addPlant(this, WNBlocks.GERANIUM_RED.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this, WNBlocks.GERANIUM_PINK.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this, WNBlocks.CHERRY_FLOWER.getDefaultState(),2);
        WNBiomeFeatures.addPlant(this, WNBlocks.SCOTCHBROOM_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this, WNBlocks.CHRYSANTHEMUM_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this, WNBlocks.CHRYSANTHEMUM_LIGHT_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this, WNBlocks.GERANIUM_RED.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this, WNBlocks.CHINESE_LANTERN_FLOWER.getDefaultState().with(BelladonnaBlock.STAGE,3),1);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("minecraft:blue_orchid").getDefaultState(),2);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:anthurium_red").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:anthurium_pink").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:orchis_purple").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this, Main.getBlockByID("wildnature:peace_lily").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DOUBLE_PLANT,new DoublePlantConfig(Main.getBlockByID("wildnature:bird_of_paradise").getDefaultState().with(FloweringBushBase.FLOWERING,true)), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(2)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DOUBLE_PLANT,new DoublePlantConfig(Main.getBlockByID("wildnature:bird_of_paradise").getDefaultState().with(FloweringBushBase.FLOWERING,true)), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(1)));

        WNBiomeFeatures.addTree(this,new jungle1(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new jungle2(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new jungle3(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new jungle4(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new JungleTreeFeature(NoFeatureConfig::deserialize, false, 4, Blocks.JUNGLE_LOG.getDefaultState(), Blocks.JUNGLE_LEAVES.getDefaultState(), true),8);
        WNBiomeFeatures.addTree(this,new shrub1(NoFeatureConfig::deserialize, false, Blocks.JUNGLE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(Blocks.JUNGLE_LEAVES)),15);
        WNBiomeFeatures.addTree(this,new citrus1(NoFeatureConfig::deserialize,true, WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.POMEGRANATE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new citrus2(NoFeatureConfig::deserialize,true, WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.POMEGRANATE_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new sakura1(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new sakura2(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new sakura3(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new sakura4(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new sakura5(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new sakura6(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new sakura7(NoFeatureConfig::deserialize,true),3);
        plantRate=2;
        treeRate=10;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PARROT, 40, 1, 2));
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


    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(BlockPos pos)
    {
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0125D, (double)pos.getZ() * 0.0125D);
        return customColor(noise,-0.1D,0x3CB45A,0x74C41F);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos)
    {
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0125D, (double)pos.getZ() * 0.0125D);
        return customColor(noise,-0.1D,0x71CB00, 0x75CB35);
    }

}