package com.example.belove.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.belove.databinding.IncenseViewBinding;
import com.example.belove.models.incense.Incense;


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
