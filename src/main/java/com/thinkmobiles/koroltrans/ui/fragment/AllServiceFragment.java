package com.thinkmobiles.koroltrans.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TableLayout;

import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.adapters.ServiceAdapter;
import com.thinkmobiles.koroltrans.model.Reys;
import com.thinkmobiles.koroltrans.model.Servis;
import com.thinkmobiles.koroltrans.ui.activity.AddActivity;
import com.thinkmobiles.koroltrans.ui.activity.DetailActivity;

import java.util.List;

/**
 * Created by john on 04.10.15.
 */
public class AllServiceFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemLongClickListener{

    private ListView serviceList;
    private FloatingActionButton fab;
    private DetailActivity detailActivity;
    private ServiceAdapter serviceAdapter;
    private ParseQueryAdapter.QueryFactory<Servis> factory;
    private TableLayout tableLayout;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        detailActivity = (DetailActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_all_service, container, false);
        findUI(root);
        setListener();
        setAdapter();
        return root;
    }

    private void findUI(View view) {
        serviceList = (ListView) view.findViewById(R.id.serviceList);
        fab    = (FloatingActionButton) view.findViewById(R.id.fab);
        tableLayout = (TableLayout) view.findViewById(R.id.serviceTable);
        tableLayout.setVisibility(View.INVISIBLE);
    }

    private void setListener(){
        fab.setOnClickListener(this);
        serviceList.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        openAddView();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        openEditView(serviceAdapter.getItem(position));
        return false;
    }



    private void openAddView() {
        Intent i = new Intent(getActivity(), AddActivity.class);
        i.putExtra("ID", detailActivity.getIntent().getExtras().getString("ID"));
        i.putExtra("CODE", App.SERVICE_CODE);

        startActivityForResult(i, App.SERVICE_CODE);
    }

    public void setAdapter() {
        setFactory();
        serviceAdapter = new ServiceAdapter(getActivity(), factory);

        serviceAdapter.addOnQueryLoadListener(new ParseQueryAdapter.OnQueryLoadListener<Servis>() {
            @Override
            public void onLoading() {

            }

            @Override
            public void onLoaded(List<Servis> objects, Exception e) {
                if (objects.size() > 0)
                    tableLayout.setVisibility(View.VISIBLE);
            }
        });

        serviceList.setAdapter(serviceAdapter);
    }

    public void setFactory() {
        factory = new ParseQueryAdapter.QueryFactory<Servis>() {
            @Override
            public ParseQuery<Servis> create() {
                ParseQuery<Servis> query = Servis.getQuery();
                query.include("truck");
                query.whereEqualTo("truck", detailActivity.getTruck());
                query.orderByDescending("createdAt");
                query.fromLocalDatastore();
                return query;
            }
        };
    }

    @Override
    public void onResume() {
        super.onResume();
        serviceAdapter.loadObjects();
    }
    private void openEditView(Servis servis) {
        Intent i = new Intent(detailActivity, AddActivity.class);
        i.putExtra("ID", servis.getUuidString());
        startActivityForResult(i, App.EDIT_TRUCK_CODE);
    }

}
