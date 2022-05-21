package com.example.belove.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belove.databinding.ProductViewBinding;
import com.example.belove.databinding.TotemViewBinding;
import com.example.belove.models.totem.Totem;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TotemsAdapter extends RecyclerView.Adapter<TotemsAdapter.VH>{

    private ArrayList<Totem> totems;

    public TotemsAdapter(ArrayList<Totem> totems) {
        this.totems = totems;
    }



    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TotemViewBinding binding =TotemViewBinding.inflate(inflater,parent,false);


        return new VH(binding);
    }

    @Override
    public void onBindViewHolder( TotemsAdapter.VH holder, int position) {
        Totem totem = totems.get(position);
        holder.binding.textviewTitle.setText(totem.getTitle());
        holder.binding.textviewDescription.setText(totem.getDescription());
        //holder.binding.imageView.setImageResource(totem.getImage());

        StorageReference storageRef = FirebaseStorage.getInstance().getReference("Images")
                .child(totem.getImageID());
        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(@NonNull Uri uri) {
                Picasso.get().load(uri).into(holder.binding.totemImageView);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(holder.itemView.getContext(),"problem getting image",Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    public int getItemCount() {
        return totems.size();
    }

    static class VH extends RecyclerView.ViewHolder{
        TotemViewBinding binding;

        public VH(TotemViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}

