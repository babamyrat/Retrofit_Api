package com.example.foodapi.fragmentActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodapi.ApiInterface;
import com.example.foodapi.R;
import com.example.foodapi.adapter.ExampleAdapter;
import com.example.foodapi.model.ExampleModel;
import com.example.foodapi.response.ServerResponse;
import com.example.foodapi.retrofit.ApiClient;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */

public class HomeFragment extends Fragment {
    View view;
    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        serviceClient();

    return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


    private void serviceClient() {
        //Create handle for the RetrofitInstance interface
        ApiInterface service = ApiClient.getRetrofitInstance().create(ApiInterface.class);
        Call<ServerResponse> call = service.getAllPhotos();
        call.enqueue(new retrofit2.Callback<ServerResponse>() {

            @Override
            public void onResponse(@NotNull Call<ServerResponse> call, @NotNull Response<ServerResponse> response) {     // Response
                progressDialog.dismiss();   // progress
                if (response.isSuccessful()){
                    assert response.body() != null;
                    generateDataList(response.body().getCategories());
                }
            }

            @Override
            public void onFailure(@NotNull Call<ServerResponse> call, @NotNull Throwable t) {       // in not on uri
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Method to generate List of data using RecyclerView with custom adapter
    private void generateDataList(List<ExampleModel> photoList) {
        ExampleAdapter adapter = new ExampleAdapter(getContext(), photoList);
        ViewPager2 pager=view.findViewById(R.id.pager);
        pager.setAdapter(adapter);
        TabLayout tabLayout = view.findViewById(R.id.tapLayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, pager, (tab, position) ->
                tab.setText(photoList.get(position).getStrCategory()));
        tabLayoutMediator.attach();
    }
}