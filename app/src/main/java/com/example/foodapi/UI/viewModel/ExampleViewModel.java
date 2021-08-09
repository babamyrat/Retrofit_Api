package com.example.foodapi.UI.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


import com.example.foodapi.model.ExampleModel;
import com.example.foodapi.repository.ExampleRepository;

import java.util.List;

public class ExampleViewModel extends AndroidViewModel {

    private ExampleRepository exampleRepository = ExampleRepository.newInstance(getApplication());

    MutableLiveData<List<ExampleModel>> liveData = new MutableLiveData<>();

    public MutableLiveData<List<ExampleModel>> getLiveData() {
        return liveData;
    }

    public ExampleViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadCategory(){
        exampleRepository.loadCategory(liveData);
    }


}
