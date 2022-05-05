package com.example.belove.models.product;

public class Product {
    private String title;
    private String description;
    private double price;
    private String imageID;
    private boolean inStock;
    //todo:probably dont need incenseID
    private String productID;

//    public Incense(String title, String description, double price, String imageID, boolean inStock,String incenseID) {
//        setTitle(title);
//        setDescription(description);
//        setPrice(price);
//        setImageID(imageID);
//        setInStock(inStock);
//        setIncenseID(incenseID);
//    }


    public Product() {
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String incenseID) {
        this.productID = incenseID;
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

    //todo:do we need this constructor?
    public Product(String title, String description, double price, String imageID, boolean inStock, String productID) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageID = imageID;
        this.inStock = inStock;
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageID='" + imageID + '\'' +
                ", inStock=" + inStock +
                ", productID='" + productID + '\'' +
                '}';
    }
}
