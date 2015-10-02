package com.thinkmobiles.koroltrans.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.TruckPagerAdapter;
import com.thinkmobiles.koroltrans.model.Truck;
import com.thinkmobiles.koroltrans.ui.activity.MainActivity;

import java.util.ArrayList;

/**
 * Created by john on 27.09.tacho.
 */
public class AllTruckPagerFragment extends Fragment {
    ArrayList<Truck> trucks = new ArrayList<>();
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        trucks = ((MainActivity) context).getTrucks();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_all_truck,container,false);
        ViewPager viewPager = (ViewPager) root.findViewById(R.id.pager);

//        trucks.add(new Truck("1","AO9999AO","CAP","88888888","TR","888888","9000000000", "12.09.tacho"));
//        trucks.add(new Truck("2","AO9999AO","CAP","88888888","TR","888888","9000000000", "12.09.tacho"));
//        trucks.add(new Truck("3","AO9999AO","CAP","88888888","TR","888888","9000000000", "12.09.tacho"));
        viewPager.setAdapter(new TruckPagerAdapter(getChildFragmentManager(), trucks));
        return root;
    }
}
