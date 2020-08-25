package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView lstPets;
    ArrayList<Pet> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_title.setText(R.string.strPets);
        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        lstPets = (RecyclerView) findViewById(R.id.rvPets);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        lstPets.setLayoutManager(llm);

        initPets();
        callAdapter();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Menu) {
            Toast.makeText(this,"Menu de solo vista",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private void callAdapter(){
        PetAdapter adapter = new PetAdapter(pets,this);
        lstPets.setAdapter(adapter);
    }

    public void initPets(){
        pets = new ArrayList<Pet>();
        pets.add(new Pet(1,"Pikachu",R.drawable.ic_pikachu,"2"));
        pets.add(new Pet(1,"Squirtle",R.drawable.ic_squirtle,"2"));
        pets.add(new Pet(1,"Charmander",R.drawable.ic_charmander,"4"));
        pets.add(new Pet(1,"Eevee",R.drawable.ic_eevee,"5"));
        pets.add(new Pet(1,"Jigglypuff",R.drawable.ic_jigglypuff,"6"));
        pets.add(new Pet(1,"Psyduck",R.drawable.ic_psyduck,"8"));
        pets.add(new Pet(1,"Bulbasaur",R.drawable.ic_bulbasaur,"0"));
        pets.add(new Pet(1,"Meowth",R.drawable.ic_meowth,"5"));
        pets.add(new Pet(1,"Ubat",R.drawable.ic_ubat,"1"));
        pets.add(new Pet(1,"Bellsprout",R.drawable.ic_bellsprout,"5"));
    }

    public void getList(View v){
        Intent intent = new Intent(MainActivity.this, FavoritePets.class);
        startActivity(intent);
    }
}