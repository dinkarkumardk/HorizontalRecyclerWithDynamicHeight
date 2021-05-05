package com.example.dinkar.dynamicheight;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private final List<Model> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        ModelAdapter modelAdapter = new ModelAdapter(modelList, MainActivity.this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(modelAdapter);
        ModelDataPrepare();

    }

    private void ModelDataPrepare() {
        modelList.add(new Model("Title 1", "Small Description"));
        modelList.add(new Model("Title 2", "Medium Description Medium Description Medium Description Medium Description"));
        modelList.add(new Model("Title 3", "Large Description Large Description Large Description Large Description Large Description Large Description Large Description"));
        modelList.add(new Model("Title 4", "Medium Description Medium Description Medium Description Medium Description"));
        modelList.add(new Model("Title 5", "Small Description"));
        modelList.add(new Model("Title 6", "Small Description"));
        modelList.add(new Model("Title 7", "Medium Description Medium Description Medium Description Medium Description"));
        modelList.add(new Model("Title 8", "Large Description Large Description Large Description Large Description Large Description Large Description Large Description"));
        modelList.add(new Model("Title 9", "Medium Description Medium Description Medium Description Medium Description"));
        modelList.add(new Model("Title 10", "Small Description"));
        modelList.add(new Model("Title 11", "Small Description"));
        modelList.add(new Model("Title 12", "Medium Description Medium Description Medium Description Medium Description"));
        modelList.add(new Model("Title 13", "Large Description Large Description Large Description Large Description Large Description Large Description Large Description"));
        modelList.add(new Model("Title 14", "Medium Description Medium Description Medium Description Medium Description"));
        modelList.add(new Model("Title 15", "Small Description"));

    }
}
