package com.matez.wildnature.world.gen.biomes.setup;

import com.google.common.collect.Lists;
import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.FloweringBushBase;
import com.matez.wildnature.blocks.RockBase;
import com.matez.wildnature.blocks.SaltOreBlock;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.BlockWeighList;
import com.matez.wildnature.other.TreeWeighList;
import com.matez.wildnature.other.WeightedList;
import com.matez.wildnature.world.gen.carvers.CarverRegistry;
import com.matez.wildnature.world.gen.carvers.WNCaveCarver;
import com.matez.wildnature.world.gen.feature.FeatureRegistry;
import com.matez.wildnature.world.gen.feature.configs.*;
import com.matez.wildnature.world.gen.feature.features.*;
import com.matez.wildnature.world.gen.feature.features.WNScatteredPlantFeature;
import com.matez.wildnature.world.gen.feature.features.TreeFeature;
import com.matez.wildnature.world.gen.feature.features.WaterlilyFeature;
import com.matez.wildnature.world.gen.structures.dungeons.easter.*;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.rocks.*;
import com.matez.wildnature.world.gen.structures.nature.woods.fallen.*;
import com.matez.wildnature.world.gen.structures.nature.woods.glowing_cave_oak.GlowingCaveOakSpawner;
import com.matez.wildnature.world.gen.structures.nature.woods.glowshroom.GlowshroomSpawner;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.world.biome.BeachBiome;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.common.BiomeDictionary;

import java.util.ArrayList;
import java.util.Arrays;

public class WNBiomeFeatures extends DefaultBiomeFeatures {

    public static ArrayList<Biome> defaultPlantBlacklist = new ArrayList<>();

    public static void removeAllDefaultFlowers(Biome biomeIn){
        defaultPlantBlacklist.add(biomeIn);
    }

