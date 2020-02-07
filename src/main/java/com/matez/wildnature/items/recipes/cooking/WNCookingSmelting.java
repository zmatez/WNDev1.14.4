package com.matez.wildnature.items.recipes.cooking;

import com.matez.wildnature.Main;
import com.matez.wildnature.items.PotItem;
import com.matez.wildnature.items.recipes.special.SpecialSmelting;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.other.Utilities;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.ArrayList;

public class WNCookingSmelting extends SpecialSmelting {
    public WNCookingSmelting(ResourceLocation p_i48715_1_) {
        super(p_i48715_1_, "cooking",Ingredient.fromItems(WNItems.POT_WATER),new ItemStack(WNItems.POT_WATER,1),1f,300);
    }
    private World w;

    @Override
    public boolean matches(IInventory inventory, World world) {

        Main.LOGGER.debug("Checking furnace");
        if(inventory.getStackInSlot(0).getItem() instanceof PotItem) {
            WNAbstractCookingRecipe recipe = PotItem.checkForRecipes(world, Utilities.loadItems(inventory.getStackInSlot(0).getOrCreateTag()));
            w = world;
            Main.LOGGER.debug("Checking furnace success");
            if(recipe!=null && recipe.ingredient!=null && recipe.result!=null) {
                Main.LOGGER.debug("SET RESULTS");
                ingredient = recipe.ingredient;
                result = getCraftingResult(inventory);
            }
            return recipe != null && recipe.getRecipeOutput() != null;
        }else{
            return false;
        }
    }

    @Override
    public ItemStack getCraftingResult(IInventory inventory) {
        Main.LOGGER.debug("GETTING RESULT");
        ItemStack s = inventory.getStackInSlot(0);
        if(s.getItem() instanceof PotItem) {
            WNAbstractCookingRecipe recipe = PotItem.checkForRecipes(w, Utilities.loadItems(inventory.getStackInSlot(0).getOrCreateTag()));
            if (recipe == null) {
                return ItemStack.EMPTY;
            } else {
                ItemStack output = recipe.getRecipeOutput();
                CompoundNBT nbt = s.getOrCreateTag();

                if (nbt.contains("Items")) {
                    nbt.remove("Items");
                }
                if (nbt.contains("Slot")) {
                    nbt.remove("Slot");
                }

                Utilities.saveItem(nbt,output);
                nbt.putBoolean("cooked",true);
                ItemStack r = s.copy();
                r.setTag(nbt);
                Main.LOGGER.debug("RESULT =  " + r.getDisplayName().getFormattedText());
                return r;
            }
        }else{
            return ItemStack.EMPTY;
        }
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return Registry.RECIPE_SERIALIZER.getOrDefault(new ResourceLocation("wildnature:furnace_cooking"));
    }
}
