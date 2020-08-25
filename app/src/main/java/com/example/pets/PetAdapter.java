package com.example.pets;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder>{
    ArrayList<Pet> pets;
    Activity activity;

    public PetAdapter(ArrayList<Pet> pets, Activity activity){
        this.pets = pets;
        this.activity = activity;
    }
    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_card,parent,false);
        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PetViewHolder petViewHolder, int position) {
        final Pet pet = pets.get(position);
        petViewHolder.imgPet.setImageResource(pet.getPicturePet());
        petViewHolder.tvPetName.setText(pet.getNamePet());
        petViewHolder.tvCounterLikes.setText(pet.getNoLikes());

        petViewHolder.btnPetLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pet.addLikes();
                Toast.makeText(activity,"Diste Like a: "+pet.getNamePet() + " Cuenta con "+ pet.getNoLikes() +" Likes.",Toast.LENGTH_SHORT).show();
                petViewHolder.tvCounterLikes.setText(pet.getNoLikes());
            }
        });
    }
    @Override
    public int getItemCount() {
        return pets.size();
    }
    public static class PetViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgPet;
        private TextView tvPetName;
        private TextView tvCounterLikes;
        private ImageButton btnPetLike;

        public PetViewHolder(View itemView){
            super(itemView);

            imgPet = (ImageView) itemView.findViewById(R.id.imgPet);
            tvPetName = (TextView) itemView.findViewById(R.id.tvPetName);
            tvCounterLikes = (TextView) itemView.findViewById(R.id.tvCounterLikes);
            btnPetLike = (ImageButton) itemView.findViewById(R.id.btnLikePet);
        }
    }
}
