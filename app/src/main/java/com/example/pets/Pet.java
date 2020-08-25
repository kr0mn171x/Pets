package com.example.pets;

public class Pet {
    private int idPet;
    private String namePet;
    private int picturePet;
    private String NoLikes;

    public Pet(int idPet, String namePet, int picturePet, String noLikes) {
        this.idPet = idPet;
        this.namePet = namePet;
        this.picturePet = picturePet;
        this.NoLikes = noLikes;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public int getPicturePet() {
        return picturePet;
    }

    public void setPicturePet(int picturePet) {
        this.picturePet = picturePet;
    }

    public String getNoLikes() {
        return NoLikes;
    }

    public void setNoLikes(String noLikes) {
        NoLikes = noLikes;
    }

    public void addLikes(){
        int NolikesIncrement;
        NolikesIncrement = Integer.parseInt(NoLikes);
        NolikesIncrement++;
        this.NoLikes = String.valueOf(NolikesIncrement);
    }

}
