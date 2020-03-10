package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.world.gen.biomes.biomes.surface.PodzolSurfaceBuilder;
import com.matez.wildnature.world.gen.biomes.biomes.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch1;
import com.matez.wildnature.world.gen.structures.nature.woods.def.BigTree;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir31;
import com.matez.wildnature.world.gen.structures.nature.woods.minecraft.WNPointyTaigaTreeFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.minecraft.WNTallTaigaTreeFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak10;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak11;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak8;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak9;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MegaPineTree;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static net.minecraft.world.gen.surfacebuilders.SurfaceBuilder.GIANT_TREE_TAIGA;
import static net.minecraft.world.gen.surfacebuilders.SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG;

public class WNSeasonalTaiga extends WNBiome {
    public WNSeasonalTaiga(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(GIANT_TREE_TAIGA, GRASS_DIRT_GRAVEL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.TAIGA)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.2F)
                .scale(0.2F)
                .temperature(0.35F)
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
        WNBiomeFeatures.addMushrooms(this);
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.func_222303_T(this);
        WNBiomeFeatures.addTaigaLargeFerns(this);
        WNBiomeFeatures.addTaigaRocks(this);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_yellow").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_white").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:leaf_pile").getDefaultState(),3);



        addTree("wildnature:maple");
        addTree("wildnature:maple_red");
        addTree("wildnature:maple_brown");
        addTree("wildnature:maple_yellow");
        addTree("wildnature:maple_orange");
        addTree("minecraft:spruce");
        WNBiomeFeatures.addTree(this,new MegaPineTree(NoFeatureConfig::deserialize, false, false),6);
        WNBiomeFeatures.addTree(this,new MegaPineTree(NoFeatureConfig::deserialize, false, true),6);
        WNBiomeFeatures.addTree(this,new tree_fir31(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:spruce_log").getDefaultState(), tree_birch1.notDecayingLeaf(Main.getBlockByID("minecraft:spruce_leaves"))),1);


        treeRate=100;
        plantRate=1;

        applyPlants();
        applyTrees();


        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 2, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.FOX, 3, 4, 4));        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));

    }
    
    private void addTree(String idLeaf){
        WNBiomeFeatures.addTree(this,new WNPointyTaigaTreeFeature(NoFeatureConfig::deserialize, Blocks.SPRUCE_LOG.getDefaultState(), tree_birch1.notDecayingLeaf(Main.getBlockByID(idLeaf+"_leaves")),true),10);
        WNBiomeFeatures.addTree(this,new WNTallTaigaTreeFeature(NoFeatureConfig::deserialize,Blocks.SPRUCE_LOG.getDefaultState(), tree_birch1.notDecayingLeaf(Main.getBlockByID(idLeaf+"_leaves")),true),10);

    }



}