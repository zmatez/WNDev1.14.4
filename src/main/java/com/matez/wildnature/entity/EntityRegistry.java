package com.matez.wildnature.entity;

import com.matez.wildnature.entity.type.monster.GoblinEntity;
import com.matez.wildnature.lists.WNItems;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class EntityRegistry {

    public static EntityType<GoblinEntity> GOBLIN = (EntityType<GoblinEntity>) EntityType.Builder.<GoblinEntity>create(GoblinEntity::new, EntityClassification.MONSTER).build("wildnature:goblin").setRegistryName("wildnature:goblin");

    public static void registerSpawningEggs(final RegistryEvent.Register<Item> register){
        WNItems.GOBLIN_EGG = registerSpawningEggs(GOBLIN,0x6c6d57,0x635136,"goblin_egg");
    }

    public static Item registerSpawningEggs(EntityType<?> type, int color1, int color2, String name){
        SpawnEggItem item = new SpawnEggItem(type,color1,color2,new Item.Properties().group(ItemGroup.MISC));
        item.setRegistryName(name);
        return item;
    }

    public static void registerEntitySpawns(){
        ArrayList<Biome> biomes = new ArrayList<>();
        Registry.BIOME.forEach(biomes::add);
        registerEntitySpawns(GOBLIN,2,2,1,EntityClassification.MONSTER, (Biome[])biomes.toArray());
    }

    public static void registerEntitySpawns(EntityType<?> type, int weight, int max, int min,EntityClassification e, Biome... biomes){
        Arrays.asList(biomes).forEach(biome -> {
            if(biome!=null){
                biome.getSpawns(e).add(new Biome.SpawnListEntry(type,weight,max,min));
            }
        });
    }
}
