package com.thinkmobiles.koroltrans.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;
import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.model.Documents;
import com.thinkmobiles.koroltrans.model.Servis;
import com.thinkmobiles.koroltrans.ui.activity.AddActivity;
import com.thinkmobiles.koroltrans.ui.activity.DetailActivity;
import com.thinkmobiles.koroltrans.until.DateHelper;

/**
 * Created by john on 13.10.15.
 */
public class AllDocumentsAdapter extends ParseQueryAdapter<Documents> {

    private LayoutInflater inflater;
    private Context context;

    public AllDocumentsAdapter(Context context, QueryFactory<Documents> queryFactory) {
        super(context, queryFactory);
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }

    @Override
    public View getItemView(final Documents documents, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_documets, parent, false);
            holder = new ViewHolder();
            holder.date = (TextView) view.findViewById(R.id.date);
            holder.nomer = (TextView) view.findViewById(R.id.nomer);
            holder.type = (TextView) view.findViewById(R.id.type);
            holder.layout = (RelativeLayout) view.findViewById(R.id.background);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        TextView date = holder.date;
        TextView nomer = holder.nomer;
        TextView type = holder.type;
        RelativeLayout layout = holder.layout;

        date.setText(DateHelper.convertLongToString(documents.getEndDate()));
        nomer.setText(documents.getTruck().getNomer());

        switch (documents.getType()) {
            case App.GCTru:
                layout.setBackgroundColor(context.getResources().getColor(android.R.color.holo_green_dark));
                type.setText("Карта");
                break;

            case App.GCTra:
                layout.setBackgroundColor(context.getResources().getColor(android.R.color.holo_green_dark));
                type.setText("Карта");
                break;

            case App.WSTru:
                layout.setBackgroundColor(context.getResources().getColor(android.R.color.white));
                type.setText("Сертиф.");
                break;

            case App.WSTra:
                layout.setBackgroundColor(context.getResources().getColor(android.R.color.white));
                type.setText("Сертиф.");
                break;

            case App.EPTru:
                layout.setBackgroundColor(context.getResources().getColor(android.R.color.white));
                type.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.euro));
                break;

            case App.EPTra:
                layout.setBackgroundColor(context.getResources().getColor(android.R.color.white));
                type.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.euro));
                break;

            case App.TACHO:
                layout.setBackgroundColor(context.getResources().getColor(android.R.color.white));
                type.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.tacho));
                break;

            case App.YSTra:
                layout.setBackgroundColor(context.getResources().getColor(android.R.color.holo_orange_light));
                type.setText("Свід.");
                break;

            case App.POLTru:
                layout.setBackgroundColor(context.getResources().getColor(android.R.color.white));
                type.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.strach));
                break;

            case App.POLTra:
                layout.setBackgroundColor(context.getResources().getColor(android.R.color.white));
                type.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.strach));
                break;
        }


        return view;
    }



    private static class ViewHolder {
        RelativeLayout layout;
        TextView date;
        TextView type;
        TextView nomer;
    }
}

