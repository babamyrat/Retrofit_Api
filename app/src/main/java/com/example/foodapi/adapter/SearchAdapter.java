package com.example.foodapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapi.R;
import com.example.foodapi.model.SearchModel;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private final List<SearchModel> dataList;
    private final Context context;

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
        holder.idMeal.setText(dataList.get(position).getIdMeal());
        holder.strMeal.setText(dataList.get(position).getStrMeal());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getStrMealThumb())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.strMealThumb);
    }

    @Override
    public int getItemCount() {
        if(dataList==null) return 0;
        return dataList.size();
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        TextView idMeal, strMeal;
        private final ImageView strMealThumb;

        public SearchViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mView = itemView;
            idMeal = mView.findViewById(R.id.idMeal);
            strMeal = mView.findViewById(R.id.strMeal);
            strMealThumb = mView.findViewById(R.id.strMealThumb);
        }
    }
}
