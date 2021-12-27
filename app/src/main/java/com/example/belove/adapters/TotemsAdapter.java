package com.example.belove.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.belove.databinding.TotemViewBinding;
import com.example.belove.models.totem.Totem;

import java.util.ArrayList;

public class TotemsAdapter extends RecyclerView.Adapter<TotemsAdapter.VH>{

    private ArrayList<Totem> totems;

    public TotemsAdapter(ArrayList<Totem> totems) {
        this.totems = totems;
    }



    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TotemViewBinding binding = TotemViewBinding.inflate(inflater);


        return new VH(binding);
    }

    @Override
    public void onBindViewHolder( TotemsAdapter.VH holder, int position) {
        Totem totem = totems.get(position);
        holder.binding.textviewTitle.setText(totem.getTitle());
        holder.binding.textviewDescription.setText(totem.getDescription());
        //holder.binding.imageView.setImageResource(totem.getImage());
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

