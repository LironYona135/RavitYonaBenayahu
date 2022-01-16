package com.example.belove.models.incense;

import java.util.ArrayList;

public class Incenses {
    public ArrayList<Incense> incenses = new ArrayList<>();

    public Incenses(){}

    public void addIncense(Incense incense){
        getIncenses().add(incense);
    }

    public ArrayList<Incense> getIncenses() {
        return incenses;
    }

    @Override
    public String toString() {
        return "Incenses{" +
                "incenses=" + incenses +
                '}';
    }
}
