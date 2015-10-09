package com.thinkmobiles.koroltrans.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.model.Truck;
import com.thinkmobiles.koroltrans.ui.fragment.AllReysFragment;
import com.thinkmobiles.koroltrans.ui.fragment.DetailFragment;

/**
 * Created by john on 02.10.15.
 */
public class DetailActivity extends AppCompatActivity {
    private int orient;
    String truckId;
    Truck truck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        if(savedInstanceState!=null){
            truckId = savedInstanceState.getString(App.TRUCK_ID);
            getTruckOF();
        }else if (getIntent().hasExtra("ID")) {
            truckId = getIntent().getExtras().getString("ID");
            getTruckOF();

        }else{
            openFragment();
        }
    }


    public void getTruckOF(){
        ParseQuery<Truck> query = ParseQuery.getQuery(Truck.class);
        query.fromLocalDatastore();
        query.whereEqualTo("uuid", truckId);
        query.getFirstInBackground(new GetCallback<Truck>() {
            @Override
            public void done(Truck object, ParseException e) {
                truck = object;
                setTitle(object.getNomer());
                openFragment();
            }
        });
    }

    public void openFragment(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.add_container, new DetailFragment())
                .commit();
    }

    public Truck getTruck(){
        return truck;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putString(App.TRUCK_ID, truckId);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }
}
