package com.thinkmobiles.koroltrans.ui.fragment;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thinkmobiles.koroltrans.R;

/**
 * Created by john on 27.09.tacho.
 */
public class TruckFragment extends Fragment {

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


    TextView greenCartPriceTruck;
    TextView certPriceTruck;
    TextView europackPriceTruck;
    TextView tachoPriceTruck;
    TextView starchPriceTruck;
    TextView greenCartPriceTrailer;
    TextView certPriceTrailer;
    TextView europackPriceTrailer;
    TextView svidPriceTrailer;
    TextView starchPriceTrailer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_truck, container, false);

        findUI(root);

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

        greenCartPriceTruck = (TextView) view.findViewById(R.id.grenCardPriceTruck);
        certPriceTruck = (TextView) view.findViewById(R.id.certPriceTruck);
        europackPriceTruck = (TextView) view.findViewById(R.id.europackPriceTruck);
        tachoPriceTruck = (TextView) view.findViewById(R.id.tachoPriceTruck);
        starchPriceTruck = (TextView) view.findViewById(R.id.strachPriceTruck);

        greenCartPriceTrailer = (TextView) view.findViewById(R.id.greenCardPriceTrailer);
        certPriceTrailer = (TextView) view.findViewById(R.id.certPriceTrailer);
        europackPriceTrailer = (TextView) view.findViewById(R.id.europackPriceTrailer);
        svidPriceTrailer = (TextView) view.findViewById(R.id.svidYellowPriceTrailer);
        starchPriceTrailer = (TextView) view.findViewById(R.id.strachCardPriceTrailer);


    }

    private void setData(){

    }


}
