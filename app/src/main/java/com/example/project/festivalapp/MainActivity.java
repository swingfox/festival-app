package com.example.project.festivalapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnFestival;
    private Button btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFestival = (Button) findViewById(R.id.btnFestival);
        btnExit = (Button) findViewById(R.id.btnExit);

        btnFestival.setOnClickListener(this);
        btnExit.setOnClickListener(this);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

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

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case R.id.btnFestival:
                Intent i = new Intent(this,MapsActivity.class);
                startActivity(i);
                break;
            case R.id.btnExit:
                finish();
                break;
        }
    }
}
