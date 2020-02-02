package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.WallSignBlock;

public class WallSignBase extends WallSignBlock {

    public WallSignBase(Properties properties) {
        super(properties);
        WNBlocks.SIGNBLOCKS.add(this);
    }
}
