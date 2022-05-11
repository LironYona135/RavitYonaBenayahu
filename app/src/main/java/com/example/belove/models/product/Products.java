package com.example.belove.models.product;

import java.util.ArrayList;

public class Products {
    public ArrayList<Product> products = new ArrayList<>();

    public Products(){}

    public void addProduct(Product product){
        getProducts().add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Products{" +
                "products=" + products +
                '}';
    }
}
