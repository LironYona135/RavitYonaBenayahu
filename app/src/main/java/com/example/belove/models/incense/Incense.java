package com.example.belove.models.incense;

public class Incense {
    private String title;
    private String description;
    private double price;
    private String imageID;
    private boolean inStock;
    private String incenseID;

//    public Incense(String title, String description, double price, String imageID, boolean inStock,String incenseID) {
//        setTitle(title);
//        setDescription(description);
//        setPrice(price);
//        setImageID(imageID);
//        setInStock(inStock);
//        setIncenseID(incenseID);
//    }

    public Incense(String headLine_test, String description_test, int i, String imageID, boolean b) {
    }

    public String getIncenseID() {
        return incenseID;
    }

    public void setIncenseID(String incenseID) {
        this.incenseID = incenseID;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
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

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Incense(String title, String description, double price, String imageID, boolean inStock, String incenseID) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageID = imageID;
        this.inStock = inStock;
        this.incenseID = incenseID;
    }

    @Override
    public String toString() {
        return "incense{" +
                ", headLine='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageID='" + imageID + '\'' +
                ", inStock=" + inStock +
                '}';
    }
}
