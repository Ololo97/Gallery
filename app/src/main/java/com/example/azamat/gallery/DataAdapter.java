package com.example.azamat.gallery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.viewHolder> {
    private List<Pojo.Photo> images;
    Context context;
    public DataAdapter(Context context, List<Pojo.Photo> images) {
        this.images=images;
        this.context=context;
    }
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
            Long farm = images.get(position).getFarm();
            String server = images.get(position).getServer();
            String id = images.get(position).getId();
            String secret = images.get(position).getSecret();
             String s ="https://farm" + farm + ".staticflickr.com/" + server + "/" + id + "_" + secret + ".jpg";
                Picasso.with(context).load(s).into(holder.itemImage);
        /**
         * https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
         * */
    }

    @Override
    public int getItemCount() {
        if(images==null)
            return  0;
        return images.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        public viewHolder(View itemView) {
            super(itemView);
            itemImage= itemView.findViewById(R.id.image);
        }
    }
}