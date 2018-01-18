package com.menulk.app.menu;

/**
 * Created by pavithraj on 1/18/2018.
 */

public class MenuItem {
    private String ItemName;
    private String Description;
    private String Price;
    private String Image;

    public MenuItem(String itemName, String description, String price, String image) {
        ItemName = itemName;
        Description = description;
        Price = price;
        Image = image;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
