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

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.adapters.ReysAdapter;
import com.thinkmobiles.koroltrans.adapters.TruckAdapter;
import com.thinkmobiles.koroltrans.model.Reys;
import com.thinkmobiles.koroltrans.model.Truck;
import com.thinkmobiles.koroltrans.ui.activity.AddActivity;
import com.thinkmobiles.koroltrans.ui.activity.DetailActivity;

import java.util.List;

/**
 * Created by john on 04.10.15.
 */
public class AllReysFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemLongClickListener {

    private ListView reysList;
    private FloatingActionButton fab;
    private ParseQueryAdapter.QueryFactory<Reys> factory;
    private ReysAdapter reysAdapter;
    private DetailActivity detailActivity;
    private TableLayout tableLayout;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        detailActivity = (DetailActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_all_reys, container, false);
        findUI(root);
        setListener();
        setAdapter();

        return root;
    }

    private void findUI(View view) {
        reysList = (ListView) view.findViewById(R.id.reysList);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        tableLayout = (TableLayout) view.findViewById(R.id.reysTable);
        tableLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onResume() {
        super.onResume();
        reysAdapter.loadObjects();

    }

    private void setListener() {
        fab.setOnClickListener(this);
        reysList.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        openAddView();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        openEditView(reysAdapter.getItem(position));
        return false;
    }


    private void openAddView() {
        Intent i = new Intent(getActivity(), AddActivity.class);
        i.putExtra("ID", detailActivity.getIntent().getExtras().getString("ID"));
        i.putExtra("CODE", App.REYS_CODE);

        startActivityForResult(i, App.REYS_CODE);
    }

    private void openEditView(Reys reys) {
        Intent i = new Intent(detailActivity, AddActivity.class);
        i.putExtra("ID", reys.getUuidString());
        startActivityForResult(i, App.EDIT_TRUCK_CODE);
    }

    public void setAdapter() {
        setFactory();
        reysAdapter = new ReysAdapter(getActivity(), factory);

        reysAdapter.addOnQueryLoadListener(new ParseQueryAdapter.OnQueryLoadListener<Reys>() {
            @Override
            public void onLoading() {

            }

            @Override
            public void onLoaded(List<Reys> objects, Exception e) {
                if(objects.size()>0)
                    tableLayout.setVisibility(View.VISIBLE);
            }
        });
        reysList.setAdapter(reysAdapter);
    }

    public void setFactory() {
        factory = new ParseQueryAdapter.QueryFactory<Reys>() {
            @Override
            public ParseQuery<Reys> create() {
                ParseQuery<Reys> query = Reys.getQuery();
                query.include("truck");
                query.whereEqualTo("truck", detailActivity.getTruck());
                query.orderByDescending("createdAt");
                query.fromLocalDatastore();
                return query;
            }
        };
    }
}