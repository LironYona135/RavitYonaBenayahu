package com.example.belove.models.totem;

import com.example.belove.R;

import java.util.ArrayList;

public class Totems {

    private ArrayList<Totem> totems= new ArrayList<>();


    public Totems() {
        totems.add(new Totem("i dont know1","i really dont know", "imageid"));
    }

    public void addTotem(Totem totem){
        totems.add(totem);
    }

    public Totem removeTotem(String title){
        for (int i = 0; i < totems.size(); i++) {
            if (totems.get(i).getTitle().equals(title)){
                return totems.remove(i);
            }
        }
        return new Totem("nothing","nothing","imageid");
    }

    public ArrayList<Totem> getTotems() {
        return totems;
    }

    @Override
    public String toString() {
        return "Totems{" +
                "totems=" + totems +
                '}';
    }
}
