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

class Item {
    private int id;
    private int idWeapon;
    private int idArmor;
    private Object item;
    /*private Weapon weapon;
    private Armor armor;
    private Backpack backpack;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdWeapon() {
        return idWeapon;
    }

    public void setIdWeapon(int idWeapon) {
        this.idWeapon = idWeapon;
    }

    public int getIdArmor() {
        return idArmor;
    }

    public void setIdArmor(int idArmor) {
        this.idArmor = idArmor;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public Item(int id, int idWeapon, int idArmor, Object item) {
        this.id = id;
        this.idWeapon = idWeapon;
        this.idArmor = idArmor;
        this.item = item;
    }

    public Item() {
    }
    
    
}
