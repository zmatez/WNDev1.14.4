package com.matez.wildnature.world.gen.feature.configs;

import com.google.common.collect.ImmutableMap;
import com.matez.wildnature.other.BlockWeighList;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.IProperty;
import net.minecraft.state.IStateHolder;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.EndSpikeFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlockWeightListConfig implements IFeatureConfig {
   public final BlockWeighList list;

   public BlockWeightListConfig(BlockWeighList list) {
      this.list = list;
   }

   public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
      return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("blockstates"), ops.createList(serializeList(ops,list.getNormalArrayList()).stream()))));
   }

   private <T> ArrayList<T> serializeList(DynamicOps<T> ops, ArrayList<BlockState> states){
      ArrayList<T> serializedList = new ArrayList<>();
      for (BlockState state : states) {
         serializedList.add(BlockState.serialize(ops, state).getValue());
      }
      return serializedList;
   }

   public static <T> BlockWeightListConfig deserialize(Dynamic<T> dynamic) {
      List<BlockState> blockstates = dynamic.get("blockstates").asList(BlockState::deserialize);
      return new BlockWeightListConfig(BlockWeighList.parseFromNormalArrayList((ArrayList<BlockState>)blockstates));
   }
}