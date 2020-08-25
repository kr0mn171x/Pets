package com.example.pets;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavoritePets extends AppCompatActivity {
    private RecyclerView lstPets;
    ArrayList<Pet> pets;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.favorite_pets);

        TextView toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_title.setText(R.string.strFavourites);

        Button btnShowCollection = (Button) findViewById(R.id.btnShowCollection);
        btnShowCollection.setVisibility(View.GONE);

        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        lstPets = (RecyclerView) findViewById(R.id.rvFavorites);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        lstPets.setLayoutManager(llm);

        initPets();
        callAdapter();
    }
    private void callAdapter(){
        PetAdapter adapter = new PetAdapter(pets,this);
        lstPets.setAdapter(adapter);
    }
    public void initPets(){
        pets = new ArrayList<Pet>();
        pets.add(new Pet(1,"Pikachu",R.drawable.ic_pikachu,"4"));
        pets.add(new Pet(1,"Squirtle",R.drawable.ic_squirtle,"6"));
        pets.add(new Pet(1,"Charmander",R.drawable.ic_charmander,"8"));
        pets.add(new Pet(1,"Bulbasaur",R.drawable.ic_bulbasaur,"5"));
        pets.add(new Pet(1,"Meowth",R.drawable.ic_meowth,"1"));
    }
}
