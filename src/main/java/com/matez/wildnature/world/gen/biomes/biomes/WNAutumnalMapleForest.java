package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.world.gen.biomes.biomes.surface.PodzolSurfaceBuilder;
import com.matez.wildnature.world.gen.biomes.biomes.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch1;
import com.matez.wildnature.world.gen.structures.nature.woods.def.BigTree;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak10;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak11;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak8;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak9;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNAutumnalMapleForest extends WNBiome {
    public WNAutumnalMapleForest(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(new PodzolSurfaceBuilder(SurfaceBuilderConfig::deserialize), WNSurfaceBuilders.BROWN_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.15F)
                .scale(0.05F)
                .temperature(0.5F)
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
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_yellow").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_white").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:yew_bush").getDefaultState(),4);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:leaf_pile").getDefaultState(),3);


        addTree("wildnature:maple","wildnature:maple");
        addTree("wildnature:maple","wildnature:maple_red");
        addTree("wildnature:maple","wildnature:maple_brown");
        addTree("wildnature:maple","wildnature:maple_yellow");
        addTree("wildnature:maple","wildnature:maple_orange");
        WNBiomeFeatures.addTree(this,new shrub1(NoFeatureConfig::deserialize,true),15);

        treeRate=8;

        applyPlants();
        applyTrees();


        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
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
    
    private void addTree(String idLog,String idLeaf){
        WNBiomeFeatures.addTree(this,new tree_oak8(NoFeatureConfig::deserialize,true,Main.getBlockByID(idLog+"_log").getDefaultState(), tree_birch1.notDecayingLeaf(Main.getBlockByID(idLeaf+"_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_oak9(NoFeatureConfig::deserialize,true,Main.getBlockByID(idLog+"_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID(idLeaf+"_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_oak10(NoFeatureConfig::deserialize,true,Main.getBlockByID(idLog+"_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID(idLeaf+"_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_oak11(NoFeatureConfig::deserialize,true,Main.getBlockByID(idLog+"_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID(idLeaf+"_leaves"))),2);
        WNBiomeFeatures.addTree(this,new BigTree(NoFeatureConfig::deserialize,true,Main.getBlockByID(idLog+"_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID(idLeaf+"_leaves"))),16);

    }

    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(BlockPos pos)
    {
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return customColor(noise,-0.1D,0xB5B952, 0xB98959);
    }


}