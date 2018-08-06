package com.example.trupti.tpretrofitdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Lenovo on 30-07-2018.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Android_Version_java> android;
    Context context;

    public DataAdapter(ArrayList<Android_Version_java> data, Context applicationContext) {
        this.android=data;
        this.context=applicationContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row,parent,false);
      return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String imageuri = "http://vaksys.com/100_application/api/v1/more_apps";
        //String aurl = "https://i0.wp.com/www.techsolpoint.com/wp-content/uploads/2018/04/";
        holder.name.setText(android.get(position).getName());
        //  Picasso.with(context).load(listiteam.getIcon()).into(holder.imageView);
        //Picasso.with(context).load(url).resize(50, 50).
        //centerCrop().into(imageView);

        holder.link.setText(android.get(position).getLink());
        Picasso.with(context).load(android.get(position).getImage()).into(holder.imge);
        //Picasso.with(context).load(imageuri).resize(50, 50).centerCrop().into(holder.imge);




    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,link;
       ImageView imge;

        public ViewHolder(View itemView) {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.name);
            imge=(ImageView)itemView.findViewById(R.id.imagea);
            link=(TextView)itemView.findViewById(R.id.link);


        }
    }
}
