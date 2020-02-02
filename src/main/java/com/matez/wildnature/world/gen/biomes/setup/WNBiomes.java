package com.matez.wildnature.world.gen.biomes.setup;

import com.matez.wildnature.world.gen.biomes.biomes.*;
import com.matez.wildnature.world.gen.manager.WNBiomeManager;
import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;

public class WNBiomes {
    public static ArrayList<Biome> biomes = new ArrayList<>();
    public static ArrayList<Biome> registerBiomes = new ArrayList<>();
    public static ArrayList<Biome> generatorBiomes = new ArrayList<>();
    public static ArrayList<BiomeToRegister> biomesToRegister = new ArrayList<>();
    public static ArrayList<String> biomesString = new ArrayList<String>();


    public static Biome River = new WNRiverBiome();
    public static Biome FrozenRiver = new WNFrozenRiverBiome();
    public static Biome AmazonRiver = new WNAmazonRiver();
    public static Biome NileRiver = new WNNileRiver();

    //POPLAR
    public static Biome PoplarForest = new WNPoplarForest("poplar_forest");
    public static Biome PoplarForestValley = new WNPoplarForestValley("poplar_forest_valley");
    public static Biome PoplarForestHills = new WNPoplarForestHills("poplar_forest_hills");

    //ASPEN
    public static Biome AspenGrove = new WNAspenGrove("aspen_grove");
    public static Biome SnowyAspenGrove = new WNSnowyAspenGrove("snowy_aspen_grove");

    //ORCHARD
    public static Biome Orchard = new WNOrchard("orchard");
    public static Biome OrchardPlum = new WNOrchardPlum("orchard_plum");
    public static Biome CherryParadise = new WNCherryParadise("cherry_paradise");

    //MAPLE
    public static Biome MapleForest = new WNMapleForest("maple_forest");
    public static Biome AutumnalMapleForest = new WNAutumnalMapleForest("autumnal_maple_forest");

    //GRASSLANDS
    public static Biome Grasslands = new WNGrasslands("grasslands");
    public static Biome GrasslandsHills = new WNGrasslandsHills("grasslands_hills");
    public static Biome ForestedGrasslands = new WNForestedGrasslands("forested_grasslands");
    public static Biome ForestedGrasslandsHills = new WNForestedGrasslands("forested_grasslands_hills");
    public static Biome Polders = new WNPolders("polders");
    public static Biome Shrublands = new WNShrublands("shrublands");
    public static Biome HillyShrublands = new WNHillyShrublands("hilly_shrublands");
    public static Biome PrehistoricValley = new WNPrehistoricValley("prehistoric_valley");


    //PRAIRIE
    public static Biome Prairie = new WNPrairie("prairie");
    public static Biome PrairieHills = new WNPrairieHills("prairie_hills");
    public static Biome RapeseedField = new WNRapeseedField("rapeseed_field");
    public static Biome CornField = new WNCornField("corn_field");

    //OUTBACK
    public static Biome Outback = new WNOutback("outback");

    //TATRA
    public static Biome TatraMountains = new WNTatraMountains("tatra_mountains");
    public static Biome TatraFoothills = new WNTatraFoothills("tatra_foothills");
    public static Biome SnowyTatraMountains = new WNTatraMountains("snowy_tatra_mountains");
    public static Biome SnowyTatraFoothills = new WNTatraFoothills("snowy_tatra_foothills");
    public static Biome MorskieOko = new WNMorskieOko("morskie_oko");
    public static Biome Rysy = new WNRysy("rysy");

    //BIALOWIEZA
    public static Biome BialowiezaForest = new WNBialowiezaForest("bialowieza_forest");
    public static Biome BialowiezaMarsh = new WNBialowiezaMarsh("bialowieza_marsh");
    public static Biome BialowiezaForestS = new WNSnowyBialowiezaForest("snowy_bialowieza_forest");
    public static Biome BialowiezaMarshS = new WNBialowiezaFrozenMarsh("bialowieza_frozen_marsh");

    public static Biome SnowyMountains = new WNSnowedMountains("snowy_mountains");
    public static Biome Glacier = new WNGlacier("glacier");
    public static Biome Himalayas = new WNHimalayas("himalayas");
    public static Biome OvergrownCliffs = new WNOvergrownCliffs("overgrown_cliffs");

