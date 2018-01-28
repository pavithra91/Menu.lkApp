package com.menulk.app.main;

/**
 * Created by Pavithra on 1/17/2018.
 */

public class Shop {
    private String ShopID;
    private String ShopName;
    private String Rating;
    private String OpenTime;
    private String DeliveryTime;
    private String ImageURL;
    private String Tags;

    public Shop(String shopID, String shopName, String rating, String openTime, String deliveryTime, String imageURL, String tags) {
        ShopID = shopID;
        ShopName = shopName;
        Rating = rating;
        OpenTime = openTime;
        DeliveryTime = deliveryTime;
        ImageURL = imageURL;
        Tags = tags;
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

    public String getDeliveryTime() {
        return DeliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        DeliveryTime = deliveryTime;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }

}
