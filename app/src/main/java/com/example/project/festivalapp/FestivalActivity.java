package com.example.project.festivalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class FestivalActivity extends AppCompatActivity implements View.OnClickListener {
    private Button maps;
    private Button lists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);


        maps = (Button) findViewById(R.id.btnMap);
        lists = (Button) findViewById(R.id.btnFestivalLists);

        maps.setOnClickListener(this);
        lists.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch(id){
            case R.id.btnMap:
                Intent i = new Intent(this,MapsActivity.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
