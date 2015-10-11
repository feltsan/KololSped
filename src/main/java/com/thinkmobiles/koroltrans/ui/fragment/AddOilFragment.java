package com.thinkmobiles.koroltrans.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.SaveCallback;
import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.model.Oil;
import com.thinkmobiles.koroltrans.model.Reys;
import com.thinkmobiles.koroltrans.ui.activity.AddActivity;

/**
 * Created by john on 04.10.15.
 */
public class AddOilFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView date;
    private EditText distance, brend, oilFilter, airFilter, fuelFilter, glagoDel, price, service;
    private Button save, delete;
    private AddActivity addActivity;
    private Oil oil = null;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        addActivity = (AddActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_oil, container, false);
        findUI(view);
        setListener();

        if(savedInstanceState!=null){
            oil = (Oil) savedInstanceState.getSerializable("Oil");
            setEditData();
            delete.setVisibility(View.VISIBLE);
        }else if(addActivity.getOil()!=null) {
            oil = addActivity.getOil();
            setEditData();
            delete.setVisibility(View.VISIBLE);
        }else {
            oil = new Oil();
            oil.setUuidString();
            oil.setTruck(addActivity.getTruck());
        }

        return view;
    }

    public void findUI(View view) {
        date = (TextView) view.findViewById(R.id.dateOil);
        distance = (EditText) view.findViewById(R.id.kmOil);
        oilFilter = (EditText) view.findViewById(R.id.oilFilter);
        airFilter = (EditText) view.findViewById(R.id.airFilter);
        fuelFilter = (EditText) view.findViewById(R.id.fuelfilter);
        glagoDel = (EditText) view.findViewById(R.id.glagoDel);
        price = (EditText) view.findViewById(R.id.priceOil);
        brend = (EditText) view.findViewById(R.id.oilBrend);
        service = (EditText) view.findViewById(R.id.serviceOil);
        save = (Button) view.findViewById(R.id.save);
        delete = (Button) view.findViewById(R.id.delete);
    }

    public void setListener() {
        save.setOnClickListener(this);
        delete.setOnClickListener(this);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDateDialog(v);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                saveOil();
                break;

            case R.id.delete:
                deleteOil();
                break;
        }

    }

    private void openDateDialog(View v){
        DialogFragment picker = new DatePickerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(App.DATE_VIEW, v.getId());
        picker.setArguments(bundle);
        picker.show(getFragmentManager(), "datePicker");
    }

    public void saveOil(){
        oil.setDate(date.getText().toString());
        oil.setDistance(distance.getText().toString());
        oil.setBrend(brend.getText().toString());
        oil.setOilFiter(oilFilter.getText().toString());
        oil.setAirFilter(airFilter.getText().toString());
        oil.setFuelFilter(fuelFilter.getText().toString());
        oil.setPrice(price.getText().toString());
        oil.setGlagoDel(glagoDel.getText().toString());
        oil.setService(service.getText().toString());
        oil.saveEventually();
        oil.pinInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                getActivity().finish();
            }
        });
    }

    private void setEditData() {
        date.setText(oil.getDate());
        distance.setText(oil.getDistance());
        brend.setText(oil.getBrend());
        oilFilter.setText(oil.getOilFiter());
        airFilter.setText(oil.getAirFilter());
        fuelFilter.setText(oil.getFuelFilter());
        price.setText(oil.getPrice());
        glagoDel.setText(oil.getGlagoDel());
        service.setText(oil.getService());
    }

    public void deleteOil(){
        oil.deleteEventually();
        addActivity.finish();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("Oil", oil);
    }
}
