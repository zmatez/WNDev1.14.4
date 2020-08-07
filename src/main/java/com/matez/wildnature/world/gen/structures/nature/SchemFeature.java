package com.matez.wildnature.world.gen.structures.nature;

import com.google.common.collect.Sets;
import com.matez.wildnature.blocks.FloweringLeaves;
import com.matez.wildnature.blocks.FruitableLeaves;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.other.Utilities;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.*;
import net.minecraft.command.arguments.BlockStateArgument;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class SchemFeature extends AbstractTreeFeature<NoFeatureConfig> {

    public BlockState LEAVES = notDecayingLeaf(Blocks.OAK_LEAVES);
    public BlockState LOG = Blocks.OAK_LOG.getDefaultState();
    public BlockState DIRT = Blocks.DIRT.getDefaultState();
    public BlockState BRANCH = LEAVES;
    public IWorld world;
    public BlockPos startBlockPos;
    public Random random;
    public int terrainIncrease = 0;
    private ArrayList<BlockPos> addedBlocks = new ArrayList<>();
    private ArrayList<BlockPos> bottomBlocks = new ArrayList<>();
    private int rotation;
    private boolean canGenerate = true;
    private boolean virtualPlace = false;

    public SchemFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn, boolean doBlockNotifyIn) {
        super(configFactoryIn, doBlockNotifyIn);
        LOG = Blocks.OAK_LOG.getDefaultState();
        LEAVES = notDecayingLeaf(Blocks.OAK_LEAVES);
        BRANCH = LEAVES;
    }
    public SchemFeature() {
        this(NoFeatureConfig::deserialize, false);
    }

    public static BlockState notDecayingLeaf(Block block) {
        if (block instanceof LeavesBlock) {
            return block.getDefaultState().with(LeavesBlock.PERSISTENT, true);
        }
        return block.getDefaultState();
    }

    public SchemFeature setCustomLog(BlockState log) {
        LOG = log;
        return this;
    }

    public SchemFeature setCustomLeaf(BlockState leaf) {
        LEAVES = leaf;
        BRANCH = LEAVES;
        return this;
    }

    public SchemFeature setCustomLogAndLeaf(BlockState log, BlockState leaf) {
        LOG = log;
        LEAVES = leaf;
        BRANCH = LEAVES;
        return this;
    }

    public void setDirt(BlockState dirt) {
        DIRT = dirt;
    }

    @Override
    protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox p_208519_5_) {
        if (!canGrowTree(worldIn, position.down(), getSapling())) {
            return false;
        }
        BlockPos soilPos = position.down();
        int x = 0;
        while (isWater(worldIn, soilPos)) {
            soilPos = soilPos.down();
            x++;
        }
        if (x >= 15) {
            return false;
        }

        this.world = (IWorld) worldIn;
        this.startBlockPos = soilPos.up(terrainIncrease);
        this.random = rand;
        rotation = Utilities.rint(1, 4, rand);
        canGenerate = true;
        addedBlocks.clear();
        virtualPlace = true;
        setBlocks();
        workWithTerrain();
        virtualPlace = false;
        if (canGenerate) {
            setBlocks();
        }
        return true;
    }

    public boolean canGrowTree(IWorldGenerationReader world, BlockPos pos, net.minecraftforge.common.IPlantable sapling) {
        return world.hasBlockState(pos, state -> state.canSustainPlant((net.minecraft.world.IBlockReader) world, pos, Direction.UP, sapling));
    }

    public Set<BlockPos> setBlocks() {
        return Sets.newHashSet(addedBlocks);
    }

    public void Block(int x, int y, int z, BlockState state) {
        BlockPos pos = startBlockPos;
        int sx = startBlockPos.getX();
        int sy = startBlockPos.getY() - 1;
        int sz = startBlockPos.getZ();
        if (rotation >= 1 && rotation <= 4) {
            if (rotation == 1) {
                pos = new BlockPos(x, y, z);//0
            } else if (rotation == 2) {
                pos = new BlockPos(x, y, z).rotate(Rotation.CLOCKWISE_180);//180
                state = state.rotate(Rotation.CLOCKWISE_180);
            } else if (rotation == 3) {
                pos = new BlockPos(x, y, z).rotate(Rotation.CLOCKWISE_90);//90
                state = state.rotate(Rotation.CLOCKWISE_90);
            } else {
                pos = new BlockPos(x, y, z).rotate(Rotation.COUNTERCLOCKWISE_90);//-90
                state = state.rotate(Rotation.COUNTERCLOCKWISE_90);
            }
            pos = new BlockPos(pos.getX() + sx, pos.getY() + sy, pos.getZ() + sz);
        } else {
            throw new IllegalArgumentException("Unknown rotation for tree at " + startBlockPos.toString() + " :\nrotation = " + rotation + " (1-4)\n   Please report it to author!");
        }

        if (world.getBlockState(pos).getBlock() == Blocks.WATER && state.getBlock() instanceof IWaterLoggable) {
            state = state.with(BlockStateProperties.WATERLOGGED, true);
        }
        if (state.getBlock() == WNBlocks.MAGNOLIA_LEAVES || state.getBlock() == WNBlocks.FORSYTHIA_LEAVES || Utilities.rint(0, 10) == 0) {
            if (state.getBlock() instanceof FloweringLeaves) {
                state = state.with(FloweringLeaves.FLOWERING, true);
            } else if (state.getBlock() instanceof FruitableLeaves) {
                state = state.with((((FruitableLeaves) state.getBlock()).getStage()), Utilities.rint(1, ((FruitableLeaves) state.getBlock()).getMaxStages()));
            }
        }
        if (!virtualPlace) {
            if ((isLeaf(state.getBlock()) && !world.getBlockState(pos).isSolid()) || !isLeaf(state.getBlock())) {
                world.setBlockState(pos, state, 19);
            }
        }
        if ((isLeaf(state.getBlock()) && !world.getBlockState(pos).isSolid()) || !isLeaf(state.getBlock())) {
            addedBlocks.add(pos);
        }

    }


    public void Block(int x, int y, int z, String s) {
        try {
            BlockState bs = BlockStateArgument.blockState().parse(new StringReader(s)).getState();
            Block(x, y, z, bs);

            return;
        } catch (CommandSyntaxException e) {
        }
    }

    public void workWithTerrain() {
        if (bottomBlocks == null) {
            return;
        }

        int x = 0;
        BlockPos down = null;
        while (x < addedBlocks.size()) {
            if (down == null) {
                down = addedBlocks.get(x);
            }
            if (addedBlocks.get(x).getY() < down.getY()) {
                down = addedBlocks.get(x);
            }
            x++;
        }

        x = 0;
        while (x < addedBlocks.size()) {
            if (addedBlocks.get(x).getY() == down.getY() + 1) {
                bottomBlocks.add(downBlock(addedBlocks.get(x), 1));
            }
            x++;
        }

        if (bottomBlocks.size() != 0 && bottomBlocks.size() != 1) {
            for (int i = 0; i < 10; i++) {
                boolean allSolid = true;
                for (int a = 0; a < bottomBlocks.size(); a++) {
                    BlockState state = world.getBlockState(bottomBlocks.get(a).down(i));
                    if (!state.isSolid()) {
                        allSolid = false;
                        startBlockPos = startBlockPos.down();
                        break;
                    }
                }
                if (allSolid) {
                    break;
                }
                if (i == 9 && !allSolid) {
                    canGenerate = false;
                }
            }
        }

        addedBlocks.clear();
        bottomBlocks.clear();
    }

    private BlockPos downBlock(BlockPos blockPos, int down) {
        return new BlockPos(blockPos.getX(), blockPos.getY() - down, blockPos.getZ());
    }

    private boolean isLeaf(Block b) {
        return b instanceof LeavesBlock;
    }

    public static class BlockStatePos {
        private BlockState state;
        private BlockPos pos;

        public BlockStatePos(BlockState state, BlockPos pos) {
            this.state = state;
            this.pos = pos;
        }

        public BlockPos getPos() {
            return pos;
        }

        public BlockState getState() {
            return state;
        }
    }

}
