package com.example.cityguideapp.helperClasses.HomeAdapter;

public class MostViewedClass {
    int image;
    String title,description;

    public MostViewedClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
