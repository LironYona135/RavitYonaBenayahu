package com.example.belove.models.totem;

public class Totem {

    private String title;
    private String description;
    private String imageid;


    public Totem(String title, String description, String imageid) {
        this.title = title;
        this.description = description;
        this.imageid = imageid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return imageid;
    }

    public void setImage(String image) {
        this.imageid = image;
    }

    @Override
    public String toString() {
        return "Totem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image=" + imageid +
                '}';
    }
}
