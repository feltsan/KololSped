package com.thinkmobiles.koroltrans.ui.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.R;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);



        if (getIntent().hasExtra("CODE")) {
            code = getIntent().getExtras().getInt("CODE");
        }
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


}
