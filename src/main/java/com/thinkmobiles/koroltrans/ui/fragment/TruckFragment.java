package com.thinkmobiles.koroltrans.ui.fragment;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.model.Truck;

/**
 * Created by john on 27.09.tacho.
 */
public class TruckFragment extends Fragment {
    Truck truck;

    public static TruckFragment newInstance(final Truck _item) {
        TruckFragment fragment = new TruckFragment();
        Bundle args = new Bundle();
        args.putSerializable("TRUCK", _item);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getArguments() != null) {
            truck = (Truck) getArguments().getSerializable("TRUCK");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_truck,container,false);

        TextView stavka = (TextView) root.findViewById(R.id.stavka);
        TextView techPasSer = (TextView) root.findViewById(R.id.techPasSer);
        TextView techPasNom = (TextView) root.findViewById(R.id.techPasNomer);
        TextView oilKm = (TextView) root.findViewById(R.id.oilKM);
        TextView oilData = (TextView) root.findViewById(R.id.oilDate);
        TextView strachNom = (TextView) root.findViewById(R.id.strachNomer);
        TextView strachDate = (TextView) root.findViewById(R.id.strachDate);

       stavka.setText(truck.getId());
//        techPasSer.setText(truck.getTechPasSerie());
//        techPasNom.setText(truck.getTechPasNomer());
//        oilKm.setText(truck.getOilKm());
//        oilData.setText(truck.getOilData());
//        strachNom.setText(truck.getStrachNomer());
//        strachDate.setText(truck.getStrachData());

        return root;
    }
}
