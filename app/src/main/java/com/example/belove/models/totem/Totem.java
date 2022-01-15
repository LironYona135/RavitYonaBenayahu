package com.example.belove.models.totem;

public class Totem {

    private String title;
    private String description;
    private double price;
    private String imageID;
    private boolean inStock;
    private String incenseID;



    public Totem(String title, String description, double price, String imageID, boolean inStock, String incenseID) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageID = imageID;
        this.inStock = inStock;
        this.incenseID = incenseID;
    }

    public Totem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getIncenseID() {
        return incenseID;
    }

    public void setIncenseID(String incenseID) {
        this.incenseID = incenseID;
    }

    @Override
    public String toString() {
        return "Totem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageID='" + imageID + '\'' +
                ", inStock=" + inStock +
                ", incenseID='" + incenseID + '\'' +
                '}';
    }
}
