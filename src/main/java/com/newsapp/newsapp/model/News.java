package com.newsapp.newsapp.model;


public class News {
    private String title;
    private String description;
    private String imageLocation;

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

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }


    @Override
    public String toString() {
        return "User [title=" + title + ", description=" + description + ", imageLocation=" + imageLocation + "]";
    }
}