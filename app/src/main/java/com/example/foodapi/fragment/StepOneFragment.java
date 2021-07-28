package com.example.foodapi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.foodapi.NavActivity;
import com.example.foodapi.R;

public class StepOneFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_step_one,
                container, false);
        Button button = (Button) view.findViewById(R.id.btnStartButton);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), NavActivity.class);
            startActivity(intent);
        });

        return view;

    }

}
