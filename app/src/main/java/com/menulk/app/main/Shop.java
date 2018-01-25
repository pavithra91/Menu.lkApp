package com.menulk.app.main;

/**
 * Created by Pavithra on 1/17/2018.
 */

public class Shop {
    private String ShopID;
    private String ShopName;
    private String Rating;
    private String OpenTime;
    private String ImageURL;

    public Shop(String shopID, String shopName, String rating, String openTime, String imageURL) {
        ShopID = shopID;
        ShopName = shopName;
        Rating = rating;
        OpenTime = openTime;
        ImageURL = imageURL;
    }

    public String getShopID() {
        return ShopID;
    }

    public void setShopID(String shopID) {
        ShopID = shopID;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getOpenTime() {
        return OpenTime;
    }

    public void setOpenTime(String openTime) {
        OpenTime = openTime;
    }
    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }
}
