package com.example.dinkar.dynamicheight;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity implements ModelAdapter.ItemOnClickListener {
    private final List<Model> modelList = new ArrayList<>();
    Products products;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        ModelDataPrepare();
        ModelAdapter modelAdapter = new ModelAdapter(products, this, this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(modelAdapter);


    }

    private void ModelDataPrepare() {
        modelList.add(new Model("Title 1", "Small Description", 1));
        modelList.add(new Model("Title 2", "Medium Description Medium Description Medium Description Medium Description", 2));
        modelList.add(new Model("Title 3", "Large Description Large Description Large Description Large Description Large Description Large Description Large Description", 3));
        modelList.add(new Model("Title 4", "Medium Description Medium Description Medium Description Medium Description", 4));
        modelList.add(new Model("Title 5", "Small Description", 5));
        products = new Products(modelList);
    }

    void onButtonClick(Model model) {
        Collections.shuffle(modelList);
        products.setModels(modelList);
        recyclerView.scrollToPosition(modelList.indexOf(model));
        ModelAdapter modelAdapter = new ModelAdapter(products, this, this);
        recyclerView.setAdapter(modelAdapter);
    }

    @Override
    public void onItemClick(Model model) {
        onButtonClick(model);
    }
}
