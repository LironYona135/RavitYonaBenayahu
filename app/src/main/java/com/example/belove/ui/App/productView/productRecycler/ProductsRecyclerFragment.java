package com.example.belove.ui.App.productView.productRecycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.belove.R;
import com.example.belove.adapters.ProductAdapter;
import com.example.belove.databinding.ProductsRecyclerFragmentBinding;
import com.example.belove.models.product.Product;
import com.example.belove.models.product.Products;
import com.example.belove.ui.App.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProductsRecyclerFragment extends Fragment {

    private ProductsRecyclerViewModel productsRecyclerViewModel;
    private ProductsRecyclerFragmentBinding binding;
    private DatabaseReference dbRef;
    private static final Products PRODUCTS = new Products();
    private static boolean firstOpening = true;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productsRecyclerViewModel =
                new ViewModelProvider(this).get(ProductsRecyclerViewModel.class);
        dbRef = FirebaseDatabase.getInstance("https://belove-c69da-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference().child("Incense");
        binding = ProductsRecyclerFragmentBinding.inflate(inflater, container, false);


        //retrieving info
        if (firstOpening) {
            dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        Product product = postSnapshot.getValue(Product.class);
                        PRODUCTS.addProduct(product);
                    }
                    //todo:save uri so that you dont have to go to internet everytime to get photos
                    ProductAdapter adapter = new ProductAdapter(PRODUCTS.getProducts());
                    binding.productRecyclerView.setAdapter(adapter);
                    binding.productRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    System.out.println(PRODUCTS);
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
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();

        if (email != null) {
            if (email.equalsIgnoreCase("lironyona135@gmail.com") | email.equalsIgnoreCase("yaniv.shtein@gmail.com")) {
                binding.actionButtonAddIncense.setVisibility(View.VISIBLE);
            } else {
                binding.actionButtonAddIncense.setVisibility(View.INVISIBLE);
            }
        }
        binding.actionButtonAddIncense.setOnClickListener(v -> {
            NavHostFragment.findNavController(ProductsRecyclerFragment.this)
                    .navigate(R.id.action_incenseRecyclerFragment_to_incenseDataUploadFragment);
        });


        if (!firstOpening) {
            ProductAdapter adapter = new ProductAdapter(PRODUCTS.getProducts());
            binding.productRecyclerView.setAdapter(adapter);
            binding.productRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }


//todo:after entering this screen once the data is downloaded and kept till destory or for a time that we will set

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