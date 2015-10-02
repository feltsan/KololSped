package com.thinkmobiles.koroltrans.ui.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.model.TodoItem;
import com.thinkmobiles.koroltrans.model.Truck;
import com.thinkmobiles.koroltrans.ui.fragment.AddTruckFragment;
import com.thinkmobiles.koroltrans.ui.fragment.AllTruckPagerFragment;

import java.util.ArrayList;
import java.util.List;

public class AllTruckActivity extends AppCompatActivity {
    FloatingActionButton fba;
    ArrayList<Truck> trucks = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ParseObject.registerSubclass(TodoItem.class);

        ParseQuery<TodoItem> query = ParseQuery.getQuery(TodoItem.class);
        query.fromLocalDatastore();
        query.findInBackground(new FindCallback<TodoItem>() {
            public void done(List<TodoItem> itemList, ParseException e) {
                if (e == null) {

                } else {
                    Log.d("item", "Error: " + e.getMessage());
                }
            }
        });



        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new AllTruckPagerFragment())
                .commit();


        fba = (FloatingActionButton) findViewById(R.id.fab);
        fba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoItem todoItem =new TodoItem("English");
                todoItem.saveEventually();
                todoItem.pinInBackground();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new AddTruckFragment())
                        .commit();
                fba.setVisibility(View.GONE);
            }
        });


    }
    public void setVisibleFAB(){
        fba.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public ArrayList<Truck> getTrucks(){
        return trucks;
    }
    public void addTruck(Truck truck){
        trucks.add(truck);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new AllTruckPagerFragment())
                .commit();

        fba.setVisibility(View.VISIBLE);
    }
}
