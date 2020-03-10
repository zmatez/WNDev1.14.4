package com.matez.wildnature.world.gen.biomes.setup;

import com.matez.wildnature.other.BiomeWeighList;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;

import java.util.ArrayList;
import java.util.Arrays;

public class BiomeGroups {
    public static ArrayList<BiomeGroup> groups = new ArrayList<>();

    public static void register(){
        groups.add(new BiomeGroup("forest_valley", new BiomeWeight(WNBiomes.Forest, 5, true, true), new BiomeWeight(WNBiomes.ForestValley, 4)));
        groups.add(new BiomeGroup("poplar_forest",new BiomeWeight(WNBiomes.PoplarForest,5,true,true),new BiomeWeight(WNBiomes.WarmLake,8),new BiomeWeight(WNBiomes.PoplarForestValley,8),new BiomeWeight(WNBiomes.PoplarForestHills,8)));
        groups.add(new BiomeGroup("aspen_grove", new BiomeWeight(WNBiomes.AspenGrove, 5, true, true), new BiomeWeight(WNBiomes.WarmLake, 4)));
        groups.add(new BiomeGroup("snowy_aspen_grove",new BiomeWeight(WNBiomes.SnowyAspenGrove,5,true,true),new BiomeWeight(WNBiomes.ColdLake,4)));
        groups.add(new BiomeGroup("orchard",new BiomeWeight(WNBiomes.Orchard,5,true,true),new BiomeWeight(WNBiomes.WarmLake,7),new BiomeWeight(WNBiomes.OrchardPlum,8)));
        groups.add(new BiomeGroup("grasslands",new BiomeWeight(WNBiomes.Grasslands,5,true,true),new BiomeWeight(WNBiomes.GrasslandsHills,5)));
        groups.add(new BiomeGroup("forested_grasslands",new BiomeWeight(WNBiomes.ForestedGrasslands,5,true,true),new BiomeWeight(WNBiomes.ForestedGrasslandsHills,5)));
        groups.add(new BiomeGroup("prairie",new BiomeWeight(WNBiomes.Prairie,5,true,true),new BiomeWeight(WNBiomes.PrairieHills,5)));
        groups.add(new BiomeGroup("tatra",new BiomeWeight(WNBiomes.TatraMountains,5,true,true),new BiomeWeight(WNBiomes.TatraFoothills,7),new BiomeWeight(WNBiomes.MorskieOko,5),new BiomeWeight(WNBiomes.Rysy,3)));
        groups.add(new BiomeGroup("bialowieza_forest",new BiomeWeight(WNBiomes.BialowiezaForest,5,true,true),new BiomeWeight(WNBiomes.ColdLake,3)));
        groups.add(new BiomeGroup("bialowieza_forest_snowy",new BiomeWeight(WNBiomes.BialowiezaForestS,5,true,true),new BiomeWeight(WNBiomes.FrozenLake,3)));
        groups.add(new BiomeGroup("rainforest",new BiomeWeight(WNBiomes.Rainforest,1,true,true),new BiomeWeight(WNBiomes.RainforestHills,3),new BiomeWeight(WNBiomes.RainforestMoor,1)));
        groups.add(new BiomeGroup("safari",new BiomeWeight(WNBiomes.Safari,1,true,true),new BiomeWeight(WNBiomes.SafariHills,1)));
        groups.add(new BiomeGroup("overgrown_cliffs",new BiomeWeight(WNBiomes.OvergrownCliffs,5,true,true),new BiomeWeight(WNBiomes.ColdLake,8)));
        groups.add(new BiomeGroup("boreal_forest",new BiomeWeight(WNBiomes.BorealForest,5,true,true),new BiomeWeight(WNBiomes.ColdLake,8),new BiomeWeight(WNBiomes.BorealValley,8),new BiomeWeight(WNBiomes.BorealForestHills,8)));
        groups.add(new BiomeGroup("snowy_boreal_forest",new BiomeWeight(WNBiomes.SnowyBorealForest,5,true,true),new BiomeWeight(WNBiomes.ColdLake,8),new BiomeWeight(WNBiomes.SnowyBorealValley,8),new BiomeWeight(WNBiomes.SnowyBorealForestHills,8)));
        groups.add(new BiomeGroup("cherry_paradise", new BiomeWeight(WNBiomes.CherryParadise, 5, true, true), new BiomeWeight(WNBiomes.WarmLake, 4)));
        groups.add(new BiomeGroup("lavender_garden", new BiomeWeight(WNBiomes.LavenderGarden, 5, true, true), new BiomeWeight(WNBiomes.WarmLake, 4)));
        groups.add(new BiomeGroup("snowy_tatra",new BiomeWeight(WNBiomes.SnowyTatraMountains,5,true,true),new BiomeWeight(WNBiomes.SnowyTatraFoothills,7),new BiomeWeight(WNBiomes.MorskieOko,5),new BiomeWeight(WNBiomes.Rysy,3)));
        groups.add(new BiomeGroup("shrublands",new BiomeWeight(WNBiomes.Shrublands,5,true,true),new BiomeWeight(WNBiomes.HillyShrublands,7)));
        groups.add(new BiomeGroup("tropical_island",new BiomeWeight(WNBiomes.TropicalIsland,5,true,true),new BiomeWeight(WNBiomes.TropicalCliffs,2)));
        groups.add(new BiomeGroup("tuchola_forest",new BiomeWeight(WNBiomes.TucholaForest,5,true,true),new BiomeWeight(WNBiomes.ColdLake,8),new BiomeWeight(WNBiomes.TucholaValley,8),new BiomeWeight(WNBiomes.TucholaForestHill,8)));
        groups.add(new BiomeGroup("snowy_tuchola_forest",new BiomeWeight(WNBiomes.SnowyTucholaForest,5,true,true),new BiomeWeight(WNBiomes.ColdLake,8),new BiomeWeight(WNBiomes.SnowyTucholaValley,8),new BiomeWeight(WNBiomes.SnowyTucholaForestHill,8)));
        groups.add(new BiomeGroup("dense_tuchola_forest",new BiomeWeight(WNBiomes.DenseTucholaForest,5,true,true),new BiomeWeight(WNBiomes.ColdLake,8),new BiomeWeight(WNBiomes.SnowyTucholaForestHill,8)));
        groups.add(new BiomeGroup("snowy_dense_tuchola_forest",new BiomeWeight(WNBiomes.SnowyDenseTucholaForest,5,true,true),new BiomeWeight(WNBiomes.ColdLake,8),new BiomeWeight(WNBiomes.SnowyTucholaForestHill,8)));
        groups.add(new BiomeGroup("olive",new BiomeWeight(WNBiomes.OliveGarden,5,true,true),new BiomeWeight(WNBiomes.TropicalLake,5),new BiomeWeight(WNBiomes.OliveHills,8)));
        groups.add(new BiomeGroup("mirkwood",new BiomeWeight(WNBiomes.Mirkwood,5,true,true),new BiomeWeight(WNBiomes.DarkMirkwood,3)));
        groups.add(new BiomeGroup("outback",new BiomeWeight(WNBiomes.Outback,9,true,true),new BiomeWeight(WNBiomes.WoodedOutback,2)));
        groups.add(new BiomeGroup("madagascar",new BiomeWeight(WNBiomes.Madagascar,5,true,true),new BiomeWeight(WNBiomes.MadagascarValley,5)));
        groups.add(new BiomeGroup("daintree",new BiomeWeight(WNBiomes.DaintreeForest,2,true,true),new BiomeWeight(WNBiomes.TropicalLake,5),new BiomeWeight(WNBiomes.DaintreePlateau,12)));


        groups.add(new BiomeGroup("oasis_desert",new BiomeWeight(Biomes.DESERT,16,true,true),new BiomeWeight(WNBiomes.Oasis,1)));
        groups.add(new BiomeGroup("oasis_sahara",new BiomeWeight(WNBiomes.Sahara,16,true,true),new BiomeWeight(WNBiomes.Oasis,1)));


        groups.forEach(biomeGroup -> {
            biomeGroup.biomes.forEach(biome -> {
                if(BiomeDictionary.getTypes(biome.biome).isEmpty()){
                    WNBiomes.registerNonSpawn(biome.biome,(BiomeDictionary.Type[])BiomeDictionary.getTypes(biome.defaultBiome).toArray());
                }
            });
        });
    }


