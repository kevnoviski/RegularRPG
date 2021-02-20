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

    public Backpack(int id, double weightlimit, double currentWeight, List<Item> itens) {
        this.id = id;
        this.weightlimit = weightlimit;
        this.currentWeight = currentWeight;
        this.itens = itens;
    }



    @Override
    public String toString() {
        return "Backpack{" + "id=" + id + ", weightlimit=" + weightlimit + '}';
    }
    
}
