package com.menulk.app.AppCode;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Pavithra on 1/23/2018.
 */

public class CustomerOrder implements Parcelable{

    private String OrderID;
    private int RestaurantID;
    private int ItemId;
    private String ItemPrice;
    private String ItemDescription;
    private String ItemImage;

    public CustomerOrder(String orderID, int restaurantID, int itemId, String itemPrice, String itemDescription, String itemImage) {
        OrderID = orderID;
        RestaurantID = restaurantID;
        ItemId = itemId;
        ItemPrice = itemPrice;
        ItemDescription = itemDescription;
        ItemImage = itemImage;
    }

    protected CustomerOrder(Parcel in) {
        OrderID = in.readString();
        RestaurantID = in.readInt();
        ItemId = in.readInt();
        ItemPrice = in.readString();
        ItemDescription = in.readString();
        ItemImage = in.readString();
    }

    public static final Creator<CustomerOrder> CREATOR = new Creator<CustomerOrder>() {
        @Override
        public CustomerOrder createFromParcel(Parcel in) {
            return new CustomerOrder(in);
        }

        @Override
        public CustomerOrder[] newArray(int size) {
            return new CustomerOrder[size];
        }
    };

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public int getRestaurantID() {
        return RestaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        RestaurantID = restaurantID;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(String itemPrice) {
        ItemPrice = itemPrice;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
    }

    public String getItemImage() {
        return ItemImage;
    }

    public void setItemImage(String itemImage) {
        ItemImage = itemImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(OrderID);
        parcel.writeInt(RestaurantID);
        parcel.writeInt(ItemId);
        parcel.writeString(ItemPrice);
        parcel.writeString(ItemDescription);
        parcel.writeString(ItemImage);
    }
}
