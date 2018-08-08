package com.example.project.festivalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;


public class FestivalInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtFestival;
    private TextView txtInfo;
    private ImageView imageFestival;
    private HashMap<String,Integer> image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);


        txtFestival = (TextView) findViewById(R.id.txtFestival);
        txtInfo = (TextView) findViewById(R.id.txtInfo);
        imageFestival = (ImageView) findViewById(R.id.imgFestival);


        image = new HashMap<String,Integer>();

        image.put(getString(R.string.sinulog),R.drawable.sinulog);
        image.put(getString(R.string.aswang),R.drawable.aswang);
        image.put(getString(R.string.tuna),R.drawable.tuna);
        image.put(getString(R.string.pintados),R.drawable.pintados);
        image.put(getString(R.string.pintaflores),R.drawable.pintaflores);
        image.put(getString(R.string.obando),R.drawable.obando);
        image.put(getString(R.string.moriones),R.drawable.moriones);
        image.put(getString(R.string.masskara),R.drawable.masskara);
        image.put(getString(R.string.bonokbonok),R.drawable.bonok);
        image.put(getString(R.string.atiatihan),R.drawable.atiatihan);
        image.put(getString(R.string.dinagyang),R.drawable.dinagyang);
        image.put(getString(R.string.kaamulan),R.drawable.kaamulan);
        image.put(getString(R.string.kadayawan),R.drawable.kadayawan);
        image.put(getString(R.string.kagayan),R.drawable.kagay_an);
        image.put(getString(R.string.lanzones),R.drawable.lanzones);
        image.put(getString(R.string.pahiyas),R.drawable.pahiyas);
        image.put(getString(R.string.kuraldal),R.drawable.kuraldal);
        image.put(getString(R.string.sarakiki),R.drawable.sarakiki);
        image.put(getString(R.string.naliyagan),R.drawable.naliyagan);
        image.put(getString(R.string.bangus),R.drawable.bangus);
        image.put(getString(R.string.sandugo),R.drawable.sandugo);
        image.put(getString(R.string.hermosa),R.drawable.hermosa);


        if(getIntent().getExtras() != null){
            Bundle extra = getIntent().getExtras();
            String festival = extra.getString("txtFestival");
            String info = extra.getString("txtInfo");
            txtFestival.setText(festival);
            txtInfo.setText(info);
            imageFestival.setImageResource(image.get(festival));
        }

        imageFestival.setOnClickListener(this);
        txtInfo.setOnClickListener(this);
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
        switch (id){
            case R.id.imgFestival:
                Intent i = new Intent(this,GameActivity.class);
                i.putExtra("txtFestival",txtFestival.getText().toString());
                startActivity(i);
                break;
            case R.id.txtInfo:
                Intent j = new Intent(this,MusicActivity.class);
                j.putExtra("txtFestival",txtFestival.getText().toString());
                startActivity(j);
                break;
        }
    }
}
