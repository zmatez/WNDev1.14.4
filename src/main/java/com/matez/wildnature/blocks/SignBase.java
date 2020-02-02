package com.matez.wildnature.blocks;

import com.matez.wildnature.lists.WNBlocks;
import net.minecraft.block.StandingSignBlock;

public class SignBase extends StandingSignBlock {

    public SignBase(Properties properties) {
        super(properties);
        WNBlocks.SIGNBLOCKS.add(this);

    }


}
