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
    private int orient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        findUI(view);
        setListener();

        orient = getActivity().getResources().getConfiguration().orientation;

        setFragment(new AllReysFragment());

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
              setFragment(new AllReysFragment());
                break;
            case R.id.oilTV:
                setFragment(new AllOilFragment());
                break;
            case R.id.serviceTV:
                setFragment(new AllServiceFragment());
                break;
            case R.id.documetsTV:
                setFragment(new TruckFragment());
                break;
        }
    }

    public void setFragment(Fragment fragment){
        if(orient==1)
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.add_container, fragment)
                    .addToBackStack("")
                    .commit();
        else
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
    }


}
