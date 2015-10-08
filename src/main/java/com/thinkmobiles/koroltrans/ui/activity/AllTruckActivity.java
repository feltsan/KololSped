package com.thinkmobiles.koroltrans.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.adapters.TruckAdapter;
import com.thinkmobiles.koroltrans.model.Truck;

import java.util.ArrayList;
import java.util.List;

public class AllTruckActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private FloatingActionButton fba;
    private GridView gridView;
    private ParseQueryAdapter.QueryFactory<Truck> factory;
    private TruckAdapter truckAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findUi();
        setListener();
        setAdapter();


    }

    public void findUi() {
        gridView = (GridView) findViewById(R.id.grid);
        fba = (FloatingActionButton) findViewById(R.id.fab);
    }

    @Override
    protected void onResume() {
        super.onResume();
            truckAdapter.loadObjects();
//        ParseQuery<Truck> query = ParseQuery.getQuery(Truck.class);
//        query.fromLocalDatastore();
//        query.findInBackground(new FindCallback<Truck>() {
//            public void done(List<Truck> itemList, ParseException e) {
//                if (e == null) {
//
//                } else {
//                    Log.d("item", "Error: " + e.getMessage());
//                }
//            }
//        });
    }

    public void setAdapter() {
        setFactory();
        truckAdapter = new TruckAdapter(this, factory);
        gridView.setAdapter(truckAdapter);
    }

    public void setFactory() {
        factory = new ParseQueryAdapter.QueryFactory<Truck>() {
            @Override
            public ParseQuery<Truck> create() {
                ParseQuery<Truck> query = Truck.getQuery();
                query.orderByDescending("createdAt");
                query.fromLocalDatastore();
                return query;
            }
        };
    }

    public void setListener() {
        fba.setOnClickListener(this);
        gridView.setOnItemClickListener(this);

//            @Override
//            public void onClick(View v) {
//                TodoItem todoItem =new TodoItem("English");
//                todoItem.saveEventually();
//                todoItem.pinInBackground();
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.container, new AddTruckFragment())
//                        .commit();
//                fba.setVisibility(View.GONE);
//
//            }
//        });
    }


    private void openAddView() {
        Intent i = new Intent(this, AddActivity.class);
//        i.putExtra("ID", todo.getUuidString());
        i.putExtra("CODE", App.NEW_TRUCK_CODE);

        startActivityForResult(i, App.NEW_TRUCK_CODE);
    }

    private void openDetailView(Truck truck) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra("ID", truck.getUuidString());
        i.putExtra("CODE", App.DETAIL_TRUCK_CODE);
        startActivityForResult(i, App.DETAIL_TRUCK_CODE);
    }

    @Override
    public void onClick(View v) {
        openAddView();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Truck truck = truckAdapter.getItem(position);
        openDetailView(truck);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == App.NEW_TRUCK_CODE) {
                // Coming back from the edit view, update the view
                truckAdapter.loadObjects();
            }
        }
    }
}