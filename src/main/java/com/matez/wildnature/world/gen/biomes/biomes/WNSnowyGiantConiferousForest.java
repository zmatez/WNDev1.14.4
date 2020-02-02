package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.world.gen.structures.nature.woods.fir.*;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.*;
import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.world.gen.biomes.biomes.surface.WNSurfaceBuilders;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.*;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.*;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNSnowyGiantConiferousForest extends WNBiome {
    public WNSnowyGiantConiferousForest(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(WNSurfaceBuilders.BROWN_PODZOL_GRAVEL, WNSurfaceBuilders.BROWN_CONFIG)
                .precipitation(RainType.SNOW)
                .category(Category.TAIGA)
                .topography(WNBiomeBuilder.Topography.HIGHLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_COOL)
                .depth(0.2F)
                .scale(0.3F)
                .temperature(-0.7F)
                .downfall(0.4F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .parent(null));



        this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        this.addStructure(Feature.VILLAGE, new VillageConfig("village/taiga/town_centers", 6));
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
        WNBiomeFeatures.addMushrooms(this);
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addFreezeTopLayer(this);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_white").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_pink").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:heather_purple").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        WNBiomeFeatures.addPlant(this,Main.getBlockByID("wildnature:bluebell").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);

        BlockState pineLog = Main.getBlockByID("minecraft:spruce_log").getDefaultState();
        BlockState pineLeaves = tree_taiga1.notDecayingLeaf(Main.getBlockByID("wildnature:pine_leaves"));
        BlockState firLog = Main.getBlockByID("minecraft:spruce_log").getDefaultState();
        BlockState firLeaves = tree_taiga1.notDecayingLeaf(Main.getBlockByID("wildnature:fir_leaves"));
        BlockState spruceLog = Main.getBlockByID("minecraft:spruce_log").getDefaultState();
        BlockState spruceLeaves = tree_taiga1.notDecayingLeaf(Main.getBlockByID("minecraft:spruce_leaves"));
        BlockState oakLog = Main.getBlockByID("minecraft:oak_log").getDefaultState();
        BlockState oakLeaves = tree_taiga1.notDecayingLeaf(Main.getBlockByID("minecraft:oak_leaves"));
        BlockState darkOakLog = Main.getBlockByID("minecraft:dark_oak_log").getDefaultState();
        BlockState darkOakLeaves = tree_taiga1.notDecayingLeaf(Main.getBlockByID("minecraft:dark_oak_leaves"));


        int x = 0;
        while(x<3){
            BlockState LOG = null;
            BlockState LEAVES = null;
            if(x==0){
                LOG = pineLog;
                LEAVES = pineLeaves;
            }else if(x==1){
                LOG = firLog;
                LEAVES = firLeaves;
            }else if(x==2){
                LOG = spruceLog;
                LEAVES = spruceLeaves;
            }
            WNBiomeFeatures.addTree(this,new tree_taiga2(NoFeatureConfig::deserialize,true,LOG,LEAVES),1);
            WNBiomeFeatures.addTree(this,new tree_taiga4(NoFeatureConfig::deserialize,true,LOG,LEAVES),1);
            WNBiomeFeatures.addTree(this,new tree_taiga5(NoFeatureConfig::deserialize,true,LOG,LEAVES),1);
            WNBiomeFeatures.addTree(this,new tree_taiga7(NoFeatureConfig::deserialize,true,LOG,LEAVES),1);
            WNBiomeFeatures.addTree(this,new tree_taiga10(NoFeatureConfig::deserialize,true,LOG,LEAVES),1);
            WNBiomeFeatures.addTree(this,new tree_taiga11(NoFeatureConfig::deserialize,true,LOG,LEAVES),1);
            WNBiomeFeatures.addTree(this,new tree_taiga12(NoFeatureConfig::deserialize,true,LOG,LEAVES),1);
            WNBiomeFeatures.addTree(this,new tree_taiga13(NoFeatureConfig::deserialize,true,LOG,LEAVES),1);
            WNBiomeFeatures.addTree(this,new tree_taiga14(NoFeatureConfig::deserialize,true,LOG,LEAVES),1);
            WNBiomeFeatures.addTree(this,new tree_taiga15(NoFeatureConfig::deserialize,true,LOG,LEAVES),1);
            WNBiomeFeatures.addTree(this,new tree_fir18(NoFeatureConfig::deserialize,true,LOG,LEAVES),1);
            WNBiomeFeatures.addTree(this,new tree_fir6(NoFeatureConfig::deserialize,true,LOG,LEAVES),1);
            WNBiomeFeatures.addTree(this,new tree_fir22(NoFeatureConfig::deserialize,true,LOG,LEAVES),1);

            WNBiomeFeatures.addTree(this,new tree_taiga25(NoFeatureConfig::deserialize,true,LOG,LEAVES),10);
            WNBiomeFeatures.addTree(this,new tree_taiga21(NoFeatureConfig::deserialize,true,LOG,LEAVES),7);
            WNBiomeFeatures.addTree(this,new tree_fir17(NoFeatureConfig::deserialize,true,LOG,LEAVES),10);
            WNBiomeFeatures.addTree(this,new tree_fir16(NoFeatureConfig::deserialize,true,LOG,LEAVES),7);
            WNBiomeFeatures.addTree(this,new tree_fir31(NoFeatureConfig::deserialize,true,LOG,LEAVES),7);
            WNBiomeFeatures.addTree(this,new tree_fir20(NoFeatureConfig::deserialize,true,LOG,LEAVES),7);
            WNBiomeFeatures.addTree(this,new tree_fir29(NoFeatureConfig::deserialize,true,LOG,LEAVES),5);
            x++;
        }

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

    @OnlyIn(Dist.CLIENT)
    public int getFoliageColor(BlockPos pos)
    {
        double noise = INFO_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return customColor(noise,-0.1D,0xC74400,0xB36D0E);
    }

}