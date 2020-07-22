package com.matez.wildnature.world.gen.structures.nature.woods.fallen;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;

public class fallen_oak1 extends SchemFeature {
    public fallen_oak1(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
        terrainIncrease=1;
    }

    public fallen_oak1(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace, BlockState log, BlockState leaves) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
        terrainIncrease=1;
        LOG = log;
        LEAVES =leaves;
    }

    @Override
    public Set<BlockPos> setBlocks() {


//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
return super.setBlocks();
    }
}