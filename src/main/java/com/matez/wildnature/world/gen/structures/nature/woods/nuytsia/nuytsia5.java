package com.matez.wildnature.world.gen.structures.nature.woods.nuytsia;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;


public class nuytsia5 extends SchemFeature {
    public nuytsia5(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
    }

    public nuytsia5(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace, BlockState log, BlockState leaves) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
        LOG = log;
        LEAVES =leaves;
    }

    @Override
    public Set<BlockPos> setBlocks() {

Block(-3,7,-3,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,4,-2,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(-3,7,-2,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,8,-2,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,3,-1,"wildnature:nuytsia_leaves[distance=1,persistent=true]");
Block(-1,4,-1,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,4,-1,"wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
Block(1,4,-1,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,5,-1,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(-3,6,-1,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(-4,7,-1,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(-3,7,-1,"wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
Block(-2,7,-1,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(-3,8,-1,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,8,-1,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,1,0,"wildnature:rosaceae_log[axis=y]");
Block(0,2,0,"wildnature:rosaceae_log[axis=y]");
Block(0,3,0,"wildnature:rosaceae_log[axis=y]");
Block(0,4,0,"wildnature:rosaceae_log[axis=y]");
Block(-3,6,0,"wildnature:rosaceae_branch[down=false,east=true,north=true,south=false,up=true,waterlogged=false,west=false]");
Block(-2,6,0,"wildnature:rosaceae_branch[down=false,east=false,north=false,south=true,up=true,waterlogged=false,west=true]");
Block(-4,7,0,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(-3,7,0,"wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
Block(-2,7,0,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,7,0,"wildnature:nuytsia_leaves[distance=1,persistent=true]");
Block(-3,8,0,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(-1,8,0,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,8,0,"wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
Block(1,8,0,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,9,0,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,4,1,"wildnature:rosaceae_log[axis=y]");
Block(-2,5,1,"wildnature:rosaceae_branch[down=false,east=true,north=false,south=false,up=true,waterlogged=false,west=false]");
Block(-1,5,1,"wildnature:rosaceae_branch[down=false,east=true,north=false,south=false,up=false,waterlogged=false,west=true]");
Block(0,5,1,"wildnature:rosaceae_log[axis=y]");
Block(-2,6,1,"wildnature:rosaceae_branch[down=true,east=false,north=true,south=false,up=false,waterlogged=false,west=false]");
Block(0,6,1,"wildnature:rosaceae_log[axis=y]");
Block(1,6,1,"wildnature:rosaceae_branch[down=false,east=true,north=false,south=false,up=false,waterlogged=false,west=true]");
Block(2,6,1,"wildnature:rosaceae_branch[down=false,east=false,north=false,south=true,up=true,waterlogged=false,west=true]");
Block(-3,7,1,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,7,1,"wildnature:rosaceae_log[axis=y]");
Block(2,7,1,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(3,7,1,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(-1,8,1,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,8,1,"wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
Block(1,8,1,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,9,1,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,10,1,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(2,6,2,"wildnature:rosaceae_branch[down=false,east=true,north=true,south=false,up=true,waterlogged=false,west=false]");
Block(3,6,2,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(1,7,2,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(2,7,2,"wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
Block(3,7,2,"wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
Block(4,7,2,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(5,7,2,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,8,2,"wildnature:rosaceae_branch[down=false,east=false,north=true,south=false,up=true,waterlogged=false,west=false]");
Block(2,8,2,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(3,8,2,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,9,2,"wildnature:rosaceae_branch[down=true,east=false,north=true,south=true,up=true,waterlogged=false,west=false]");
Block(-1,10,2,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,10,2,"wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
Block(1,10,2,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,11,2,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(2,7,3,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(3,7,3,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,9,3,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(-1,10,3,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,10,3,"wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
Block(1,10,3,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,11,3,"wildnature:nuytsia_leaves[distance=7,persistent=true]");
Block(0,10,4,"wildnature:nuytsia_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
return super.setBlocks();
    }
}