    //BOG
    public static Biome Bog = new WNBog("bog");

    //BOREAL
    public static Biome BorealForest = new WNBorealForest("boreal_forest");
    public static Biome BorealForestHills = new WNBorealForestHill("boreal_forest_hills");
    public static Biome BorealValley = new WNBorealValley("boreal_valley");
    public static Biome SnowyBorealForest = new WNSnowyBorealForest("snowy_boreal_forest");
    public static Biome SnowyBorealForestHills = new WNSnowyBorealForestHill("snowy_boreal_forest_hills");
    public static Biome SnowyBorealValley = new WNSnowyBorealValley("snowy_boreal_valley");
    public static Biome RockyTaiga = new WNRockySpruceForest("rocky_taiga");
    public static Biome SeasonalTaiga = new WNSeasonalTaiga("seasonal_taiga");

    public static Biome TucholaForest = new WNTucholaForest("tuchola_forest");
    public static Biome DenseTucholaForest = new WNDenseTucholaForest("dense_tuchola_forest");
    public static Biome TucholaForestHill = new WNTucholaForestHill("tuchola_forest_hill");
    public static Biome TucholaValley = new WNTucholaValley("tuchola_valley");
    public static Biome SnowyTucholaForest = new WNTucholaForest("snowy_tuchola_forest");
    public static Biome SnowyDenseTucholaForest = new WNDenseTucholaForest("snowy_dense_tuchola_forest");
    public static Biome SnowyTucholaForestHill = new WNTucholaForestHill("snowy_tuchola_forest_hill");
    public static Biome SnowyTucholaValley = new WNTucholaValley("snowy_tuchola_valley");


    //HIGHLANDS
    public static Biome Highlands = new WNHighlands("highlands");

    //RAINFOREST
    public static Biome Rainforest = new WNRainforest("rainforest");
    public static Biome RainforestHills = new WNRainforestHills("rainforest_hills");
    public static Biome RainforestMoor = new WNRainforestMoor("rainforest_moor");

    //SAFARI
    public static Biome Safari = new WNSafari("safari");
    public static Biome SafariHills = new WNSafariHills("safari_hills");

    //REDWOOD
    public static Biome RedwoodForest = new WNRedwoodForest("redwood_forest");

    //CHRISTMAS
    public static Biome ChristmasDream = new WNChristmasDream("christmas_dream");

    //GIANT CONIFEROUS
    public static Biome GiantConiferousForest = new WNGiantConiferousForest("giant_coniferous_forest");
    public static Biome SnowyGiantConiferousForest = new WNSnowyGiantConiferousForest("snowy_giant_coniferous_forest");

    //AUTUMNAL
    public static Biome AutumnalSpruceForest = new WNAutumnalSpruceForest("autumnal_spruce");

    //BIRCH_GROVE
    public static Biome BirchGrove = new WNBirchGrove("birch_grove");
    public static Biome SnowyBirchGrove = new WNSnowyBirchGrove("snowy_birch_grove");


    //FLOWER FIELD
    public static Biome FlowerField = new WNFlowerField("flower_field");

    //SAHARA
    public static Biome Sahara = new WNSahara("sahara");

    //DESERT
    public static Biome Oasis = new WNOasis("oasis");
    public static Biome LushDesert = new WNLushDesert("lush_desert");
    public static Biome CrackedDesert = new WNCrackedDesert("cracked_desert");
    public static Biome TintedDesert = new WNTintedDesert("tinted_desert");
    public static Biome TintedDesertHills = new WNTintedDesertHills("tinted_desert_hills");
    public static Biome Badlands = new WNBadlands("badlands");


    //DENSE FOREST
    public static Biome DeciduousForest = new WNDeciduousForest("deciduous_forest");
    public static Biome Forest = new WNForest("forest");
    public static Biome ForestValley = new WNForestValley("forest_valley");
    public static Biome SnowyForest = new WNSnowyForest("snowy_forest");

    //GOLDEN WOODS
    public static Biome GoldenWoods = new WNGoldenWoods("golden_woods");

    //LAVENDER
    public static Biome LavenderGarden = new WNLavenderGarden("lavender_garden");

