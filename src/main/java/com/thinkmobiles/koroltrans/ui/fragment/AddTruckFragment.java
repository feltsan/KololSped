package com.thinkmobiles.koroltrans.ui.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.model.Truck;
import com.thinkmobiles.koroltrans.ui.activity.AllTruckActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by john on 27.09.tacho.
 */
public class AddTruckFragment extends Fragment implements View.OnClickListener {
    AllTruckActivity allTruckActivity;
    TextView greenCartDateTruck;
    TextView certDateTruck;
    TextView europackDateTruck;
    TextView tachoDateTruck;
    TextView starchDateTruck;
    TextView greenCartDateTrailer;
    TextView certDateTrailer;
    TextView europackDateTrailer;
    TextView svidDateTrailer;
    TextView starchDateTrailer;


    EditText greenCartPriceTruck;
    EditText certPriceTruck;
    EditText europackPriceTruck;
    EditText tachoPriceTruck;
    EditText starchPriceTruck;
    EditText greenCartPriceTrailer;
    EditText certPriceTrailer;
    EditText europackPriceTrailer;
    EditText svidPriceTrailer;
    EditText starchPriceTrailer;


    Button save;
    int year_x, mont_x, day_x;
    static final int DIALOG_ID = 0;
    static final View[] views = new View[1];

    ArrayList<Truck> trucks = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        allTruckActivity = (AllTruckActivity) context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.add_truck, container, false);

        findUI(root);
        setListener();
        return root;
    }

    private void findUI(View view) {
        greenCartDateTruck = (TextView) view.findViewById(R.id.greenCardDateTruck);
        certDateTruck = (TextView) view.findViewById(R.id.certDateTruck);
        europackDateTruck = (TextView) view.findViewById(R.id.europackDateTruck);
        tachoDateTruck = (TextView) view.findViewById(R.id.tachoDateTruck);
        starchDateTruck = (TextView) view.findViewById(R.id.policyDateTruck);

        greenCartDateTrailer = (TextView) view.findViewById(R.id.greenCardDateTrailer);
        certDateTrailer = (TextView) view.findViewById(R.id.certDateTrailer);
        europackDateTrailer = (TextView) view.findViewById(R.id.europackDateTrailer);
        svidDateTrailer = (TextView) view.findViewById(R.id.svidYellowDateTrailer);
        starchDateTrailer = (TextView) view.findViewById(R.id.strachDateTrailer);

        greenCartPriceTruck = (EditText) view.findViewById(R.id.grenCardPriceTruck);
        certPriceTruck = (EditText) view.findViewById(R.id.certPriceTruck);
        europackPriceTruck = (EditText) view.findViewById(R.id.europackPriceTruck);
        tachoPriceTruck = (EditText) view.findViewById(R.id.tachoPriceTruck);
        starchPriceTruck = (EditText) view.findViewById(R.id.strachPriceTruck);

        greenCartPriceTrailer = (EditText) view.findViewById(R.id.greenCardPriceTrailer);
        certPriceTrailer = (EditText) view.findViewById(R.id.certPriceTrailer);
        europackPriceTrailer = (EditText) view.findViewById(R.id.europackPriceTrailer);
        svidPriceTrailer = (EditText) view.findViewById(R.id.svidYellowPriceTrailer);
        starchPriceTrailer = (EditText) view.findViewById(R.id.strachCardPriceTrailer);

        save = (Button) view.findViewById(R.id.save);

    }

    private void setListener() {
        greenCartDateTruck.setOnClickListener(this);
        certDateTruck.setOnClickListener(this);
        europackDateTruck.setOnClickListener(this);
        tachoDateTruck.setOnClickListener(this);
        starchDateTruck.setOnClickListener(this);

        greenCartDateTrailer.setOnClickListener(this);
        certDateTrailer.setOnClickListener(this);
        europackDateTrailer.setOnClickListener(this);
        svidDateTrailer.setOnClickListener(this);
        starchDateTrailer.setOnClickListener(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        views[0] = v;
        DialogFragment picker = new DatePickerFragment();
        picker.show(getFragmentManager(), "datePicker");

    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {


        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
// Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

// Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {


            Calendar c = Calendar.getInstance();
            c.set(year, month, day);

            SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yy");

            Toast.makeText(getActivity(), "selected date:" + year + "/" + month + "/" + day, Toast.LENGTH_LONG).show();
            String formattedDate = sdf.format(c.getTime());
            ((TextView) views[0]).setText(formattedDate);
        }
    }


}
