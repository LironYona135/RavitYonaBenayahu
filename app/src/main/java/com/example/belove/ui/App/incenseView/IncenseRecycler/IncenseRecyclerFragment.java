package com.example.belove.ui.App.incenseView.IncenseRecycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.belove.R;
import com.example.belove.databinding.IncenseRecyclerFragmentBinding;
import com.example.belove.models.incense.Incense;
import com.example.belove.models.incense.Incenses;
import com.example.belove.ui.App.MainActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firestore.v1.Document;

import java.util.ArrayList;
import java.util.List;


public class IncenseRecyclerFragment extends Fragment {

    private IncenseRecyclerViewModel incenseRecyclerViewModel;
    private IncenseRecyclerFragmentBinding binding;
    private DocumentReference dbRef;
    private ArrayList<Incense> incenses = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        incenseRecyclerViewModel =
                new ViewModelProvider(this).get(IncenseRecyclerViewModel.class);
        dbRef = FirebaseFirestore.getInstance().collection("Data").document("Incenses");
        binding = IncenseRecyclerFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.actionButtonAddIncense.setOnClickListener(v -> {
            NavHostFragment.findNavController(IncenseRecyclerFragment.this).navigate(R.id.action_incenseRecyclerFragment_to_incenseDataUploadFragment);
        });


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