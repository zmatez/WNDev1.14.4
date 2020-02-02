package com.matez.wildnature.items;

import com.matez.wildnature.Main;
import com.matez.wildnature.other.Utilities;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class PotItem extends Item {
    public PotItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        ArrayList<ItemStack> items = Utilities.loadItems(stack.getOrCreateTag());
        int i = 0;
        int j = 0;

        for(ItemStack itemstack : items) {
            if (!itemstack.isEmpty()) {
                ++j;
                if (i <= 4) {
                    ++i;
                    ITextComponent itextcomponent = itemstack.getDisplayName().deepCopy().applyTextStyle(TextFormatting.DARK_GREEN);
                    ITextComponent itextcomponent2 = new StringTextComponent("").appendText(" x").appendText(String.valueOf(itemstack.getCount())).applyTextStyle(TextFormatting.GRAY);
                    tooltip.add(itextcomponent.appendSibling(itextcomponent2));
                }
            }
        }

        if (j - i > 0) {
            tooltip.add((new TranslationTextComponent("container.shulkerBox.more", j - i)).applyTextStyle(TextFormatting.GRAY).applyTextStyle(TextFormatting.ITALIC));
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        ArrayList<ItemStack> items = Utilities.loadItems(stack.getOrCreateTag());
        CompoundNBT nbt = stack.getOrCreateTag();
        if(nbt.contains("Items")){
            nbt.remove("Items");
        }
        if(nbt.contains("Slot")){
            nbt.remove("Slot");
        }

        for (ItemStack itemStack : items) {
            Main.LOGGER.debug("s: " + itemStack.getItem() + ":"+itemStack.getCount());

            player.addItemStackToInventory(itemStack);
        }
        stack.setTag(nbt);
        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }
}
