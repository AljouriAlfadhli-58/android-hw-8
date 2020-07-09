package com.example.pokemon;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
// make an adapter step5
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter {
    //نعرف array من النوع الي نبي نظهره
    ArrayList<pokemon>pArray;
    Context c;
    // constructor


    public PokemonAdapter(ArrayList<pokemon> pArray, Context c) {
        this.pArray = pArray;
        this.c = c;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_list_item,parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder)holder).img.setImageResource(pArray.get(position).getImage());
        ((ViewHolder)holder).pokemonName.setText(pArray.get(position).getName());
        ((ViewHolder)holder).pokemonTotal.setText(pArray.get(position).getTotal()+"");
        ((ViewHolder)holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(c,detailes.class);
                i.putExtra("pokemon",pArray.get(position));

                c.startActivity(i);

            }
        });
        ((ViewHolder)holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pArray.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return pArray.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // select the items that we wonna show it
        public ImageView img;
        public TextView pokemonName;
        public TextView pokemonTotal;
        public View view;
        public  ImageView delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            pokemonName=itemView.findViewById(R.id.textView);
            pokemonTotal=itemView.findViewById(R.id.textView3);
            img=itemView.findViewById(R.id.imageView2);
            delete=itemView.findViewById(R.id.imageView6);
        }
    }
}
