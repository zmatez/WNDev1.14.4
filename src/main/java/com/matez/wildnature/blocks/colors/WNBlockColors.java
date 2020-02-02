package com.matez.wildnature.blocks.colors;

import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;

public class WNBlockColors {

    public BlockColors colors = Minecraft.getInstance().getBlockColors();
    public WNBlockColors(){
        //foliage: 7842607 default: 4764952
        //grass: 9551193 default: -7423631
        colors.register((p1, p2, p3, p4) -> {
            return p2 != null && p3 != null ? BiomeColors.getFoliageColor(p2, p3) : FoliageColors.getDefault();
        }, WNBlocks.BEECH_LEAVES, WNBlocks.ASPEN_LEAVES, WNBlocks.BAOBAB_LEAVES, WNBlocks.CEDAR_LEAVES, WNBlocks.HORNBEAM_LEAVES, WNBlocks.MAHOGANY_LEAVES, WNBlocks.MANGROVE_LEAVES, WNBlocks.MAPLE_LEAVES, WNBlocks.POPLAR_LEAVES, WNBlocks.WILLOW_LEAVES);

        colors.register((p1, p2, p3, p4) -> {
            return p2 != null && p3 != null ? BiomeColors.getFoliageColor(p2, p3) : FoliageColors.getDefault();
        }, WNBlocks.BEECH_SAPLING, WNBlocks.ASPEN_SAPLING, WNBlocks.BAOBAB_SAPLING, WNBlocks.CEDAR_SAPLING, WNBlocks.HORNBEAM_SAPLING, WNBlocks.MAHOGANY_SAPLING, WNBlocks.MANGROVE_SAPLING, WNBlocks.MAPLE_SAPLING, WNBlocks.POPLAR_SAPLING, WNBlocks.WILLOW_SAPLING);
        
        colors.register((p_210225_0_, p_210225_1_, p_210225_2_, p_210225_3_) -> {
            return p_210225_1_ != null && p_210225_2_ != null ? BiomeColors.getGrassColor(p_210225_1_, p_210225_2_) : GrassColors.get(0.5D, 1.0D);
        }, WNBlocks.BROWN_GRASS_BLOCK, WNBlocks.MOLD_GRASS_BLOCK, WNBlocks.DESERT_GRASS_BLOCK, WNBlocks.DRIED_GRASS_BLOCK, WNBlocks.TROPICAL_GRASS_BLOCK, WNBlocks.OVERGROWN_STONE);

        colors.register((p_210225_0_, p_210225_1_, p_210225_2_, p_210225_3_) -> {
            return p_210225_1_ != null && p_210225_2_ != null ? BiomeColors.getGrassColor(p_210225_1_, p_210225_2_) : GrassColors.get(0.5D, 1.0D);
        }, WNBlocks.HEATHER_PINK, WNBlocks.HEATHER_PURPLE, WNBlocks.HEATHER_WHITE, WNBlocks.HEATHER_YELLOW
                , WNBlocks.BLUEBELL, WNBlocks.FORGET_ME_NOT_BLUE, WNBlocks.FORGET_ME_NOT_PINK, WNBlocks.FORGET_ME_NOT_WHITE
                , WNBlocks.IRIS_PINK, WNBlocks.IRIS_PURPLE, WNBlocks.IRIS_VIOLET, WNBlocks.IRIS_WHITE
                , WNBlocks.LUPINE_BLUE, WNBlocks.LUPINE_PINK, WNBlocks.LUPINE_RED, WNBlocks.LUPINE_VIOLET, WNBlocks.LUPINE_YELLOW
                , WNBlocks.PASQUE_PINK, WNBlocks.PASQUE_PURPLE, WNBlocks.PASQUE_WHITE, WNBlocks.PASQUE_YELLOW
                , WNBlocks.GRASS_FERNSPROUT, WNBlocks.GRASS_FLOWER, WNBlocks.GRASS_WHEAT, WNBlocks.GRASS_THISTLE
                , WNBlocks.WILD_WHEAT, WNBlocks.SMALL_GRASS, WNBlocks.MEDIUM_GRASS, WNBlocks.LEAF_PILE, WNBlocks.CLOVER
                , WNBlocks.AZALEA_ORANGE, WNBlocks.AZALEA_PINK, WNBlocks.AZALEA_PURPLE, WNBlocks.AZALEA_RED, WNBlocks.AZALEA_WHITE, WNBlocks.AZALEA_YELLOW
                , WNBlocks.BUTTERCUP_ORANGE, WNBlocks.BUTTERCUP_YELLOW, WNBlocks.CANA_BULB_ORANGE, WNBlocks.CANA_BULB_PINK
                , WNBlocks.CANA_BULB_RED, WNBlocks.CANA_BULB_YELLOW, WNBlocks.PERENNIAL_BLUE, WNBlocks.PERENNIAL_PINK, WNBlocks.PERENNIAL_VIOLET
                , WNBlocks.VIBURNUM_PINK, WNBlocks.VIBURNUM_WHITE, WNBlocks.RADISSIUM_BLUE, WNBlocks.RADISSIUM_PINK, WNBlocks.RADISSIUM_RED
                , WNBlocks.YEW_BUSH, WNBlocks.BLACKBERRY_BUSH, WNBlocks.POISON_IVY, WNBlocks.LAMPGRASS, WNBlocks.SPIDERGRASS, WNBlocks.BIRD_OF_PARADISE, WNBlocks.LAVENDER, WNBlocks.RAPESEED, WNBlocks.BUSH_BLACK_LILAC);

    }

}
