package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.world.gen.structures.nature.woods.birch.tree_birch1;
import com.matez.wildnature.world.gen.structures.nature.woods.def.BigTree;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak22;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.tree_oak5;
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
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNOrchardPlum extends WNBiome {
    public WNOrchardPlum(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.1F)
                .scale(0.01F)
                .temperature(0.6F)
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

        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_yellow").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_white").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_pink").getDefaultState().with(FloweringBushBase.FLOWERING,true),3);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_purple").getDefaultState(),4);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:pasque_yellow").getDefaultState().with(FloweringBushBase.FLOWERING,true),3);


        //WNBiomeFeatures.addTree(this,new tree_oak5(NoFeatureConfig::deserialize,true,Crack.getBlockByID("wildnature:plum_log").getDefaultState(),tree_birch1.notDecayingLeaf(Crack.getBlockByID("wildnature:plum_leaves"))),2);
        //WNBiomeFeatures.addTree(this,new tree_oak22(NoFeatureConfig::deserialize,true,Crack.getBlockByID("wildnature:plum_log").getDefaultState(),tree_birch1.notDecayingLeaf(Crack.getBlockByID("wildnature:plum_leaves"))),2);
        //WNBiomeFeatures.addTree(this,new tree_oak4(NoFeatureConfig::deserialize,true,Crack.getBlockByID("minecraft:oak_log").getDefaultState(),tree_birch1.notDecayingLeaf(Crack.getBlockByID("minecraft:oak_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_oak22(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:plum_log").getDefaultState(), tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:plum_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_oak5(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:plum_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:plum_leaves"))),2);
        WNBiomeFeatures.addTree(this,new BigTree(NoFeatureConfig::deserialize,true,Main.getBlockByID("minecraft:oak_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("minecraft:oak_leaves"))),2);
        WNBiomeFeatures.addTree(this,new tree_oak5(NoFeatureConfig::deserialize,true,Main.getBlockByID("wildnature:plum_log").getDefaultState(),tree_birch1.notDecayingLeaf(Main.getBlockByID("wildnature:mirabelle_plum_leaves"))),2);
        treeRate=5;

        //applyPlants();
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


    @OnlyIn(Dist.CLIENT)
    public int getGrassColor(BlockPos pos)
    {
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return customColor(noise,-0.1D,9039360,11721984);
    }

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos)
    {
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return customColor(noise,-0.1D,9039360, 11721984);
    }

}