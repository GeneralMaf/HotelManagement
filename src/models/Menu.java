/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author I2S
 */
public class Menu {

    private int menu_item_id;
    private String item_name;
    private String category;
    private float price;
    private int stock_quantity;
    private String description;

    public Menu(String item_name, String category, float price, int stock_quantity, String description) {
        this.item_name = item_name;
        this.category = category;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.description = description;
    }

    public Menu(int menu_item_id, String item_name, String category, float price, int stock_quantity, String description) {
        this.menu_item_id = menu_item_id;
        this.item_name = item_name;
        this.category = category;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.description = description;
    }

    public int getMenu_item_id() {
        return menu_item_id;
    }

    public void setMenu_item_id(int menu_item_id) {
        this.menu_item_id = menu_item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

}
