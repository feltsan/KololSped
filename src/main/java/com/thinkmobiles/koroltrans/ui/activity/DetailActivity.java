package com.thinkmobiles.koroltrans.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.thinkmobiles.koroltrans.R;
import com.thinkmobiles.koroltrans.ui.fragment.AllReysFragment;
import com.thinkmobiles.koroltrans.ui.fragment.DetailFragment;

/**
 * Created by john on 02.10.15.
 */
public class DetailActivity extends AppCompatActivity {

    private int orient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        orient = this.getResources().getConfiguration().orientation;

        if(orient==1){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detail_container, new DetailFragment())
                    .commit();
        }else{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detail_container, new AllReysFragment())
                    .commit();
        }

    }
}