    public static class BiomeGroup{

        private ArrayList<BiomeWeight> biomes;
        private String name;
        private BiomeWeighList list = new BiomeWeighList();
        public BiomeGroup(String name, BiomeWeight... biomes){
            this.name=name;
            this.biomes = new ArrayList<>(Arrays.asList(biomes));
            int x = 0;
            while(x<this.biomes.size()){
                BiomeWeight weight = this.biomes.get(x);
                this.list.add(weight.getBiome(),weight.getWeight());
                x++;
            }
        }

        public ArrayList<BiomeWeight> getBiomes() {
            return biomes;
        }

        public Biome getDefault(){
            int x = 0;
            while(x<biomes.size()){
                if(biomes.get(x).defaultBiome!=null){
                    return biomes.get(x).defaultBiome;
                }
                x++;
            }
            return null;
        }

        public Biome randomBiome(){
            Biome b = null;
            int z = 0;
            b = Utilities.getWeighBiome(list);
            /*int x = 0;
            while(x<biomes.size()){
                if(biomes.get(x).getBiome()==b){
                    if(biomes.get(x).isUsed()){
                        z++;
                        x++;
                        continue;
                    }else{
                        return biomes.get(x).getBiome();///tp 340.01 88.00 -759.98
                    }
                }

                x++;
            }*/
            return b;
        }

        public String getName() {
            return name;
        }
    }

    public static class BiomeWeight{
        private Biome biome;
        private int weight;
        private boolean used = false;
        private boolean alwaysUse;
        private Biome defaultBiome = null;

        public BiomeWeight(Biome biome, int weight, boolean alwaysUse){
            this.biome=biome;
            this.weight=weight;
            this.alwaysUse=alwaysUse;
        }
        public BiomeWeight(Biome biome, int weight){
            this.biome=biome;
            this.weight=weight;
            this.alwaysUse=false;
        }
        public BiomeWeight(Biome biome, int weight, boolean alwaysUse, boolean isDefault){
            this.biome=biome;
            this.weight=weight;
            this.alwaysUse=alwaysUse;
            if(isDefault){
                defaultBiome=biome;
            }
        }

        public Biome getBiome() {
            return biome;
        }

        public int getWeight() {
            return weight;
        }

        public void setUsed(){
            if(!alwaysUse){
                used = true;
            }
        }

        public boolean isUsed() {
            return used;
        }

        public void reset(){
            used=false;
        }

        public Biome getDefaultBiome() {
            return defaultBiome;
        }
    }
}
