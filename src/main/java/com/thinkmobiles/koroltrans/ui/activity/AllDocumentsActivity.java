package com.thinkmobiles.koroltrans.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.adapters.AllDocumentsAdapter;
import com.thinkmobiles.koroltrans.adapters.TruckAdapter;
import com.thinkmobiles.koroltrans.model.Documents;
import com.thinkmobiles.koroltrans.model.Truck;

import java.util.List;

/**
 * Created by john on 13.10.15.
 */
public class AllDocumentsActivity extends AppCompatActivity {

    private ListView listView;
    private ParseQueryAdapter.QueryFactory<Documents> factory;
    private AllDocumentsAdapter documentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_documents);
        findUI();
        setAdapter();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void findUI(){
        listView = (ListView) findViewById(R.id.documentsList);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
        super.onResume();
        documentsAdapter.loadObjects();
    }

    public void setAdapter() {
        setFactory();
        documentsAdapter = new AllDocumentsAdapter(this, factory);
        documentsAdapter.addOnQueryLoadListener(new ParseQueryAdapter.OnQueryLoadListener<Documents>() {
            @Override
            public void onLoading() {

            }

            @Override
            public void onLoaded(List<Documents> objects, Exception e) {

            }
        });
        listView.setAdapter(documentsAdapter);
    }

    public void setFactory() {
        factory = new ParseQueryAdapter.QueryFactory<Documents>() {
            @Override
            public ParseQuery<Documents> create() {
                ParseQuery<Documents> query = Documents.getQuery();
                query.addAscendingOrder("end_date");
                query.fromLocalDatastore();
                return query;
            }
        };
    }

}