    public static void addBerryBushes(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.SCATTERED_PLANT_FEATURE, new BushConfig(Blocks.SWEET_BERRY_BUSH.getDefaultState().with(SweetBerryBushBlock.AGE, 3)), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(1)));
    }

	public static void addGrass(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.GRASS, new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(9)));
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.GRASS, new GrassFeatureConfig(Main.getBlockByID("wildnature:medium_grass").getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(3)));
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.GRASS, new GrassFeatureConfig(Main.getBlockByID("wildnature:small_grass").getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(2)));
    }

    public static void addLotsOfGrass(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.GRASS, new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(14)));
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.GRASS, new GrassFeatureConfig(Main.getBlockByID("wildnature:medium_grass").getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(6)));
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.GRASS, new GrassFeatureConfig(Main.getBlockByID("wildnature:small_grass").getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(5)));
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.DOUBLE_GRASS_FEATURE, new DoublePlantConfig(Blocks.TALL_GRASS.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(5)));

    }

    public static void addBlob(Biome biomeIn, BlockState block, int startRadius, boolean surfaceBlob, boolean undergroundBlob, int frequency){
        biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(FeatureRegistry.BLOB_FEATURE, new WNBlobConfig(block,startRadius,surfaceBlob,undergroundBlob), Placement.FOREST_ROCK, new FrequencyConfig(frequency)));
    }

    public static void addBlobWithCountRangePlacement(Biome biomeIn, BlockState block, int startRadius, boolean surfaceBlob, boolean undergroundBlob, int count, int bottom, int top){
        biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(FeatureRegistry.BLOB_FEATURE, new WNBlobConfig(block,startRadius,surfaceBlob,undergroundBlob), Placement.COUNT_RANGE, new CountRangeConfig(count,bottom,0,top)));
    }

    public static void addTatraStoneTypes(Biome biomeIn){
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GRAVEL.getDefaultState(), 33), Placement.COUNT_RANGE, new CountRangeConfig(3, 0, 0, 256)));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GRANITE.getDefaultState(), 33), Placement.COUNT_RANGE, new CountRangeConfig(16, 0, 0, 80)));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIORITE.getDefaultState(), 33), Placement.COUNT_RANGE, new CountRangeConfig(5, 0, 0, 80)));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.ANDESITE.getDefaultState(), 33), Placement.COUNT_RANGE, new CountRangeConfig(5, 0, 0, 80)));

    }

    public static void addLavender(Biome biomeIn){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.LAVENDER_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(77)));
    }

    public static void addGeysers(Biome biomeIn, int count){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.GEYSER_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(count,64,0,90)));
    }

    public static void addMarigold(Biome biomeIn){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.MARIGOLD_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(90)));
    }

    public static void addMelons(Biome biomeIn, int count){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.MELON, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(count)));
    }

    public static void addWisterias(Biome biomeIn, int count){
        biomeIn.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Biome.createDecoratedFeature(FeatureRegistry.WISTERIA_FEATURE, new BushConfig(WNBlocks.WISTERIA_PINK.getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(count, 65, 0, 80)));
    }

    public static void addTreeVines(Biome biomeIn, BlockState vine, int count, int maxHeight){
        biomeIn.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Biome.createDecoratedFeature(FeatureRegistry.TREE_VINES_FEATURE, new BushConfig(vine), Placement.COUNT_RANGE, new CountRangeConfig(count, 65, 0, maxHeight)));
    }

    public static void addBlob(Biome biomeIn, BlockState block, int startRadius, boolean surfaceBlob, boolean undergroundBlob, boolean flatInTerrain, int frequency){
        biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(FeatureRegistry.BLOB_FEATURE, new WNBlobConfig(block,startRadius,surfaceBlob,undergroundBlob,flatInTerrain), Placement.FOREST_ROCK, new FrequencyConfig(frequency)));
    }

    public static void addCattail(Biome biomeIn, int frequency){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CATTAIL_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(frequency)));
    }

    public static void addCactus(Biome biomeIn, int frequency){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.CACTUS, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(frequency)));
    }
    public static void addDeadBushes(Biome biomeIn, int frequency){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DEAD_BUSH, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(frequency)));
    }

    public static void addMoai(Biome biomeIn){
        WeightedList<SchemFeature> moais = new WeightedList<>();
        moais.add(new estatue1(),1);
        moais.add(new estatue2(),1);
        moais.add(new estatue3(),1);
        moais.add(new estatue4(),1);
        moais.add(new estatue5(),1);
        moais.add(new estatue6(),1);
        moais.add(new estatue7(),1);

        biomeIn.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(FeatureRegistry.STRUCTURE_FEATURE,new StructureWeightListConfig(moais), Placement.COUNT_RANGE, new CountRangeConfig(7,70,0,80)));
    }

    public static void addBigRocks(Biome biomeIn){
        WeightedList<SchemFeature> rocks = new WeightedList<>();
        rocks.add(new big_rock_1(),1);
        rocks.add(new big_rock_2(),1);
        rocks.add(new big_rock_3(),1);
        rocks.add(new big_rock_4(),1);
        rocks.add(new big_rock_5(),1);
        rocks.add(new big_rock_6(),1);
        rocks.add(new big_rock_7(),1);
        rocks.add(new big_rock_8(),1);

        biomeIn.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(FeatureRegistry.STRUCTURE_FEATURE,new StructureWeightListConfig(rocks), Placement.COUNT_RANGE, new CountRangeConfig(8,64,0,130)));
    }

    public static void addRocks(Biome biomeIn){
        WeightedList<SchemFeature> rocks = new WeightedList<>();
        rocks.add(new rock1(),1);
        rocks.add(new rock2(),1);
        rocks.add(new rock3(),1);
        rocks.add(new rock4(),1);
        rocks.add(new rock5(),1);
        rocks.add(new rock6(),1);
        rocks.add(new rock7(),1);
        rocks.add(new rock8(),1);

        biomeIn.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(FeatureRegistry.STRUCTURE_FEATURE,new StructureWeightListConfig(rocks), Placement.COUNT_RANGE, new CountRangeConfig(80,64,0,90)));
    }

    public static void addSunflowers(Biome biomeIn){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DOUBLE_PLANT, new DoublePlantConfig(Blocks.SUNFLOWER.getDefaultState()), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(10)));
    }

    public static void addHugeMushrooms(Biome biomeIn, int frequency){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_BOOLEAN_SELECTOR, new TwoFeatureChoiceConfig(Feature.HUGE_RED_MUSHROOM, new BigMushroomFeatureConfig(false), Feature.HUGE_BROWN_MUSHROOM, new BigMushroomFeatureConfig(false)), Placement.COUNT_HEIGHTMAP, new FrequencyConfig(frequency)));
    }

    public static void addSinglePlantFeature(Biome biomeIn, BlockWeighList list, int frequency){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.SINGLE_PLANT_FEATURE, new BlockWeightListAndSpawnChanceConfig(list,0), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(frequency)));
    }

    public static void addFreezeLeaf(Biome biomeIn, int count){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.LEAF_FREEZE_FEATURE,new CountConfig(count), Placement.COUNT_BIASED_RANGE, new CountRangeConfig(50, 60, 0, 150)));
    }

    public static void addCandyCane(Biome biomeIn, int frequency){
        biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(FeatureRegistry.CANDY_CANE_FEATURE,new NoFeatureConfig(), Placement.FOREST_ROCK, new FrequencyConfig(frequency)));
    }

    public static void addScatteredPlant(Biome biomeIn, BlockState state, int chance){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.SCATTERED_PLANT_FEATURE, new BushConfig(state), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(chance)));
    }

    public static void addSeagrass(Biome biomeIn, int count){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.SEAGRASS, new SeaGrassConfig(count, 0.4D), Placement.TOP_SOLID_HEIGHTMAP, IPlacementConfig.NO_PLACEMENT_CONFIG));
    }

    public static void addSeagrass(Biome biomeIn, int count, double tallProbability){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.SEAGRASS, new SeaGrassConfig(count, tallProbability), Placement.TOP_SOLID_HEIGHTMAP, IPlacementConfig.NO_PLACEMENT_CONFIG));
    }

    public static void addMushrooms(Biome biomeIn) {
	    if(BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.FOREST)) {
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(Blocks.BROWN_MUSHROOM.getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(2)));
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(Blocks.RED_MUSHROOM.getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(4)));

            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(Main.getBlockByID("wildnature:mushroom1").getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(2)));
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(Main.getBlockByID("wildnature:mushroom2").getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(2)));
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(Main.getBlockByID("wildnature:mushroom4").getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(4)));
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(Main.getBlockByID("wildnature:mushroom5").getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(4)));
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(Main.getBlockByID("wildnature:mushroom6").getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(2)));
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(Main.getBlockByID("wildnature:mushroom7").getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(2)));
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(Main.getBlockByID("wildnature:mushroom8").getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(2)));
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(Main.getBlockByID("wildnature:mushroom9").getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(2)));
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(Main.getBlockByID("wildnature:psilocybin_mushroom").getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(1)));

        }
        if(BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.PLAINS)) {
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(Main.getBlockByID("wildnature:mushroom3").getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(2)));

        }
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(Main.getBlockByID("wildnature:fuzzball").getDefaultState()), Placement.CHANCE_HEIGHTMAP_DOUBLE, new ChanceConfig(1)));

    }

    public static ArrayList<Biome> lakeBiomes = new ArrayList<>();
    public static void addLakes(Biome biomeIn) {
	    lakeBiomes.add(biomeIn);
    }

    public static ArrayList<Biome> springBiomes = new ArrayList<>();
    public static void addSprings(Biome p_222337_0_) {
	    springBiomes.add(p_222337_0_);
    }



    public static void addGrass(Biome biomeIn, int rate) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.GRASS, new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(rate)));
    }

    public static void addGrass(Biome biomeIn, int rate, BlockState grass) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.GRASS, new GrassFeatureConfig(grass), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(rate)));
    }

    public static void addGrass(Biome biomeIn, int rate, BlockState grass,boolean isDouble) {
        if (isDouble) {
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.DOUBLE_GRASS_FEATURE, new DoublePlantConfig(grass), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(rate)));
        }else{
            addGrass(biomeIn,rate,grass);
        }
    }

    public static void addPlant(Biome biomeIn, BlockState state, int frequency){
        if(biomeIn instanceof WNBiome){
            ((WNBiome) biomeIn).plants.add(state,frequency);
        }
    }

    public static void addDoublePlant(Biome biomeIn, BlockState state, int frequency){
        if(biomeIn instanceof WNBiome){
            ((WNBiome) biomeIn).plants.add(state,frequency);
        }
    }

    public static void addFloodedForestDecorations(Biome biomeIn){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.SEAGRASS, new SeaGrassConfig(128, 0.6D), Placement.TOP_SOLID_HEIGHTMAP, IPlacementConfig.NO_PLACEMENT_CONFIG));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.DISK, new SphereReplaceConfig(Blocks.CLAY.getDefaultState(), 4, 1, Lists.newArrayList(Main.getBlockByID("wildnature:mold_dirt").getDefaultState())), Placement.COUNT_TOP_SOLID, new FrequencyConfig(1)));
    }

    public static void addWaterlilies(Biome biome, Block waterlily, int count) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.WATERLILY_FEATURE, new BushConfig(waterlily.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(count)));
    }

    public static void addWaterlilies(Biome biome, BlockState waterlily, int count){
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.WATERLILY_FEATURE, new BushConfig(waterlily), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(count)));
    }

    public static void addTree(Biome biomeIn, AbstractTreeFeature tree, int frequency){
        if(biomeIn instanceof WNBiome){
            ((WNBiome) biomeIn).trees.add(tree,frequency);
        }
    }

    public static void addNewStoneVariants(Biome biomeIn) {
        int seaLevel = 40;
        int worldHeight = 255;
        ArrayList<Block> rocks = new ArrayList<>(Arrays.asList(Main.RegistryEvents.rockRegistry.rocks));
        for(int i = 0; i < rocks.size(); i++){
            Block b = Main.getBlockByID(rocks.get(i).getRegistryName().toString());
            RockBase r = null;
            if(b instanceof RockBase){
                r = (RockBase)b;
            }else{
                continue;
            }

            if(CommonConfig.generateRocks.get()){
                boolean gen = true;
                if(!CommonConfig.genBasalt.get() && r.getRegistryName().getPath().equals("basalt")){
                    gen = false;
                }
                if(!CommonConfig.genConglomerate.get() && r.getRegistryName().getPath().equals("conglomerate")){
                    gen = false;
                }
                if(!CommonConfig.genGneiss.get() && r.getRegistryName().getPath().equals("gneiss")){
                    gen = false;
                }
                if(!CommonConfig.genLimestone.get() && r.getRegistryName().getPath().equals("limestone")){
                    gen = false;
                }
                if(!CommonConfig.genMarble.get() && r.getRegistryName().getPath().equals("marble")){
                    gen = false;
                }
                if(!CommonConfig.genPegmatite.get() && r.getRegistryName().getPath().equals("pegmatite")){
                    gen = false;
                }
                if(!CommonConfig.genSlate.get() && r.getRegistryName().getPath().equals("slate")){
                    gen = false;
                }
                if(gen) {
                    biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, b.getDefaultState(), r.getSize()), Placement.COUNT_RANGE, new CountRangeConfig(r.getCount(), r.getMinYByType(seaLevel), 0, r.getMaxYByType(seaLevel, worldHeight))));
                }
            }
        }

        if(biomeIn.getTempCategory()== Biome.TempCategory.COLD) {
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.PACKED_ICE.getDefaultState(), CommonConfig.rockSize.get() * 2), Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.rockChance.get(), 25, 0, seaLevel-(seaLevel/4))));
        }

        rocks=null;
    }



    public static void addCarvers(Biome biomeIn) {
        biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(CarverRegistry.CAVE_CARVER, new ProbabilityConfig(0.14285715F)));
    }

    public static void addCaveVines(Biome biomeIn) {
        if (biomeIn.getTempCategory() == Biome.TempCategory.WARM && BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.JUNGLE)) {
            if (biomeIn != WNBiomes.Polders) {
                biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_VINE_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(3, 10, 0, 35)));
                biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.VINES_FEATURE, new BushConfig(Blocks.VINE.getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(3, 10, 0, 35)));
            }
        }else if(biomeIn.getTempCategory() == Biome.TempCategory.WARM){
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_VINE_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(4, 10, 0, 35)));
        }else if(biomeIn.getTempCategory() == Biome.TempCategory.MEDIUM){
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_VINE_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(1, 10, 0, 35)));
        }
    }

    public static void addCrystals(Biome biomeIn) {
        if(biomeIn!= com.matez.wildnature.world.gen.biomes.setup.WNBiomes.Polders)
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CRYSTAL_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(10, 10, 0, 35)));
    }

    public static void addCobweb(Biome biomeIn) {
        if(biomeIn!= com.matez.wildnature.world.gen.biomes.setup.WNBiomes.Polders)
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.COBWEB_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(30, 10, 0, 35)));
    }

    public static void addStalagmites(Biome biomeIn) {
        if(biomeIn!= com.matez.wildnature.world.gen.biomes.setup.WNBiomes.Polders)
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.STALAGMITE_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(100, 10, 0, 50)));
    }

    public static void addPebbles(Biome biomeIn) {
        if(biomeIn!= com.matez.wildnature.world.gen.biomes.setup.WNBiomes.Polders)
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.PEBBLE_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(70, 10, 0, 50)));
    }

    public static void addNewOres(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, WNBlocks.TIN_ORE.getDefaultState(), 7), Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.tinRarity.get(), 40, 0, 64)));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, WNBlocks.COPPER_ORE.getDefaultState(), 6), Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.copperRarity.get(), 0, 0, 30)));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, WNBlocks.SALT_ORE.getDefaultState().with(SaltOreBlock.SALT_VARIANT,SaltOreBlock.SaltVariant.STONE), 5), Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.saltStoneRarity.get(), 20, 0, 55)));

        if(biomeIn.getTempCategory()== Biome.TempCategory.COLD){
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, WNBlocks.AMETHYST_ORE.getDefaultState(), 3), Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.amethystRarity.get(), 10, 0, 28)));
        }
        if(biomeIn.getTempCategory()== Biome.TempCategory.MEDIUM){
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, WNBlocks.SAPPHIRE_ORE.getDefaultState(), 3), Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.sapphireRarity.get(), 10, 0, 28)));
        }
        if(biomeIn.getTempCategory()== Biome.TempCategory.WARM){
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, WNBlocks.MALACHITE_ORE.getDefaultState(), 3), Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.malachiteRarity.get(), 10, 0, 28)));
        }
        if(biomeIn instanceof BeachBiome){
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(FeatureRegistry.ORE_FEATURE, new WNOreFeatureConfig(WNOreFeatureConfig.FillerBlockType.SAND, WNBlocks.AMBER_ORE.getDefaultState(), 3), Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.amberRarity.get(), 50, 0, 65)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(FeatureRegistry.ORE_FEATURE, new WNOreFeatureConfig(WNOreFeatureConfig.FillerBlockType.SAND, WNBlocks.SALT_ORE.getDefaultState().with(SaltOreBlock.SALT_VARIANT,SaltOreBlock.SaltVariant.SAND), 7), Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.saltSandRarity.get(), 50, 0, 65)));

        }
        if(biomeIn.getTempCategory()== Biome.TempCategory.OCEAN){
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, WNBlocks.RUBY_ORE.getDefaultState(), 4), Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.rubyRarity.get(), 0, 0, 15)));

        }


        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, WNBlocks.SILVER_ORE.getDefaultState(), 6), Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.silverRarity.get(), 20, 0, 36)));

    }

    public static void addRockFormations(Biome biomeIn){
        biomeIn.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(new basalt_rock(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(1,64,0,80)));
        biomeIn.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(new conglomerate_rock(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(1,64,0,80)));
        biomeIn.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(new gneiss_rock(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(1,64,0,80)));
        biomeIn.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(new slate_rock(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(1,64,0,80)));
    }

    public static void addRiverCane(Biome biomeIn) {
        if (biomeIn.isHighHumidity() || BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.RIVER) || biomeIn==WNBiomes.River || biomeIn==WNBiomes.AmazonRiver || biomeIn==WNBiomes.NileRiver || biomeIn==WNBiomes.TropicalLake || biomeIn==WNBiomes.WarmLake || biomeIn==WNBiomes.MangroveForest ) {
            biomeIn.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(FeatureRegistry.RIVER_CANE_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.riverCaneRarity.get(), 55, 0, 65)));
        }
    }

    public static void addRiverPlants(Biome biomeIn) {
        if (BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.RIVER) || biomeIn==WNBiomes.River || biomeIn==WNBiomes.AmazonRiver || biomeIn==WNBiomes.NileRiver || biomeIn==WNBiomes.TropicalLake || biomeIn==WNBiomes.WarmLake || biomeIn==WNBiomes.ColdLake ) {
            biomeIn.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(FeatureRegistry.REEDS_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.riverCaneRarity.get(), 55, 0, 65)));
        }
    }

    public static void addFruits(Biome biomeIn){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.FRUIT_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.fruitBushRarity.get(),64,0,100)));

    }

    public static void addVeggies(Biome biomeIn){
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.VEGE_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.vegeCropRarity.get(),64,0,100)));

    }

    public static void addPoisonIves(Biome biomeIn){
        BlockWeighList l = new BlockWeighList();

        if(BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.FOREST)){
            l.add(Main.getBlockByID("wildnature:poison_ivy").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
            l.add(Main.getBlockByID("wildnature:spidergrass").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        }
        if(biomeIn.getTempCategory()== Biome.TempCategory.WARM || biomeIn.getTempCategory()== Biome.TempCategory.MEDIUM){
            l.add(Main.getBlockByID("wildnature:grass_thistle").getDefaultState().with(FloweringBushBase.FLOWERING,true),1);
        }
        if(biomeIn.getTempCategory()!= Biome.TempCategory.COLD){
            l.add(Main.getBlockByID("wildnature:nettle").getDefaultState().with(FloweringBushBase.FLOWERING,true),2);
        }
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.SINGLE_PLANT_FEATURE, new BlockWeightListAndSpawnChanceConfig(l,5), Placement.COUNT_HEIGHTMAP, new FrequencyConfig(CommonConfig.poisonIvyRarity.get())));
    }

    public static void addSmallCacti(Biome biomeIn){
        if(BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.SANDY) && biomeIn.getTempCategory()== Biome.TempCategory.WARM && biomeIn!= Biomes.BEACH && biomeIn!=WNBiomes.TintedDesert && biomeIn!=WNBiomes.TintedDesertHills || biomeIn==WNBiomes.WhiteBeach || biomeIn==WNBiomes.Oasis){
            BlockWeighList l = new BlockWeighList();
            l.add(Main.getBlockByID("wildnature:small_cacti").getDefaultState(),1);
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.SINGLE_PLANT_FEATURE, new BlockWeightListAndSpawnChanceConfig(l,0), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(CommonConfig.smallCactiRarity.get())));
        }
    }



    public static void addCavePlants(Biome biomeIn){
        if(biomeIn.getTempCategory()== Biome.TempCategory.COLD){
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:icycle").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(10, 35, 0, 50)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:large_icycle").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(10, 40, 0, 50)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:ice_grass").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(35, 30, 0, 45)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:ice_shroom").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(5, 30, 0, 45)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:glowshroom").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(3, 10, 0, 45)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.SLIME_CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:hanging_glowing_slimeshroom_blue").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(3, 5, 0, 20)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.SLIME_CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:hanging_glowing_slimeshroom_green").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(1, 5, 0, 20)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.SLIME_CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:glowing_slimeshroom_blue").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(4, 5, 0, 20)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.SLIME_CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:glowing_slimeshroom_green").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(1, 5, 0, 20)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:sunshroom").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(1, 10, 0, 20)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.LAVALILY_FEATURE, new BushConfig(WNBlocks.MAGMA_PAD.getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(5, 2, 0, 20)));

            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_STAR_FEATURE, new BushConfig(Main.getBlockByID("wildnature:cave_star").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(9, 15, 0, 23)));

        }else{
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:glowshroom").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(11, 10, 0, 50)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.DOUBLE_CAVE_BUSH_FEATURE, new ReverseBushConfig(Main.getBlockByID("wildnature:large_glowshroom").getDefaultState(),false), Placement.COUNT_RANGE, new CountRangeConfig(8, 10, 0, 50)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.SLIME_CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:hanging_glowing_slimeshroom_blue").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(3, 5, 0, 20)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.SLIME_CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:hanging_glowing_slimeshroom_green").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(3, 5, 0, 20)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.SLIME_CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:glowing_slimeshroom_blue").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(3, 5, 0, 20)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.SLIME_CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:glowing_slimeshroom_green").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(3, 5, 0, 20)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:sunshroom").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(2, 10, 0, 20)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.LAVALILY_FEATURE, new BushConfig(WNBlocks.MAGMA_PAD.getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(9, 2, 0, 20)));



        }
        if(biomeIn.getTempCategory()== Biome.TempCategory.WARM){
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:poison_shroom").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(2, 10, 0, 50)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:sulfur_shroom").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(2, 20, 0, 50)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:dragon_shroom").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(1, 10, 0, 15)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:gravityshroom").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(1, 5, 0, 20)));

            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_STAR_FEATURE, new BushConfig(Main.getBlockByID("wildnature:cave_star").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(4, 15, 0, 23)));

        }
        if(biomeIn.getTempCategory()== Biome.TempCategory.OCEAN){
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:sulfur_shroom").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(4, 20, 0, 50)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:dragon_shroom").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(1, 10, 0, 15)));
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.JELLYSHROOM_FEATURE, new BushConfig(Main.getBlockByID("wildnature:jellyshroom").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(3, 2, 0, 15)));

        }



        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:stone_grass").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(40, 10, 0, 50)));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:stalagmite").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(6, 10, 0, 50)));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:stalactite").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(6, 10, 0, 50)));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.DOUBLE_CAVE_BUSH_FEATURE, new ReverseBushConfig(Main.getBlockByID("wildnature:large_stalagmite").getDefaultState(),false), Placement.COUNT_RANGE, new CountRangeConfig(6, 10, 0, 50)));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.DOUBLE_CAVE_BUSH_FEATURE, new ReverseBushConfig(Main.getBlockByID("wildnature:large_stalactite").getDefaultState(),true), Placement.COUNT_RANGE, new CountRangeConfig(6, 10, 0, 50)));

        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:roots").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(10, 55, 0, 52)));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.DOUBLE_CAVE_BUSH_FEATURE, new ReverseBushConfig(Main.getBlockByID("wildnature:large_root").getDefaultState(),true), Placement.COUNT_RANGE, new CountRangeConfig(10, 55, 0, 52)));

        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:magma_shroom").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(4, 5, 0, 16)));

        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:glowing_shadowshroom").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(1, 3, 0, 10)));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:cave_lily").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(1, 5, 0, 20)));

        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.UNDERWATER_CAVE_BUSH_FEATURE, new BushConfig(Main.getBlockByID("wildnature:tubeshroom").getDefaultState()), Placement.COUNT_RANGE, new CountRangeConfig(1, 2, 0, 12)));


    }


    public static void addGlowingCaveOaks(Biome biomeIn) {
        //TODO Glowing cave oak registry
        if (biomeIn.getTempCategory() == Biome.TempCategory.COLD) {
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(new GlowingCaveOakSpawner(NoFeatureConfig::deserialize,false,true), new NoFeatureConfig(), Placement.COUNT_RANGE, new CountRangeConfig(2, 5, 0, 35)));
        }else if (biomeIn.getTempCategory() == Biome.TempCategory.WARM && biomeIn.getCategory()!= Biome.Category.DESERT && biomeIn.getCategory()!= Biome.Category.MESA) {
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(new GlowingCaveOakSpawner(NoFeatureConfig::deserialize,false,false), new NoFeatureConfig(), Placement.COUNT_RANGE, new CountRangeConfig(2, 5, 0, 35)));
        }else if (biomeIn.getTempCategory() == Biome.TempCategory.OCEAN) {
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(new GlowingCaveOakSpawner(NoFeatureConfig::deserialize,false,false), new NoFeatureConfig(), Placement.COUNT_RANGE, new CountRangeConfig(2, 5, 0, 35)));
        }
    }

    public static void addGlowshrooms(Biome biomeIn) {
        //TODO Glowshroom registry
        if (biomeIn.getTempCategory() == Biome.TempCategory.WARM && biomeIn.getCategory()!= Biome.Category.DESERT && biomeIn.getCategory()!= Biome.Category.MESA) {
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(new GlowshroomSpawner(NoFeatureConfig::deserialize,false), new NoFeatureConfig(), Placement.COUNT_RANGE, new CountRangeConfig(7, 5, 0, 45)));
        }else if (biomeIn.getTempCategory() == Biome.TempCategory.OCEAN) {
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(new GlowshroomSpawner(NoFeatureConfig::deserialize,false), new NoFeatureConfig(), Placement.COUNT_RANGE, new CountRangeConfig(10, 5, 0, 35)));
        }
    }

    public static void addWater(Biome biomeIn){
        biomeIn.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Biome.createDecoratedFeature(FeatureRegistry.WATER_FEATURE,new CountConfig(24), Placement.COUNT_BIASED_RANGE, new CountRangeConfig(50, 60, 0, 150)));
    }

    public static void addWater(Biome biomeIn, int count){
        biomeIn.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Biome.createDecoratedFeature(FeatureRegistry.WATER_FEATURE,new CountConfig(count), Placement.COUNT_BIASED_RANGE, new CountRangeConfig(50, 60, 0, 150)));
    }

    public static void addShells(Biome biomeIn){
	    if(biomeIn==Biomes.BEACH || biomeIn==WNBiomes.WhiteBeach) {
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.SHELL_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.shellRarity.get(), 50, 0, 69)));
        }
    }

    public static void addMoss(Biome biomeIn){
	    if(BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.DENSE)){
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.MOSS_FEATURE, new CountConfig(32), Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.mossRarityDense.get(),64,0,180)));
        }else if(BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.FOREST)) {
            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.MOSS_FEATURE, new CountConfig(12), Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.mossRarity.get(), 64, 0, 180)));

        }
        if(biomeIn.getTempCategory()== Biome.TempCategory.WARM) {
            biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.MOSS_FEATURE, new CountConfig(64), Placement.COUNT_RANGE, new CountRangeConfig(CommonConfig.mossRarityDense.get(), 10, 0, 40)));
        }
    }

    public static void addFallenTrees(Biome biomeIn) {
        if (BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.FOREST)) {
            Main.LOGGER.info("Adding fallen trees for " + biomeIn.getRegistryName());
            boolean isDense = BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.DENSE);
            boolean isConiferous = BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.CONIFEROUS);
            Biome.Category category = biomeIn.getCategory();
            TreeWeighList trees = new TreeWeighList();
            if (biomeIn == WNBiomes.Madagascar || biomeIn == WNBiomes.DaintreeForest) {
                trees.add(new fallen_ebony1(), 1);
                trees.add(new fallen_ebony2(), 1);
                trees.add(new fallen_ebony3(), 1);
            } else if (biomeIn == WNBiomes.WeepingBirchForest || biomeIn == WNBiomes.BirchGrove || biomeIn == WNBiomes.BirchMarsh || biomeIn == WNBiomes.BirchScrubs || biomeIn == WNBiomes.SnowyBirchGrove) {
                trees.add(new fallen_birch1(), 2);
                trees.add(new fallen_birch2(), 2);
                trees.add(new fallen_pointy_birch1(), 1);
                trees.add(new fallen_pointy_birch2(), 1);
                trees.add(new fallen_pointy_birch3(), 1);
                trees.add(new fallen_pointy_birch4(), 1);
            } else if (category == Biome.Category.TAIGA) {
                trees.add(new fallen_spruce1(), 1);
                trees.add(new fallen_spruce2(), 1);
                trees.add(new fallen_spruce3(), 1);
            } else if (category == Biome.Category.PLAINS) {
                trees.add(new fallen_oak1(), 1);
                trees.add(new fallen_oak2(), 1);
                trees.add(new fallen_oak3(), 1);
            } else if (category == Biome.Category.FOREST) {
                if (isConiferous) {
                    trees.add(new fallen_spruce1(), 1);
                    trees.add(new fallen_spruce2(), 1);
                    trees.add(new fallen_spruce3(), 1);
                } else {
                    trees.add(new fallen_oak1(), 1);
                    trees.add(new fallen_oak2(), 1);
                    trees.add(new fallen_oak3(), 1);
                    trees.add(new fallen_oak4(), 1);
                    trees.add(new fallen_birch1(), 1);
                    trees.add(new fallen_birch2(), 1);
                }
            }

            biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(FeatureRegistry.TREE_FEATURE, new TreeWeightListConfig(trees), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(isDense ? 1 : 0, isDense ? 0.02F : 0.3F, isDense ? 5 : 1)));
        }
    }

    public static void addDefaultFlowersForBiome(Biome biomeIn){
        if(defaultPlantBlacklist.contains(biomeIn)){
            return;
        }
        Biome.TempCategory category = biomeIn.getTempCategory();

        if (BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.FOREST) && !BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.JUNGLE)&& !BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.PLAINS)) {
            if (BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.DENSE)) {
                if(category== Biome.TempCategory.COLD) {
                    addPlant(biomeIn, WNBlocks.HEPATICA_BLUE.getDefaultState(), 1);
                    addPlant(biomeIn, WNBlocks.HEPATICA_WHITE.getDefaultState(), 1);
                    addPlant(biomeIn, WNBlocks.HEPATICA_PINK.getDefaultState(), 1);
                    addPlant(biomeIn, WNBlocks.HEPATICA_PURPLE.getDefaultState(), 1);
                }else {
                    addPlant(biomeIn, WNBlocks.PASQUE_PINK.getDefaultState(), 1);
                    addPlant(biomeIn, WNBlocks.PASQUE_PURPLE.getDefaultState(), 1);
                    addPlant(biomeIn, WNBlocks.PASQUE_WHITE.getDefaultState(), 1);
                }

                addPlant(biomeIn,WNBlocks.ANEMONE.getDefaultState(),2);

                if(category== Biome.TempCategory.MEDIUM) {
                    addPlant(biomeIn, WNBlocks.PRIMROSE_WHITE.getDefaultState(), 1);
                    addPlant(biomeIn, WNBlocks.PRIMROSE_BLUE.getDefaultState(), 1);
                }

                addPlant(biomeIn,WNBlocks.FORGET_ME_NOT_BLUE.getDefaultState(),1);
                if(biomeIn.getTempCategory()== Biome.TempCategory.COLD){
                    addPlant(biomeIn,WNBlocks.SNOWDROP.getDefaultState(),2);
                    addPlant(biomeIn,WNBlocks.BLUEBELL.getDefaultState(),2);
                    addPlant(biomeIn,WNBlocks.HEATH_PURPLE.getDefaultState(),2);
                    addPlant(biomeIn,WNBlocks.HEATH_PINK.getDefaultState(),2);
                    addPlant(biomeIn,WNBlocks.HEATH_WHITE.getDefaultState(),2);
                }

                addPlant(biomeIn,WNBlocks.GRASS_FERNSPROUT.getDefaultState(),3);

                addPlant(biomeIn,WNBlocks.SHRUB.getDefaultState(),4);
                addPlant(biomeIn,WNBlocks.SHRUB_TALL.getDefaultState(),4);
            }else{
                if(category== Biome.TempCategory.COLD) {
                    addPlant(biomeIn, WNBlocks.HEPATICA_PURPLE.getDefaultState(), 1);
                    addPlant(biomeIn, WNBlocks.HEPATICA_PINK.getDefaultState(), 2);
                    addPlant(biomeIn, WNBlocks.HEPATICA_VIOLET.getDefaultState(), 1);
                    addPlant(biomeIn, WNBlocks.VIOLET_PURPLE.getDefaultState(), 1);
                }else {
                    addPlant(biomeIn, WNBlocks.PASQUE_YELLOW.getDefaultState(), 2);
                    addPlant(biomeIn, WNBlocks.PASQUE_WHITE.getDefaultState(), 1);
                }


                addPlant(biomeIn,WNBlocks.ANEMONE.getDefaultState(),1);

                if(category== Biome.TempCategory.MEDIUM) {
                    addPlant(biomeIn, WNBlocks.PRIMROSE_PINK.getDefaultState(), 2);
                }

                addPlant(biomeIn,WNBlocks.FORGET_ME_NOT_PINK.getDefaultState(),1);

                addPlant(biomeIn,WNBlocks.GRASS_FERNSPROUT.getDefaultState(),3);

                if(biomeIn.getTempCategory()== Biome.TempCategory.COLD){
                    addPlant(biomeIn,WNBlocks.SNOWDROP.getDefaultState(),2);
                    addPlant(biomeIn,WNBlocks.BLUEBELL.getDefaultState(),2);
                    addPlant(biomeIn,WNBlocks.HEATHER_PURPLE.getDefaultState(),2);
                    addPlant(biomeIn,WNBlocks.HEATHER_PINK.getDefaultState(),2);
                    addPlant(biomeIn,WNBlocks.HEATHER_WHITE.getDefaultState(),1);
                    addPlant(biomeIn,WNBlocks.HEATHER_YELLOW.getDefaultState(),1);
                    addPlant(biomeIn, WNBlocks.VIOLET_PURPLE.getDefaultState(), 1);
                }

                addPlant(biomeIn,WNBlocks.SHRUB.getDefaultState(),2);
                addPlant(biomeIn,WNBlocks.SHRUB_TALL.getDefaultState(),2);
            }

            addPlant(biomeIn,WNBlocks.WILD_ROSE.getDefaultState(),1);

        }
        if(BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.PLAINS)&& !BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.JUNGLE)){
            addPlant(biomeIn,WNBlocks.CHAMOMILE_WHITE.getDefaultState(),2);
            addPlant(biomeIn,WNBlocks.CHAMOMILE_DOUBLE_WHITE.getDefaultState(),1);
            addPlant(biomeIn,WNBlocks.GOLDENROD.getDefaultState(),3);
            addPlant(biomeIn,WNBlocks.TANSY.getDefaultState(),1);
            if(category== Biome.TempCategory.MEDIUM) {
                addPlant(biomeIn, WNBlocks.CATNIP.getDefaultState(), 2);
                addPlant(biomeIn, WNBlocks.BUTTERCUP_YELLOW.getDefaultState(), 1);
                addPlant(biomeIn, WNBlocks.FORGET_ME_NOT_WHITE.getDefaultState(), 1);
                addPlant(biomeIn, WNBlocks.GIANT_HOGWEED.getDefaultState(), 2);

            }

            if(category== Biome.TempCategory.COLD){
                addPlant(biomeIn, WNBlocks.VIOLET_PURPLE.getDefaultState(), 2);
            }

            addPlant(biomeIn, WNBlocks.BOXWOOD.getDefaultState(), 3);
            addPlant(biomeIn, WNBlocks.SHRUB.getDefaultState(), 1);


        }

        if(BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.PLAINS) && BiomeDictionary.getTypes(biomeIn).contains(BiomeDictionary.Type.WET)){
            addPlant(biomeIn, WNBlocks.MISCANTHUS_GRASS.getDefaultState(), 2);

        }
    }
}
