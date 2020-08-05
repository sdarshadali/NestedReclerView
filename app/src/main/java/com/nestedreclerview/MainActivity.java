package com.nestedreclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<String> itemsArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.parentRV);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new Parent_recyclerViewAdapter(itemsArrayList,MainActivity.this);
        recyclerView.setAdapter(adapter);
        String [] items = {"Item One","Item Two","Item Three","Item Four","Item Five",};
        for (int i = 0;1 < items.length;i++){
            itemsArrayList.add(items[1]);
        }
        adapter.notifyDataSetChanged();
    }
}