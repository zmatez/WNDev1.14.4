package com.matez.wildnature.world.gen.structures.nature.woods.glowing_cave_oak;

import com.matez.wildnature.Main;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class GlowingCaveOakSpawner extends AbstractTreeFeature<NoFeatureConfig> {
    private boolean icy = false;
    private ArrayList<SchemFeature> normalCaveOaks = new ArrayList<SchemFeature>();
    private ArrayList<SchemFeature> icyCaveOaks = new ArrayList<SchemFeature>();

    public GlowingCaveOakSpawner(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49920_1_, boolean doBlockNofityOnPlace, boolean icy) {
        super(p_i49920_1_, doBlockNofityOnPlace);
        this.icy = icy;
        normalCaveOaks.add(new glowing_cave_oak_1(NoFeatureConfig::deserialize, false, WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_LEAVES)));
        normalCaveOaks.add(new glowing_cave_oak_2(NoFeatureConfig::deserialize, false, WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_LEAVES)));
        normalCaveOaks.add(new glowing_cave_oak_3(NoFeatureConfig::deserialize, false, WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_LEAVES)));
        normalCaveOaks.add(new glowing_cave_oak_4(NoFeatureConfig::deserialize, false, WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_LEAVES)));

        icyCaveOaks.add(new glowing_cave_oak_1(NoFeatureConfig::deserialize, false, WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_ICY_LEAVES)));
        icyCaveOaks.add(new glowing_cave_oak_2(NoFeatureConfig::deserialize, false, WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_ICY_LEAVES)));
        icyCaveOaks.add(new glowing_cave_oak_3(NoFeatureConfig::deserialize, false, WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_ICY_LEAVES)));
        icyCaveOaks.add(new glowing_cave_oak_4(NoFeatureConfig::deserialize, false, WNBlocks.GLOWING_CAVE_OAK_LOG.getDefaultState(), SchemFeature.notDecayingLeaf(WNBlocks.GLOWING_CAVE_OAK_ICY_LEAVES)));
    }

    public void setIcy(boolean icy) {
        this.icy = icy;
    }

    @Override
    protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox mutable) {
        for(int i = position.getY(); i < position.getY()+15; i++){
            if(!worldIn.hasBlockState(position, new Predicate<BlockState>() {
                @Override
                public boolean test(BlockState state) {
                    return state.isAir();
                }
            })){
                return false;
            }
        }

        Main.LOGGER.debug("YEAH Generating tree at " + position + " : icy: " + icy);
        if (icy) {
            int index = Utilities.rint(0, icyCaveOaks.size() - 1, rand);
            return icyCaveOaks.get(index).place((IWorld)worldIn,((IWorld) worldIn).getChunkProvider().getChunkGenerator(),rand, position,new NoFeatureConfig());
        } else {
            int index = Utilities.rint(0, normalCaveOaks.size() - 1, rand);
            return normalCaveOaks.get(index).place((IWorld)worldIn,((IWorld) worldIn).getChunkProvider().getChunkGenerator(),rand, position,new NoFeatureConfig());
        }
    }
}
