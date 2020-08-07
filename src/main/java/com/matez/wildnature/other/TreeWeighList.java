package com.matez.wildnature.other;

import net.minecraft.block.Block;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;


import java.util.ArrayList;

public class TreeWeighList {

    protected ArrayList<AbstractTreeFeature> blocks;
    protected ArrayList<Integer> weigh;

    public TreeWeighList(){
        blocks  = new ArrayList<>();
        weigh  = new ArrayList<>();
    }

    public ArrayList<AbstractTreeFeature> getNormalArrayList(){
        ArrayList<AbstractTreeFeature> states = new ArrayList<>();
        int x = 0;
        while(x<this.size()){
            int a = this.getWeighList().get(x);
            int z = 0;
            while(z<a){
                states.add(this.getTreesList().get(x));
                z++;
            }
            x++;
        }


        return states;
    }

    public void add(AbstractTreeFeature block, Integer iWeigh){


        blocks.add(block);
        weigh.add(iWeigh);
    }

    public void remove(AbstractTreeFeature block, Integer iWeigh){
        blocks.remove(block);
        weigh.remove(iWeigh);
    }

    public void remove(AbstractTreeFeature block){
        weigh.remove(weigh.get(blocks.indexOf(block)));
        blocks.remove(block);
    }

    public void clear(){
        weigh.clear();
        blocks.clear();
    }

    public Integer size(){

        if(checkIfEquals()){
            return blocks.size();
        }else{
            return -99999;
        }

    }


    public boolean checkIfEquals(){
        if(blocks.size()==weigh.size()){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Integer> getWeighList(){
        return weigh;
    }

    public ArrayList<AbstractTreeFeature> getTreesList(){
        return blocks;
    }

}