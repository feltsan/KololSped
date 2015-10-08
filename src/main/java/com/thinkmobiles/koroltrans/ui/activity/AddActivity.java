package com.thinkmobiles.koroltrans.ui.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.model.Truck;
import com.thinkmobiles.koroltrans.ui.fragment.AddOilFragment;
import com.thinkmobiles.koroltrans.ui.fragment.AddReysFragment;
import com.thinkmobiles.koroltrans.ui.fragment.AddServiceFragment;
import com.thinkmobiles.koroltrans.ui.fragment.AddTruckFragment;

/**
 * Created by john on 02.10.15.
 */
public class AddActivity extends AppCompatActivity {

    private int code =-1;
    private Fragment fragment;
    String truckId;
    Truck truck;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);



        if (getIntent().hasExtra("CODE")) {
            code = getIntent().getExtras().getInt("CODE");
        }

        if(getIntent().hasExtra("ID")) {
            truckId = getIntent().getExtras().getString("ID");
            getTruckOF();
        }
        else
          openFragment();

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
        switchFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.add_container, fragment)
                .commit();
    }

    public void switchFragment(){
        switch (code){
            case App.NEW_TRUCK_CODE:
                fragment =  new AddTruckFragment();
                break;
            case App.REYS_CODE:
                fragment =  new AddReysFragment();
                break;
            case App.OIL_CODE:
                fragment =  new AddOilFragment();
                break;
            case App.SERVICE_CODE:
                fragment =  new AddServiceFragment();
                break;
        }
    }

    public Truck getTruck(){
        return truck;
    }

}
