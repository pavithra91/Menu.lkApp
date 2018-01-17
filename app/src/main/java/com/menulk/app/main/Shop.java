package com.menulk.app.main;

/**
 * Created by Pavithra on 1/17/2018.
 */

public class Shop {
    private String ShopName;
    private String Rating;
    private String OpenTime;

    public Shop(String shopName, String rating, String openTime) {
        ShopName = shopName;
        Rating = rating;
        OpenTime = openTime;
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
}
