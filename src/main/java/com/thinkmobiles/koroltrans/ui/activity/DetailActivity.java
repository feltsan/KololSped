package com.thinkmobiles.koroltrans.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.model.Truck;
import com.thinkmobiles.koroltrans.ui.fragment.AllReysFragment;
import com.thinkmobiles.koroltrans.ui.fragment.DetailFragment;
import com.thinkmobiles.koroltrans.until.Sender;

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


        if (getIntent().hasExtra("ID")) {
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
            testInvite();

            return true;
        }

        return super.onOptionsItemSelected(item);
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

    public void testInvite(){
        Sender.sendEmail("");
        Sender.sendSMS(this, "+380979330846", "АО7555ВН Зелена карта 18.10.15 " +
                "АО1441АХ Заміна масла");
        startActivityForResult(new Intent(this, InviteActivity.class), 55);
    }

    public AllReysFragment getMyFragment(){
        return (AllReysFragment)
                getSupportFragmentManager()
                .findFragmentByTag("ALL");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == App.REYS_CODE) {
                // Coming back from the edit view, update the view
               getMyFragment().refreshAdapter();
            }
        }
    }


}
