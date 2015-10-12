package com.thinkmobiles.koroltrans.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.model.Invite;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by john on 11.10.15.
 */
public class InviteAdapter extends BaseAdapter {
    Context context;
    ArrayList<Invite> invite;
    private LayoutInflater inflater;

    public InviteAdapter(Context context, ArrayList<Invite> maps) {
        this.context = context;
        this.invite = maps;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return invite.size();
    }

    @Override
    public Invite getItem(int position) {
        return invite.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_invite, parent, false);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.updateView(getItem(position));

        return convertView;
    }


    private static class ViewHolder {
        TextView nomer, date, type;


        public ViewHolder(final View _convertView) {
            initUI(_convertView);
            _convertView.setTag(this);
        }

        private void initUI(final View _convertView) {
            nomer = (TextView) _convertView.findViewById(R.id.nomer);
            date = (TextView) _convertView.findViewById(R.id.date);
            type = (TextView) _convertView.findViewById(R.id.type);
        }

        public final void updateView(final Invite invite) {
            nomer.setText(invite.getNomer());
            date.setText(invite.getDate());
            type.setText(invite.getType());
        }
    }
}