    //
    public static Biome SaltFlats = new WNSaltFlats("salt_flats");


    //FARMLANDS
    public static Biome Farmlands = new WNFarmlands("farmlands");

    //MAHOGANY
    public static Biome MahoganyRainforest = new WNMahoganyRainforest("mahogany_rainforest");


    //BADLANDS
    public static Biome TropicalBadlands = new WNTropicalBadlands("tropical_badlands");
    public static Biome Steppe = new WNSteppe("steppe");

    //RIVERED
    public static Biome Masuria = new WNMasuria("masuria");
    public static Biome LandOfRivers = new WNLandOfRivers("land_of_rivers");

    //WETLANDS
    public static Biome Wetlands = new WNWetlands("wetlands");
    public static Biome MangroveForest = new WNMangroveBayou("mangrove_bayou");


    //LAKES
    public static Biome WarmLake = new WNWarmLake("warm_lake");
    public static Biome ColdLake = new WNColdLake("cold_lake");
    public static Biome TropicalLake = new WNTropicalLake("tropical_lake");
    public static Biome FrozenLake = new WNFrozenLake("frozen_lake");
    public static Biome DriedLake = new WNDriedLake("dried_lake");


    //ISLANDS
    public static Biome EasterIsland = new WNEasterIsland("easter_island");
    public static Biome TropicalIsland = new WNTropicalIsland("tropical_island");
    public static Biome TropicalCliffs = new WNTropicalCliffs("tropical_cliffs");
    public static Biome ChristmasIsland = new WNChristmasIsland("christmas_island");


    //BEACHES
    public static Biome WhiteBeach = new WNWhiteBeach("white_beach");


