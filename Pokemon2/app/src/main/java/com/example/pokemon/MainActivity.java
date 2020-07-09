package com.example.pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // make an array an items(pokemons) step2
        ArrayList<pokemon> myPokemons = new ArrayList<>();
        pokemon p1 = new pokemon("Bulbasaur",R.drawable.bulbasaur,49,49,318);
        pokemon p2 = new pokemon("Charizard",R.drawable.charizard,84,78,534);
        pokemon p3 = new pokemon("Pikachu",R.drawable.pikachu,55,40,320);
        pokemon p4 = new pokemon("Clefable",R.drawable.clefable,70,73,483);

        myPokemons.add(p1);
        myPokemons.add(p2);
        myPokemons.add(p3);
        myPokemons.add(p4);
        myPokemons.add(p1);

        //connect the recycler view with the activity step3
        RecyclerView rv = findViewById(R.id.RecyclerView);

        rv.addItemDecoration(new DividerItemDecoration(this,
        DividerItemDecoration.VERTICAL));

        // to arranging the items
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);


        PokemonAdapter adapter = new PokemonAdapter(myPokemons,this);
        rv.setAdapter(adapter);



    }
}