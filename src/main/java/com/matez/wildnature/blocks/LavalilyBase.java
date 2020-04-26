package com.matez.wildnature.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class LavalilyBase extends WaterLilyBase {
    public LavalilyBase(Properties properties, ResourceLocation regName) {
        super(properties, regName);
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        IFluidState ifluidstate = worldIn.getFluidState(pos);
        return ifluidstate.getFluid() == Fluids.LAVA || state.getMaterial() == Material.LAVA;
    }
}
