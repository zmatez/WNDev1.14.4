package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.biomes.surface.CustomSurfaceBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.feature.WNBlobConfig;
import com.matez.wildnature.world.gen.feature.WNBlobFeature;
import com.matez.wildnature.world.gen.feature.WNTreeVinesFeature;
import com.matez.wildnature.world.gen.feature.WNWisteriaFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.cedar.*;
import com.matez.wildnature.world.gen.structures.nature.woods.cherry.*;
import com.matez.wildnature.world.gen.structures.nature.woods.cypress.cypress1;
import com.matez.wildnature.world.gen.structures.nature.woods.cypress.cypress2;
import com.matez.wildnature.world.gen.structures.nature.woods.cypress.cypress3;
import com.matez.wildnature.world.gen.structures.nature.woods.cypress.cypress4;
import com.matez.wildnature.world.gen.structures.nature.woods.deco.*;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.*;
import com.matez.wildnature.world.gen.structures.nature.woods.oaklands.*;
import com.matez.wildnature.world.gen.structures.nature.woods.orchard.*;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan1;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan2;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan3;
import com.matez.wildnature.world.gen.structures.nature.woods.rowan.rowan4;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.gen.structures.nature.woods.small_redwood.*;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.tree_taiga1;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BushConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNVibrantForest extends WNBiome {
    public WNVibrantForest(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(new CustomSurfaceBuilder(new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG,4),new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.PODZOL_DIRT_GRAVEL_CONFIG,1)), SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.15F)
                .scale(0.03F)
                .temperature(0.45F)
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
        WNBiomeFeatures.addGrass(this,18);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);

        WNBiomeFeatures.addPlant(this,WNBlocks.SCOTCHBROOM_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING,true),3);
        WNBiomeFeatures.addPlant(this,WNBlocks.SCOTCHBROOM_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.MATTHIOLA_PINK.getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,WNBlocks.CHRYSANTHEMUM_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.CHRYSANTHEMUM_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.HYACINTH_DARK_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.HYACINTH_RED.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.HYACINTH_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.HYACINTH_PINK.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.CATNIP.getDefaultState().with(FloweringBushBase.FLOWERING,true),3);
        WNBiomeFeatures.addPlant(this,WNBlocks.YUCCA.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.CLEMATIS_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.CLEMATIS_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.HYDRANGEA_PINK.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.HYDRANGEA_BLUE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.HYDRANGEA_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.TAMARISK.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.RHODODENDRON_PINK.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,WNBlocks.RHODODENDRON_PURPLE.getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:yew_bush").getDefaultState(),4);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:clover").getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:leaf_pile").getDefaultState(),3);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:grass_wheat").getDefaultState().with(FloweringBushBase.FLOWERING,true),4);

        WNBiomeFeatures.addTree(this,new small_redwood1(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new small_redwood2(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new small_redwood3(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new small_redwood4(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new small_redwood5(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new small_redwood6(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new weeping_cedar_1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new weeping_cedar_2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new weeping_cedar_3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new weeping_cedar_4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new weeping_cedar_5(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new weeping_cedar_6(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new spiky_birch_1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new spiky_birch_2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new spiky_birch_3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new spiky_birch_4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_birch1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_birch2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_birch3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_birch4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_oak_1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_oak_2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_oak_3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pointy_oak_4(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new cypress1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new cypress2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new cypress3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new cypress4(NoFeatureConfig::deserialize,true),1);

        WNBiomeFeatures.addTree(this,new pear1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pear2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new pear3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new apple1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new apple2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new apple3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new tree_oak5(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:plum_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:plum_leaves"))),1);
        WNBiomeFeatures.addTree(this,new tree_oak5(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:plum_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:mirabelle_plum_leaves"))),2);
        WNBiomeFeatures.addTree(this,new rowan1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new rowan2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new rowan3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new rowan4(NoFeatureConfig::deserialize,true),1);


        WNBiomeFeatures.addTree(this,new oaklands_smallshrub1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oaklands_smallshrub2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oaklands_smallshrub3(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oaklands_shrub1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oaklands_shrub2(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new oaklands_shrub5(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new shrub1(NoFeatureConfig::deserialize,true),1);

        WNBiomeFeatures.addTree(this,new magnolia1(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new magnolia2(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new magnolia3(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new magnolia4(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new magnolia5(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new forsythia1(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new forsythia2(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new forsythia3(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new forsythia4(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new forsythia5(NoFeatureConfig::deserialize,true),5);

        WNBiomeFeatures.addTree(this,new cherry1(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:cherry_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:cherry_leaves"))),1);
        WNBiomeFeatures.addTree(this,new cherry2(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:cherry_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:cherry_leaves"))),1);
        WNBiomeFeatures.addTree(this,new cherry3(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:cherry_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:cherry_leaves"))),1);
        WNBiomeFeatures.addTree(this,new cherry4(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:cherry_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:cherry_leaves"))),1);

        WNBiomeFeatures.addTree(this,new wild_cherry1(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new wild_cherry2(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new wild_cherry3(NoFeatureConfig::deserialize,true),2);
        WNBiomeFeatures.addTree(this,new wild_cherry4(NoFeatureConfig::deserialize,true),2);


        //WNBiomeFeatures.addTree(this,new high_oak_1(NoFeatureConfig::deserialize,true),5);
        //WNBiomeFeatures.addTree(this,new high_oak_2(NoFeatureConfig::deserialize,true),5);
        //WNBiomeFeatures.addTree(this,new high_oak_3(NoFeatureConfig::deserialize,true),5);
        //WNBiomeFeatures.addTree(this,new high_oak_4(NoFeatureConfig::deserialize,true),5);
        WNBiomeFeatures.addTree(this,new branchy_oak_1(NoFeatureConfig::deserialize,true),1);
        WNBiomeFeatures.addTree(this,new branchy_oak_2(NoFeatureConfig::deserialize,true),1);

        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(new WNBlobFeature(WNBlobConfig::deserialize), new WNBlobConfig(Blocks.PODZOL.getDefaultState(),2,true,false), Placement.FOREST_ROCK, new FrequencyConfig(3)));
        this.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Biome.createDecoratedFeature(new WNTreeVinesFeature(BushConfig::deserialize), new BushConfig(WNBlocks.ROSEVINE_YELLOW.getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(2, 65, 0, 80)));
        this.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Biome.createDecoratedFeature(new WNTreeVinesFeature(BushConfig::deserialize), new BushConfig(WNBlocks.ROSEVINE_PINK.getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(2, 65, 0, 80)));
        this.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Biome.createDecoratedFeature(new WNTreeVinesFeature(BushConfig::deserialize), new BushConfig(WNBlocks.ROSEVINE_RED.getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(1, 65, 0, 80)));
        this.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Biome.createDecoratedFeature(new WNWisteriaFeature(BushConfig::deserialize), new BushConfig(WNBlocks.WISTERIA_PINK.getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(3, 65, 0, 80)));

        plantRate=2;
        treeRate=10;

        applyPlants();
        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 10, 1, 1));

    }

    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(BlockPos pos)
    {
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return customColor(noise,-0.1D,0x88D64E,0x9CCB5F);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos)
    {
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return customColor(noise,-0.1D,0x7EC948,0xA7D549);
    }



}