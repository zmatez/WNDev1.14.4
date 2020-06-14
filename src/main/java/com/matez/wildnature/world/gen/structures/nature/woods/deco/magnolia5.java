package com.matez.wildnature.world.gen.structures.nature.woods.deco;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;public class magnolia5 extends SchemFeature {
    public magnolia5(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
    }

    public magnolia5(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace, BlockState log, BlockState leaves) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
        LOG = log;
        LEAVES =leaves;
    }

    @Override
    public Set<BlockPos> setBlocks() {

Block(0,3,-3,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");
Block(0,4,-3,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");
Block(2,4,-3,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");
Block(-2,4,-2,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");
Block(-1,4,-2,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");
Block(-1,5,-2,"wildnature:magnolia_leaves[distance=6,flowering=false,persistent=true]");
Block(0,5,-2,"wildnature:magnolia_leaves[distance=5,flowering=false,persistent=true]");
Block(1,5,-2,"wildnature:magnolia_leaves[distance=4,flowering=false,persistent=true]");
Block(2,5,-2,"wildnature:magnolia_leaves[distance=5,flowering=false,persistent=true]");
Block(0,1,-1,"wildnature:rosaceae_log[axis=y]");
Block(0,2,-1,"wildnature:rosaceae_log[axis=y]");
Block(-3,4,-1,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");
Block(0,4,-1,"wildnature:rosaceae_branch[down=false,east=false,north=false,south=true,up=true,waterlogged=false,west=false]");
Block(4,4,-1,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");
Block(-2,5,-1,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");
Block(0,5,-1,"wildnature:rosaceae_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=false]");
Block(1,5,-1,"wildnature:magnolia_leaves[distance=3,flowering=false,persistent=true]");
Block(3,5,-1,"wildnature:magnolia_leaves[distance=5,flowering=false,persistent=true]");
Block(-1,6,-1,"wildnature:magnolia_leaves[distance=2,flowering=false,persistent=true]");
Block(0,6,-1,"wildnature:magnolia_leaves[distance=1,flowering=false,persistent=true]");
Block(1,6,-1,"wildnature:magnolia_leaves[distance=2,flowering=false,persistent=true]");
Block(2,6,-1,"wildnature:magnolia_leaves[distance=3,flowering=false,persistent=true]");
Block(0,7,-1,"wildnature:magnolia_leaves[distance=2,flowering=false,persistent=true]");
Block(1,7,-1,"wildnature:magnolia_leaves[distance=3,flowering=false,persistent=true]");
Block(-1,1,0,"wildnature:rosaceae_log[axis=x]");
Block(0,1,0,"wildnature:rosaceae_log[axis=y]");
Block(0,2,0,"wildnature:rosaceae_log[axis=y]");
Block(-3,3,0,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");
Block(0,3,0,"wildnature:rosaceae_log[axis=y]");
Block(1,3,0,"wildnature:rosaceae_branch[down=false,east=true,north=false,south=false,up=false,waterlogged=false,west=true]");
Block(2,3,0,"wildnature:rosaceae_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=true]");
Block(-3,4,0,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");
Block(-2,4,0,"wildnature:rosaceae_branch[down=false,east=true,north=false,south=false,up=true,waterlogged=false,west=true]");
Block(-1,4,0,"wildnature:rosaceae_branch[down=false,east=true,north=false,south=false,up=false,waterlogged=false,west=true]");
Block(0,4,0,"wildnature:rosaceae_log[axis=y]");
Block(2,4,0,"wildnature:rosaceae_branch[down=true,east=true,north=false,south=false,up=true,waterlogged=false,west=false]");
Block(3,4,0,"wildnature:magnolia_leaves[distance=5,flowering=false,persistent=true]");
Block(-2,5,0,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");
Block(0,5,0,"wildnature:rosaceae_log[axis=y]");
Block(2,5,0,"wildnature:magnolia_leaves[distance=3,flowering=false,persistent=true]");
Block(3,5,0,"wildnature:magnolia_leaves[distance=4,flowering=false,persistent=true]");
Block(-1,6,0,"wildnature:magnolia_leaves[distance=1,flowering=false,persistent=true]");
Block(0,6,0,"wildnature:rosaceae_log[axis=y]");
Block(1,6,0,"wildnature:magnolia_leaves[distance=1,flowering=false,persistent=true]");
Block(2,6,0,"wildnature:magnolia_leaves[distance=2,flowering=false,persistent=true]");
Block(0,7,0,"wildnature:magnolia_leaves[distance=1,flowering=false,persistent=true]");
Block(1,7,0,"wildnature:magnolia_leaves[distance=2,flowering=false,persistent=true]");
Block(-2,5,1,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");
Block(2,5,1,"wildnature:magnolia_leaves[distance=4,flowering=false,persistent=true]");
Block(-1,6,1,"wildnature:magnolia_leaves[distance=2,flowering=false,persistent=true]");
Block(0,6,1,"wildnature:magnolia_leaves[distance=1,flowering=false,persistent=true]");
Block(1,6,1,"wildnature:magnolia_leaves[distance=2,flowering=false,persistent=true]");
Block(0,7,1,"wildnature:magnolia_leaves[distance=2,flowering=false,persistent=true]");
Block(-2,5,2,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");
Block(-1,5,2,"wildnature:magnolia_leaves[distance=6,flowering=false,persistent=true]");
Block(0,5,2,"wildnature:magnolia_leaves[distance=5,flowering=false,persistent=true]");
Block(1,5,2,"wildnature:magnolia_leaves[distance=4,flowering=false,persistent=true]");
Block(2,5,2,"wildnature:magnolia_leaves[distance=5,flowering=false,persistent=true]");
Block(1,6,2,"wildnature:magnolia_leaves[distance=3,flowering=false,persistent=true]");
Block(-1,5,3,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");
Block(0,5,3,"wildnature:magnolia_leaves[distance=6,flowering=false,persistent=true]");
Block(1,5,3,"wildnature:magnolia_leaves[distance=5,flowering=false,persistent=true]");
Block(0,4,4,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");
Block(1,4,4,"wildnature:magnolia_leaves[distance=7,flowering=false,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
return super.setBlocks();
    }
}