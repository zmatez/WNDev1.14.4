package com.matez.wildnature.blocks;

import com.matez.wildnature.event.ClientPlayerEventHandler;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.registry.ParticleRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.network.play.server.SPlaySoundPacket;
import net.minecraft.state.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TickPriority;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Random;

public class SteamGeneratorBlock extends BlockBase {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final BooleanProperty RUNNING = BooleanProperty.create("running");
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final IntegerProperty STEAM = IntegerProperty.create("steam",0,25);

    public SteamGeneratorBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }


    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onBlockAdded(state, worldIn, pos, oldState, isMoving);
    }


    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING,context.getNearestLookingDirection().getOpposite()).with(RUNNING,false).with(POWERED, Boolean.valueOf(context.getWorld().isBlockPowered(context.getPos())));
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isRemote) {
            boolean flag = state.get(POWERED);
            if (flag != worldIn.isBlockPowered(pos)) {
                if (flag) {
                    worldIn.getPendingBlockTicks().scheduleTick(pos, this, 4);
                } else {
                    worldIn.setBlockState(pos, state.cycle(POWERED).with(STEAM,25).with(RUNNING,true), 2);
                    worldIn.getPendingBlockTicks().scheduleTick(pos, this, 1, TickPriority.NORMAL);
                }
            }

        }
    }


    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
        if (!worldIn.isRemote) {
            if (state.get(POWERED) && !worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, worldIn.getBlockState(pos).cycle(POWERED).with(STEAM,0).with(RUNNING,false), 2);
            }
        }
        steam(state,worldIn,pos,random);


    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        //steam(stateIn,worldIn,pos,rand);
    }

    public void steam(BlockState state, World worldIn, BlockPos pos, Random random){
        if(state.get(POWERED)){
            if(state.get(STEAM)>0) {
                if(state.get(STEAM)==25){
                    playSound(worldIn, new Vec3d(pos), new ResourceLocation("wildnature","block.steam_generator"), SoundCategory.BLOCKS,1,1,0.1F);
                }
                worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(RUNNING,true).with(POWERED,true).with(STEAM,state.get(STEAM)-1));

                DistExecutor.runWhenOn(Dist.CLIENT, () -> new Runnable() {
                    @Override
                    public void run() {
                        steamParticle(pos, state, worldIn, random);
                    }
                });

                worldIn.getPendingBlockTicks().scheduleTick(pos, this, 2, TickPriority.NORMAL);
            }else{
                worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(RUNNING,false));

            }
        }
    }

    public void playSound(World world, Vec3d pos, ResourceLocation soundIn, SoundCategory category, float volume, float pitch, float minVolume) {
        double d0 = Math.pow(volume > 1.0F ? (double)(volume * 16.0F) : 16.0D, 2.0D);
        int i = 0;
        ArrayList<PlayerEntity> spea = (ArrayList<PlayerEntity>)world.getPlayers();

        while(true) {
            ServerPlayerEntity serverplayerentity;
            Vec3d vec3d;
            float f;
            while(true) {
                if(i>=spea.size()){
                    return;
                }
                serverplayerentity = (ServerPlayerEntity)spea.get(i);
                double d1 = pos.x - serverplayerentity.posX;
                double d2 = pos.y - serverplayerentity.posY;
                double d3 = pos.z - serverplayerentity.posZ;
                double d4 = d1 * d1 + d2 * d2 + d3 * d3;
                vec3d = pos;
                f = volume;
                if (!(d4 > d0)) {
                    break;
                }

                if (!(minVolume <= 0.0F)) {
                    double d5 = (double)MathHelper.sqrt(d4);
                    vec3d = new Vec3d(serverplayerentity.posX + d1 / d5 * 2.0D, serverplayerentity.posY + d2 / d5 * 2.0D, serverplayerentity.posZ + d3 / d5 * 2.0D);
                    f = minVolume;
                    break;
                }
            }

            serverplayerentity.connection.sendPacket(new SPlaySoundPacket(soundIn, category, vec3d, f, pitch));
            ++i;
        }

    }

    @OnlyIn(Dist.CLIENT)
    public void steamParticle(BlockPos oldPos, BlockState state, World world, Random random){
        Direction direction = state.get(FACING);
        double X = offset(oldPos,direction,0.6).getX();
        double Y = offset(oldPos,direction,0.6).getY();
        double Z = offset(oldPos,direction,0.6).getZ();

        double divider = 3;
        double res = 0.15;
        for(int i = 0; i < Utilities.rint(15,40,random); i++) {
            double speedX = -((oldPos.getX()-X)/divider)+ Utilities.rdoub(-res,res);
            double speedY = -((oldPos.getY()-Y)/divider)+ Utilities.rdoub(-res,res);
            double speedZ = -((oldPos.getZ()-Z)/divider)+ Utilities.rdoub(-res,res);
            world.addParticle(ParticleRegistry.STEAM,true, X+0.5, Y+0.5, Z+0.5, speedX,speedY,speedZ);
            Minecraft.getInstance().worldRenderer.addParticle(ParticleRegistry.STEAM, false, X+0.5, Y+0.5, Z+0.5, speedX,speedY,speedZ);

        }
    }

    public Vec3d offset(BlockPos pos, Direction facing, double n) {
        return new Vec3d(pos.getX() + facing.getXOffset() * n, pos.getY() + facing.getYOffset() * n, pos.getZ() + facing.getZOffset() * n);
    }


    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING,RUNNING,POWERED,STEAM);
    }
}
