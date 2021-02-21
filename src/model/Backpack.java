/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Oem
 */
public class Backpack {
    private int id;
    private double weightlimit;
    private double currentWeight;
    private List<Item> itens;
    private Picture picture;
    private Tier tier;

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }
    
    

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getWeightlimit() {
        return weightlimit;
    }

    public void setWeightlimit(double weightlimit) {
        this.weightlimit = weightlimit;
    }

    public Backpack(int id, double weightlimit, double currentWeight, List<Item> itens, Picture picture, Tier tier) {
        this.id = id;
        this.weightlimit = weightlimit;
        this.currentWeight = currentWeight;
        this.itens = itens;
        this.picture = picture;
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Backpack{" + "id=" + id + ", weightlimit=" + weightlimit + ", currentWeight=" + currentWeight + ", itens=" + itens + ", picture=" + picture + ", tier=" + tier + '}';
    }

  


}
