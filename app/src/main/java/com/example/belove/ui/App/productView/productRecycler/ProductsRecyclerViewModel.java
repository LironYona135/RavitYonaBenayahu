package com.example.belove.ui.App.productView.productRecycler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductsRecyclerViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProductsRecyclerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}