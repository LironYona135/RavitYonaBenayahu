package com.example.belove.models.ShoppingCart;

public class CartItem {

    private String title;
    private double price;
    private String imageID;

    public CartItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", imageID='" + imageID + '\'' +
                '}';
    }
}
