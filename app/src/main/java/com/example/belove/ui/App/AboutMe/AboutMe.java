package com.example.belove.ui.App.AboutMe;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.belove.R;
import com.example.belove.databinding.AboutMeFragmentBinding;
import com.example.belove.databinding.ShoppingCartFragmentBinding;
import com.example.belove.ui.App.ShoppingCart.ShoppingCartViewModel;

public class AboutMe extends Fragment {


    private AboutMeViewModel aboutMeViewModel;
    private AboutMeFragmentBinding binding;

@Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutMeViewModel =
                new ViewModelProvider(this).get(AboutMeViewModel.class);

        binding = AboutMeFragmentBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}