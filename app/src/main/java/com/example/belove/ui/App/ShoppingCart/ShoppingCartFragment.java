package com.example.belove.ui.App.ShoppingCart;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.belove.R;
import com.example.belove.SharedPrefs.SharedPrefs;
import com.example.belove.adapters.IncenseAdapter;
import com.example.belove.adapters.ShoppingCartAdapter;
import com.example.belove.databinding.ShoppingCartFragmentBinding;
import com.example.belove.models.ShoppingCart.CartItems;


public class ShoppingCartFragment extends Fragment {

    private ShoppingCartViewModel shoppingCartViewModel;
    private ShoppingCartFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shoppingCartViewModel =
                new ViewModelProvider(this).get(ShoppingCartViewModel.class);

        binding = ShoppingCartFragmentBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CartItems cartItems = SharedPrefs.getShoppingItems(getContext());
        if (cartItems != null) {
            ShoppingCartAdapter adapter = new ShoppingCartAdapter(cartItems.getCartItems());
            binding.shoppingCartRecyclerView.setAdapter(adapter);
            binding.shoppingCartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        binding.checkoutBtn.setOnClickListener(v -> {

            NavHostFragment.findNavController(ShoppingCartFragment.this)
                    .navigate(R.id.action_shoppingCart_to_addressesFragment);
        });



    }
}