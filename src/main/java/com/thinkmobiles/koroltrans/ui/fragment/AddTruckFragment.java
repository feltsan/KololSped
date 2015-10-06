package com.thinkmobiles.koroltrans.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.SaveCallback;
import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.model.Documents;
import com.thinkmobiles.koroltrans.model.Truck;
import com.thinkmobiles.koroltrans.ui.activity.AllTruckActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 27.09.tacho.
 */
public class AddTruckFragment extends Fragment implements View.OnClickListener {
    AllTruckActivity allTruckActivity;
    TextView greenCartDateTruck;
    TextView certDateTruck;
    TextView europackDateTruck;
    TextView tachoDateTruck;
    TextView strachDateTruck;
    TextView greenCartDateTrailer;
    TextView certDateTrailer;
    TextView europackDateTrailer;
    TextView svidDateTrailer;
    TextView strachDateTrailer;


    EditText greenCartPriceTruck;
    EditText certPriceTruck;
    EditText europackPriceTruck;
    EditText tachoPriceTruck;
    EditText strachPriceTruck;
    EditText greenCartPriceTrailer;
    EditText certPriceTrailer;
    EditText europackPriceTrailer;
    EditText svidPriceTrailer;
    EditText strachPriceTrailer;
    EditText nomer, trailerNomer;


