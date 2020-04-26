package com.matez.wildnature.world.gen.structures.nature.woods.oaklands;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;

public class oaklands_shrub5 extends SchemFeature {
    public oaklands_shrub5(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
    }

    public oaklands_shrub5(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace, BlockState log, BlockState leaves) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
        LOG = log;
        LEAVES =leaves;
    }

    @Override
    public Set<BlockPos> setBlocks() {

Block(0,1,-3,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(1,1,-3,"minecraft:birch_leaves[distance=4,persistent=true]");
Block(-1,2,-3,"minecraft:birch_leaves[distance=4,persistent=true]");
Block(0,2,-3,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(1,2,-3,"minecraft:birch_leaves[distance=4,persistent=true]");
Block(-1,1,-2,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(0,1,-2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-1,2,-2,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(0,2,-2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,2,-2,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(2,2,-2,"minecraft:birch_leaves[distance=4,persistent=true]");
Block(0,3,-2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,3,-2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-2,1,-1,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(-1,1,-1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,1,-1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(3,1,-1,"minecraft:birch_leaves[distance=4,persistent=true]");
Block(-2,2,-1,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(-1,2,-1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,2,-1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(1,2,-1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(2,2,-1,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(-2,3,-1,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(-1,3,-1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,3,-1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(1,3,-1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(-1,4,-1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,4,-1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(1,4,-1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-2,1,0,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-1,1,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(0,1,0,"minecraft:oak_log[axis=y]");
Block(1,1,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(2,1,0,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(3,1,0,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(-2,2,0,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-1,2,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(0,2,0,"minecraft:oak_log[axis=y]");
Block(1,2,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(2,2,0,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-2,3,0,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(-1,3,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(0,3,0,"minecraft:oak_log[axis=y]");
Block(1,3,0,"minecraft:oak_log[axis=x]");
Block(2,3,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(-1,4,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(0,4,0,"minecraft:oak_log[axis=y]");
Block(1,4,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(0,5,0,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(2,1,1,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(-2,2,1,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(-1,2,1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,2,1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(1,2,1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(2,2,1,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(-1,3,1,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(0,3,1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(1,3,1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(0,4,1,"minecraft:birch_leaves[distance=1,persistent=true]");
Block(-1,2,2,"minecraft:birch_leaves[distance=3,persistent=true]");
Block(0,2,2,"minecraft:birch_leaves[distance=2,persistent=true]");
Block(1,2,2,"minecraft:birch_leaves[distance=3,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
return super.setBlocks();
    }
}