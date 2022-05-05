package com.example.belove.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belove.SharedPrefs.SharedPrefs;
import com.example.belove.databinding.ProductViewBinding;
import com.example.belove.models.ShoppingCart.CartItem;
import com.example.belove.models.ShoppingCart.CartItems;
import com.example.belove.models.product.Product;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.VH> {

    private ArrayList<Product> products;
    private static CartItems cartItems;

    public ProductAdapter(ArrayList<Product> products) {
        this.products = products;
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ProductViewBinding binding = ProductViewBinding.inflate(inflater,parent,false);


        return new VH(binding);
    }



    public void onBindViewHolder(ProductAdapter.VH holder, int position) {
        Product product = products.get(position);
        System.out.println(product);
        holder.binding.titleTextView.setText(product.getTitle());
        holder.binding.descriptionTextView.setText(product.getDescription());
        holder.binding.priceTextView.setText(Double.toString(product.getPrice()));
        //holder.binding.imageView.setImageResource(totem.getImage());
        StorageReference storageRef = FirebaseStorage.getInstance().getReference("Images")
                .child(product.getImageID());
        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(@NonNull Uri uri) {
                Picasso.get().load(uri).into(holder.binding.productImageView);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(holder.itemView.getContext(),"problem getting image",Toast.LENGTH_SHORT);
            }
        });

        holder.binding.addToCartButton.setOnClickListener(v -> {
            cartItems = SharedPrefs.getShoppingItems(holder.itemView.getContext());
            CartItem cartItem = new CartItem();
            cartItem.setTitle(product.getTitle());
            cartItem.setPrice(product.getPrice());
            cartItem.setImageID(product.getImageID());
            cartItems.addCartItem(cartItem);
            SharedPrefs.saveShoppingItems(holder.itemView.getContext(), cartItems);
        });

    }


    public int getItemCount() {
        return products.size();
    }

    static class VH extends RecyclerView.ViewHolder{
        ProductViewBinding binding;

        public VH(ProductViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
