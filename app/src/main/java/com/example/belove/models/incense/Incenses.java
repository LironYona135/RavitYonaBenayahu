package com.example.belove.models.incense;

import java.util.ArrayList;

public class Incenses {
    public ArrayList<Incense> incenses = new ArrayList<>();
int i = 0;
    public Incenses(){

        for (int i = 0; i < 150; i++) {

            //incenses.add(new Incense("headLine test", "description test", 555,"imageID", true));

        }

    }

    public void addIncense(Incense incense){
        getIncenses().add(incense);
    }

    public Incenses(ArrayList<Incense> incenses){
        this.incenses = incenses;
    }


    public ArrayList<Incense> getIncenses() {
        return incenses;
    }

    public void setIncenses(ArrayList<Incense> incenses) {
        this.incenses = incenses;
    }

    @Override
    public String toString() {
        return "Incenses{" +
                "incenses=" + incenses +
                '}';
    }
}
