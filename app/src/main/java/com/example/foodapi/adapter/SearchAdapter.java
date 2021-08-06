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
import com.example.foodapi.R;
import com.example.foodapi.model.SearchModel;
import com.example.foodapi.response.SearchResponse;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private List<SearchModel> dataList;
    private final Context context;

    public void addItems(List<SearchModel> categories) {
        this.dataList.clear();
        this.dataList.addAll(categories);
        notifyDataSetChanged();
    }


    public static class SearchViewHolder extends RecyclerView.ViewHolder {
        TextView idMeal, strMeal;
        private final ImageView strMealThumb;

        public SearchViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            //idMeal = itemView.findViewById(R.id.idMeal);
            strMeal = itemView.findViewById(R.id.strMeal);
            strMealThumb = itemView.findViewById(R.id.strMealThumb);
        }
    }


    public SearchAdapter(List<SearchModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.search_item, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SearchAdapter.SearchViewHolder holder, int position) {
       // holder.idMeal.setText(dataList.get(position).getIdMeal());
        holder.strMeal.setText(dataList.get(position).getStrMeal());

        Glide.with(context)
                .load(dataList.get(position).getStrMealThumb())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.strMealThumb);
    }

    @Override
    public int getItemCount() {
        if (dataList == null) return 0;
        return dataList.size();
    }

//    public void addData(List<SearchModel> listModel) {
//        if (listModel != null)
//            dataList = listModel;
//        else
//            dataList.clear();
//        notifyDataSetChanged();
//    }


}
