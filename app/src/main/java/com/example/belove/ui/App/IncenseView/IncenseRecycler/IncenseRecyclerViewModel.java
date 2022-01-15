package com.example.belove.ui.App.IncenseView.IncenseRecycler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IncenseRecyclerViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public IncenseRecyclerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}