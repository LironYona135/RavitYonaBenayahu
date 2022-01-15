package com.example.belove.models.totem;

import com.example.belove.R;

import java.util.ArrayList;

public class Totems {

    private ArrayList<Totem> totems= new ArrayList<>();


    public Totems(){}


    public void addTotem(Totem totem){
        getTotems().add(totem);
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
