package com.matez.wildnature.customizable;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.manager.WNBiomeManager;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonConfig {

    private static CommonConfig instance;
    private final ForgeConfigSpec.Builder builder;

    public static ForgeConfigSpec.ConfigValue<String> currentVersion;
    public static ForgeConfigSpec.DoubleValue riverDepth;
    public static ForgeConfigSpec.BooleanValue messageOnJoin;
    public static ForgeConfigSpec.BooleanValue effectOnJoin;
    public static ForgeConfigSpec.BooleanValue renderCapes;
    public static ForgeConfigSpec.BooleanValue playAmbientSounds;
    public static ForgeConfigSpec.BooleanValue replaceOakTrees;
    public static ForgeConfigSpec.BooleanValue generateUndergroundPlants;
    public static ForgeConfigSpec.BooleanValue generateRiverCanes;
    public static ForgeConfigSpec.BooleanValue generatePoisonIves,generateCrystals,generateStalagmites,generatePebbles,generateCobweb,generateRockFormations,generateFruitBushes,generateVines,generateSmallCacti;
    public static ForgeConfigSpec.DoubleValue ambientSoundsVolume;

    public static ForgeConfigSpec.IntValue biomeSize,riverSize;
    public static ForgeConfigSpec.IntValue maxTpLoop,biomeGroupSpawningSize, biomeGroupChance;
    public static ForgeConfigSpec.IntValue rockFormationChance;
    public static ForgeConfigSpec.BooleanValue generateOres, generateRocks, genBasalt, genConglomerate, genGneiss, genLimestone, genMarble, genPegmatite, genSlate;
    public static ForgeConfigSpec.IntValue rockChance, rockSize;
    public static ForgeConfigSpec.DoubleValue steamMaxAge;
    public static ForgeConfigSpec.ConfigValue<String> blacklistBiome;
    public static ForgeConfigSpec.BooleanValue generateBiomes;
    public static ForgeConfigSpec.BooleanValue flowerDisappearsOnWalk;
    public static ForgeConfigSpec.BooleanValue poisonIvyHurts;
    public static ForgeConfigSpec.BooleanValue poisonIvyPoisons;
    public static ForgeConfigSpec.DoubleValue poisonIvyDamage;
    public static ForgeConfigSpec.IntValue leafFruitChance, flowerBloomChance, flowerDropChance,fruitBushRarity,riverCaneRarity,smallCactiRarity,poisonIvyRarity,riverCaneDensity;
    public static ForgeConfigSpec.IntValue tinRarity,copperRarity,amethystRarity,sapphireRarity,malachiteRarity,silverRarity,amberRarity,rubyRarity;

    public static ArrayList<Biome> blacklistedBiomes = new ArrayList<>();


    public CommonConfig(ForgeConfigSpec.Builder builder) {
        instance = this;

        this.builder = builder;
        builder.comment("WildNature configuration file");

        general();
        generator();
        sound();
        block();


    }

    public static CommonConfig get()
    {
        return instance;
    }

    private void general()
    {
        builder.push("general");

        currentVersion = builder
                .comment("Installed mod version. Please do not change this.").define("system.version", "");
        maxTpLoop = builder
                .comment("Max value of loop when finding biome (/wn biome tp)\nDefault: 10000")
                .defineInRange("system.max_tp_time", 10000,0,99999999);
        //runWorldOnServer = builder
        // .comment("Use WildNature World Generator on servers?")
        // .define("system.generate_on_server",true);
        messageOnJoin = builder
                .comment("Send messages to users on join?\nDefault:true")
                .define("system.message_on_join",true);
        effectOnJoin = builder
                .comment("Special effects on join?\nDefault:true")
                .define("system.effect_on_join",true);
        renderCapes = builder
                .comment("Should render capes?\nDefault:true")
                .define("system.render_capes",true);

        builder.pop();
    }

    private void generator()
    {
        builder.push("generator");
        biomeSize = builder
                .comment("Biome Size\nDefault: 15")
                .defineInRange("biomeSize",15, 0, 500);

        riverSize = builder
                .comment("River Size\nDefault: 4")
                .defineInRange("riverSize",4, 0, 500);

        generateOres = builder
                .comment("Generate Ores?\nDefault: true")
                .define("ores.all",true);

        generateRocks = builder
                .comment("Generate Rocks?\nDefault: true")
                .define("rocks.all",true);

        genBasalt = builder
                .comment("Generate Basalt?\nIf you set generator.rocks.all to FALSE, changing this has no sense\nDefault: true")
                .define("rocks.define.basalt",true);

        genConglomerate = builder
                .comment("Generate Conglomerate?\nIf you set generator.rocks.all to FALSE, changing this has no sense\nDefault: true")
                .define("rocks.define.conglomerate",true);

        genGneiss = builder
                .comment("Generate Gneiss?\nIf you set generator.rocks.all to FALSE, changing this has no sense\nDefault: true")
                .define("rocks.define.gneiss",true);

        genLimestone = builder
                .comment("Generate Limestone?\nIf you set generator.rocks.all to FALSE, changing this has no sense\nDefault: true")
                .define("rocks.define.limestone",true);

        genMarble = builder
                .comment("Generate Marble?\nIf you set generator.rocks.all to FALSE, changing this has no sense\nDefault: true")
                .define("rocks.define.marble",true);

        genPegmatite = builder
                .comment("Generate Pegmatite?\nIf you set generator.rocks.all to FALSE, changing this has no sense\nDefault: true")
                .define("rocks.define.pegmatite",true);

        genSlate = builder
                .comment("Generate Slate?\nIf you set generator.rocks.all to FALSE, changing this has no sense\nDefault: true")
                .define("rocks.define.slate",true);

        rockChance = builder
                .comment("Chance of rock generation\nDefault: 33")
                .defineInRange("rocks.chance",33, 0, 100);

        rockSize = builder
                .comment("Rock deposit size\nDefault: 10")
                .defineInRange("rocks.size",10, 0, 100);

        riverDepth=builder
                .comment("Depth of all of rivers\nDefault: -1.0")
                .defineInRange("biome.river.depth",-1.0,-10.0,10);

        biomeGroupSpawningSize=builder
                .comment("Size of sub-biomes\nbigger sub-biomes = lower number\nDefault: 3")
                .defineInRange("biome.group.size",3,1,100);

        biomeGroupChance=builder
                .comment("Chance of sub-biome spawn\nDefault: 5")
                .defineInRange("biome.group.chance",5,0 ,10);

        rockFormationChance = builder
                .comment("Rock formation chance\nSmaller = more common\nDefault: 7")
                .defineInRange("rocks.formation_chance",7, 0, 10000);

        tinRarity = builder
                .comment("Tin ore rarity\nSmaller = more rare\nDefault: 10")
                .defineInRange("ores.tin_rarity",10, 0, 500);

        copperRarity = builder
                .comment("Copper ore rarity\nSmaller = more rare\nDefault: 10")
                .defineInRange("ores.copper_rarity",10, 0, 500);

        amethystRarity = builder
                .comment("Amethyst ore rarity\nSmaller = more rare\nDefault: 5")
                .defineInRange("ores.amethyst_rarity",5, 0, 500);

        sapphireRarity = builder
                .comment("Sapphire ore rarity\nSmaller = more rare\nDefault: 4")
                .defineInRange("ores.sapphire_rarity",4, 0, 500);

        malachiteRarity = builder
                .comment("Malachite ore rarity\nSmaller = more rare\nDefault: 3")
                .defineInRange("ores.malachite_rarity",3, 0, 500);

        silverRarity = builder
                .comment("Silver ore rarity\nSmaller = more rare\nDefault: 5")
                .defineInRange("ores.silver_rarity",5, 0, 500);

        amberRarity = builder
                .comment("Amber ore rarity\nSmaller = more rare\nDefault: 3")
                .defineInRange("ores.amber_rarity",3, 0, 500);

        rubyRarity = builder
                .comment("Ruby ore rarity\nSmaller = more rare\nDefault: 1")
                .defineInRange("ores.ruby_rarity",1, 0, 500);

        generateBiomes = builder
                .comment("Generate Biomes?\nDefault: true")
                .define("biome.generate",true);

        blacklistBiome = builder
                .comment("Insert biome ids that shouldn't generate naturally. Example - wildnature:grasslands,wildnature:bog").define("biome.blacklist", "");

        replaceOakTrees = builder
                .comment("[W.I.P] Replace oak trees with WildNature ones?\nDefault: true")
                .define("biome.feature.replaceOakTrees",true);

        generateUndergroundPlants = builder
            .comment("Should generate cave plants like glowing mushrooms\nDefault: true")
            .define("biome.feature.cavePlants",true);

        generateCrystals = builder
                .comment("Should generate crystals?\nDefault: true")
                .define("biome.feature.crystals",true);

        generateStalagmites = builder
                .comment("Should generate stalagmites?\nDefault: true")
                .define("biome.feature.stalagmites",true);

        generatePebbles = builder
                .comment("Should generate pebbles?\nDefault: true")
                .define("biome.feature.pebbles",true);

        generateCobweb = builder
                .comment("Should generate cobweb?\nDefault: true")
                .define("biome.feature.cobweb",true);

        generateRockFormations = builder
                .comment("Should generate rock formations?\nDefault: true")
                .define("biome.feature.rock_formations",true);

        generatePoisonIves = builder
                .comment("Should generate poison ives & spidergrass?\nDefault: true")
                .define("biome.feature.special_plants",true);

        generateFruitBushes = builder
                .comment("Should generate fruit bushes?\nDefault: true")
                .define("biome.feature.fruit_bushes",true);

        generateVines = builder
            .comment("Should generate vines?\nDefault: true")
            .define("biome.feature.vines",true);

        generateRiverCanes = builder
                .comment("Should generate river cane?\nDefault: true")
                .define("biome.feature.river_cane",true);

        generateSmallCacti = builder
                .comment("Should generate small cacti?\nDefault: true")
                .define("biome.feature.small_cacti",true);

        fruitBushRarity = builder
                .comment("Fruit bushes spawn rarity\nSmaller = more rare\nDefault: 10")
                .defineInRange("biome.feature.fruit_bushes_rarity",10, 0, 500);

        poisonIvyRarity = builder
                .comment("Posion ivy & spidergrass rarity\nSmaller = more rare\nDefault: 2")
                .defineInRange("biome.feature.ivy_rarity",2, 0, 500);

        riverCaneRarity = builder
                .comment("River cane rarity\nSmaller = more rare\nDefault: 50")
                .defineInRange("biome.feature.river_cane_rarity",50, 0, 500);

        riverCaneDensity = builder
                .comment("River cane density\nSmaller = less\nDefault: 50")
                .defineInRange("biome.feature.river_cane_density",64, 0, 500);

        smallCactiRarity = builder
                .comment("Small cacti rarity\nSmaller = more rare\nDefault: 5")
                .defineInRange("biome.feature.small_cacti_rarity",5, 0, 500);

        builder.pop();
    }

    private void sound()
    {
        builder.push("sound");

        playAmbientSounds = builder
                .comment("[W.I.P] Play ambient sounds on biomes?")
                .define("play_ambient",true);
        ambientSoundsVolume = builder
                .comment("[W.I.P] Ambient sounds volume")
                .defineInRange("volume_ambient",1,0.1,1);
        builder.pop();
    }


    private void block(){
        builder.push("block");

        steamMaxAge=builder
                .comment("Steam Particle max age multiplier - how long does steam live\nDefault: 10.0")
                .defineInRange("steam_max_age",10.0,1.0,100);

        flowerDisappearsOnWalk = builder
                .comment("Flower disappears on walk?\nDefault: true")
                .define("flowerDisappears",true);

        poisonIvyHurts = builder
                .comment("Poison ivy hurts on walk?\nDefault: true")
                .define("poisonIvyHurts",true);

        poisonIvyPoisons = builder
                .comment("Poison ivy poisons on walk?\nDefault: true")
                .define("poisonIvyPoison",true);

        poisonIvyDamage = builder
                .comment("Poison ivy damage?\nDefault: 0.5")
                .defineInRange("poisonIvyDamage",0.5,0.0,1000.0);

        leafFruitChance = builder
                .comment("Leaf fruit chance\nDefault: 10")
                .defineInRange("leafFruitChance",10,0,1000);

        flowerBloomChance = builder
                .comment("Flower bloom chance (Bone meal)\nDefault: 10")
                .defineInRange("flowerBloomChance",10,0,1000);

        flowerDropChance = builder
                .comment("Flower drop chance\nDefault: 10")
                .defineInRange("flowerDropChance",10,0,1000);


        builder.pop();
    }

    public static void compile(){
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(blacklistBiome.get().replace(" ","").split(",")));
        Main.LOGGER.debug("Initializing biome blacklist module...\nValues: " + strings.toString()+"\nRaw values: " + blacklistBiome.get());
        for (String s : strings) {
            try {
                s = s + "";
                Main.LOGGER.debug("Blacklisting " + s + "...");
                Biome b = Main.getBiomeByID(s);
                if (b != Biomes.DEFAULT) {
                    Main.LOGGER.debug("Blacklisted Biome: " + b.getRegistryName());
                    blacklistedBiomes.add(b);
                } else {
                    Main.LOGGER.debug("Invalid Blacklisted Biome: " + b.getRegistryName());
                }
            }catch (Exception e){
                Main.LOGGER.debug("Invalid Blacklisted Biome: " + s+"");
            }
        }
    }
}