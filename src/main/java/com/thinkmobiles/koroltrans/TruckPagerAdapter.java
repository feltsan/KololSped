package com.thinkmobiles.koroltrans;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.thinkmobiles.koroltrans.model.Truck;
import com.thinkmobiles.koroltrans.ui.fragment.TruckFragment;

import java.util.ArrayList;


/**
 * Created by feltsan on 09.09.tacho.
 */
public class TruckPagerAdapter extends FragmentPagerAdapter  {
    ArrayList<Truck> trucks;

    public TruckPagerAdapter(FragmentManager fm, ArrayList<Truck> trucks) {
        super(fm);
        this.trucks = trucks;
    }

    public void updateData(ArrayList<Truck> trucks){
        this.trucks = trucks;
        notifyDataSetChanged();
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
      return TruckFragment.newInstance(trucks.get(position));
    }

    @Override
    public int getCount() {
        return trucks.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
       return  trucks.get(position).getDerzhNomer();
    }
}