    public static void registerBiomes(){
        register(Forest, BiomeManager.BiomeType.WARM,10, Type.FOREST, Type.DENSE);
        register(SnowyForest, BiomeManager.BiomeType.COOL,10, Type.FOREST, Type.DENSE, Type.SNOWY);
        register(DeciduousForest, BiomeManager.BiomeType.WARM,10, Type.FOREST, Type.DENSE);
        register(PoplarForest, BiomeManager.BiomeType.WARM,10, Type.FOREST, Type.DENSE);
        register(AspenGrove, BiomeManager.BiomeType.COOL,10, Type.FOREST, Type.DENSE);
        register(SnowyAspenGrove, BiomeManager.BiomeType.COOL,10, Type.FOREST, Type.DENSE, Type.SNOWY);
        register(SnowyBorealForest, BiomeManager.BiomeType.ICY,10, Type.FOREST, Type.DENSE, Type.COLD, Type.CONIFEROUS, Type.SNOWY);
        register(BorealForest, BiomeManager.BiomeType.COOL,10, Type.FOREST, Type.DENSE, Type.COLD, Type.CONIFEROUS);
        register(TucholaForest, BiomeManager.BiomeType.COOL,5, Type.FOREST, Type.DENSE, Type.COLD, Type.CONIFEROUS);
        register(DenseTucholaForest, BiomeManager.BiomeType.COOL,3, Type.FOREST, Type.DENSE, Type.COLD, Type.CONIFEROUS);
        register(SnowyTucholaForest, BiomeManager.BiomeType.ICY,5, Type.FOREST, Type.DENSE, Type.COLD, Type.SNOWY, Type.CONIFEROUS);
        register(SnowyDenseTucholaForest, BiomeManager.BiomeType.ICY,3, Type.FOREST, Type.DENSE, Type.COLD, Type.SNOWY, Type.CONIFEROUS);
        register(RockyTaiga, BiomeManager.BiomeType.COOL,8, Type.FOREST, Type.MOUNTAIN, Type.HILLS, Type.COLD, Type.CONIFEROUS);
        register(Orchard, BiomeManager.BiomeType.WARM,7, Type.FOREST, Type.PLAINS);
        register(CherryParadise, BiomeManager.BiomeType.WARM,5, Type.FOREST, Type.PLAINS, Type.RARE);
        register(GoldenWoods, BiomeManager.BiomeType.WARM,7, Type.FOREST, Type.PLAINS);
        register(Steppe, BiomeManager.BiomeType.WARM,7, Type.DEAD, Type.DRY, Type.WASTELAND, Type.PLAINS);
        register(MapleForest, BiomeManager.BiomeType.WARM,7, Type.FOREST, Type.DENSE);
        register(AutumnalMapleForest, BiomeManager.BiomeType.WARM,7, Type.FOREST, Type.DENSE);
        register(Grasslands, BiomeManager.BiomeType.WARM,12, Type.PLAINS);
        register(Shrublands, BiomeManager.BiomeType.WARM,8, Type.PLAINS, Type.HILLS, Type.FOREST);
        register(ForestedGrasslands, BiomeManager.BiomeType.WARM,10, Type.PLAINS, Type.FOREST);
        register(Polders, BiomeManager.BiomeType.WARM,7, Type.PLAINS);
        register(Farmlands, BiomeManager.BiomeType.WARM,8, Type.PLAINS);
        register(LavenderGarden, BiomeManager.BiomeType.WARM,4, Type.PLAINS);
        register(Prairie, BiomeManager.BiomeType.WARM,10, Type.PLAINS, Type.DRY);
        register(Masuria, BiomeManager.BiomeType.WARM,6, Type.PLAINS, Type.WET);
        register(LandOfRivers, BiomeManager.BiomeType.COOL,6, Type.PLAINS, Type.WET);
        register(Wetlands, BiomeManager.BiomeType.WARM,9, Type.PLAINS, Type.WET);
        register(TropicalBadlands, BiomeManager.BiomeType.WARM,7, Type.HILLS, Type.MESA, Type.JUNGLE);
        register(RapeseedField, BiomeManager.BiomeType.WARM,10, Type.PLAINS, Type.DRY);
        register(CornField, BiomeManager.BiomeType.WARM,5, Type.PLAINS, Type.DRY);
        register(Outback, BiomeManager.BiomeType.DESERT,10, Type.DEAD, Type.DRY, Type.SAVANNA);
        register(TatraMountains, BiomeManager.BiomeType.ICY,10, Type.MOUNTAIN, Type.FOREST, Type.HILLS);
        register(SnowyTatraMountains, BiomeManager.BiomeType.ICY,10, Type.MOUNTAIN, Type.FOREST, Type.HILLS, Type.SNOWY);
        register(BialowiezaForest, BiomeManager.BiomeType.COOL,7, Type.FOREST, Type.DENSE, Type.CONIFEROUS);
        register(BialowiezaForestS, BiomeManager.BiomeType.ICY,7, Type.FOREST, Type.DENSE, Type.COLD, Type.CONIFEROUS);
        register(BialowiezaMarsh, BiomeManager.BiomeType.COOL,6, Type.SWAMP, Type.WET);
        register(BialowiezaMarshS, BiomeManager.BiomeType.ICY,6, Type.SWAMP, Type.WET, Type.COLD);
        register(OvergrownCliffs, BiomeManager.BiomeType.COOL,8, Type.MOUNTAIN, Type.HILLS, Type.WATER, Type.HOT);
        register(SnowyMountains, BiomeManager.BiomeType.ICY,9, Type.MOUNTAIN, Type.HILLS, Type.COLD, Type.SNOWY);
        register(Glacier, BiomeManager.BiomeType.ICY,9, Type.MOUNTAIN, Type.HILLS, Type.COLD);
        register(Himalayas, BiomeManager.BiomeType.ICY,7, Type.MOUNTAIN, Type.HILLS, Type.COLD, Type.SNOWY);
        register(Bog, BiomeManager.BiomeType.COOL,10, Type.WET, Type.SWAMP, Type.DEAD);
        register(Highlands, BiomeManager.BiomeType.COOL,10, Type.HILLS, Type.PLAINS);
        register(Rainforest, BiomeManager.BiomeType.WARM,7, Type.FOREST, Type.JUNGLE);
        register(MahoganyRainforest, BiomeManager.BiomeType.WARM,7, Type.FOREST, Type.JUNGLE);
        register(Safari, BiomeManager.BiomeType.DESERT,10, Type.SAVANNA);
        register(RedwoodForest, BiomeManager.BiomeType.WARM,10, Type.FOREST, Type.DENSE);
        register(GiantConiferousForest, BiomeManager.BiomeType.COOL,8, Type.FOREST, Type.CONIFEROUS, Type.DENSE);
        register(SnowyGiantConiferousForest, BiomeManager.BiomeType.ICY,8, Type.FOREST, Type.CONIFEROUS, Type.SNOWY, Type.DENSE);
        register(ChristmasDream, BiomeManager.BiomeType.ICY,5, Type.PLAINS, Type.CONIFEROUS, Type.SNOWY, Type.COLD);
        register(AutumnalSpruceForest, BiomeManager.BiomeType.COOL,10, Type.PLAINS, Type.CONIFEROUS, Type.SNOWY, Type.COLD);
        register(BirchGrove, BiomeManager.BiomeType.WARM,10, Type.FOREST, Type.WET, Type.DENSE);
        register(SnowyBirchGrove, BiomeManager.BiomeType.COOL,10, Type.FOREST, Type.SNOWY, Type.COLD);
        register(FlowerField, BiomeManager.BiomeType.WARM,7, Type.PLAINS, Type.DENSE, Type.LUSH);
        register(Sahara, BiomeManager.BiomeType.DESERT,10, Type.DEAD, Type.DRY, Type.SANDY);
        register(Badlands, BiomeManager.BiomeType.DESERT,8, Type.DEAD, Type.DRY, Type.SANDY);
        register(TintedDesert, BiomeManager.BiomeType.DESERT,5, Type.DEAD, Type.DRY, Type.SANDY);
        register(TintedDesertHills, BiomeManager.BiomeType.DESERT,3, Type.DEAD, Type.DRY, Type.SANDY, Type.MOUNTAIN, Type.HILLS);
        register(LushDesert, BiomeManager.BiomeType.DESERT,5, Type.LUSH, Type.DRY, Type.SANDY);
        register(CrackedDesert, BiomeManager.BiomeType.DESERT,2, Type.LUSH, Type.DRY, Type.SANDY);
        register(SaltFlats, BiomeManager.BiomeType.COOL,1, Type.WASTELAND, Type.DRY, Type.COLD);
        register(MangroveForest, BiomeManager.BiomeType.WARM,5, Type.FOREST, Type.SWAMP, Type.JUNGLE);
        register(PrehistoricValley, BiomeManager.BiomeType.WARM,1, Type.PLAINS, Type.RARE);
        register(SeasonalTaiga, BiomeManager.BiomeType.COOL,8, Type.FOREST, Type.CONIFEROUS, Type.DENSE);



        BiomeGroups.register();
    }



