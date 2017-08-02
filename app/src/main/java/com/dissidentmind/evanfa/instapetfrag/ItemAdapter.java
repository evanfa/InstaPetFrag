package com.dissidentmind.evanfa.instapetfrag;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Fabio on 7/23/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    ArrayList<Pet> items;
    Activity activity;
    //final ImageButton btns = (ImageButton) findViewById(R.id.btnStar);

    public ItemAdapter(ArrayList<Pet> items, Activity activity){
        this.items = items;
        this.activity = activity;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //Populate Layout - Infate Layout and pass it to viewholder to get ecah element
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item,parent,false);
        return new ItemViewHolder(v);
        //return null;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) { //Associate each element from the list to each view

        final Pet item = items.get(position);

        holder.namePet.setText(String.valueOf(item.getNamePet()));
        holder.votosPet.setText(String.valueOf(item.getValuePet()));
        holder.fotoPet.setImageResource(item.getFotoPet());

        holder.fotoPet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, item.getNamePet(), Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(activity, FiveStarsPets.class);
                intent.putExtra("petname",item.getNamePet());
                intent.putExtra("petcalif", item.getValuePet());
                intent.putExtra("petpic", item.getFotoPet());
                activity.startActivity(intent);*/
            }
        });

        holder.btnVote.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                item.setValuePet(item.getValuePet()+1);
                holder.votosPet.setText(Integer.toString(item.getValuePet()));
            }
        });

    }

    @Override
    public int getItemCount() { //List Size
        //return 0;
        return items.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        /**
         * Declaración Views
         *
         * @param itemView
         */
        private ImageView fotoPet;
        private TextView namePet;
        private TextView votosPet;
        private ImageButton btnVote;
        //private Button btnStar;

        public ItemViewHolder(View itemView) {
            super(itemView);

            fotoPet = (ImageView) itemView.findViewById(R.id.imgFoto);
            namePet = (TextView) itemView.findViewById(R.id.tvName);
            votosPet = (TextView) itemView.findViewById(R.id.tvCalif);
            btnVote = (ImageButton) itemView.findViewById(R.id.btnVote);

            //btnStar = (Button) itemView.findViewById(R.id.btnStar);
        }
    }
}