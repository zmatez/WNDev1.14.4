package com.matez.wildnature.world.gen.biomes.biomes;

import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.world.gen.biomes.setup.WNBiome;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeBuilder;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomeFeatures;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.shrubs.shrub1;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import com.matez.wildnature.world.gen.surface.builders.CustomSurfaceBuilder;
import com.matez.wildnature.world.gen.surface.configs.CustomSurfaceBuilderConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WNBirchGrove extends WNBiome {
    public WNBirchGrove(String name) {
        super(name, (new WNBiomeBuilder())
                .surfaceBuilder(SurfaceRegistry.CUSTOM_SURFACE_BUILDER, new CustomSurfaceBuilderConfig(new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG, 3), new CustomSurfaceBuilder.BlockCfg(SurfaceBuilder.PODZOL_DIRT_GRAVEL_CONFIG, 1)))
                .precipitation(RainType.RAIN)
                .category(Category.FOREST)
                .topography(WNBiomeBuilder.Topography.LOWLANDS)
                .climate(WNBiomeBuilder.Climate.CONTINENTAL_WARM)
                .depth(0.08F)
                .scale(0.15F)
                .temperature(0.6F)
                .downfall(0.8F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .parent(null));


        WNBiomeFeatures.addMineshafts(this, MineshaftStructure.Type.NORMAL);
        WNBiomeFeatures.addStrongholds(this);
        WNBiomeFeatures.addCarvers(this);
        WNBiomeFeatures.addStructures(this);
        WNBiomeFeatures.addLakes(this);
        WNBiomeFeatures.addMonsterRooms(this);
        WNBiomeFeatures.addDoubleFlowers(this);
        WNBiomeFeatures.addStoneVariants(this);
        WNBiomeFeatures.addOres(this);
        WNBiomeFeatures.addSedimentDisks(this);
        WNBiomeFeatures.addGrass(this);

        WNBiomeFeatures.addReedsAndPumpkins(this);
        WNBiomeFeatures.addSprings(this);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_YELLOW.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.HEATHER_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 2);
        WNBiomeFeatures.addPlant(this, WNBlocks.YEW_BUSH.getDefaultState(), 4);
        WNBiomeFeatures.addPlant(this, WNBlocks.PASQUE_WHITE.getDefaultState().with(FloweringBushBase.FLOWERING, true), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.CLOVER.getDefaultState(), 3);
        WNBiomeFeatures.addPlant(this, WNBlocks.LEAF_PILE.getDefaultState(), 3);
        WNBiomeFeatures.addTree(this, new tree_birch1().setCustomLog(Blocks.BIRCH_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Blocks.BIRCH_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_birch3().setCustomLog(Blocks.BIRCH_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Blocks.BIRCH_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_birch4().setCustomLog(Blocks.BIRCH_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Blocks.BIRCH_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_birch5().setCustomLog(Blocks.BIRCH_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Blocks.BIRCH_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_birch6().setCustomLog(Blocks.BIRCH_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Blocks.BIRCH_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_birch8().setCustomLog(Blocks.BIRCH_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Blocks.BIRCH_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_birch10().setCustomLog(Blocks.BIRCH_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Blocks.BIRCH_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_birch11().setCustomLog(Blocks.BIRCH_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Blocks.BIRCH_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new tree_birch12().setCustomLog(Blocks.BIRCH_LOG.getDefaultState()).setCustomLeaf(tree_birch1.notDecayingLeaf(Blocks.BIRCH_LEAVES)), 2);
        WNBiomeFeatures.addTree(this, new shrub1(), 10);

        treeRate = 18;

        applyPlants();
        applyTrees();


        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
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
    public int getGrassColor(BlockPos pos) {
        double noise = INFO_NOISE.getValue((double) pos.getX() * 0.0225D, (double) pos.getZ() * 0.0225D);
        return customColor(noise, -0.1D, 0x2E8545, 0x307D31);
    }


}