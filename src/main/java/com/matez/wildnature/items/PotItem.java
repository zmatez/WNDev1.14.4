package com.matez.wildnature.items;

import com.matez.wildnature.Main;
import com.matez.wildnature.items.recipes.cooking.WNAbstractCookingRecipe;
import com.matez.wildnature.other.Utilities;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.*;
import net.minecraft.util.registry.Registry;
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

        CompoundNBT nbt = stack.getOrCreateTag();
        if(nbt.contains("cooked") && nbt.getBoolean("cooked")){
            ItemStack result = Utilities.loadItem(nbt);
            if(result!=null && !result.isEmpty()) {
                tooltip.add((new StringTextComponent(TextFormatting.GOLD + "Cooked " + TextFormatting.YELLOW + result.getDisplayName().getFormattedText() + " x" + result.getCount())));
                tooltip.add((new StringTextComponent(TextFormatting.GREEN + "Right click to get it")));

            }
        }else {

            if (worldIn != null) {
                WNAbstractCookingRecipe recipe = checkForRecipes(worldIn, items);
                if (recipe != null) {
                    ItemStack output = recipe.getRecipeOutput();
                    tooltip.add((new StringTextComponent(TextFormatting.GOLD + "Cook now to get " + TextFormatting.YELLOW + output.getDisplayName().getFormattedText() + " x" + output.getCount())));
                }
            } else {
                tooltip.add((new StringTextComponent(TextFormatting.RED + "Cannot get recipes for this world")));
            }


            for (ItemStack itemstack : items) {
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
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        CompoundNBT nbt = stack.getOrCreateTag();

        if(nbt.contains("cooked") && nbt.getBoolean("cooked")){
            ItemStack result = Utilities.loadItem(nbt);
            if(result!=null && !result.isEmpty()) {
                player.addItemStackToInventory(result);

                nbt.remove("cooked");
                //Main.LOGGER.debug("----------------------------- CLOICKED");
                stack.setTag(new CompoundNBT());
                return new ActionResult<>(ActionResultType.SUCCESS, stack);
            }
        }else {
            ArrayList<ItemStack> items = Utilities.loadItems(nbt);

            if (nbt.contains("Items")) {
                nbt.remove("Items");
            }
            if (nbt.contains("Slot")) {
                nbt.remove("Slot");
            }

            for (ItemStack itemStack : items) {
                Main.LOGGER.debug("s: " + itemStack.getItem() + ":" + itemStack.getCount());

                player.addItemStackToInventory(itemStack);
            }
            stack.setTag(nbt);
            return new ActionResult<>(ActionResultType.SUCCESS, stack);
        }

        return new ActionResult<>(ActionResultType.PASS, stack);
    }

    public static WNAbstractCookingRecipe checkForRecipes(World world, ArrayList<ItemStack> items){
        ItemStack[] itemStacks = new ItemStack[items.size()];
        items.toArray(itemStacks);
        Inventory i = new Inventory(itemStacks);
        WNAbstractCookingRecipe recipe = world.getRecipeManager().getRecipe((IRecipeType<WNAbstractCookingRecipe>) Registry.RECIPE_TYPE.getOrDefault(new ResourceLocation("wildnature:cooking")), i, world).orElse(null);
        assert recipe != null && recipe.getRecipeOutput() != null;
        try {
            //Main.LOGGER.debug("Recipe: " + recipe.getRecipeOutput().getDisplayName().getFormattedText());
        }catch (Exception e){
            return null;
        };
        return recipe;
    }

}
