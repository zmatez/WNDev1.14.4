package com.matez.wildnature.world.gen.structures.nature.woods.citrus;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;

public class citrus2 extends SchemFeature {
    public citrus2(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
    }

    public citrus2(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace, BlockState log, BlockState leaves) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
        LOG = log;
        LEAVES =leaves;
    }

    @Override
    public Set<BlockPos> setBlocks() {

Block(-1,3,-1,LEAVES);
Block(1,3,-1,LEAVES);
Block(-1,4,-1,LEAVES);
Block(0,4,-1,LEAVES);
Block(0,1,0,"wildnature:citrus_log[axis=y]");
Block(0,2,0,"wildnature:citrus_log[axis=y]");
Block(0,3,0,"wildnature:citrus_log[axis=y]");
Block(1,3,0,LEAVES);
Block(-2,4,0,LEAVES);
Block(-1,4,0,"wildnature:citrus_log[axis=x]");
Block(0,4,0,"wildnature:citrus_log[axis=y]");
Block(1,4,0,LEAVES);
Block(-1,5,0,LEAVES);
Block(0,5,0,LEAVES);
Block(-2,3,1,LEAVES);
Block(-1,3,1,LEAVES);
Block(0,3,1,LEAVES);
Block(0,4,1,LEAVES);

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
return super.setBlocks();
    }
}