    public static void register(Biome biome, WNBiomeManager.BiomeType type, int weight, Type... types){//adds biome to biome list that have to spawn naturally.
        Main.LOGGER.info("Preparing for registering " + biome.getRegistryName() + " biome to generate naturally...");
        if(CommonConfig.generateBiomes.get()) {
            biomesToRegister.add(new BiomeToRegister(biome, type, weight, types));
        }
        generatorBiomes.add(biome);
    }

    public static void registerAll(){//adds biome to biome list that have to spawn naturally.
        Main.LOGGER.info(" ----- Registering " + biomesToRegister.size() + " biomes ----- ");
        biomesToRegister.forEach(BiomeToRegister::registerIt);
        WNGlobalBiomeFeatures.setup();
        if(CommonConfig.generateBiomes.get()){
            Main.LOGGER.info("Biome generation is not active");
        }
        Main.LOGGER.info(" -------------------------------------------------------------- ");
    }

    public static class BiomeToRegister{
        private Biome biome;
        private WNBiomeManager.BiomeType type;
        private int weight;
        private Type[] types;
        public BiomeToRegister(Biome biome, WNBiomeManager.BiomeType type, int weight, Type... types){
            this.biome=biome;
            this.type=type;
            this.weight=weight;
            this.types=types;
        }

        public void registerIt(){
            if(CommonConfig.blacklistedBiomes.contains(biome)){
                Main.LOGGER.info(biome.getRegistryName() + " is blacklisted.");

                return;
            }
            Main.LOGGER.info("Registered " + biome.getRegistryName() + " biome");

            BiomeDictionary.addTypes(biome, types);
            WNBiomeManager.addBiome(type, new WNBiomeManager.BiomeEntry(biome, weight));
            WNBiomeManager.addSpawnBiome(biome);
        }
    }

}
