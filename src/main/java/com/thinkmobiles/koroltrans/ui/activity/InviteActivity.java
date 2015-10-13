package com.thinkmobiles.koroltrans.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.adapters.InviteAdapter;
import com.thinkmobiles.koroltrans.model.Invite;

import java.util.ArrayList;

/**
 * Created by john on 11.10.15.
 */
public class InviteActivity extends AppCompatActivity {

    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);

        ArrayList<Invite> invites = new ArrayList<>();
        invites.add(new Invite("AO7555BH","Зелена карта", "18.10.15"));
        invites.add(new Invite("AO1441AX","Масло", "-"));

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
