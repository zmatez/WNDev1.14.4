package com.matez.wildnature.gui.screen;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.listener.TrackingChunkStatusListener;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WNWorldLoadProgressScreen extends Screen {
    private final TrackingChunkStatusListener progress;
    private long field_213041_b = -1L;
    private static final Object2IntMap<ChunkStatus> COLORS = (Object2IntMap) Util.make(new Object2IntOpenHashMap(), (p_213039_0_) -> {
        p_213039_0_.defaultReturnValue(0);
        p_213039_0_.put(ChunkStatus.EMPTY, 0xffffff);
        p_213039_0_.put(ChunkStatus.STRUCTURE_STARTS, 0x123321);
        p_213039_0_.put(ChunkStatus.STRUCTURE_REFERENCES, 0x332244);
        p_213039_0_.put(ChunkStatus.BIOMES, 0xff0000);
        p_213039_0_.put(ChunkStatus.NOISE, 0x00ff00);
        p_213039_0_.put(ChunkStatus.SURFACE, 0xff22ff);
        p_213039_0_.put(ChunkStatus.CARVERS, 0xabcdef);
        p_213039_0_.put(ChunkStatus.LIQUID_CARVERS, 3159410);
        p_213039_0_.put(ChunkStatus.FEATURES, 0x987654);
        p_213039_0_.put(ChunkStatus.LIGHT, 0xbb11bb);
        p_213039_0_.put(ChunkStatus.SPAWN, 0x987123);
        p_213039_0_.put(ChunkStatus.HEIGHTMAPS, 0x654987);
        p_213039_0_.put(ChunkStatus.FULL, 0xfb05ba);
    });

    public WNWorldLoadProgressScreen(TrackingChunkStatusListener p_i51113_1_) {
        super(NarratorChatListener.field_216868_a);
        this.progress = p_i51113_1_;
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

        int lvt_7_1_ = this.width / 2;
        int lvt_8_1_ = this.height / 2;
        //int lvt_9_1_ = true;
        func_213038_a(this.progress, lvt_7_1_, lvt_8_1_ + 30, 2, 0);
        FontRenderer var10001 = this.font;
        this.font.getClass();
        this.drawCenteredString(var10001, lvt_4_1_, lvt_7_1_, lvt_8_1_ - 9 / 2 - 30, 16777215);
    }

    public static void func_213038_a(TrackingChunkStatusListener progress, int p_213038_1_, int p_213038_2_, int p_213038_3_, int p_213038_4_) {
        int lvt_5_1_ = p_213038_3_ + p_213038_4_;
        int lvt_6_1_ = progress.getDiameter();
        int lvt_7_1_ = lvt_6_1_ * lvt_5_1_ - p_213038_4_;
        int lvt_8_1_ = progress.func_219523_d();
        int lvt_9_1_ = lvt_8_1_ * lvt_5_1_ - p_213038_4_;
        int lvt_10_1_ = p_213038_1_ - lvt_9_1_ / 2;
        int lvt_11_1_ = p_213038_2_ - lvt_9_1_ / 2;
        int lvt_12_1_ = lvt_7_1_ / 2 + 1;
        int lvt_13_1_ = -16772609;
        if (p_213038_4_ != 0) {
            fill(p_213038_1_ - lvt_12_1_, p_213038_2_ - lvt_12_1_, p_213038_1_ - lvt_12_1_ + 1, p_213038_2_ + lvt_12_1_, -16772609);
            fill(p_213038_1_ + lvt_12_1_ - 1, p_213038_2_ - lvt_12_1_, p_213038_1_ + lvt_12_1_, p_213038_2_ + lvt_12_1_, -16772609);
            fill(p_213038_1_ - lvt_12_1_, p_213038_2_ - lvt_12_1_, p_213038_1_ + lvt_12_1_, p_213038_2_ - lvt_12_1_ + 1, -16772609);
            fill(p_213038_1_ - lvt_12_1_, p_213038_2_ + lvt_12_1_ - 1, p_213038_1_ + lvt_12_1_, p_213038_2_ + lvt_12_1_, -16772609);
        }

        for(int lvt_14_1_ = 0; lvt_14_1_ < lvt_8_1_; ++lvt_14_1_) {
            for(int lvt_15_1_ = 0; lvt_15_1_ < lvt_8_1_; ++lvt_15_1_) {
                ChunkStatus lvt_16_1_ = progress.func_219525_a(lvt_14_1_, lvt_15_1_);
                int lvt_17_1_ = lvt_10_1_ + lvt_14_1_ * lvt_5_1_;
                int lvt_18_1_ = lvt_11_1_ + lvt_15_1_ * lvt_5_1_;
                fill(lvt_17_1_, lvt_18_1_, lvt_17_1_ + p_213038_3_, lvt_18_1_ + p_213038_3_, COLORS.getInt(lvt_16_1_) | -16777216);
            }
        }

    }
}