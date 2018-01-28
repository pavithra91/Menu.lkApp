package com.menulk.app.menu;

/**
 * Created by pavithraj on 1/18/2018.
 */

public class MenuItem {
    private String ItemID;
    private String RestaurantID;
    private String ItemName;
    private String Description;
    private String Price;
    private String Image;

    public MenuItem(String itemID, String restaurantID, String itemName, String description, String price, String image) {
        ItemID = itemID;
        RestaurantID = restaurantID;
        ItemName = itemName;
        Description = description;
        Price = price;
        Image = image;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getRestaurantID() {
        return RestaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        RestaurantID = restaurantID;
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
