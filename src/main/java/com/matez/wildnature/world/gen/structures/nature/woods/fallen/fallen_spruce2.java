package com.matez.wildnature.world.gen.structures.nature.woods.fallen;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;

public class fallen_spruce2 extends SchemFeature {
    public fallen_spruce2(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
        terrainIncrease=1;
    }

    public fallen_spruce2(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace, BlockState log, BlockState leaves) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
        terrainIncrease=1;
        LOG = log;
        LEAVES =leaves;
    }

    @Override
    public Set<BlockPos> setBlocks() {

Block(2,1,-3,"minecraft:spruce_leaves[distance=1,persistent=true]");
Block(0,1,-2,"minecraft:spruce_leaves[distance=2,persistent=true]");
Block(1,1,-2,"minecraft:spruce_leaves[distance=1,persistent=true]");
Block(2,1,-2,"minecraft:spruce_log[axis=z]");
Block(3,1,-2,"minecraft:spruce_leaves[distance=1,persistent=true]");
Block(2,2,-2,"minecraft:spruce_leaves[distance=1,persistent=true]");
Block(2,1,-1,"minecraft:spruce_log[axis=z]");
Block(3,1,-1,"minecraft:spruce_leaves[distance=1,persistent=true]");
Block(2,2,-1,"minecraft:spruce_leaves[distance=1,persistent=true]");
Block(-2,1,0,"minecraft:spruce_leaves[distance=7,persistent=true]");
Block(0,1,0,"minecraft:spruce_log[axis=z]");
Block(2,1,0,"minecraft:spruce_log[axis=z]");
Block(4,1,0,"minecraft:spruce_leaves[distance=7,persistent=true]");
Block(0,2,0,"minecraft:spruce_leaves[distance=1,persistent=true]");
Block(0,3,0,"minecraft:spruce_leaves[distance=2,persistent=true]");
Block(0,1,1,"minecraft:spruce_log[axis=z]");
Block(1,1,1,"minecraft:spruce_leaves[distance=1,persistent=true]");
Block(-1,1,2,"minecraft:spruce_leaves[distance=1,persistent=true]");
Block(0,1,2,"minecraft:spruce_log[axis=z]");
Block(0,2,2,"minecraft:spruce_leaves[distance=1,persistent=true]");
Block(-2,1,3,"minecraft:spruce_leaves[distance=7,persistent=true]");
Block(0,1,3,"minecraft:spruce_log[axis=z]");
Block(1,1,3,"minecraft:spruce_leaves[distance=1,persistent=true]");
Block(0,2,3,"minecraft:spruce_leaves[distance=1,persistent=true]");
Block(-1,1,4,"minecraft:spruce_leaves[distance=1,persistent=true]");
Block(0,1,4,"minecraft:spruce_log[axis=z]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
return super.setBlocks();
    }
}