package com.example.belove.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belove.databinding.IncenseViewBinding;
import com.example.belove.models.incense.Incense;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class IncenseAdapter extends RecyclerView.Adapter<IncenseAdapter.VH> {

    private ArrayList<Incense> incenses;

    public IncenseAdapter(ArrayList<Incense> incenses) {
        this.incenses = incenses;
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        IncenseViewBinding binding = IncenseViewBinding.inflate(inflater);


        return new VH(binding);
    }



    public void onBindViewHolder( IncenseAdapter.VH holder, int position) {
        Incense incense = incenses.get(position);
        System.out.println(incense);
        holder.binding.titleTextView.setText(incense.getTitle());
        holder.binding.descriptionTextView.setText(incense.getDescription());
        //holder.binding.imageView.setImageResource(totem.getImage());
        StorageReference storageRef = FirebaseStorage.getInstance().getReference("Images")
                .child(incense.getImageID());
        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(@NonNull Uri uri) {
                Picasso.get().load(uri).into(holder.binding.incenseImageView);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(holder.itemView.getContext(),"problem getting image",Toast.LENGTH_SHORT);
            }
        });

    }


    public int getItemCount() {
        return incenses.size();
    }

    static class VH extends RecyclerView.ViewHolder{
        IncenseViewBinding binding;

        public VH(IncenseViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
