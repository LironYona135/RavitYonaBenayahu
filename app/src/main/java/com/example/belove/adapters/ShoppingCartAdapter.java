package com.example.belove.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belove.SharedPrefs.SharedPrefs;
import com.example.belove.databinding.IncenseViewBinding;
import com.example.belove.databinding.ShoppingCartViewBinding;
import com.example.belove.models.ShoppingCart.CartItem;
import com.example.belove.models.incense.Incense;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.VH> {

    private ArrayList<CartItem> cartItems;

    public ShoppingCartAdapter(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }



    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ShoppingCartViewBinding binding = ShoppingCartViewBinding.inflate(inflater);


        return new VH(binding);
    }



    public void onBindViewHolder( ShoppingCartAdapter.VH holder, int position) {
        CartItem cartItem = cartItems.get(position);
        holder.binding.titleTextView.setText(cartItem.getTitle());
        holder.binding.priceTextView.setText(Double.toString(cartItem.getPrice()));
    }


    public int getItemCount() {
        return cartItems.size();
    }

    static class VH extends RecyclerView.ViewHolder{
        ShoppingCartViewBinding binding;

        public VH(ShoppingCartViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
