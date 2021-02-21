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
public class BackpackItem {
    private int id;
    private int idBackpack;
    private int idItem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBackpack() {
        return idBackpack;
    }

    public void setIdBackpack(int idBackpack) {
        this.idBackpack = idBackpack;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public BackpackItem(int id, int idBackpack, int idItem) {
        this.id = id;
        this.idBackpack = idBackpack;
        this.idItem = idItem;
    }

    public BackpackItem() {
    }
    
}
