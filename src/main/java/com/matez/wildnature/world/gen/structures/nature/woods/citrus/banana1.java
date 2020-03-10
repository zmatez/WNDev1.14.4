package com.matez.wildnature.world.gen.structures.nature.woods.citrus;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;

public class banana1 extends SchemFeature {

    public banana1(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
        this.terrainIncrease = 1;
    }

    public banana1(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace, BlockState log, BlockState leaves) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
        LOG = log;
        LEAVES =leaves;
        this.terrainIncrease = 1;

    }

    @Override
    public Set<BlockPos> setBlocks() {

Block(0,3,-4,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(0,4,-4,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(0,4,-3,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(0,5,-3,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(-1,4,-2,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(0,4,-2,"wildnature:palm_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
Block(1,4,-2,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(0,5,-2,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(0,3,-1,"wildnature:palm_branch[down=false,east=false,north=false,south=true,up=true,waterlogged=false,west=false]");
Block(0,4,-1,"wildnature:palm_branch[down=true,east=false,north=true,south=true,up=true,waterlogged=false,west=false]");
Block(2,4,-1,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(0,5,-1,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(0,1,0,"wildnature:palm_log[axis=y]");
Block(0,2,0,"wildnature:palm_log[axis=y]");
Block(4,2,0,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(-1,3,0,"wildnature:palm_branch[down=false,east=true,north=false,south=false,up=true,waterlogged=false,west=false]");
Block(0,3,0,"wildnature:palm_log[axis=y]");
Block(1,3,0,"wildnature:palm_branch[down=false,east=true,north=false,south=false,up=true,waterlogged=false,west=true]");
Block(2,3,0,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(3,3,0,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(4,3,0,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(-2,4,0,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(-1,4,0,"wildnature:palm_branch[down=true,east=true,north=false,south=true,up=true,waterlogged=false,west=true]");
Block(0,4,0,"wildnature:banana_leaves[distance=1,persistent=true]");
Block(1,4,0,"wildnature:palm_branch[down=true,east=true,north=false,south=true,up=true,waterlogged=false,west=true]");
Block(2,4,0,"wildnature:palm_branch[down=true,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
Block(3,4,0,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(-1,5,0,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(1,5,0,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(2,5,0,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(-4,2,1,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(-4,3,1,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(-3,3,1,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(0,3,1,"wildnature:palm_branch[down=false,east=false,north=true,south=true,up=true,waterlogged=false,west=false]");
Block(-3,4,1,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(-2,4,1,"wildnature:palm_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
Block(-1,4,1,"wildnature:palm_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
Block(0,4,1,"wildnature:banana_leaves[distance=2,persistent=true]");
Block(1,4,1,"wildnature:banana_leaves[distance=3,persistent=true]");
Block(2,4,1,"wildnature:banana_leaves[distance=4,persistent=true]");
Block(-2,5,1,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(-1,5,1,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(0,3,2,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(-2,4,2,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(-1,4,2,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(0,2,3,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(0,3,3,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(0,1,4,"wildnature:banana_leaves[distance=7,persistent=true]");
Block(0,2,4,"wildnature:banana_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
return super.setBlocks();
    }
}