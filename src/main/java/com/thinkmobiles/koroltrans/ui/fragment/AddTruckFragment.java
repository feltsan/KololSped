package com.thinkmobiles.koroltrans.ui.fragment;

import android.app.Activity;
import android.content.Context;
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

import com.parse.DeleteCallback;
import com.parse.ParseException;
import com.parse.SaveCallback;
import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.model.Documents;
import com.thinkmobiles.koroltrans.model.Oil;
import com.thinkmobiles.koroltrans.model.Reys;
import com.thinkmobiles.koroltrans.model.Servis;
import com.thinkmobiles.koroltrans.model.Truck;
import com.thinkmobiles.koroltrans.ui.activity.AddActivity;
import com.thinkmobiles.koroltrans.ui.activity.AllTruckActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 27.09.tacho.
 */
public class AddTruckFragment extends Fragment implements View.OnClickListener {
    AddActivity addActivity;
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
    private Truck truck=null;
    private Documents documentGCTru, documentGCTra, documentWSTru,documentWSTra,documentEPTru,documentEPTra,documentTACHO,
            documentYSTra, documentPOLTru, documentPOLTra;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        addActivity = (AddActivity) context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_truck, container, false);

        findUI(root);
        setListener();
        if(addActivity.getTruck()!=null) {
            truck = addActivity.getTruck();
            getDoc();
            setEditData();
            delete.setVisibility(View.VISIBLE);
        }else{
            truck = new Truck();
            truck.setUuidString();

            documentGCTru = new Documents();
            documentGCTru.setUuidString();
            documentGCTru.setType(App.GCTru);

            documentGCTra = new Documents();
            documentGCTra.setUuidString();
            documentGCTra.setType(App.GCTra);

            documentWSTru = new Documents();
            documentWSTru.setUuidString();
            documentWSTru.setType(App.WSTru);

            documentWSTra = new Documents();
            documentWSTra.setType(App.WSTra);
            documentWSTra.setUuidString();

            documentEPTru = new Documents();
            documentEPTru.setType(App.EPTru);
            documentEPTru.setUuidString();

            documentEPTra = new Documents();
            documentEPTra.setUuidString();
            documentEPTra.setType(App.EPTra);

            documentTACHO = new Documents();
            documentTACHO.setUuidString();
            documentTACHO.setType(App.TACHO);

            documentYSTra = new Documents();
            documentYSTra.setUuidString();
            documentYSTra.setType(App.YSTra);

            documentPOLTru = new Documents();
            documentPOLTru.setUuidString();
            documentPOLTru.setType(App.POLTru);

            documentPOLTra = new Documents();
            documentPOLTra.setUuidString();
            documentPOLTra.setType(App.POLTra);

        }
        return root;
    }

    private void getDoc(){
        for (Documents d:addActivity.getDocuments())
            switch (d.getType()) {
                case App.GCTru:
                    documentGCTru = d;
                    break;

                case App.GCTra:
                    documentGCTra = d;
                    break;

                case App.WSTru:
                    documentWSTru = d;
                    break;

                case App.WSTra:
                    documentWSTra = d;
                    break;

                case App.EPTru:
                    documentEPTru =d;
                    break;

                case App.EPTra:
                    documentEPTra = d;
                    break;

                case App.TACHO:
                    documentTACHO = d;
                    break;

                case App.YSTra:
                    documentYSTra = d;
                    break;

                case App.POLTru:
                    documentPOLTru = d;
                    break;

                case App.POLTra:
                    documentPOLTra = d;
                    break;

            }
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
                deleteAll();
            }
        });


    }

    public void saveTruck() {

        final List<Documents> documentsList = new ArrayList<>();

        truck.setNomer(nomer.getText().toString());
        truck.setTrailerNomer(trailerNomer.getText().toString());


        documentGCTru.setEndDate(greenCartDateTruck.getText().toString());
        documentGCTru.setPrice(greenCartPriceTruck.getText().toString());
        documentGCTru.setTruck(truck);

        documentGCTra.setEndDate(greenCartDateTrailer.getText().toString());
        documentGCTra.setPrice(greenCartPriceTrailer.getText().toString());
        documentGCTra.setTruck(truck);

        documentWSTru.setEndDate(certDateTruck.getText().toString());
        documentWSTru.setPrice(certPriceTruck.getText().toString());
        documentWSTru.setTruck(truck);

        documentWSTra.setEndDate(certDateTrailer.getText().toString());
        documentWSTra.setPrice(certPriceTrailer.getText().toString());
        documentWSTra.setTruck(truck);

        documentEPTru.setEndDate(europackDateTruck.getText().toString());
        documentEPTru.setPrice(europackPriceTruck.getText().toString());
        documentEPTru.setTruck(truck);

        documentEPTra.setEndDate(europackDateTrailer.getText().toString());
        documentEPTra.setPrice(europackPriceTrailer.getText().toString());
        documentEPTra.setTruck(truck);

        documentTACHO.setEndDate(tachoDateTruck.getText().toString());
        documentTACHO.setPrice(tachoPriceTruck.getText().toString());
        documentTACHO.setTruck(truck);

        documentYSTra.setEndDate(svidDateTrailer.getText().toString());
        documentYSTra.setPrice(svidPriceTrailer.getText().toString());
        documentYSTra.setTruck(truck);

        documentPOLTru.setEndDate(strachDateTruck.getText().toString());
        documentPOLTru.setPrice(strachPriceTruck.getText().toString());
        documentPOLTru.setTruck(truck);

        documentPOLTra.setEndDate(strachDateTrailer.getText().toString());
        documentPOLTra.setPrice(strachPriceTrailer.getText().toString());
        documentPOLTra.setTruck(truck);

        documentsList.add(documentGCTru);
        documentsList.add(documentGCTra);
        documentsList.add(documentWSTru);
        documentsList.add(documentWSTra);
        documentsList.add(documentEPTru);
        documentsList.add(documentEPTra);
        documentsList.add(documentTACHO);
        documentsList.add(documentYSTra);
        documentsList.add(documentPOLTru);
        documentsList.add(documentPOLTra);

        for(Documents d:documentsList)
            d.saveEventually();
        truck.saveEventually();

        truck.pinInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {


                Documents.pinAllInBackground(documentsList, new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        getActivity().finish();

                    }
                });

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


    private void setEditData() {
        nomer.setText(truck.getNomer());
        trailerNomer.setText(truck.getTrailerNomer());

        greenCartDateTruck.setText(documentGCTru.getEndDate());
        greenCartPriceTruck.setText(documentGCTru.getPrice());

        greenCartDateTrailer.setText(documentGCTra.getEndDate());
        greenCartPriceTrailer.setText(documentGCTra.getPrice());

        certDateTruck.setText(documentWSTru.getEndDate());
        certPriceTruck.setText(documentWSTru.getPrice());

        certDateTrailer.setText(documentWSTra.getEndDate());
        certPriceTrailer.setText(documentWSTra.getPrice());

        europackDateTruck.setText(documentEPTru.getEndDate());
        europackPriceTruck.setText(documentEPTru.getPrice());

        europackDateTrailer.setText(documentEPTra.getEndDate());
        europackPriceTrailer.setText(documentEPTra.getPrice());

        tachoDateTruck.setText(documentTACHO.getEndDate());
        tachoPriceTruck.setText(documentTACHO.getPrice());

        svidDateTrailer.setText(documentYSTra.getEndDate());
        svidPriceTrailer.setText(documentYSTra.getPrice());

        strachDateTruck.setText(documentPOLTru.getEndDate());
        strachPriceTruck.setText(documentPOLTru.getPrice());

        strachDateTrailer.setText(documentPOLTra.getEndDate());
        strachPriceTrailer.setText(documentPOLTra.getPrice());
    }

    public void deleteAll(){
        deleteAllDocuments();
    }

    public void deleteAllReys(){
        Reys.deleteAllInBackground(addActivity.getReyses(), new DeleteCallback() {
            @Override
            public void done(ParseException e) {
                deleteAllOil();
            }

        });

    }

    public void deleteAllDocuments(){
        Documents.deleteAllInBackground(addActivity.getDocuments(), new DeleteCallback() {
            @Override
            public void done(ParseException e) {
                deleteAllReys();
            }
        });
    }

    public void deleteAllOil(){
        Oil.deleteAllInBackground(addActivity.getOils(), new DeleteCallback() {
            @Override
            public void done(ParseException e) {
                deleteAllService();
            }
        });
    }

    public void deleteAllService(){
        Servis.deleteAllInBackground(addActivity.getServices(),  new DeleteCallback() {
            @Override
            public void done(ParseException e) {
                deleteTruck();
            }

            });

    }

    public void deleteTruck(){
        truck.deleteEventually(new DeleteCallback() {
            @Override
            public void done(ParseException e) {
                getActivity().finish();
            }
        });
    }

}
