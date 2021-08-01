package com.example.foodapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapi.model.ExampleModel;
import com.example.foodapi.R;

import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private final List<ExampleModel> dataList;
    private final Context context;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtNumber;
        private final ImageView coverImage;

        ExampleViewHolder(View itemView) {
            super(itemView);

            txtNumber = itemView.findViewById(R.id.textView2);
            txtTitle = itemView.findViewById(R.id.textView);
            coverImage = itemView.findViewById(R.id.imageView);

        }

    }

    public ExampleAdapter(Context context, List<ExampleModel> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ExampleAdapter.ExampleViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ExampleAdapter.ExampleViewHolder holder, int position) {

        holder.txtTitle.setText(dataList.get(position).getStrCategory());
        holder.txtNumber.setText(dataList.get(position).getIdCategory());

        Glide.with(context)
                .load(dataList.get(position).getStrCategoryThumb())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.coverImage);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}
