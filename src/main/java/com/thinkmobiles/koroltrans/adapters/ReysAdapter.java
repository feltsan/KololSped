package com.thinkmobiles.koroltrans.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.parse.ParseQueryAdapter;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.model.Reys;
import com.thinkmobiles.koroltrans.model.Truck;

/**
 * Created by john on 04.10.15.
 */
public class ReysAdapter extends ParseQueryAdapter<Reys> {

    private LayoutInflater inflater;
    int count=0;

    public ReysAdapter(Context context,
                        ParseQueryAdapter.QueryFactory<Reys> queryFactory) {
        super(context, queryFactory);

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getItemView(final Reys reys, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_reys,parent, false);
            holder = new ViewHolder();
            holder.date = (TextView) view.findViewById(R.id.reysDate);
            holder.start = (TextView) view.findViewById(R.id.startpoint);
            holder.finish = (TextView) view.findViewById(R.id.finishPoint);
            holder.client = (TextView) view.findViewById(R.id.client);
            holder.price = (TextView) view.findViewById(R.id.priceSpedition);
            holder.confirm = (CheckBox) view.findViewById(R.id.confirmReys);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        TextView date = holder.date;
        TextView start = holder.start;
        TextView finish = holder.finish;
        TextView client = holder.client;
        TextView price = holder.price;
        final CheckBox confirm = holder.confirm;

        date.setText(reys.getDate());
        start.setText(reys.getStart());
        finish.setText(reys.getFinish());
        client.setText(reys.getClient());
        price.setText(reys.getPrice());
        confirm.setChecked(reys.getConfirm());
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reys.setConfirm(confirm.isChecked());
                reys.saveInBackground();
            }
        });


        return view;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();

    }

    private static class ViewHolder {
        TextView date;
        TextView start;
        TextView finish;
        TextView client;
        TextView price;
        CheckBox confirm;
    }
    public int getCou(){
        return count;
    }
}
