package com.matez.wildnature.commands;

import com.matez.wildnature.Main;
import com.matez.wildnature.customizable.CommonConfig;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;

import java.util.concurrent.CompletableFuture;

public class BiomeArgument implements ArgumentType<Biome>
{
    public static final DynamicCommandExceptionType INVALID_BIOME_EXCEPTION = new DynamicCommandExceptionType((biome) -> {
        return new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(new StringTextComponent(TextFormatting.RED + "This biome is invalid."));
    });

    public static BiomeArgument createArgument()
    {
        return new BiomeArgument();
    }

    @Override
    public Biome parse(StringReader reader) throws CommandSyntaxException
    {
        ResourceLocation location = ResourceLocation.read(reader);
        return Registry.BIOME.getValue(location).orElseThrow(() ->
        {
            return INVALID_BIOME_EXCEPTION.create(location);
        });
    }

    public static Biome getValue(CommandContext<CommandSource> context, String name) throws CommandSyntaxException
    {
        return context.getArgument(name, Biome.class);
    }


    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder suggestionsBuilder)
    {
        return ISuggestionProvider.suggestIterable(Registry.BIOME.keySet(), suggestionsBuilder);
    }

    public static int findTeleportBiome(CommandSource cs, ServerPlayerEntity player, Biome biome)
    {
        if(CommonConfig.blacklistedBiomes.contains(biome)){
            StringTextComponent sx = new StringTextComponent(TextFormatting.RED + "This biome is blacklisted.");
            Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sx));
            return 0;
        }

        StringTextComponent s2 = new StringTextComponent(TextFormatting.AQUA + "Trying to find " + TextFormatting.GOLD + biome.getRegistryName() + TextFormatting.AQUA+" biome...");
        Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s2));
        StringTextComponent sx = new StringTextComponent(TextFormatting.AQUA + "This will take a moment. Your world will lag.");
        Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(sx));

        World world = player.world;
        BlockPos closestBiomePos = biome == null ? null : lookForBiome(world, biome, player.posX, player.posZ);

        if (closestBiomePos != null)
        {
            double x = (double)closestBiomePos.getX();
            double y = (double) getTopBlock(world, closestBiomePos.getX(), closestBiomePos.getZ()).getY();
            double z = (double)closestBiomePos.getZ();

            if (!world.getDimension().isSurfaceWorld())
            {
                y = (double)getY(world, closestBiomePos).getY();
            }

            //player.connection.setPlayerLocation(x, y, z, player.rotationYaw, player.rotationPitch);
            StringTextComponent s3 = new StringTextComponent(TextFormatting.AQUA + "Found " + TextFormatting.LIGHT_PURPLE + biome.getRegistryName() + TextFormatting.AQUA+" biome at ");
            StringTextComponent s4 = new StringTextComponent(TextFormatting.YELLOW + ""+x+" " + y + " " + z);
            s4.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GOLD+"Click to copy to the command prompt")));
            s4.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND,"" + x + " " + y + " " + z));
            Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s3).appendSibling(s4));
            StringTextComponent s5 = new StringTextComponent(TextFormatting.GREEN + "Click to teleport");
            s5.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GOLD+"Click here")));
            s5.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/tp " + player.getName().getString() + " " + x + " " + y + " " + z));
            Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s5));
        }
        else
        {
            StringTextComponent s3 = new StringTextComponent(TextFormatting.RED + "Unable to find " + TextFormatting.LIGHT_PURPLE + biome.getRegistryName() + TextFormatting.RED+" biome.");
            s3.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.DARK_RED+"Operation Failed :/")));
            Main.sendChatMessage(player, new StringTextComponent("").appendSibling(Main.WNPrefix).appendSibling(s3));

        }

        return 1;
    }

    public static BlockPos getY(World world, BlockPos pos)
    {
        IChunk chunk = world.getChunk(pos);
        BlockPos blockpos;
        BlockPos blockpos1;
        BlockPos blockpos2 = new BlockPos(pos.getX(), chunk.getTopFilledSegment() + 16, pos.getZ());

        for (blockpos = blockpos2; blockpos.getY() >= 0; blockpos = blockpos1)
        {
            blockpos1 = blockpos.down();
            BlockState state = chunk.getBlockState(blockpos1);

            if (!state.getMaterial().blocksMovement() && !world.isAirBlock(blockpos1.down()) && state.getMaterial() != Material.LEAVES)
            {
                return blockpos1;
            }
        }

        return blockpos2;
    }

    public static BlockPos getTopBlock(IWorld world, int x, int z)
    {
        IChunk chunk = world.getChunk(x >> 4, z >> 4, ChunkStatus.FULL);
        return new BlockPos(x, chunk.getTopBlockY(Heightmap.Type.MOTION_BLOCKING, x & 15, z & 15), z);
    }

    public static BlockPos lookForBiome(World world, Biome biomeToFind, double startX, double startZ)
    {
        int sampleSpacing = 4 << 12;
        int maxDist = sampleSpacing * 100;
        return lookForBiome(world, biomeToFind, startX, startZ, maxDist, sampleSpacing);
    }

    // sample points in an archimedean spiral starting from startX,startY each one sampleSpace apart
    // stop when the specified biome is found (and return the position it was found at) or when we reach maxDistance (and return null)
    public static BlockPos lookForBiome(World world, Biome biomeToFind, double startX, double startZ, int maxDist, int sampleSpace)
    {
        int m = 0;
        if (maxDist <= 0 || sampleSpace <= 0) {throw new IllegalArgumentException("maxDist and sampleSpace must be positive");}
        BiomeProvider chunkManager = world.getChunkProvider().getChunkGenerator().getBiomeProvider();
        double a = sampleSpace / Math.sqrt(Math.PI);
        double b = 2 * Math.sqrt(Math.PI);
        double x = 0;
        double z = 0;
        double dist = 0;
        int n = 0;
        //String biomeName = world.isRemote ? biomeToFind.getDisplayName().getString() : "biome";
        for (n = 0; dist < maxDist; ++n)
        {
            //System.out.println("Looking for biome");

            double rootN = Math.sqrt(n);
            dist = a * rootN;
            x = startX + (dist * Math.sin(b * rootN));
            z = startZ + (dist * Math.cos(b * rootN));
            Biome[] biomesAtSample = chunkManager.getBiomes((int)x, (int)z, 1, 1, false);
            if (biomesAtSample[0] == biomeToFind)
            {
                return new BlockPos((int)x, 0, (int)z);
            }
            if(m>= CommonConfig.maxTpLoop.get()){
                return null;
            }
        }

        return null;
    }
}