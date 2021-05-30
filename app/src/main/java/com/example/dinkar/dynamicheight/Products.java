package com.example.dinkar.dynamicheight;

import java.util.List;

public class Products {
    List<Model> models;
    String extraInfo;

    public Products(List<Model> models) {
        this.models = models;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
