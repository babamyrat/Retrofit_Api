package com.example.foodapi.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


import com.example.foodapi.model.ExampleModel;
import com.example.foodapi.repository.DataManager;

import java.util.List;

public class ExampleViewModel extends AndroidViewModel {

    private DataManager dataManager = DataManager.newInstance(getApplication());

    MutableLiveData<List<ExampleModel>> liveData = new MutableLiveData<>();

    public MutableLiveData<List<ExampleModel>> getLiveData() {
        return liveData;
    }

    public ExampleViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadCategory(){
        dataManager.loadCategory(liveData);
    }


}
