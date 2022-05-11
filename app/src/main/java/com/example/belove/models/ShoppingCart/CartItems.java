package com.example.belove.models.ShoppingCart;

import java.util.ArrayList;

public class CartItems {
    private ArrayList<CartItem> cartItems = new ArrayList<>();

    public CartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public CartItems() {
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addCartItem(CartItem item){
        cartItems.add(item);
    }

    public void removeCartItem(int position){
        cartItems.remove(position);
    }


    @Override
    public String toString() {
        return "CartItems{" +
                "cartItems=" + cartItems +
                '}';
    }
}
