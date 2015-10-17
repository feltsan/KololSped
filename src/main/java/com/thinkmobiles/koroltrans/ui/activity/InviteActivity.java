package com.thinkmobiles.koroltrans.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.thinkmobiles.koroltrans.App;
import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.adapters.InviteAdapter;
import com.thinkmobiles.koroltrans.model.Documents;
import com.thinkmobiles.koroltrans.model.Invite;
import com.thinkmobiles.koroltrans.model.Oil;
import com.thinkmobiles.koroltrans.until.DateHelper;
import com.thinkmobiles.koroltrans.until.InviteManager;
import com.thinkmobiles.koroltrans.until.Sender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 11.10.15.
 */
public class InviteActivity extends AppCompatActivity {

    private ListView listView;
    private Button button;
    private List<Documents> documentses;
    private List<Oil> oils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);


        ArrayList<Invite> invites = new ArrayList<>();

        if(this.getIntent().getParcelableArrayListExtra("arrayinvites")!=null)
            invites = this.getIntent().getParcelableArrayListExtra("arrayinvites");

        listView = (ListView) findViewById(R.id.documentsList);
        listView.setAdapter(new InviteAdapter(this, invites));

        button = (Button) findViewById(R.id.close);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



}
