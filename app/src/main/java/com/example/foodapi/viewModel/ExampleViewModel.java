package com.example.foodapi.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodapi.repository.ExampleRepository;
import com.example.foodapi.response.ExampleResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExampleViewModel extends ViewModel {
    private final MutableLiveData<ExampleResponse> exampleResponseMutableLiveData = new MutableLiveData<>();
    private ExampleRepository exampleRepository = ExampleRepository.getInstanceExample();;

    public MutableLiveData<ExampleResponse> getExampleLiveData() {
        return exampleResponseMutableLiveData;
    }

    public void example() {
        exampleRepository.example().enqueue(new Callback<ExampleResponse>() {
            @Override
            public void onResponse(Call<ExampleResponse> call, Response<ExampleResponse> response) {
                exampleResponseMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ExampleResponse> call, Throwable t) {
                Log.d("error", t.getLocalizedMessage());
            }
        });
    }

}
