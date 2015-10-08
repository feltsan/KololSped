package com.thinkmobiles.koroltrans.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.parse.ParseQueryAdapter;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.model.Oil;
import com.thinkmobiles.koroltrans.model.Reys;

/**
 * Created by john on 04.10.15.
 */
public class OilAdapter extends ParseQueryAdapter<Oil> {

    private LayoutInflater inflater;

    public OilAdapter(Context context,
                      ParseQueryAdapter.QueryFactory<Oil> queryFactory) {
        super(context, queryFactory);

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getItemView(Oil oil, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_oil, parent, false);
            holder = new ViewHolder();
            holder.date = (TextView) view.findViewById(R.id.dateOil);
            holder.distance = (TextView) view.findViewById(R.id.kmOil);
            holder.brend = (TextView) view.findViewById(R.id.oilBrend);
            holder.oilF = (TextView) view.findViewById(R.id.oilFilter);
            holder.airF = (TextView) view.findViewById(R.id.airFilter);
            holder.fuelF = (TextView) view.findViewById(R.id.fuelfilter);
            holder.glagodel = (TextView) view.findViewById(R.id.glagoDel);
            holder.price = (TextView) view.findViewById(R.id.priceOil);
            holder.service = (TextView) view.findViewById(R.id.serviceOil);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        TextView date = holder.date;
        TextView distance = holder.distance;
        TextView brend = holder.brend;
        TextView oilF = holder.oilF;
        TextView airF = holder.airF;
        TextView fuelF = holder.fuelF;
        TextView glagodel = holder.glagodel;
        TextView price = holder.price;
        TextView service = holder.service;

        date.setText(oil.getDate());
        distance.setText(oil.getDistance());
        brend.setText(oil.getBrend());
        oilF.setText(oil.getOilFiter());
        airF.setText(oil.getAirFilter());
        fuelF.setText(oil.getFuelFilter());
        glagodel.setText(oil.getGlagoDel());
        price.setText(oil.getPrice());
        service.setText(oil.getService());

        return view;
    }


    private static class ViewHolder {
        TextView date;
        TextView distance;
        TextView brend;
        TextView oilF;
        TextView airF;
        TextView fuelF;
        TextView glagodel;
        TextView price;
        TextView service;
    }
}