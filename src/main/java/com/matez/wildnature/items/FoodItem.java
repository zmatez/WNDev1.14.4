package com.matez.wildnature.items;

import com.matez.wildnature.Main;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static com.matez.wildnature.commands.RecipeCommand.checkIngredients;

public class FoodItem extends Item {
    public FoodItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public void addInformation(ItemStack itemStackInfo, @Nullable World world, List<ITextComponent> tooltips, ITooltipFlag tooltipFlag) {
        if(world!=null) {
            ArrayList<ArrayList<ItemStack>> stacks = checkIngredients(world, new ItemStack(this, 1));
            int x = 0;
            for (ArrayList<ItemStack> stack : stacks) {
                x++;
                StringTextComponent sr = new StringTextComponent(TextFormatting.LIGHT_PURPLE + itemStackInfo.getDisplayName().getFormattedText());

                ITextComponent tooltip1 = (new StringTextComponent("")
                        .appendSibling(new StringTextComponent(TextFormatting.GREEN+"Recipe " + x+ "/" + stacks.size())));
                tooltips.add(tooltip1);
                int i = 0;
                ItemStack tool = ItemStack.EMPTY;
                for (ItemStack itemStack : stack) {
                    if(itemStack.getItem() instanceof CookingItem){
                        tool=itemStack.copy();
                    }else {
                        i++;
                        StringTextComponent si = new StringTextComponent(TextFormatting.DARK_GREEN + itemStack.getDisplayName().getFormattedText());

                        ITextComponent tooltip2 = (new StringTextComponent(TextFormatting.GRAY + "- ")
                                .appendSibling(new StringTextComponent(TextFormatting.DARK_GREEN + "").appendSibling(si).appendSibling(new StringTextComponent(TextFormatting.DARK_AQUA + " x" + itemStack.getCount()))));
                        tooltips.add(tooltip2);
                    }
                }
                if(!tool.isEmpty()) {
                    StringTextComponent st = new StringTextComponent(TextFormatting.GOLD + tool.getDisplayName().getFormattedText());
                    if(tool.getItem()==Item.getItemFromBlock(Blocks.STONE)){
                        st = new StringTextComponent(TextFormatting.RED+"unknown");
                    }else {
                        st.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ITEM, new StringTextComponent(tool.write(new CompoundNBT()).toString())));
                    }
                    ITextComponent cook = (new StringTextComponent(TextFormatting.GREEN + "Cook it using ").appendSibling(st));
                    tooltips.add(cook);
                }

            }

            if(stacks.isEmpty()){
                //ITextComponent unable = (new StringTextComponent("").appendSibling(new StringTextComponent(TextFormatting.RED+"Unable to find recipes for " + TextFormatting.GOLD+itemStackInfo.getDisplayName().getFormattedText()+" x" +itemStackInfo.getCount()+TextFormatting.RED+".")));
                //tooltips.add(unable);

            }

        }
    }


}
