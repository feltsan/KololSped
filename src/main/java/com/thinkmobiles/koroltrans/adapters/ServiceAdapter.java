package com.thinkmobiles.koroltrans.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseQueryAdapter;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.model.Servis;

/**
 * Created by john on 04.10.15.
 */
public class ServiceAdapter extends ParseQueryAdapter<Servis> {

    private LayoutInflater inflater;

    public ServiceAdapter(Context context,
                          ParseQueryAdapter.QueryFactory<Servis> queryFactory) {
        super(context, queryFactory);

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getItemView(Servis service, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_service, parent, false);
            holder = new ViewHolder();
            holder.date = (TextView) view.findViewById(R.id.dateService);
            holder.distance = (TextView) view.findViewById(R.id.kmService);
            holder.brend = (TextView) view.findViewById(R.id.brendService);
            holder.zapchast = (TextView) view.findViewById(R.id.zapchastService);
            holder.price = (TextView) view.findViewById(R.id.priceBrend);
            holder.service = (TextView) view.findViewById(R.id.serviceName);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        TextView date = holder.date;
        TextView distance = holder.distance;
        TextView brend = holder.brend;
        TextView zapchast = holder.zapchast;
        TextView price = holder.price;
        TextView servis = holder.service;

        date.setText(service.getDate());
        distance.setText(service.getDistance());
        brend.setText(service.getBrend());
        zapchast.setText(service.getZapchast());
        price.setText(service.getPrice());
        servis.setText(service.getService());

        return view;
    }


    private static class ViewHolder {
        TextView date;
        TextView distance;
        TextView zapchast;
        TextView brend;
        TextView price;
        TextView service;
    }
}
