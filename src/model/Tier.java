/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Oem
 */
public class Tier {
    private int id;
    private int tierNumber;
    private int requiredExp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTierNumber() {
        return tierNumber;
    }

    public void setTierNumber(int tierNumber) {
        this.tierNumber = tierNumber;
    }

    public int getRequiredExp() {
        return requiredExp;
    }

    public void setRequiredExp(int requiredExp) {
        this.requiredExp = requiredExp;
    }

    public Tier() {
    }

    public Tier(int id, int tierNumber, int requiredExp) {
        this.id = id;
        this.tierNumber = tierNumber;
        this.requiredExp = requiredExp;
    }

    @Override
    public String toString() {
        return "Tier{" + "id=" + id + ", tierNumber=" + tierNumber + ", requiredExp=" + requiredExp + '}';
    }
    
    
}
