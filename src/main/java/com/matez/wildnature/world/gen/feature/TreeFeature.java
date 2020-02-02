package com.matez.wildnature.world.gen.feature;

import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.other.TreeWeighList;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class TreeFeature extends Feature<NoFeatureConfig> {
    private TreeWeighList list;
    public TreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49869_1_, TreeWeighList list) {
        super(p_i49869_1_);
        this.list=list;
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        AbstractTreeFeature feature = Utilities.getWeighTree(list);
        return feature ==null ? false : feature.place(worldIn,generator,rand,pos,config);
    }


}
