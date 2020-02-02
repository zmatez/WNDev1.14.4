package com.matez.wildnature.gui;

import com.matez.wildnature.gui.container.PouchContainer;
import com.matez.wildnature.gui.screen.PouchScreen;
import com.matez.wildnature.gui.tileEntities.DungeonCommanderTileEntity;
import com.matez.wildnature.gui.tileEntities.ParticleGeneratorTileEntity;
import com.matez.wildnature.gui.container.CraftingManagerContainer;
import com.matez.wildnature.gui.tileEntities.CustomPistonTileEntity;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class initGuis {
    public static TileEntityType<ParticleGeneratorTileEntity> PARTICLE_GENERATOR_TILE;
    @ObjectHolder("wildnature:rs_piston1")
    public static TileEntityType<CustomPistonTileEntity> PISTON_TYPE;

    @ObjectHolder("wildnature:dungeon_commander")
    public static TileEntityType<DungeonCommanderTileEntity> DUNGEON_COMMANDER;

    @ObjectHolder("wildnature:pouch")
    public static ContainerType<PouchContainer> POUCH = null;

    public static ContainerType<CraftingManagerContainer> CRAFTING_MANAGER_CONTAINER;



}
