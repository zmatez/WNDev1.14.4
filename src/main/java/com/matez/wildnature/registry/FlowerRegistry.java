package com.matez.wildnature.registry;

import com.matez.wildnature.Main;
import com.matez.wildnature.blocks.*;
import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class FlowerRegistry {

    Block[] flowers;
    private ArrayList<FruitableLeaves.StageFruit> lemonFruits = new ArrayList<>();
    private ArrayList<FruitableLeaves.StageFruit> orangeFruits = new ArrayList<>();
    private ArrayList<FruitableLeaves.StageFruit> grapeFruitFruits = new ArrayList<>();
    public FlowerRegistry(){
        lemonFruits.add(new FruitableLeaves.StageFruit(0, new FruitableLeaves.ItemPortion("",0,0)));
        lemonFruits.add(new FruitableLeaves.StageFruit(1, new FruitableLeaves.ItemPortion("",0,0)));
        lemonFruits.add(new FruitableLeaves.StageFruit(2, new FruitableLeaves.ItemPortion("wildnature:lemon",1,1)));
        lemonFruits.add(new FruitableLeaves.StageFruit(3, new FruitableLeaves.ItemPortion("wildnature:lemon",1,1)));
        lemonFruits.add(new FruitableLeaves.StageFruit(4, new FruitableLeaves.ItemPortion("wildnature:lemon",1,1)));
        lemonFruits.add(new FruitableLeaves.StageFruit(5, new FruitableLeaves.ItemPortion("wildnature:lemon",1,1)));
        lemonFruits.add(new FruitableLeaves.StageFruit(6, new FruitableLeaves.ItemPortion("wildnature:lemon",1,1)));
        lemonFruits.add(new FruitableLeaves.StageFruit(7, new FruitableLeaves.ItemPortion("wildnature:lemon",1,1)));

        orangeFruits.add(new FruitableLeaves.StageFruit(0, new FruitableLeaves.ItemPortion("",0,0)));
        orangeFruits.add(new FruitableLeaves.StageFruit(1, new FruitableLeaves.ItemPortion("",0,0)));
        orangeFruits.add(new FruitableLeaves.StageFruit(2, new FruitableLeaves.ItemPortion("wildnature:orange",1,1)));
        orangeFruits.add(new FruitableLeaves.StageFruit(3, new FruitableLeaves.ItemPortion("wildnature:orange",1,1)));
        orangeFruits.add(new FruitableLeaves.StageFruit(4, new FruitableLeaves.ItemPortion("wildnature:orange",1,1)));
        orangeFruits.add(new FruitableLeaves.StageFruit(5, new FruitableLeaves.ItemPortion("wildnature:orange",1,1)));
        orangeFruits.add(new FruitableLeaves.StageFruit(6, new FruitableLeaves.ItemPortion("wildnature:orange",1,1)));
        orangeFruits.add(new FruitableLeaves.StageFruit(7, new FruitableLeaves.ItemPortion("wildnature:orange",1,1)));

        grapeFruitFruits.add(new FruitableLeaves.StageFruit(0, new FruitableLeaves.ItemPortion("",0,0)));
        grapeFruitFruits.add(new FruitableLeaves.StageFruit(1, new FruitableLeaves.ItemPortion("",0,0)));
        grapeFruitFruits.add(new FruitableLeaves.StageFruit(2, new FruitableLeaves.ItemPortion("wildnature:grapefruit",1,1)));
        grapeFruitFruits.add(new FruitableLeaves.StageFruit(3, new FruitableLeaves.ItemPortion("wildnature:grapefruit",1,1)));
        grapeFruitFruits.add(new FruitableLeaves.StageFruit(4, new FruitableLeaves.ItemPortion("wildnature:grapefruit",1,1)));
        grapeFruitFruits.add(new FruitableLeaves.StageFruit(5, new FruitableLeaves.ItemPortion("wildnature:grapefruit",1,1)));
        grapeFruitFruits.add(new FruitableLeaves.StageFruit(6, new FruitableLeaves.ItemPortion("wildnature:grapefruit",1,1)));
        grapeFruitFruits.add(new FruitableLeaves.StageFruit(7, new FruitableLeaves.ItemPortion("wildnature:grapefruit",1,1)));

        flowers = new Block[]{
                WNBlocks.CHERRY_FLOWER = new BushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cherry_flower")),
                WNBlocks.JACARANDA_FLOWER = new BushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("jacaranda_flower")),
                WNBlocks.PLUM_FLOWER = new BushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("plum_flower")),
                WNBlocks.DAISY = new BushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("daisy")),
                WNBlocks.HEATHER_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("heather_purple")),
                WNBlocks.HEATHER_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("heather_pink")),
                WNBlocks.HEATHER_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("heather_white")),
                WNBlocks.HEATHER_YELLOW = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("heather_yellow")),
                WNBlocks.BLUEBELL = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bluebell")),
                WNBlocks.FORGET_ME_NOT_BLUE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("forget_me_not_blue")),
                WNBlocks.FORGET_ME_NOT_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("forget_me_not_pink")),
                WNBlocks.FORGET_ME_NOT_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("forget_me_not_white")),
                WNBlocks.IRIS_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("iris_pink")),
                WNBlocks.IRIS_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("iris_purple")),
                WNBlocks.IRIS_VIOLET = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("iris_violet")),
                WNBlocks.IRIS_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("iris_white")),
                WNBlocks.LUPINE_BLUE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lupine_blue")),
                WNBlocks.LUPINE_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lupine_pink")),
                WNBlocks.LUPINE_RED = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lupine_red")),
                WNBlocks.LUPINE_VIOLET = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lupine_violet")),
                WNBlocks.LUPINE_YELLOW = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lupine_yellow")),
                WNBlocks.PASQUE_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("pasque_pink")),
                WNBlocks.PASQUE_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("pasque_purple")),
                WNBlocks.PASQUE_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("pasque_white")),
                WNBlocks.PASQUE_YELLOW = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("pasque_yellow")),
                WNBlocks.AZALEA_ORANGE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("azalea_orange")),
                WNBlocks.AZALEA_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("azalea_pink")),
                WNBlocks.AZALEA_PURPLE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("azalea_purple")),
                WNBlocks.AZALEA_RED = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("azalea_red")),
                WNBlocks.AZALEA_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("azalea_white")),
                WNBlocks.AZALEA_YELLOW = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("azalea_yellow")),
                WNBlocks.BUTTERCUP_ORANGE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("buttercup_orange")),
                WNBlocks.BUTTERCUP_YELLOW = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("buttercup_yellow")),
                WNBlocks.CANA_BULB_ORANGE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cana_bulb_orange")),
                WNBlocks.CANA_BULB_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cana_bulb_pink")),
                WNBlocks.CANA_BULB_RED = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cana_bulb_red")),
                WNBlocks.CANA_BULB_YELLOW = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cana_bulb_yellow")),
                WNBlocks.PERENNIAL_BLUE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("perennial_blue")),
                WNBlocks.PERENNIAL_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("perennial_pink")),
                WNBlocks.PERENNIAL_VIOLET = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("perennial_violet")),
                WNBlocks.VIBURNUM_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("viburnum_pink")),
                WNBlocks.VIBURNUM_WHITE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("viburnum_white")),
                WNBlocks.RADISSIUM_BLUE = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("radissium_blue")),
                WNBlocks.RADISSIUM_PINK = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("radissium_pink")),
                WNBlocks.RADISSIUM_RED = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("radissium_red")),
                WNBlocks.LAVENDER = new FloweringBushBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lavender")),






                WNBlocks.GRASS_FERNSPROUT = new BushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("grass_fernsprout")),
                WNBlocks.GRASS_FLOWER = new FloweringBushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("grass_flower")),
                WNBlocks.GRASS_THISTLE = new FloweringBushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("grass_thistle")),
                WNBlocks.GRASS_WHEAT = new FloweringBushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("grass_wheat")),
                WNBlocks.WILD_WHEAT = new FloweringBushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("wild_wheat")),
                WNBlocks.MEDIUM_GRASS = new BushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("medium_grass")),
                WNBlocks.SMALL_GRASS = new BushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("small_grass")),
                WNBlocks.DESERT_GRASS = new DesertBush(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("desert_grass")),
                WNBlocks.DEAD_SHORT_GRASS = new DesertBush(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("dead_short_grass")),
                WNBlocks.LEAF_PILE = new BushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("leaf_pile")),
                WNBlocks.DEAD_LEAF_PILE = new BushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("dead_leaf_pile")),
                WNBlocks.CLOVER = new BushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("clover")),
                WNBlocks.POISON_IVY = new PoisonIvyBlock(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("poison_ivy")),
                WNBlocks.LAMPGRASS = new FloweringBushBase(Block.Properties.create(Material.TALL_PLANTS).lightValue(4),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lampgrass")),
                WNBlocks.SPIDERGRASS = new SpidergrassBlock(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("spidergrass")),

                WNBlocks.YEW_BUSH = new BushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("yew_bush")),
                WNBlocks.BLACKBERRY_BUSH = new FloweringBushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("blackberry_bush")),
                WNBlocks.CATTAIL = new CattailBlock(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cattail")),
                WNBlocks.BIRD_OF_PARADISE = new DoubleBushBase(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bird_of_paradise")),
                WNBlocks.RAPESEED = new DoubleBushBaseFlowering(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("rapeseed")),
                WNBlocks.COFFEE_SAPLING = new CoffeeSapling(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("coffee_sapling")),
                WNBlocks.COFFEE_BUSH = new CoffeeBush(Block.Properties.create(Material.TALL_PLANTS), Main.RegistryEvents.location("coffee_bush")),
                WNBlocks.CORN_BUSH = new CornPlant(Block.Properties.create(Material.TALL_PLANTS), Main.RegistryEvents.location("corn_bush")),
                WNBlocks.RIVER_CANE = new RiverCaneBush(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("river_cane")),
                WNBlocks.SMALL_CACTI = new DesertBush(Block.Properties.create(Material.TALL_PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("small_cacti")),


                WNBlocks.GREEN_WATERLILY = new WaterLilyBase(Block.Properties.create(Material.PLANTS), Main.RegistryEvents.location("green_waterlily")),
                WNBlocks.RED_WATERLILY = new WaterLilyBase(Block.Properties.create(Material.PLANTS), Main.RegistryEvents.location("red_waterlily")),


                WNBlocks.BUSH_RASPBERRY = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_raspberry"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:raspberry",1,3))),
                WNBlocks.BUSH_BLUEBERRY = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_blueberry"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:blueberry",1,3))),
                WNBlocks.BUSH_LINGONBERRY = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_lingonberry"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:lingonberry",1,3))),
                WNBlocks.BUSH_GOOSEBERRY = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_gooseberry"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:gooseberry",1,3))),
                WNBlocks.BUSH_CHOKEBERRY = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_chokeberry"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:chokeberry",1,3))),
                WNBlocks.BUSH_BILBERRY = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_bilberry"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:bilberries",1,3))),
                WNBlocks.BUSH_HAWTHORN = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_hawthorn"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:hawthorn_berry",1,3))),
                WNBlocks.BUSH_KAMCHATKA = new BushBerryBase(Block.Properties.create(Material.PLANTS),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_kamchatka"),new FruitableLeaves.StageFruit(1,new FruitableLeaves.ItemPortion("wildnature:kamchatka_berry",1,3))),
                WNBlocks.BUSH_BLACK_CURRANT = new CurrantPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_black_currant")),
                WNBlocks.BUSH_RED_CURRANT = new CurrantPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_red_currant")),
                WNBlocks.BUSH_WHITE_CURRANT = new CurrantPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_white_currant")),
                WNBlocks.BUSH_WILD_STRAWBERRY = new WildStrawberryPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_wild_strawberry")),
                WNBlocks.BUSH_QUINCE = new QuincePlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_quince")),
                WNBlocks.BUSH_BLACK_LILAC = new BlackLilacPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("bush_black_lilac")),

                //CITRUS
                WNBlocks.LEMON_LEAVES = new CitrusLeavesBlock(Block.Properties.create(Material.LEAVES),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lemon_leaves"),lemonFruits),
                WNBlocks.ORANGE_LEAVES = new CitrusLeavesBlock(Block.Properties.create(Material.LEAVES),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("orange_leaves"),orangeFruits),
                WNBlocks.GRAPE_FRUIT_LEAVES = new CitrusLeavesBlock(Block.Properties.create(Material.LEAVES),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("grape_fruit_leaves"),grapeFruitFruits),




                //PLANTS



                WNBlocks.TOMATO_PLANT = new TomatoPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("tomato_plant")),
                WNBlocks.LETTUCE_PLANT = new LettucePlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("lettuce_plant")),
                WNBlocks.ONION_PLANT = new OnionPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("onion_plant")),
                WNBlocks.RED_ONION_PLANT = new OnionPlant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("red_onion_plant")),
                WNBlocks.GREEN_BEANS_BUSH = new GreenBeansBush(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("green_bean_bush")),
                WNBlocks.BASIL_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("basil_plant"),"wildnature:basil"),
                WNBlocks.CAULIFLOWER_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("cauliflower_plant"),"wildnature:cauliflower"),
                WNBlocks.CELERY_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("celery_plant"),"wildnature:celery"),
                WNBlocks.GARLIC_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("garlic_plant"),"wildnature:garlic"),
                WNBlocks.GINGER_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("ginger_plant"),"wildnature:ginger"),
                WNBlocks.GREEN_PEPPER_PLANT = new Age6Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("green_pepper_plant"),"wildnature:green_pepper"),
                WNBlocks.LEEK_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("leek_plant"),"wildnature:leek"),
                WNBlocks.PARSLEY_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("parsley_plant"),"wildnature:fresh_parsley"),
                WNBlocks.RED_PEPPER_PLANT = new Age6Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("red_pepper_plant"),"wildnature:red_pepper"),
                WNBlocks.RHUBARB_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("rhubarb_plant"),"wildnature:rhubarb"),
                WNBlocks.RICE_PLANT = new Age5Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("rice_plant"),"wildnature:rice"),
                WNBlocks.SAGE_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("sage_plant"),"wildnature:dried_sage"),
                WNBlocks.TURMERIC_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("turmeric_plant"),"wildnature:turmeric"),
                WNBlocks.TURNIP_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("turnip_plant"),"wildnature:turnip"),
                WNBlocks.BROCCOLI_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("broccoli_plant"),"wildnature:broccoli"),
                WNBlocks.CABBAGE_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("cabbage_plant"),"wildnature:cabbage"),
                WNBlocks.CHIVES_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("chives_plant"),"wildnature:chives"),
                WNBlocks.CUCUMBER_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("cucumber_plant"),"wildnature:cucumber"),
                WNBlocks.EGGPLANT_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("eggplant_plant"),"wildnature:eggplant"),
                WNBlocks.CURRY_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("curry_plant"),"wildnature:curry_leaf"),
                WNBlocks.MARJORAM_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("marjoram_plant"),"wildnature:fresh_marjoram"),
                WNBlocks.ROSEMARY_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("rosemary_plant"),"wildnature:fresh_rosemary"),
                WNBlocks.PEA_PLANT = new Age4Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("pea_plant"),"wildnature:peas"),
                WNBlocks.PEANUT_PLANT = new Age3Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("peanut_plant"),"wildnature:peanut"),
                WNBlocks.HORSE_RADISH_PLANT = new BushBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),null, "wildnature:horse_radish", 1,2,0,Main.RegistryEvents.location("horse_radish_plant")),


                WNBlocks.COTTON_PLANT = new Age2Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("cotton_plant"),"wildnature:cotton"),
                WNBlocks.PINEAPPLE_PLANT = new Age2Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("pineapple_plant"),"wildnature:pineapple"),


                WNBlocks.BLACK_TEA_PLANT = new Age2Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("black_tea_plant"),"wildnature:black_tea_leaf"),
                WNBlocks.GREEN_TEA_PLANT = new Age2Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("green_tea_plant"),"wildnature:green_tea_leaf"),
                WNBlocks.MELISSA_PLANT = new Age2Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("melissa_tea_plant"),"wildnature:melissa_tea_leaf"),
                WNBlocks.MINT_PLANT = new BushBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP),null, "wildnature:mint", 1,2,0,Main.RegistryEvents.location("mint_plant")),
                WNBlocks.WHITE_TEA = new Age2Plant(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP), Main.RegistryEvents.location("white_tea_plant"),"wildnature:white_tea_leaf"),




                WNBlocks.MUSHROOM1_PORCINO = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom1")),
                WNBlocks.MUSHROOM2_SLIPPERY_JACK = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom2")),
                WNBlocks.MUSHROOM3_CHAMPIGNON = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom3")),
                WNBlocks.MUSHROOM4_DEATH_CAP = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom4")),
                WNBlocks.MUSHROOM5_TOADSTOOL = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom5")),
                WNBlocks.MUSHROOM6_SAFFRON_MILK_CAP = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom6")),
                WNBlocks.MUSHROOM7_BIRCH_BOLETE = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom7")),
                WNBlocks.MUSHROOM8_BOLETUS = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom8")),
                WNBlocks.MUSHROOM9_CHANTARELLE = new MushroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mushroom9")),





                //UNDERGROUNDS
                WNBlocks.GLOW_SHROOM = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(6),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("glowshroom")),
                WNBlocks.ICE_SHROOM = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(6),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("ice_shroom")),
                WNBlocks.SULFUR_SHROOM = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("sulfur_shroom")),
                WNBlocks.POISON_SHROOM = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("poison_shroom")),
                WNBlocks.MAGMA_SHROOM = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(6),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("magma_shroom")),
                WNBlocks.DRAGON_SHROOM = new CaveShroomBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(3),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("dragon_shroom")),

                WNBlocks.STONE_GRASS = new CaveBush(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("stone_grass"),false),
                WNBlocks.ICE_GRASS = new CaveBush(Block.Properties.create(Material.ICE),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("ice_grass"),false),

                WNBlocks.ICYCLE = new CaveBush(Block.Properties.create(Material.ICE),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("icycle"),true),
                WNBlocks.ROOTS = new CaveBush(Block.Properties.create(Material.WOOD),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("roots"),true),
                WNBlocks.STALACTITE = new CaveBush(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("stalactite"),true),
                WNBlocks.STALAGMITE = new CaveBush(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("stalagmite"),false),

                WNBlocks.LARGE_GLOWSHROOM = new DoubleCaveBushBase(Block.Properties.create(Material.PLANTS).lightValue(10),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("large_glowshroom"),false),
                WNBlocks.LARGE_ICYCLE = new DoubleCaveBushBase(Block.Properties.create(Material.ICE),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("large_icycle"),true),
                WNBlocks.LARGE_ROOT = new DoubleCaveBushBase(Block.Properties.create(Material.WOOD),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("large_root"),true),
                WNBlocks.LARGE_STALACTITE = new DoubleCaveBushBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("large_stalactite"),true),
                WNBlocks.LARGE_STALAGMITE = new DoubleCaveBushBase(Block.Properties.create(Material.ROCK),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("large_stalagmite"),false),

                WNBlocks.GLOW_VINE = new VineBase(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().lightValue(6).sound(SoundType.PLANT),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("glow_vine")),



        };
    }

    public Block[] getFlowers() {
        return flowers;
    }
}
