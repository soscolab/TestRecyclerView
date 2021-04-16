package com.example.testrecyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DetecteurDeClicSurRecycler {
    private RecyclerView mRecyclerView;
    private MonRecyclerViewAdapteur mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler((DetecteurDeClicSurRecycler) this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MonRecyclerViewAdapteur(getDataSource());
        mRecyclerView.setAdapter(mAdapter);
    }


    private ArrayList<Donnee> getDataSource() {
        ArrayList results = new ArrayList<Donnee>();
        for (int index = 0; index < 20; index++) {
            Donnee obj = new Donnee("Texte principal " + index,"Texte auxiliaire " +
                    index);
            results.add(index, obj);
        }
        return results;
    }

    @Override
    public void clicSurRecyclerItem(int position, View v) {
            Toast.makeText(getApplicationContext(), "Clic sur l'item "+position, Toast.LENGTH_LONG).show();
        }

    }
