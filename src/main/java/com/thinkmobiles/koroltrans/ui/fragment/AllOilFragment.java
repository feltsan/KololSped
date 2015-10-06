package com.thinkmobiles.koroltrans.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.ui.activity.AddActivity;

import java.util.List;

/**
 * Created by john on 04.10.15.
 */
public class AllOilFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemLongClickListener{

    private ListView oilList;
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_all_oil, container, false);
        findUI(root);
        setListener();

        return root;
    }

    private void findUI(View view) {
        oilList = (ListView) view.findViewById(R.id.oilList);
        fab    = (FloatingActionButton) view.findViewById(R.id.fab);
    }

    private void setListener(){
        fab.setOnClickListener(this);
        oilList.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        openAddView();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        openAddView();
        return false;
    }



    private void openAddView() {
        Intent i = new Intent(getActivity(), AddActivity.class);
//        i.putExtra("ID", todo.getUuidString());
        i.putExtra("CODE", App.OIL_CODE);

        startActivityForResult(i, App.OIL_CODE);
    }
}
