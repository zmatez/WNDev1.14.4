package com.matez.wildnature.world.gen.structures.nature.woods.mini_pine;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;


public class mini_bald_pine2 extends SchemFeature {
    public mini_bald_pine2(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
    }

    public mini_bald_pine2(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace, BlockState log, BlockState leaves) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
        LOG = log;
        LEAVES =leaves;
    }

    @Override
    public Set<BlockPos> setBlocks() {

Block(0,2,-1,"wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
Block(-1,4,-1,"wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
Block(0,4,-1,"wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
Block(1,4,-1,"wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
Block(0,5,-1,"wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
Block(0,1,0,"minecraft:spruce_log[axis=y]");
Block(-1,2,0,"wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
Block(0,2,0,"minecraft:spruce_log[axis=y]");
Block(1,2,0,"wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
Block(0,3,0,"minecraft:spruce_log[axis=y]");
Block(-1,4,0,"wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
Block(0,4,0,"minecraft:spruce_log[axis=y]");
Block(1,4,0,"wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
Block(-1,5,0,"wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
Block(0,5,0,"minecraft:spruce_log[axis=y]");
Block(1,5,0,"wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
Block(0,6,0,"wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
Block(0,7,0,"wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
Block(0,2,1,"wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
Block(-1,4,1,"wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
Block(0,4,1,"wildnature:pine_leaves[distance=1,persistent=true,stage=0]");
Block(1,4,1,"wildnature:pine_leaves[distance=2,persistent=true,stage=0]");
Block(0,5,1,"wildnature:pine_leaves[distance=1,persistent=true,stage=0]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
return super.setBlocks();
    }
}