    Button save, delete;
    int year_x, mont_x, day_x;
    static final int DIALOG_ID = 0;
    private View views;
    private Truck truck;
    private Documents documentGCTru, documentGCTra, documentWSTru,documentWSTra,documentEPTru,documentEPTra,documentTACHO,
            documentYSTra, documentPOLTru, documentPOLTra;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_truck, container, false);

        findUI(root);
        setListener();
        return root;
    }

    private void findUI(View view) {
        greenCartDateTruck = (TextView) view.findViewById(R.id.greenCardDateTruck);
        certDateTruck = (TextView) view.findViewById(R.id.certDateTruck);
        europackDateTruck = (TextView) view.findViewById(R.id.europackDateTruck);
        tachoDateTruck = (TextView) view.findViewById(R.id.tachoDateTruck);
        strachDateTruck = (TextView) view.findViewById(R.id.policyDateTruck);

        greenCartDateTrailer = (TextView) view.findViewById(R.id.greenCardDateTrailer);
        certDateTrailer = (TextView) view.findViewById(R.id.certDateTrailer);
        europackDateTrailer = (TextView) view.findViewById(R.id.europackDateTrailer);
        svidDateTrailer = (TextView) view.findViewById(R.id.svidYellowDateTrailer);
        strachDateTrailer = (TextView) view.findViewById(R.id.strachDateTrailer);

        greenCartPriceTruck = (EditText) view.findViewById(R.id.grenCardPriceTruck);
        certPriceTruck = (EditText) view.findViewById(R.id.certPriceTruck);
        europackPriceTruck = (EditText) view.findViewById(R.id.europackPriceTruck);
        tachoPriceTruck = (EditText) view.findViewById(R.id.tachoPriceTruck);
        strachPriceTruck = (EditText) view.findViewById(R.id.strachPriceTruck);

        greenCartPriceTrailer = (EditText) view.findViewById(R.id.greenCardPriceTrailer);
        certPriceTrailer = (EditText) view.findViewById(R.id.certPriceTrailer);
        europackPriceTrailer = (EditText) view.findViewById(R.id.europackPriceTrailer);
        svidPriceTrailer = (EditText) view.findViewById(R.id.svidYellowPriceTrailer);
        strachPriceTrailer = (EditText) view.findViewById(R.id.strachCardPriceTrailer);

        nomer = (EditText) view.findViewById(R.id.nomerZnakTruck);
        trailerNomer = (EditText) view.findViewById(R.id.nomerZnakTrailer);

        save   = (Button) view.findViewById(R.id.save);
        delete = (Button) view.findViewById(R.id.delete);

    }

    private void setListener() {
        greenCartDateTruck.setOnClickListener(this);
        certDateTruck.setOnClickListener(this);
        europackDateTruck.setOnClickListener(this);
        tachoDateTruck.setOnClickListener(this);
        strachDateTruck.setOnClickListener(this);

        greenCartDateTrailer.setOnClickListener(this);
        certDateTrailer.setOnClickListener(this);
        europackDateTrailer.setOnClickListener(this);
        svidDateTrailer.setOnClickListener(this);
        strachDateTrailer.setOnClickListener(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTruck();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    public void saveTruck(){
        truck = new Truck();
        truck.setUuidString();
        truck.setNomer(nomer.getText().toString());
        truck.setTrailerNomer(trailerNomer.getText().toString());

        truck.pinInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

            }
        });


        documentGCTru = new Documents();
        documentGCTru.setUuidString();
        documentGCTru.setEndDate(greenCartDateTruck.getText().toString());
        documentGCTru.setType(App.GCTru);
        documentGCTru.setPrice(greenCartPriceTruck.getText().toString());
        documentGCTru.setTruck(truck);


        documentGCTru.pinInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

            }
        });

        documentGCTra = new Documents();
        documentGCTra.setUuidString();
        documentGCTra.setEndDate(greenCartDateTrailer.getText().toString());
        documentGCTra.setType(App.GCTra);
        documentGCTra.setPrice(greenCartPriceTrailer.getText().toString());
        documentGCTra.setTruck(truck);

        documentGCTra.pinInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

            }
        });

        documentWSTru = new Documents();
        documentWSTru.setUuidString();
        documentWSTru.setEndDate(certDateTruck.getText().toString());
        documentWSTru.setType(App.WSTru);
        documentWSTru.setPrice(certPriceTruck.getText().toString());
        documentWSTru.setTruck(truck);

        documentWSTru.pinInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

            }
        });

        documentWSTra = new Documents();
        documentWSTra.setUuidString();
        documentWSTra.setEndDate(certDateTrailer.getText().toString());
        documentWSTra.setType(App.WSTru);
        documentWSTra.setPrice(certPriceTrailer.getText().toString());
        documentWSTra.setTruck(truck);

        documentWSTra.pinInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

            }
        });

        documentEPTru = new Documents();
        documentEPTru.setUuidString();
        documentEPTru.setEndDate(europackDateTruck.getText().toString());
        documentEPTru.setType(App.EPTru);
        documentEPTru.setPrice(europackPriceTruck.getText().toString());
        documentEPTru.setTruck(truck);

        documentEPTru.pinInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

            }
        });

        documentEPTra = new Documents();
        documentEPTra.setUuidString();
        documentEPTra.setEndDate(europackDateTrailer.getText().toString());
        documentEPTra.setType(App.EPTra);
        documentEPTra.setPrice(europackPriceTrailer.getText().toString());
        documentEPTra.setTruck(truck);

        documentEPTra.pinInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

            }
        });

        documentTACHO = new Documents();
        documentTACHO.setUuidString();
        documentTACHO.setEndDate(tachoDateTruck.getText().toString());
        documentTACHO.setType(App.TACHO);
        documentTACHO.setPrice(tachoPriceTruck.getText().toString());
        documentTACHO.setTruck(truck);

        documentTACHO.pinInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

            }
        });

        documentYSTra = new Documents();
        documentYSTra.setUuidString();
        documentYSTra.setEndDate(svidDateTrailer.getText().toString());
        documentYSTra.setType(App.YSTra);
        documentYSTra.setPrice(svidPriceTrailer.getText().toString());
        documentYSTra.setTruck(truck);

        documentYSTra.pinInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

            }
        });

        documentPOLTru = new Documents();
        documentPOLTru.setUuidString();
        documentPOLTru.setEndDate(strachDateTruck.getText().toString());
        documentPOLTru.setType(App.POLTru);
        documentPOLTru.setPrice(strachPriceTruck.getText().toString());
        documentPOLTru.setTruck(truck);

        documentPOLTru.pinInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

            }
        });

        documentPOLTra = new Documents();
        documentPOLTra.setUuidString();
        documentPOLTra.setEndDate(strachDateTrailer.getText().toString());
        documentPOLTra.setType(App.POLTra);
        documentPOLTra.setPrice(strachPriceTrailer.getText().toString());
        documentPOLTra.setTruck(truck);

        documentPOLTra.pinInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

            }
        });



    }

    @Override
    public void onClick(View v) {
        openDateDialog(v);

    }

    private void openDateDialog(View v){
        DialogFragment picker = new DatePickerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(App.DATE_VIEW, v.getId());
        picker.setArguments(bundle);
        picker.show(getFragmentManager(), "datePicker");

    }




}
