package com.example.belove.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.belove.SharedPrefs.SharedPrefs;
import com.example.belove.databinding.ShoppingCartViewBinding;
import com.example.belove.models.ShoppingCart.CartItem;

import java.util.ArrayList;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.VH> {

    private ArrayList<CartItem> cartItems;

    public ShoppingCartAdapter(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }



    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ShoppingCartViewBinding binding = ShoppingCartViewBinding.inflate(inflater,parent,false);


        return new VH(binding);
    }



    public void onBindViewHolder( ShoppingCartAdapter.VH holder, int position) {
        CartItem cartItem = cartItems.get(position);
        holder.binding.titleTextView.setText(cartItem.getTitle());
        holder.binding.priceTextView.setText(Double.toString(cartItem.getPrice()));
        holder.binding.btnRemove.setOnClickListener(v -> {
            SharedPrefs.removeShoppingItem(holder.itemView.getContext(),position);
            cartItems.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, cartItems.size());
        });
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
