package com.example.belove.ui.App.TotemView.TotemRecycler;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.belove.R;
import com.example.belove.adapters.IncenseAdapter;
import com.example.belove.adapters.TotemsAdapter;
import com.example.belove.databinding.IncenseRecyclerFragmentBinding;
import com.example.belove.databinding.TotemRecyclerFragmentBinding;
import com.example.belove.models.incense.Incense;
import com.example.belove.models.incense.Incenses;
import com.example.belove.models.totem.Totem;
import com.example.belove.models.totem.Totems;
import com.example.belove.ui.App.IncenseView.IncenseRecycler.IncenseRecyclerViewModel;
import com.example.belove.ui.App.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TotemRecyclerFragment extends Fragment {

    private TotemRecyclerViewModel totemRecyclerViewModel;
    private TotemRecyclerFragmentBinding binding;
    private DatabaseReference dbRef;
    private static Totems totems = new Totems();
    private static boolean firstOpening = true;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        totemRecyclerViewModel =
                new ViewModelProvider(this).get(TotemRecyclerViewModel.class);
        dbRef = FirebaseDatabase.getInstance("https://belove-c69da-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference().child("Totem");
        binding = TotemRecyclerFragmentBinding.inflate(inflater, container, false);

        //retrieving info
        if (firstOpening) {
            dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        Totem totem = postSnapshot.getValue(Totem.class);
                        totems.addTotem(totem);
                    }
                    TotemsAdapter adapter = new TotemsAdapter(totems.getTotems());
                    binding.totemRecyclerView.setAdapter(adapter);
                    binding.totemRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    System.out.println(totems);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            firstOpening = false;
        }

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.actionButtonAddTotem.setOnClickListener(v -> {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_totemRecyclerFragment_to_totemDataUploadFragment);
        });

        if (!firstOpening){
            TotemsAdapter adapter = new TotemsAdapter(totems.getTotems());
            binding.totemRecyclerView.setAdapter(adapter);
            binding.totemRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.showBottomNav();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}