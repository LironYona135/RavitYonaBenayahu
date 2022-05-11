package com.example.belove.SharedPrefs;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.belove.adapters.ProductAdapter;
import com.example.belove.models.ShoppingCart.CartItem;
import com.example.belove.models.ShoppingCart.CartItems;
import com.google.gson.Gson;

public final class SharedPrefs {
    private SharedPrefs() {}
private static Gson gson = new Gson();

    public static void saveShoppingItems(Context context, CartItems cartItems){
        SharedPreferences prefs = context.getSharedPreferences("ShoppingCart",MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        String json = gson.toJson(cartItems);
        prefsEditor.putString("ShoppingCart", json).commit();
    }

    public static CartItems getShoppingItems(Context context){
        SharedPreferences prefs = context.getSharedPreferences("ShoppingCart",MODE_PRIVATE);
        String json = prefs.getString("ShoppingCart", null);
        CartItems cartItems = gson.fromJson(json, CartItems.class);
        return cartItems;
    }


public static void removeShoppingItem(Context context, int position){
    CartItems cartItems = getShoppingItems(context);
    cartItems.removeCartItem(position);
    saveShoppingItems(context,cartItems);
}
}
