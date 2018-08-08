package com.example.project.festivalapp.model;

import android.app.Activity;
import android.widget.ImageView;

import com.example.project.festivalapp.R;

import java.util.ArrayList;



public class SelectionImage extends Activity {
    private ArrayList<ImageView> selection;
    public SelectionImage(){
        selection = new ArrayList<ImageView>();
        selection.add((ImageView)findViewById(R.id.s1));
        selection.add((ImageView)findViewById(R.id.s2));
        selection.add((ImageView)findViewById(R.id.s3));
        selection.add((ImageView)findViewById(R.id.s4));
        selection.add((ImageView)findViewById(R.id.s5));
        selection.add((ImageView)findViewById(R.id.s6));
        selection.add((ImageView)findViewById(R.id.s7));
        selection.add((ImageView)findViewById(R.id.s8));
        selection.add((ImageView)findViewById(R.id.s9));
    }

    public ArrayList<ImageView> getSelection(){
        return selection;
    }
}
