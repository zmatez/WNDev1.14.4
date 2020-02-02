package com.matez.wildnature.world.gen.structures.nature.woods.mangrove;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Set;
import java.util.function.Function;

public class mangrove_shrub5 extends SchemFeature {
    public mangrove_shrub5(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
    }

    public mangrove_shrub5(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace, BlockState log, BlockState leaves) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
        LOG = log;
        LEAVES =leaves;
    }

    @Override
    public boolean canGrowTree(IWorldGenerationReader world, BlockPos pos, net.minecraftforge.common.IPlantable sapling){
        if(!super.canGrowTree(world, pos.down(), getSapling()) && !isWater(world,pos.down())){
            return false;
        }

        if(isWater(world,pos.up(1))){
            return false;
        }

        return true;
    }

    @Override
    public Set<BlockPos> setBlocks() {

Block(1,1,-1,"wildnature:mangrove_log[axis=y]");
Block(1,2,-1,"wildnature:mangrove_log[axis=y]");
Block(1,3,-1,"wildnature:mangrove_fence[east=false,north=false,south=false,waterlogged=false,west=false]");
Block(1,4,-1,"wildnature:mangrove_fence[east=false,north=false,south=false,waterlogged=false,west=false]");
Block(-1,1,0,"wildnature:mangrove_log[axis=y]");
Block(-1,2,0,"wildnature:mangrove_log[axis=y]");
Block(-1,3,0,"wildnature:mangrove_log[axis=y]");
Block(1,3,0,"wildnature:ebony_leaves[distance=7,persistent=true]");
Block(-1,4,0,"wildnature:mangrove_fence[east=false,north=false,south=false,waterlogged=false,west=false]");
Block(-1,5,0,"wildnature:mangrove_fence[east=false,north=false,south=false,waterlogged=false,west=false]");
Block(-1,6,0,"wildnature:ebony_leaves[distance=7,persistent=true]");
Block(1,1,1,"wildnature:mangrove_log[axis=y]");
Block(1,2,1,"wildnature:mangrove_log[axis=y]");
Block(-1,3,1,"wildnature:ebony_leaves[distance=7,persistent=true]");
Block(1,3,1,"wildnature:mangrove_log[axis=y]");
Block(1,4,1,"wildnature:mangrove_fence[east=false,north=false,south=false,waterlogged=false,west=false]");
Block(1,4,2,"wildnature:ebony_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
return super.setBlocks();
    }
}