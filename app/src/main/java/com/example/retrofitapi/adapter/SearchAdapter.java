package com.example.retrofitapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapi.R;
import com.example.retrofitapi.model.SearchModel;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> implements Filterable {
    private List<SearchModel> dataList;
    private Context context;
    private List<SearchModel> mExampleListFull; //Search code

    public SearchAdapter(List<SearchModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
        mExampleListFull = new ArrayList<>(dataList); //Code for search
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
        return dataList.size();
    }


    public class SearchViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        TextView idMeal, strMeal;
        private ImageView strMealThumb;

        public SearchViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mView = itemView;
            idMeal = mView.findViewById(R.id.idMeal);
            strMeal = mView.findViewById(R.id.strMeal);
            strMealThumb = mView.findViewById(R.id.strMealThumb);
        }
    }

    //------------------search codes ----------------------------------------------------------//

    @Override
    public Filter getFilter() {
        return mExampleFilter;
    }

    private Filter mExampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<SearchModel> filteredArrayList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredArrayList.addAll(mExampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (SearchModel item : mExampleListFull){
                    if (item.getStrMeal().toLowerCase().contains(filterPattern)){
                        filteredArrayList.add(item);

                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredArrayList;

            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dataList.clear();
            dataList.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };

    //------------------------------end---------------------------------------------------//
}
