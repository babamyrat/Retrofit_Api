package com.example.retrofitapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapi.fragment.PageFragment;
import com.example.retrofitapi.model.ExampleModel;
import com.example.retrofitapi.R;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.CustomViewHolder> {
    private List<ExampleModel> dataList;
    private Context context;

    public ExampleAdapter(Context context, List<ExampleModel> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        TextView txtTitle, txtNumber;
        private ImageView coverImage;

        CustomViewHolder(View itemView) {
         super(itemView);
         mView = itemView;

         txtNumber = mView.findViewById(R.id.textView2);
         txtTitle = mView.findViewById(R.id.textView);
         coverImage = mView.findViewById(R.id.imageView);

        }

    }


    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ExampleAdapter.CustomViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ExampleAdapter.CustomViewHolder holder, int position) {

        holder.txtTitle.setText(dataList.get(position).getStrCategory());
        holder.txtNumber.setText(dataList.get(position).getIdCategory());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getStrCategoryThumb())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.coverImage);

    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
