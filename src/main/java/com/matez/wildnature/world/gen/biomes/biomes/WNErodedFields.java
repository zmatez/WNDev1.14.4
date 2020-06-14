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
import com.matez.wildnature.world.gen.structures.nature.rocks.*;
import com.matez.wildnature.world.gen.structures.nature.woods.def.BigTree;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.*;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga13;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga17;
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
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNErodedFields extends WNBiome {
    public WNErodedFields(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.DEFAULT, WNSurfaceBuilders.BROWN_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.45F)
                .scale(0.1F)
                .temperature(0.3F)
                .downfall(0.3F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .parent(null));



        this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        this.addStructure(Feature.VILLAGE, new VillageConfig("village/plains/town_centers", 6));

        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addLakes(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addDoubleFlowers(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addDefaultFlowers(this);
        WNBiomeFeatures.addGrass(this,18);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.removeAllDefaultFlowers(this);

        WNBiomeFeatures.addPlant(this, WNBlocks.SHRUB.getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,WNBlocks.SHRUB_TALL.getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,WNBlocks.THUJA.getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,WNBlocks.THUJA_LIMEGREEN.getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:grass_flower").getDefaultState().with(FloweringBushBase.FLOWERING,true),5);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:wild_wheat").getDefaultState().with(FloweringBushBase.FLOWERING,true),5);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:grass_wheat").getDefaultState().with(FloweringBushBase.FLOWERING,true),5);
        WNBiomeFeatures.addPlant(this,WNBlocks.MARIGOLD_ORANGE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.MARIGOLD_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.DAFFODIL.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.CARNATION_PINK.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);

        //big
        WNBiomeFeatures.addTree(this,new tree_taiga17(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_fir7(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_fir8(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_fir9(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_fir24(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),2);
        WNBiomeFeatures.addTree(this,new tree_fir25(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),2);

        //skewed
        WNBiomeFeatures.addTree(this,new tree_fir26(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),1);
        WNBiomeFeatures.addTree(this,new tree_fir27(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),1);

        //small
        WNBiomeFeatures.addTree(this,new tree_taiga13(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),3);
        WNBiomeFeatures.addTree(this,new tree_fir2(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),3);
        WNBiomeFeatures.addTree(this,new tree_fir3(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),3);
        WNBiomeFeatures.addTree(this,new tree_fir4(NoFeatureConfig::deserialize,true, Blocks.SPRUCE_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),3);

        int count = 1;
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new big_rock_1(NoFeatureConfig::deserialize,true), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(count,64,0,130)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new big_rock_2(NoFeatureConfig::deserialize,true), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(count,64,0,130)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new big_rock_3(NoFeatureConfig::deserialize,true), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(count,64,0,130)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new big_rock_4(NoFeatureConfig::deserialize,true), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(count,64,0,130)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new big_rock_5(NoFeatureConfig::deserialize,true), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(count,64,0,130)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new big_rock_6(NoFeatureConfig::deserialize,true), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(count,64,0,130)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new big_rock_7(NoFeatureConfig::deserialize,true), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(count,64,0,130)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new big_rock_8(NoFeatureConfig::deserialize,true), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(count,64,0,130)));


        plantRate=1;
        treeRate=0;
        treeExtra=1;
        treeExtraChance=0.7f;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 7, 2, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 5, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 2, 2, 4));
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
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.005D, (double)pos.getZ() * 0.005D);
        return customColor(noise,-0.05D,0xD9C661,0xF2CF7A);
    }


}