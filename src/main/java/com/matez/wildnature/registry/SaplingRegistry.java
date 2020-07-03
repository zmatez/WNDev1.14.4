package com.matez.wildnature.registry;

import com.matez.wildnature.Main;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.TreeWeighList;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.world.gen.structures.nature.SchemTree;
import com.matez.wildnature.world.gen.structures.nature.woods.baobab.*;
import com.matez.wildnature.world.gen.structures.nature.woods.beech.*;
import com.matez.wildnature.world.gen.structures.nature.woods.birch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.cedar.*;
import com.matez.wildnature.world.gen.structures.nature.woods.cherry.cherry1;
import com.matez.wildnature.world.gen.structures.nature.woods.cherry.cherry2;
import com.matez.wildnature.world.gen.structures.nature.woods.cherry.cherry3;
import com.matez.wildnature.world.gen.structures.nature.woods.cherry.cherry4;
import com.matez.wildnature.world.gen.structures.nature.woods.citrus.*;
import com.matez.wildnature.world.gen.structures.nature.woods.deco.*;
import com.matez.wildnature.world.gen.structures.nature.woods.ebony.ebony1;
import com.matez.wildnature.world.gen.structures.nature.woods.ebony.ebony2;
import com.matez.wildnature.world.gen.structures.nature.woods.ebony.ebony3;
import com.matez.wildnature.world.gen.structures.nature.woods.ebony.ebony4;
import com.matez.wildnature.world.gen.structures.nature.woods.eucalyptus.*;
import com.matez.wildnature.world.gen.structures.nature.woods.fir.*;
import com.matez.wildnature.world.gen.structures.nature.woods.larch.*;
import com.matez.wildnature.world.gen.structures.nature.woods.mahogany.mahogany1;
import com.matez.wildnature.world.gen.structures.nature.woods.mahogany.mahogany2;
import com.matez.wildnature.world.gen.structures.nature.woods.mahogany.mahogany3;
import com.matez.wildnature.world.gen.structures.nature.woods.mahogany.mahogany4;
import com.matez.wildnature.world.gen.structures.nature.woods.mangrove.*;
import com.matez.wildnature.world.gen.structures.nature.woods.nuytsia.*;
import com.matez.wildnature.world.gen.structures.nature.woods.oak.*;
import com.matez.wildnature.world.gen.structures.nature.woods.orchard.*;
import com.matez.wildnature.world.gen.structures.nature.woods.palm.*;
import com.matez.wildnature.world.gen.structures.nature.woods.pine.*;
import com.matez.wildnature.world.gen.structures.nature.woods.spruce.*;
import com.matez.wildnature.blocks.SaplingBase;
import com.matez.wildnature.world.gen.structures.nature.woods.hornbeam.tree_hornbeam1;
import com.matez.wildnature.world.gen.structures.nature.woods.hornbeam.tree_hornbeam3;
import com.matez.wildnature.world.gen.structures.nature.woods.hornbeam.tree_hornbeam5;
import com.matez.wildnature.world.gen.structures.nature.woods.hornbeam.tree_hornbeam7;
import com.matez.wildnature.world.gen.structures.nature.woods.redwood.tree_redwood1;
import com.matez.wildnature.world.gen.structures.nature.woods.redwood.tree_redwood2;
import com.matez.wildnature.world.gen.structures.nature.woods.redwood.tree_redwood3;
import com.matez.wildnature.world.gen.structures.nature.woods.redwood.tree_redwood4;
import com.matez.wildnature.world.gen.structures.nature.woods.willow.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;
import net.minecraft.item.Item;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class SaplingRegistry {

    private Block[] saplings;

    public SaplingRegistry(){
        TreeWeighList weighList = new TreeWeighList();
        weighList.add(new apple1(NoFeatureConfig::deserialize,false),10);
        weighList.add(new apple2(NoFeatureConfig::deserialize,false),10);
        weighList.add(new apple3(NoFeatureConfig::deserialize,false),10);
        Tree appleTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new oak1(NoFeatureConfig::deserialize,false,Blocks.OAK_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PARADISE_APPLE_LEAVES)),10);
        weighList.add(new oak2(NoFeatureConfig::deserialize,false,Blocks.OAK_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PARADISE_APPLE_LEAVES)),10);
        weighList.add(new oak3(NoFeatureConfig::deserialize,false,Blocks.OAK_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PARADISE_APPLE_LEAVES)),10);
        Tree paradiseAppleTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new tree_birch11(NoFeatureConfig::deserialize,false,Blocks.BIRCH_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.ASPEN_LEAVES)),10);
        weighList.add(new tree_birch12(NoFeatureConfig::deserialize,false,Blocks.BIRCH_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.ASPEN_LEAVES)),10);
        weighList.add(new tree_birch10(NoFeatureConfig::deserialize,false,Blocks.BIRCH_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.ASPEN_LEAVES)),5);

        Tree aspenTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new baobab1(NoFeatureConfig::deserialize,false),10);
        weighList.add(new baobab2(NoFeatureConfig::deserialize,false),10);
        weighList.add(new baobab3(NoFeatureConfig::deserialize,false),10);
        weighList.add(new baobab4(NoFeatureConfig::deserialize,false),10);
        weighList.add(new baobab5(NoFeatureConfig::deserialize,false),10);


        Tree baobabTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new beech1(NoFeatureConfig::deserialize,false),10);
        weighList.add(new beech2(NoFeatureConfig::deserialize,false),10);
        weighList.add(new beech3(NoFeatureConfig::deserialize,false),10);
        weighList.add(new beech4(NoFeatureConfig::deserialize,false),10);
        weighList.add(new beech5(NoFeatureConfig::deserialize,false),10);
        weighList.add(new beech6(NoFeatureConfig::deserialize,false),10);
        weighList.add(new beech7(NoFeatureConfig::deserialize,false),10);
        weighList.add(new beech8(NoFeatureConfig::deserialize,false),10);
        weighList.add(new beech9(NoFeatureConfig::deserialize,false),10);
        weighList.add(new beech10(NoFeatureConfig::deserialize,false),10);
        weighList.add(new beech11(NoFeatureConfig::deserialize,false),10);
        weighList.add(new beech12(NoFeatureConfig::deserialize,false),10);
        Tree beechTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new leafy_beech_1(NoFeatureConfig::deserialize,true,null,SchemFeature.notDecayingLeaf(WNBlocks.PURPLE_BEECH_LEAVES)),10);
        weighList.add(new leafy_beech_2(NoFeatureConfig::deserialize,true,null,SchemFeature.notDecayingLeaf(WNBlocks.PURPLE_BEECH_LEAVES)),10);
        weighList.add(new leafy_beech_3(NoFeatureConfig::deserialize,true,null,SchemFeature.notDecayingLeaf(WNBlocks.PURPLE_BEECH_LEAVES)),10);
        Tree purpleBeechTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new cedar1(NoFeatureConfig::deserialize,false),10);
        weighList.add(new cedar2(NoFeatureConfig::deserialize,false),10);
        weighList.add(new cedar3(NoFeatureConfig::deserialize,false),10);
        weighList.add(new cedar4(NoFeatureConfig::deserialize,false),10);
        weighList.add(new cedar5(NoFeatureConfig::deserialize,false),10);
        weighList.add(new cedar6(NoFeatureConfig::deserialize,false),10);
        weighList.add(new cedar7(NoFeatureConfig::deserialize,false),10);
        weighList.add(new cedar8(NoFeatureConfig::deserialize,false),10);


        Tree cedarTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new cherry1(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_LEAVES)),10);
        weighList.add(new cherry2(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_LEAVES)),10);
        weighList.add(new cherry3(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_LEAVES)),10);
        weighList.add(new cherry4(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_LEAVES)),10);
        weighList.add(new tree_oak2(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_LEAVES)),10);
        weighList.add(new tree_oak5(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_LEAVES)),10);
        Tree cherryTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new cherry1(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_PINK_LEAVES)),10);
        weighList.add(new cherry2(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_PINK_LEAVES)),10);
        weighList.add(new cherry3(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_PINK_LEAVES)),10);
        weighList.add(new cherry4(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_PINK_LEAVES)),10);
        weighList.add(new tree_oak2(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_PINK_LEAVES)),10);
        weighList.add(new tree_oak5(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_PINK_LEAVES)),10);
        Tree cherryPinkTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new cherry1(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_WHITE_LEAVES)),10);
        weighList.add(new cherry2(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_WHITE_LEAVES)),10);
        weighList.add(new cherry3(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_WHITE_LEAVES)),10);
        weighList.add(new cherry4(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_WHITE_LEAVES)),10);
        weighList.add(new tree_oak2(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_WHITE_LEAVES)),10);
        weighList.add(new tree_oak5(NoFeatureConfig::deserialize,false, WNBlocks.CHERRY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.CHERRY_WHITE_LEAVES)),10);

        Tree cherryWhiteTrees = new SchemTree(weighList);

        weighList = new TreeWeighList();

        weighList.add(new ebony1(NoFeatureConfig::deserialize,false, WNBlocks.EBONY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.EBONY_LEAVES)),10);
        weighList.add(new ebony2(NoFeatureConfig::deserialize,false, WNBlocks.EBONY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.EBONY_LEAVES)),10);
        weighList.add(new ebony3(NoFeatureConfig::deserialize,false, WNBlocks.EBONY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.EBONY_LEAVES)),10);
        weighList.add(new ebony4(NoFeatureConfig::deserialize,false, WNBlocks.EBONY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.EBONY_LEAVES)),10);

        Tree ebonyTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new eucalyptus_1(NoFeatureConfig::deserialize,false),10);
        weighList.add(new eucalyptus_2(NoFeatureConfig::deserialize,false),10);
        weighList.add(new eucalyptus_3(NoFeatureConfig::deserialize,false),10);
        weighList.add(new eucalyptus_4(NoFeatureConfig::deserialize,false),10);
        weighList.add(new eucalyptus_5(NoFeatureConfig::deserialize,false),10);
        weighList.add(new eucalyptus_6(NoFeatureConfig::deserialize,false),10);
        weighList.add(new eucalyptus_7(NoFeatureConfig::deserialize,false),10);
        weighList.add(new eucalyptus_8(NoFeatureConfig::deserialize,false),10);
        weighList.add(new eucalyptus_9(NoFeatureConfig::deserialize,false),10);
        weighList.add(new eucalyptus_10(NoFeatureConfig::deserialize,false),10);


        Tree eucalyptusTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_taiga14(NoFeatureConfig::deserialize,false,Blocks.SPRUCE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),10);
        weighList.add(new tree_taiga15(NoFeatureConfig::deserialize,false,Blocks.SPRUCE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),10);
        weighList.add(new tree_taiga16(NoFeatureConfig::deserialize,false,Blocks.SPRUCE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),10);
        weighList.add(new tree_taiga17(NoFeatureConfig::deserialize,false,Blocks.SPRUCE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),10);
        weighList.add(new tree_taiga18(NoFeatureConfig::deserialize,false,Blocks.SPRUCE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),10);
        weighList.add(new tree_fir1(NoFeatureConfig::deserialize,false,Blocks.SPRUCE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),10);
        weighList.add(new tree_fir9(NoFeatureConfig::deserialize,false,Blocks.SPRUCE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),10);
        weighList.add(new tree_fir18(NoFeatureConfig::deserialize,false,Blocks.SPRUCE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.FIR_LEAVES)),2);


        Tree firTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new silver_fir1(NoFeatureConfig::deserialize,false),10);
        weighList.add(new silver_fir2(NoFeatureConfig::deserialize,false),10);
        weighList.add(new silver_fir3(NoFeatureConfig::deserialize,false),10);
        weighList.add(new silver_fir4(NoFeatureConfig::deserialize,false),10);


        Tree firSilverTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_oak20(NoFeatureConfig::deserialize,false,Blocks.OAK_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.HAZEL_LEAVES)),10);
        weighList.add(new tree_oak21(NoFeatureConfig::deserialize,false,Blocks.OAK_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.HAZEL_LEAVES)),10);
        weighList.add(new tree_oak3(NoFeatureConfig::deserialize,false,Blocks.OAK_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.HAZEL_LEAVES)),10);

        Tree hazelTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_hornbeam1(NoFeatureConfig::deserialize,false,Blocks.OAK_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.HORNBEAM_LEAVES)),10);
        weighList.add(new tree_hornbeam3(NoFeatureConfig::deserialize,false,Blocks.OAK_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.HORNBEAM_LEAVES)),10);
        weighList.add(new tree_hornbeam5(NoFeatureConfig::deserialize,false,Blocks.OAK_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.HORNBEAM_LEAVES)),10);
        weighList.add(new tree_hornbeam7(NoFeatureConfig::deserialize,false,Blocks.OAK_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.HORNBEAM_LEAVES)),10);
        Tree hornbeamTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new cherry1(NoFeatureConfig::deserialize,false, WNBlocks.JACARANDA_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.JACARANDA_LEAVES)),10);
        weighList.add(new cherry2(NoFeatureConfig::deserialize,false, WNBlocks.JACARANDA_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.JACARANDA_LEAVES)),10);
        weighList.add(new cherry3(NoFeatureConfig::deserialize,false, WNBlocks.JACARANDA_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.JACARANDA_LEAVES)),10);
        weighList.add(new cherry4(NoFeatureConfig::deserialize,false, WNBlocks.JACARANDA_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.JACARANDA_LEAVES)),10);

        Tree jacarandaTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_larch1(NoFeatureConfig::deserialize,false, WNBlocks.LARCH_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);
        weighList.add(new tree_larch2(NoFeatureConfig::deserialize,false, WNBlocks.LARCH_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);
        weighList.add(new tree_larch3(NoFeatureConfig::deserialize,false, WNBlocks.LARCH_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);
        weighList.add(new tree_larch5(NoFeatureConfig::deserialize,false, WNBlocks.LARCH_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);
        weighList.add(new tree_larch6(NoFeatureConfig::deserialize,false, WNBlocks.LARCH_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);
        weighList.add(new tree_larch7(NoFeatureConfig::deserialize,false, WNBlocks.LARCH_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);
        weighList.add(new tree_larch8(NoFeatureConfig::deserialize,false, WNBlocks.LARCH_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);
        weighList.add(new tree_larch9(NoFeatureConfig::deserialize,false, WNBlocks.LARCH_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.LARCH_LEAVES)),10);


        Tree larchTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new mahogany1(NoFeatureConfig::deserialize,true, WNBlocks.MAHOGANY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAHOGANY_LEAVES)),10);
        weighList.add(new mahogany2(NoFeatureConfig::deserialize,true, WNBlocks.MAHOGANY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAHOGANY_LEAVES)),10);
        weighList.add(new mahogany3(NoFeatureConfig::deserialize,true, WNBlocks.MAHOGANY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAHOGANY_LEAVES)),10);
        weighList.add(new mahogany4(NoFeatureConfig::deserialize,true, WNBlocks.MAHOGANY_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAHOGANY_LEAVES)),10);

        Tree mahoganyTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new mangrove1(NoFeatureConfig::deserialize,false, WNBlocks.MANGROVE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MANGROVE_LEAVES)),10);
        weighList.add(new mangrove2(NoFeatureConfig::deserialize,false, WNBlocks.MANGROVE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MANGROVE_LEAVES)),10);
        weighList.add(new mangrove3(NoFeatureConfig::deserialize,false, WNBlocks.MANGROVE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MANGROVE_LEAVES)),10);
        weighList.add(new mangrove4(NoFeatureConfig::deserialize,false, WNBlocks.MANGROVE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MANGROVE_LEAVES)),10);
        weighList.add(new mangrove5(NoFeatureConfig::deserialize,false, WNBlocks.MANGROVE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MANGROVE_LEAVES)),10);

        Tree mangroveTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_oak8(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_LEAVES)),10);
        weighList.add(new tree_oak9(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_LEAVES)),10);
        weighList.add(new tree_oak10(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_LEAVES)),10);
        weighList.add(new tree_oak11(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_LEAVES)),10);


        Tree mapleTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_oak8(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)),10);
        weighList.add(new tree_oak9(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)),10);
        weighList.add(new tree_oak10(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)),10);
        weighList.add(new tree_oak11(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_RED_LEAVES)),10);


        Tree mapleRedTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_oak8(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)),10);
        weighList.add(new tree_oak9(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)),10);
        weighList.add(new tree_oak10(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)),10);
        weighList.add(new tree_oak11(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_ORANGE_LEAVES)),10);


        Tree mapleOrangeTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_oak8(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)),10);
        weighList.add(new tree_oak9(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)),10);
        weighList.add(new tree_oak10(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)),10);
        weighList.add(new tree_oak11(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_YELLOW_LEAVES)),10);


        Tree mapleYellowTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_oak8(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)),10);
        weighList.add(new tree_oak9(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)),10);
        weighList.add(new tree_oak10(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)),10);
        weighList.add(new tree_oak11(NoFeatureConfig::deserialize,false, WNBlocks.MAPLE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MAPLE_BROWN_LEAVES)),10);


        Tree mapleBrownTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_palm1(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm2(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm3(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm4(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm5(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm6(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm7(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm8(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm9(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm10(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm11(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm12(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm13(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm14(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm15(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm16(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);
        weighList.add(new tree_palm17(NoFeatureConfig::deserialize,false, WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PALM_LEAVES)),10);

        Tree palmTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new pear1(NoFeatureConfig::deserialize,false),10);
        weighList.add(new pear2(NoFeatureConfig::deserialize,false),10);
        weighList.add(new pear3(NoFeatureConfig::deserialize,false),10);
        Tree pearTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_pine1(NoFeatureConfig::deserialize,false,Blocks.SPRUCE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),10);
        weighList.add(new tree_pine2(NoFeatureConfig::deserialize,false,Blocks.SPRUCE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),10);
        weighList.add(new tree_pine3(NoFeatureConfig::deserialize,false,Blocks.SPRUCE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),10);
        weighList.add(new tree_pine4(NoFeatureConfig::deserialize,false,Blocks.SPRUCE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),10);
        weighList.add(new tree_pine5(NoFeatureConfig::deserialize,false,Blocks.SPRUCE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),10);
        weighList.add(new tree_pine6(NoFeatureConfig::deserialize,false,Blocks.SPRUCE_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PINE_LEAVES)),10);

        Tree pineTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_oak22(NoFeatureConfig::deserialize,false, WNBlocks.PLUM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PLUM_LEAVES)),10);
        weighList.add(new tree_oak5(NoFeatureConfig::deserialize,false, WNBlocks.PLUM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PLUM_LEAVES)),10);

        Tree plumTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_oak22(NoFeatureConfig::deserialize,false, WNBlocks.PLUM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MIRABELLE_PLUM_LEAVES)),10);
        weighList.add(new tree_oak5(NoFeatureConfig::deserialize,false, WNBlocks.PLUM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MIRABELLE_PLUM_LEAVES)),10);

        Tree mirabellePlumTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_birch10(NoFeatureConfig::deserialize,false,Blocks.OAK_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.POPLAR_LEAVES)),10);

        Tree poplarTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_redwood1(NoFeatureConfig::deserialize,false, WNBlocks.REDWOOD_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.REDWOOD_LEAVES)),10);
        weighList.add(new tree_redwood2(NoFeatureConfig::deserialize,false, WNBlocks.REDWOOD_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.REDWOOD_LEAVES)),10);
        weighList.add(new tree_redwood3(NoFeatureConfig::deserialize,false, WNBlocks.REDWOOD_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.REDWOOD_LEAVES)),10);
        weighList.add(new tree_redwood4(NoFeatureConfig::deserialize,false, WNBlocks.REDWOOD_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.REDWOOD_LEAVES)),10);

        Tree redwoodTrees = new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new tree_oak18(NoFeatureConfig::deserialize,false,Blocks.OAK_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.ROWAN_LEAVES_RED)),10);
        weighList.add(new tree_oak19(NoFeatureConfig::deserialize,false,Blocks.OAK_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.ROWAN_LEAVES_RED)),10);
        Tree rowanTreesRed = new SchemTree(weighList);

        weighList.add(new tree_oak18(NoFeatureConfig::deserialize,false,Blocks.OAK_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.ROWAN_LEAVES_ORANGE)),10);
        weighList.add(new tree_oak19(NoFeatureConfig::deserialize,false,Blocks.OAK_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.ROWAN_LEAVES_ORANGE)),10);
        Tree rowanTreesOrange = new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new tree_willow1(NoFeatureConfig::deserialize,false,WNBlocks.WILLOW_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow2(NoFeatureConfig::deserialize,false,WNBlocks.WILLOW_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow3(NoFeatureConfig::deserialize,false,WNBlocks.WILLOW_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow4(NoFeatureConfig::deserialize,false,WNBlocks.WILLOW_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow5(NoFeatureConfig::deserialize,false,WNBlocks.WILLOW_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow6(NoFeatureConfig::deserialize,false,WNBlocks.WILLOW_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow7(NoFeatureConfig::deserialize,false,WNBlocks.WILLOW_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow8(NoFeatureConfig::deserialize,false,WNBlocks.WILLOW_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow9(NoFeatureConfig::deserialize,false,WNBlocks.WILLOW_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow10(NoFeatureConfig::deserialize,false,WNBlocks.WILLOW_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow11(NoFeatureConfig::deserialize,false,WNBlocks.WILLOW_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow12(NoFeatureConfig::deserialize,false,WNBlocks.WILLOW_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        weighList.add(new tree_willow13(NoFeatureConfig::deserialize,false,WNBlocks.WILLOW_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.WILLOW_LEAVES)),10);
        Tree willowTrees = new SchemTree(weighList);

        //CITRUS
        weighList = new TreeWeighList();
        weighList.add(new citrus1(NoFeatureConfig::deserialize,false,WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.LEMON_LEAVES)),10);
        weighList.add(new citrus2(NoFeatureConfig::deserialize,false,WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.LEMON_LEAVES)),10);
        Tree lemonTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new citrus1(NoFeatureConfig::deserialize,false,WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.ORANGE_LEAVES)),10);
        weighList.add(new citrus3(NoFeatureConfig::deserialize,false,WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.ORANGE_LEAVES)),10);

        Tree orangeTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new citrus2(NoFeatureConfig::deserialize,false,WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.GRAPE_FRUIT_LEAVES)),10);
        weighList.add(new citrus4(NoFeatureConfig::deserialize,false,WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.GRAPE_FRUIT_LEAVES)),10);
        Tree grapefruitTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new banana1(NoFeatureConfig::deserialize,false,WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.BANANA_LEAVES)),10);
        weighList.add(new banana2(NoFeatureConfig::deserialize,false,WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.BANANA_LEAVES)),10);
        weighList.add(new banana3(NoFeatureConfig::deserialize,false,WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.BANANA_LEAVES)),10);
        weighList.add(new banana4(NoFeatureConfig::deserialize,false,WNBlocks.PALM_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.BANANA_LEAVES)),10);

        Tree bananaTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new citrus1(NoFeatureConfig::deserialize,false,WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.LIME_LEAVES)),10);
        weighList.add(new citrus2(NoFeatureConfig::deserialize,false,WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.LIME_LEAVES)),10);

        Tree limeTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new olive1(NoFeatureConfig::deserialize,false),10);
        weighList.add(new olive2(NoFeatureConfig::deserialize,false),10);
        weighList.add(new olive3(NoFeatureConfig::deserialize,false),10);
        weighList.add(new olive4(NoFeatureConfig::deserialize,false),10);
        Tree oliveTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new citrus1(NoFeatureConfig::deserialize,false,WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PEACH_LEAVES)),10);
        weighList.add(new citrus3(NoFeatureConfig::deserialize,false,WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.PEACH_LEAVES)),10);

        Tree peachTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new citrus3(NoFeatureConfig::deserialize,false,WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.POMEGRANATE_LEAVES)),10);
        weighList.add(new citrus4(NoFeatureConfig::deserialize,false,WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.POMEGRANATE_LEAVES)),10);

        Tree pomegranateTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();

        weighList.add(new citrus1(NoFeatureConfig::deserialize,false,WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MANGO_LEAVES)),10);
        weighList.add(new citrus2(NoFeatureConfig::deserialize,false,WNBlocks.CITRUS_LOG.getDefaultState(),SchemFeature.notDecayingLeaf(WNBlocks.MANGO_LEAVES)),10);

        Tree mangoTrees= new SchemTree(weighList);

        weighList.add(new nuytsia1(NoFeatureConfig::deserialize,false),10);
        weighList.add(new nuytsia2(NoFeatureConfig::deserialize,false),10);
        weighList.add(new nuytsia3(NoFeatureConfig::deserialize,false),10);
        weighList.add(new nuytsia4(NoFeatureConfig::deserialize,false),10);
        weighList.add(new nuytsia5(NoFeatureConfig::deserialize,false),10);
        weighList.add(new nuytsia6(NoFeatureConfig::deserialize,false),10);
        Tree nuytsiaTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new magnolia1(NoFeatureConfig::deserialize,false),10);
        weighList.add(new magnolia2(NoFeatureConfig::deserialize,false),10);
        weighList.add(new magnolia3(NoFeatureConfig::deserialize,false),10);
        weighList.add(new magnolia4(NoFeatureConfig::deserialize,false),10);
        weighList.add(new magnolia5(NoFeatureConfig::deserialize,false),10);
        Tree magnoliaTrees= new SchemTree(weighList);
        weighList = new TreeWeighList();
        weighList.add(new forsythia1(NoFeatureConfig::deserialize,false),10);
        weighList.add(new forsythia2(NoFeatureConfig::deserialize,false),10);
        weighList.add(new forsythia3(NoFeatureConfig::deserialize,false),10);
        weighList.add(new forsythia4(NoFeatureConfig::deserialize,false),10);
        weighList.add(new forsythia5(NoFeatureConfig::deserialize,false),10);
        Tree forsythiaTrees= new SchemTree(weighList);
        saplings = new Block[]{
                WNBlocks.APPLE_SAPLING = new SaplingBase(appleTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("apple_sapling")),
                WNBlocks.PARADISE_APPLE_SAPLING = new SaplingBase(paradiseAppleTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("paradise_apple_sapling")),
                WNBlocks.ASPEN_SAPLING = new SaplingBase(aspenTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("aspen_sapling")),
                WNBlocks.BAOBAB_SAPLING = new SaplingBase(baobabTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("baobab_sapling")),
                WNBlocks.BEECH_SAPLING = new SaplingBase(beechTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("beech_sapling")),
                WNBlocks.PURPLE_BEECH_SAPLING = new SaplingBase(purpleBeechTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("purple_beech_sapling")),
                WNBlocks.CEDAR_SAPLING = new SaplingBase(cedarTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cedar_sapling")),
                WNBlocks.CHERRY_SAPLING = new SaplingBase(cherryTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cherry_sapling")),
                WNBlocks.CHERRY_PINK_SAPLING = new SaplingBase(cherryPinkTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cherry_pink_sapling")),
                WNBlocks.CHERRY_WHITE_SAPLING = new SaplingBase(cherryWhiteTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("cherry_white_sapling")),
                WNBlocks.EBONY_SAPLING = new SaplingBase(ebonyTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("ebony_sapling")),
                WNBlocks.EUCALYPTUS_SAPLING = new SaplingBase(eucalyptusTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("eucalyptus_sapling")),
                WNBlocks.FIR_SAPLING = new SaplingBase(firTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("fir_sapling")),
                WNBlocks.FIR_SILVER_SAPLING = new SaplingBase(firSilverTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("fir_silver_sapling")),
                WNBlocks.HAZEL_SAPLING = new SaplingBase(hazelTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hazel_sapling")),
                WNBlocks.HORNBEAM_SAPLING = new SaplingBase(hornbeamTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("hornbeam_sapling")),
                WNBlocks.JACARANDA_SAPLING = new SaplingBase(jacarandaTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("jacaranda_sapling")),
                WNBlocks.LARCH_SAPLING = new SaplingBase(larchTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("larch_sapling")),
                WNBlocks.MAHOGANY_SAPLING = new SaplingBase(mahoganyTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mahogany_sapling")),
                WNBlocks.MANGROVE_SAPLING = new SaplingBase(mangroveTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mangrove_sapling")),
                WNBlocks.MAPLE_SAPLING = new SaplingBase(mapleTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("maple_sapling")),
                WNBlocks.MAPLE_RED_SAPLING = new SaplingBase(mapleRedTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("maple_red_sapling")),
                WNBlocks.MAPLE_ORANGE_SAPLING = new SaplingBase(mapleOrangeTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("maple_orange_sapling")),
                WNBlocks.MAPLE_YELLOW_SAPLING = new SaplingBase(mapleYellowTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("maple_yellow_sapling")),
                WNBlocks.MAPLE_BROWN_SAPLING = new SaplingBase(mapleBrownTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("maple_brown_sapling")),
                WNBlocks.PALM_SAPLING = new SaplingBase(palmTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("palm_sapling")),
                WNBlocks.PEAR_SAPLING = new SaplingBase(pearTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("pear_sapling")),
                WNBlocks.PINE_SAPLING = new SaplingBase(pineTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("pine_sapling")),
                WNBlocks.PLUM_SAPLING = new SaplingBase(plumTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("plum_sapling")),
                WNBlocks.MIRABELLE_PLUM_SAPLING = new SaplingBase(mirabellePlumTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mirabelle_plum_sapling")),
                WNBlocks.POPLAR_SAPLING = new SaplingBase(poplarTrees, Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(), new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("poplar_sapling")),
                WNBlocks.REDWOOD_SAPLING = new SaplingBase(redwoodTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("redwood_sapling")),
                WNBlocks.ROWAN_SAPLING_RED = new SaplingBase(rowanTreesRed,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("rowan_sapling_red")),
                WNBlocks.ROWAN_SAPLING_ORANGE = new SaplingBase(rowanTreesOrange,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("rowan_sapling_orange")),
                WNBlocks.WILLOW_SAPLING = new SaplingBase(willowTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("willow_sapling")),
                WNBlocks.LEMON_SAPLING = new SaplingBase(lemonTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lemon_sapling")),
                WNBlocks.ORANGE_SAPLING = new SaplingBase(orangeTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("orange_sapling")),
                WNBlocks.GRAPE_FRUIT_SAPLING = new SaplingBase(grapefruitTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("grape_fruit_sapling")),
                WNBlocks.BANANA_SAPLING = new SaplingBase(bananaTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("banana_sapling")),
                WNBlocks.LIME_SAPLING = new SaplingBase(limeTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("lime_sapling")),
                WNBlocks.OLIVE_SAPLING = new SaplingBase(oliveTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("olive_sapling")),
                WNBlocks.PEACH_SAPLING = new SaplingBase(peachTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("peach_sapling")),
                WNBlocks.POMEGRANATE_SAPLING = new SaplingBase(pomegranateTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("pomegranate_sapling")),
                WNBlocks.MANGO_SAPLING = new SaplingBase(mangoTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("mango_sapling")),
                WNBlocks.NUYTSIA_SAPLING = new SaplingBase(nuytsiaTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("nuytsia_sapling")),
                WNBlocks.MAGNOLIA_SAPLING = new SaplingBase(magnoliaTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("magnolia_sapling")),
                WNBlocks.FORSYTHIA_SAPLING = new SaplingBase(forsythiaTrees,Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).doesNotBlockMovement(),new Item.Properties().group(Main.WILDNATURE_GROUP), Main.RegistryEvents.location("forsythia_sapling"))


        };
    }

    public Block[] getSaplings() {
        return saplings;
    }
}
