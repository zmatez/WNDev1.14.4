package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.world.gen.biomes.biomes.surface.NoiseSurfaceBuilder;
import com.matez.wildnature.world.gen.biomes.biomes.surface.SnowedSurfaceBuilder;
import com.matez.wildnature.world.gen.biomes.biomes.surface.XMASSurfaceBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.feature.CandyCaneFeature;
import com.matez.wildnature.world.gen.feature.WNScatteredPlantFeature;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir18;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir19;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir20;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.tree_fir21;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.*;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.ArrayList;

public class WNChristmasIsland extends WNBiome {
    public WNChristmasIsland(String name) {
        super(name,(new WNBiomeBuilder())
                .surfaceBuilder(new XMASSurfaceBuilder(SurfaceBuilderConfig::deserialize), SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG)
                .precipitation(RainType.SNOW)
                .category(Category.ICY)
                .topography(WNBiomeBuilder.Topography.HIGH_MOUNTAINS)
                .climate(WNBiomeBuilder.Climate.POLAR)
                .depth(0.2F)
                .scale(0.1F)
                .temperature(-0.25F)
                .downfall(0.9F)
                .waterColor(ConfigSettings.coldWaterColor)
                .waterFogColor(ConfigSettings.coldWaterFogColor)
                .parent(null));

        this.addStructure(Feature.IGLOO, IFeatureConfig.NO_FEATURE_CONFIG);
        this.addStructure(Feature.IGLOO, IFeatureConfig.NO_FEATURE_CONFIG);
        this.addStructure(Feature.VILLAGE, new VillageConfig("village/snowy/town_centers", 6));
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
        WNBiomeFeatures.addGrass(this,3);
        WNBiomeFeatures.addMushrooms(this);
        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addFreezeTopLayer(this);
        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(new CandyCaneFeature(NoFeatureConfig :: deserialize),new NoFeatureConfig(), Placement.FOREST_ROCK, new FrequencyConfig(2)));

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new WNScatteredPlantFeature(NoFeatureConfig::deserialize, Blocks.JACK_O_LANTERN.getDefaultState()), IFeatureConfig.NO_FEATURE_CONFIG, Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(1)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new WNScatteredPlantFeature(NoFeatureConfig::deserialize, Blocks.JACK_O_LANTERN.getDefaultState()), IFeatureConfig.NO_FEATURE_CONFIG, Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(1)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new WNScatteredPlantFeature(NoFeatureConfig::deserialize, Blocks.JACK_O_LANTERN.getDefaultState()), IFeatureConfig.NO_FEATURE_CONFIG, Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(1)));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new WNScatteredPlantFeature(NoFeatureConfig::deserialize, Blocks.JACK_O_LANTERN.getDefaultState()), IFeatureConfig.NO_FEATURE_CONFIG, Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(1)));

        BlockState spruceLog = Main.getBlockByID("minecraft:spruce_log").getDefaultState();
        BlockState spruceLeaves = tree_taiga1.notDecayingLeaf(Main.getBlockByID("minecraft:spruce_leaves"));


        WNBiomeFeatures.addTree(this,new tree_fir18(NoFeatureConfig::deserialize,true,spruceLog,spruceLeaves),1);
        WNBiomeFeatures.addTree(this,new tree_fir20(NoFeatureConfig::deserialize,true,spruceLog,spruceLeaves),1);
        WNBiomeFeatures.addTree(this,new tree_fir21(NoFeatureConfig::deserialize,true,spruceLog,spruceLeaves),1);
        WNBiomeFeatures.addTree(this,new tree_taiga15(NoFeatureConfig::deserialize,true,spruceLog,spruceLeaves),4);
        WNBiomeFeatures.addTree(this,new tree_taiga14(NoFeatureConfig::deserialize,true,spruceLog,spruceLeaves),4);
        WNBiomeFeatures.addTree(this,new tree_taiga13(NoFeatureConfig::deserialize,true,spruceLog,spruceLeaves),4);
        WNBiomeFeatures.addTree(this,new tree_taiga12(NoFeatureConfig::deserialize,true,spruceLog,spruceLeaves),4);
        WNBiomeFeatures.addTree(this,new tree_taiga11(NoFeatureConfig::deserialize,true,spruceLog,spruceLeaves),4);


        applyTrees();

        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SNOW_GOLEM, 20, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
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




}