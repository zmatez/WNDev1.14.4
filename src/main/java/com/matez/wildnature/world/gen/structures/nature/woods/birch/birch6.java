package com.matez.wildnature.world.gen.structures.nature.woods.birch;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;

public class birch6 extends SchemFeature {
    public birch6(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
    }

    public birch6(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace, BlockState log, BlockState leaves) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
        LOG = log;
        LEAVES =leaves;
    }

    @Override
    public Set<BlockPos> setBlocks() {

Block(1,8,-3,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,9,-3,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(0,8,-2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,8,-2,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(2,8,-2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,9,-2,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(1,9,-2,"minecraft:birch_log[axis=y]");
Block(2,9,-2,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(-2,10,-2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,10,-2,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(1,11,-2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,1,-1,"minecraft:birch_log[axis=x]");
Block(1,1,-1,"minecraft:birch_log[axis=z]");
Block(1,2,-1,"minecraft:birch_log[axis=y]");
Block(-2,8,-1,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(-1,8,-1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,8,-1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(1,8,-1,"minecraft:birch_log[axis=z]");
Block(2,8,-1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(-3,9,-1,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(-2,9,-1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-1,9,-1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(1,9,-1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(2,9,-1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-3,10,-1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-2,10,-1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(-1,10,-1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,10,-1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,10,-1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(-2,11,-1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,11,-1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,11,-1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(2,11,-1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-1,1,0,"minecraft:birch_log[axis=x]");
Block(0,1,0,"minecraft:birch_log[axis=x]");
Block(1,1,0,"minecraft:birch_log[axis=y]");
Block(2,1,0,"minecraft:birch_log[axis=x]");
Block(0,2,0,"minecraft:birch_log[axis=y]");
Block(1,2,0,"minecraft:birch_log[axis=y]");
Block(0,3,0,"minecraft:birch_log[axis=y]");
Block(1,3,0,"minecraft:birch_log[axis=y]");
Block(1,4,0,"minecraft:birch_log[axis=y]");
Block(1,5,0,"minecraft:birch_log[axis=y]");
Block(1,6,0,"minecraft:birch_log[axis=y]");
Block(1,7,0,"minecraft:birch_log[axis=y]");
Block(-2,8,0,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-1,8,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(1,8,0,"minecraft:birch_log[axis=y]");
Block(-3,9,0,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-2,9,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(-1,9,0,"minecraft:birch_log[axis=x]");
Block(0,9,0,"minecraft:birch_log[axis=x]");
Block(1,9,0,"minecraft:birch_log[axis=y]");
Block(-3,10,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(-2,10,0,"minecraft:birch_log[axis=y]");
Block(-1,10,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(0,10,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(1,10,0,"minecraft:birch_log[axis=y]");
Block(-2,11,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(-1,11,0,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,11,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(1,11,0,"minecraft:birch_log[axis=y]");
Block(2,11,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(0,12,0,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,12,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(0,1,1,"minecraft:birch_log[axis=x]");
Block(1,1,1,"minecraft:birch_log[axis=y]");
Block(0,2,1,"minecraft:birch_log[axis=y]");
Block(1,2,1,"minecraft:birch_log[axis=y]");
Block(1,3,1,"minecraft:birch_log[axis=y]");
Block(-2,8,1,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(-2,9,1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-1,9,1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(1,9,1,"minecraft:birch_log[axis=z]");
Block(2,9,1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(-3,10,1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-2,10,1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(-1,10,1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,10,1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,10,1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(2,10,1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,11,1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,11,1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(2,11,1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,12,1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,1,2,"minecraft:birch_log[axis=x]");
Block(0,9,2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,9,2,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(2,9,2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-1,10,2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,10,2,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(1,10,2,"minecraft:birch_log[axis=y]");
Block(2,10,2,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(3,10,2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,11,2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,11,2,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(2,11,2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,12,2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,10,3,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,10,3,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(2,10,3,"minecraft:birch_leaves[distance=2,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
return super.setBlocks();
    }
}