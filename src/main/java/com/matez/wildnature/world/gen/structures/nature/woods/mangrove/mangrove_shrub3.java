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

public class mangrove_shrub3 extends SchemFeature {
    public mangrove_shrub3(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace) {
        super(config, doBlockNofityOnPlace);
        Main.treesList.add(this);
    }

    public mangrove_shrub3(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace, BlockState log, BlockState leaves) {
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

Block(0,3,-1,"wildnature:mangrove_leaves[distance=7,persistent=true]");
Block(-1,1,0,"wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
Block(1,1,0,"wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
Block(-1,2,0,"wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
Block(1,2,0,"wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
Block(-1,3,0,"wildnature:mangrove_leaves[distance=7,persistent=true]");
Block(0,3,0,"wildnature:mangrove_branch[down=false,east=true,north=true,south=true,up=true,waterlogged=false,west=true]");
Block(1,3,0,"wildnature:mangrove_leaves[distance=7,persistent=true]");
Block(0,4,0,"wildnature:mangrove_leaves[distance=7,persistent=true]");
Block(0,1,1,"wildnature:mangrove_branch[down=false,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
Block(0,2,1,"wildnature:mangrove_branch[down=true,east=false,north=false,south=false,up=true,waterlogged=false,west=false]");
Block(0,3,1,"wildnature:mangrove_branch[down=true,east=false,north=true,south=false,up=true,waterlogged=false,west=false]");
Block(0,4,1,"wildnature:mangrove_leaves[distance=7,persistent=true]");

//   wildnature mod
//           created by matez 
//         all rights reserved   
//     http://bit.ly/wildnature-mod
return super.setBlocks();
    }
}