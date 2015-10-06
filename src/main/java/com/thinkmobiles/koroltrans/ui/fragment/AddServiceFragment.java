package com.thinkmobiles.koroltrans.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.R;

/**
 * Created by john on 04.10.15.
 */
public class AddServiceFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView date;
    private EditText distance, zapchast, brend, price, service;
    private Button save, delete;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_service, container, false);
        findUI(view);
        setListener();
        return view;
    }

    public void findUI(View view) {
        date = (TextView) view.findViewById(R.id.dateService);
        distance = (EditText) view.findViewById(R.id.kmService);
        zapchast = (EditText) view.findViewById(R.id.zapchastService);
        price = (EditText) view.findViewById(R.id.priceService);
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

                break;

            case R.id.delete:

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
}
