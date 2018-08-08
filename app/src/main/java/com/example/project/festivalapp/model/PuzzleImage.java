package com.example.project.festivalapp.model;

import android.app.Activity;
import android.widget.ImageView;

import com.example.project.festivalapp.R;

import java.util.ArrayList;


public class PuzzleImage extends Activity {
    private ArrayList<ImageView> puzzle;

    public PuzzleImage(){
        puzzle = new ArrayList<>();
        puzzle.add((ImageView)findViewById(R.id.i1));
        puzzle.add((ImageView)findViewById(R.id.i2));
        puzzle.add((ImageView)findViewById(R.id.i3));
        puzzle.add((ImageView)findViewById(R.id.i4));
        puzzle.add((ImageView)findViewById(R.id.i5));
        puzzle.add((ImageView)findViewById(R.id.i6));
        puzzle.add((ImageView)findViewById(R.id.i7));
        puzzle.add((ImageView)findViewById(R.id.i8));
        puzzle.add((ImageView)findViewById(R.id.i9));
    }

    public ArrayList<ImageView> getPuzzle(){
        return puzzle;
    }

}
