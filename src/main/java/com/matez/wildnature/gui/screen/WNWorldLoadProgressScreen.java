package com.matez.wildnature.gui.screen;

import com.matez.wildnature.Main;
import com.matez.wildnature.other.Utilities;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.chunk.listener.TrackingChunkStatusListener;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public class WNWorldLoadProgressScreen extends Screen {
    public static World world;
    private final TrackingChunkStatusListener progress;
    private long field_213041_b = -1L;
    public int color;
    public ArrayList<BlockPoint> blockPoints;
    public ChunkStatus currentChunkStatus = null;

    public WNWorldLoadProgressScreen(TrackingChunkStatusListener p_i51113_1_) {
        super(NarratorChatListener.field_216868_a);
        this.progress = p_i51113_1_;
        this.blockPoints = new ArrayList<>();
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    public void removed() {
        NarratorChatListener.INSTANCE.func_216864_a(I18n.format("narrator.loading.done", new Object[0]));
    }

    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();

        String lvt_4_1_ = MathHelper.clamp(this.progress.getPercentDone(), 0, 100) + "%";
        long lvt_5_1_ = Util.milliTime();
        if (lvt_5_1_ - this.field_213041_b > 2000L) {
            this.field_213041_b = lvt_5_1_;
            NarratorChatListener.INSTANCE.func_216864_a((new TranslationTextComponent("narrator.loading", new Object[]{lvt_4_1_})).getString());
        }

        int centerWidth = this.width / 2;
        int centerHeight = this.height / 2;
        

        renderChunks(this.progress, centerWidth, centerHeight + 30,this.width,this.height);
        FontRenderer var10001 = this.font;
        this.drawCenteredString(var10001, lvt_4_1_, centerWidth, centerHeight - 9 / 2 + 30, 16777215);
        drawLoading(centerWidth,centerHeight);

    }

    private int points = 0;
    public void drawLoading(int centerWidth, int centerHeight){
        points++;
        String sp = "";
        if(points>=0 && points<30){
            sp = "";
        }else if(points>=30 && points<60){
            sp = ".";
        }else if(points>=60 && points<90){
            sp = "..";
        }else if(points>=90 && points<120){
            sp = "...";
        }else{
            points=0;
        }
        this.drawCenteredString(this.font, "Loading world"+sp, centerWidth, centerHeight - 9 / 2, 16777215);

    }



    public void renderChunks(TrackingChunkStatusListener progress, int centerX, int centerY,int maxX,int maxY) {
        if(world!=null && world.getDimension()!=null) {
            try {
                BlockPos center = world.getSpawnPoint();
                int blockSize = 2;

                if(currentChunkStatus==null || currentChunkStatus!=progress.func_219525_a(world.getChunkAt(center).getPos().x,world.getChunkAt(center).getPos().z)){
                    Main.LOGGER.debug("Drawing background");
                    drawBackground(centerX,centerY,maxX,maxY,blockSize,center.getX(),center.getZ());
                }



                for (BlockPoint blockPoint : blockPoints) {
                    fillWithColor(blockPoint.getStartX(),blockPoint.getStartY(),blockPoint.getEndX(),blockPoint.getEndY(),blockPoint.getPosX(),blockPoint.getPosZ());
                }


            }catch (Exception e){
            }

        }
    }


    public void fillWithColor(int startX, int startY, int endX, int endY, int posX, int posZ){
        getColorV(posX,posZ);
        int c;
        if(color==0){
            c=Utilities.getColorValue(0x313131);
        }else{
            c=color;
        }
        fill(startX,startY,endX,endY,c);
    }

    public void fillWithColor(int startX, int startY, int endX, int endY, int color){
        fill(startX,startY,endX,endY,color);
    }


    public int getHeight(int x, int z, World world){
        for(int i = world.getHeight(); i>1; i--){
            Block b = world.getBlockState(new BlockPos(x,i,z)).getBlock();
            if(b!=null && b!= Blocks.AIR && b!= Blocks.VOID_AIR && b!=Blocks.CAVE_AIR){
                return i;
            }
        }
        return 1;
    }


    public void drawBackground(int centerWidth, int centerHeight, int maxWidth, int maxHeight, int size, int posX, int posZ){
        blockPoints = new ArrayList<>();
        int x =centerWidth;//horiz
        int y =centerHeight;//vert

        int pX = posX;
        int pZ = posZ;

        while(x>0){
            x=x-size;
            pX=pX-1;
            drawVertical(x,y,maxWidth,maxHeight,size,pX,pZ);
        }

        x =centerWidth;//horiz
        y =centerHeight;//vert

        pX = posX;
        pZ = posZ;


        while(x<maxWidth+size){
            x=x+size;
            pX=pX+1;
            drawVertical(x,y,maxWidth,maxHeight,size,pX,pZ);
        }

    }

    private void drawVertical(int centerWidth, int centerHeight, int maxWidth, int maxHeight, int size, int posX, int posZ){
        int x =centerWidth;//horiz
        int y =centerHeight;//vert

        int pX = posX;
        int pZ = posZ;

        //down
        while (y>0){
            y=y-size;
            pZ=pZ-1;
            blockPoints.add(new BlockPoint(x + size, y + size, x - size, y - size, pX, pZ));

        }
        x =centerWidth;//horiz
        y =centerHeight;//vert

        pX = posX;
        pZ = posZ;

        //up
        while (y<maxHeight+size){
            y=y+size;
            pZ=pZ+1;
            blockPoints.add(new BlockPoint(x + size, y + size, x - size, y - size, pX, pZ));

        }

    }

    public void getColorV(int posX, int posZ){
        WNWorldLoadProgressScreen self = this;
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        self.color = Utilities.getColorValue(WNWorldLoadProgressScreen.world.getBlockState(new BlockPos(posX, self.getHeight(posX, posZ, WNWorldLoadProgressScreen.world), posZ)).getBlock().getMaterialColor(null, null, null).colorValue);

    }

    public int getColor(int posX, int posZ){
        return Utilities.getColorValue(WNWorldLoadProgressScreen.world.getBlockState(new BlockPos(posX,getHeight(posX,posZ,WNWorldLoadProgressScreen.world),posZ)).getBlock().getMaterialColor(null,null,null).colorValue);
    }


    public static class BlockPoint{
        private int startX, startY, endX, endY, posX, posZ;
        public BlockPoint(int startX, int startY, int endX, int endY, int posX, int posZ){
            this.startX=startX;
            this.startY=startY;
            this.endX=endX;
            this.endY=endY;
            this.posX=posX;
            this.posZ=posZ;
        }

        public int getEndX() {
            return endX;
        }

        public int getEndY() {
            return endY;
        }

        public int getPosX() {
            return posX;
        }

        public int getPosZ() {
            return posZ;
        }

        public int getStartX() {
            return startX;
        }

        public int getStartY() {
            return startY;
        }
    }

    /*CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        return getColor(center.getX(),center.getZ());
                    }
                });

                fillWithColor(centerX+blockSize,centerY+blockSize,centerX-blockSize,centerY-blockSize,completableFuture.get());*/
    //fillWithColor(centerX+blockSize,centerY+blockSize,centerX-blockSize,centerY-blockSize,center.getX(),center.getZ());
}