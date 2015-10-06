package com.thinkmobiles.koroltrans.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.thinkmobiles.koroltrans.R;

/**
 * Created by john on 04.10.15.
 */
public class DetailFragment extends Fragment implements View.OnClickListener {

    LinearLayout reys, oil, service, documents;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        findUI(view);
        setListener();
        return view;
    }

    public void findUI(View view) {
        reys = (LinearLayout) view.findViewById(R.id.speditionTV);
        oil = (LinearLayout) view.findViewById(R.id.oilTV);
        service = (LinearLayout) view.findViewById(R.id.serviceTV);
        documents = (LinearLayout) view.findViewById(R.id.documetsTV);
    }

    public void setListener() {
        reys.setOnClickListener(this);
        oil.setOnClickListener(this);
        service.setOnClickListener(this);
        documents.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.speditionTV:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new AllReysFragment())
                        .commit();
                break;

            case R.id.oilTV:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new AllOilFragment())
                        .commit();
                break;

            case R.id.serviceTV:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new AllServiceFragment())
                        .commit();
                break;

            case R.id.documetsTV:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new TruckFragment())
                        .commit();
                break;


        }
    }
}
