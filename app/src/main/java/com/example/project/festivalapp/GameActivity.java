package com.example.project.festivalapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project.festivalapp.model.ImageHash;
import com.example.project.festivalapp.model.PuzzleImage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<ImageView> puzzle;
    private HashMap<Integer,ImageHash> images;
    private ArrayList<ImageView> selection;
    private TextView txtFestival;
    private TextView txtFinish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);



        txtFestival = (TextView) findViewById(R.id.txtFestival);
        txtFinish = (TextView) findViewById(R.id.txtFinish);

        puzzle = new ArrayList<ImageView>();
        puzzle.add((ImageView)findViewById(R.id.i1));
        puzzle.add((ImageView)findViewById(R.id.i2));
        puzzle.add((ImageView)findViewById(R.id.i3));
        puzzle.add((ImageView)findViewById(R.id.i4));
        puzzle.add((ImageView)findViewById(R.id.i5));
        puzzle.add((ImageView)findViewById(R.id.i6));
        puzzle.add((ImageView)findViewById(R.id.i7));
        puzzle.add((ImageView)findViewById(R.id.i8));
        puzzle.add((ImageView)findViewById(R.id.i9));

        for(int i = 0; i < 9; i++){
            puzzle.get(i).setOnClickListener(this);
            puzzle.get(i).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);

       // ImageView image = new ImageView(GameActivity.this);
       // image.getLayoutParams().width = 115;
       // image.getLayoutParams().height = ActionBar.LayoutParams.WRAP_CONTENT;
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



        if(getIntent().getExtras() != null){
            Bundle extra = getIntent().getExtras();
            String festival = extra.getString("txtFestival");
            if(festival.equals(getString(R.string.atiatihan))) {
                images = getAtiAtihan();
            }
            else if(festival.equals(getString(R.string.aswang))) {
                images = getAswang();
            }
            else if(festival.equals(getString(R.string.sandugo))) {
                images = getSandugo();
            }
            else if(festival.equals(getString(R.string.hermosa))) {
                images = getHermosa();
            }
            else if(festival.equals(getString(R.string.masskara))) {
                images = getMasskara();
            }
            else if(festival.equals(getString(R.string.kagayan))) {
                images = getKagayan();
            }
            else if(festival.equals(getString(R.string.sinulog))) {
                images = getSinulog();
            }
            else if(festival.equals(getString(R.string.bangus))) {
                images = getBangus();
            }
            else if(festival.equals(getString(R.string.bonokbonok))) {
                images = getBonokbonok();
            }
            else if(festival.equals(getString(R.string.moriones))) {
                images = getMoriones();
            }
            else if(festival.equals(getString(R.string.lanzones))) {
                images = getLanzones();
            }
            else if(festival.equals(getString(R.string.dinagyang))) {
                images = getDinagyang();
            }
            else if(festival.equals(getString(R.string.kuraldal))) {
                images = getKuraldal();
            }
            else if(festival.equals(getString(R.string.naliyagan))) {
                images = getNaliyagan();
            }
            else if(festival.equals(getString(R.string.pahiyas))) {
                images = getPahiyas();
            }
            else if(festival.equals(getString(R.string.tuna))) {
                images = getTuna();
            }
            else if(festival.equals(getString(R.string.kadayawan))) {
                images = getKadayawan();
            }
            else if(festival.equals(getString(R.string.kaamulan))) {
                images = getKaamulan();
            }
            else if(festival.equals(getString(R.string.obando))) {
                images = getObando();
            }
            else if(festival.equals(getString(R.string.pintados))) {
                images = getPintados();
            }
            else if(festival.equals(getString(R.string.pintaflores))) {
                images = getPintaflores();
            }
            else if(festival.equals(getString(R.string.sarakiki))) {
                images = getSarakiki();
            }
            else{
                images = getAtiAtihan();
            }
            txtFestival.setText(festival);
        }

        for(int i = 0; i < selection.size(); i++){
            selection.get(i).setOnClickListener(this);
            selection.get(i).setImageResource(images.get(i).getResourceId());
            selection.get(i).setTag(images.get(i).getImageId());
            selection.get(i).setScaleType(ImageView.ScaleType.FIT_XY);
        }



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public HashMap<Integer,ImageHash> getAtiAtihan(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.atiatihan001));
        images.put(number.get(1),new ImageHash(1,R.drawable.atiatihan002));
        images.put(number.get(2),new ImageHash(2,R.drawable.atiatihan003));
        images.put(number.get(3),new ImageHash(3,R.drawable.atiatihan004));
        images.put(number.get(4),new ImageHash(4,R.drawable.atiatihan005));
        images.put(number.get(5),new ImageHash(5,R.drawable.atiatihan006));
        images.put(number.get(6),new ImageHash(6,R.drawable.atiatihan007));
        images.put(number.get(7),new ImageHash(7,R.drawable.atiatihan008));
        images.put(number.get(8),new ImageHash(8,R.drawable.atiatihan009));
        return images;
    }

    public HashMap<Integer,ImageHash> getBangus(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.bangus001));
        images.put(number.get(1),new ImageHash(1,R.drawable.bangus002));
        images.put(number.get(2),new ImageHash(2,R.drawable.bangus003));
        images.put(number.get(3),new ImageHash(3,R.drawable.bangus004));
        images.put(number.get(4),new ImageHash(4,R.drawable.bangus005));
        images.put(number.get(5),new ImageHash(5,R.drawable.bangus006));
        images.put(number.get(6),new ImageHash(6,R.drawable.bangus007));
        images.put(number.get(7),new ImageHash(7,R.drawable.bangus008));
        images.put(number.get(8),new ImageHash(8,R.drawable.bangus009));
        return images;
    }

    public HashMap<Integer,ImageHash> getSandugo(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.sandugo001));
        images.put(number.get(1),new ImageHash(1,R.drawable.sandugo002));
        images.put(number.get(2),new ImageHash(2,R.drawable.sandugo003));
        images.put(number.get(3),new ImageHash(3,R.drawable.sandugo004));
        images.put(number.get(4),new ImageHash(4,R.drawable.sandugo005));
        images.put(number.get(5),new ImageHash(5,R.drawable.sandugo006));
        images.put(number.get(6),new ImageHash(6,R.drawable.sandugo007));
        images.put(number.get(7),new ImageHash(7,R.drawable.sandugo008));
        images.put(number.get(8),new ImageHash(8,R.drawable.sandugo009));
        return images;
    }

    public HashMap<Integer,ImageHash> getHermosa(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.hermosa001));
        images.put(number.get(1),new ImageHash(1,R.drawable.hermosa002));
        images.put(number.get(2),new ImageHash(2,R.drawable.hermosa003));
        images.put(number.get(3),new ImageHash(3,R.drawable.hermosa004));
        images.put(number.get(4),new ImageHash(4,R.drawable.hermosa005));
        images.put(number.get(5),new ImageHash(5,R.drawable.hermosa006));
        images.put(number.get(6),new ImageHash(6,R.drawable.hermosa007));
        images.put(number.get(7),new ImageHash(7,R.drawable.hermosa008));
        images.put(number.get(8),new ImageHash(8,R.drawable.hermosa009));
        return images;
    }

    public HashMap<Integer,ImageHash> getKuraldal(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.kuraldal001));
        images.put(number.get(1),new ImageHash(1,R.drawable.kuraldal002));
        images.put(number.get(2),new ImageHash(2,R.drawable.kuraldal003));
        images.put(number.get(3),new ImageHash(3,R.drawable.kuraldal004));
        images.put(number.get(4),new ImageHash(4,R.drawable.kuraldal005));
        images.put(number.get(5),new ImageHash(5,R.drawable.kuraldal006));
        images.put(number.get(6),new ImageHash(6,R.drawable.kuraldal007));
        images.put(number.get(7),new ImageHash(7,R.drawable.kuraldal008));
        images.put(number.get(8),new ImageHash(8,R.drawable.kuraldal009));
        return images;
    }

    public HashMap<Integer,ImageHash> getSinulog(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.sinulog001));
        images.put(number.get(1),new ImageHash(1,R.drawable.sinulog002));
        images.put(number.get(2),new ImageHash(2,R.drawable.sinulog003));
        images.put(number.get(3),new ImageHash(3,R.drawable.sinulog004));
        images.put(number.get(4),new ImageHash(4,R.drawable.sinulog005));
        images.put(number.get(5),new ImageHash(5,R.drawable.sinulog006));
        images.put(number.get(6),new ImageHash(6,R.drawable.sinulog007));
        images.put(number.get(7),new ImageHash(7,R.drawable.sinulog008));
        images.put(number.get(8),new ImageHash(8,R.drawable.sinulog009));
        return images;
    }

    public HashMap<Integer,ImageHash> getMasskara(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.masskara001));
        images.put(number.get(1),new ImageHash(1,R.drawable.masskara002));
        images.put(number.get(2),new ImageHash(2,R.drawable.masskara003));
        images.put(number.get(3),new ImageHash(3,R.drawable.masskara004));
        images.put(number.get(4),new ImageHash(4,R.drawable.masskara005));
        images.put(number.get(5),new ImageHash(5,R.drawable.masskara006));
        images.put(number.get(6),new ImageHash(6,R.drawable.masskara007));
        images.put(number.get(7),new ImageHash(7,R.drawable.masskara008));
        images.put(number.get(8),new ImageHash(8,R.drawable.masskara009));
        return images;
    }

    public HashMap<Integer,ImageHash> getLanzones(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.lanzones001));
        images.put(number.get(1),new ImageHash(1,R.drawable.lanzones002));
        images.put(number.get(2),new ImageHash(2,R.drawable.lanzones003));
        images.put(number.get(3),new ImageHash(3,R.drawable.lanzones004));
        images.put(number.get(4),new ImageHash(4,R.drawable.lanzones005));
        images.put(number.get(5),new ImageHash(5,R.drawable.lanzones006));
        images.put(number.get(6),new ImageHash(6,R.drawable.lanzones007));
        images.put(number.get(7),new ImageHash(7,R.drawable.lanzones008));
        images.put(number.get(8),new ImageHash(8,R.drawable.lanzones009));
        return images;
    }

    public HashMap<Integer,ImageHash> getKaamulan(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.kaamulan001));
        images.put(number.get(1),new ImageHash(1,R.drawable.kaamulan002));
        images.put(number.get(2),new ImageHash(2,R.drawable.kaamulan003));
        images.put(number.get(3),new ImageHash(3,R.drawable.kaamulan004));
        images.put(number.get(4),new ImageHash(4,R.drawable.kaamulan005));
        images.put(number.get(5),new ImageHash(5,R.drawable.kaamulan006));
        images.put(number.get(6),new ImageHash(6,R.drawable.kaamulan007));
        images.put(number.get(7),new ImageHash(7,R.drawable.kaamulan008));
        images.put(number.get(8),new ImageHash(8,R.drawable.kaamulan009));
        return images;
    }

    public HashMap<Integer,ImageHash> getBonokbonok(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.bonok001));
        images.put(number.get(1),new ImageHash(1,R.drawable.bonok002));
        images.put(number.get(2),new ImageHash(2,R.drawable.bonok003));
        images.put(number.get(3),new ImageHash(3,R.drawable.bonok004));
        images.put(number.get(4),new ImageHash(4,R.drawable.bonok005));
        images.put(number.get(5),new ImageHash(5,R.drawable.bonok006));
        images.put(number.get(6),new ImageHash(6,R.drawable.bonok007));
        images.put(number.get(7),new ImageHash(7,R.drawable.bonok008));
        images.put(number.get(8),new ImageHash(8,R.drawable.bonok009));
        return images;
    }

    public HashMap<Integer,ImageHash> getKagayan(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.kagayan001));
        images.put(number.get(1),new ImageHash(1,R.drawable.kagayan002));
        images.put(number.get(2),new ImageHash(2,R.drawable.kagayan003));
        images.put(number.get(3),new ImageHash(3,R.drawable.kagayan004));
        images.put(number.get(4),new ImageHash(4,R.drawable.kagayan005));
        images.put(number.get(5),new ImageHash(5,R.drawable.kagayan006));
        images.put(number.get(6),new ImageHash(6,R.drawable.kagayan007));
        images.put(number.get(7),new ImageHash(7,R.drawable.kagayan008));
        images.put(number.get(8),new ImageHash(8,R.drawable.kagayan009));
        return images;
    }

    public HashMap<Integer,ImageHash> getMoriones(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.moriones001));
        images.put(number.get(1),new ImageHash(1,R.drawable.moriones002));
        images.put(number.get(2),new ImageHash(2,R.drawable.moriones003));
        images.put(number.get(3),new ImageHash(3,R.drawable.moriones004));
        images.put(number.get(4),new ImageHash(4,R.drawable.moriones005));
        images.put(number.get(5),new ImageHash(5,R.drawable.moriones006));
        images.put(number.get(6),new ImageHash(6,R.drawable.moriones007));
        images.put(number.get(7),new ImageHash(7,R.drawable.moriones008));
        images.put(number.get(8),new ImageHash(8,R.drawable.moriones009));
        return images;
    }

    public HashMap<Integer,ImageHash> getSarakiki(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.sarakiki001));
        images.put(number.get(1),new ImageHash(1,R.drawable.sarakiki002));
        images.put(number.get(2),new ImageHash(2,R.drawable.sarakiki003));
        images.put(number.get(3),new ImageHash(3,R.drawable.sarakiki004));
        images.put(number.get(4),new ImageHash(4,R.drawable.sarakiki005));
        images.put(number.get(5),new ImageHash(5,R.drawable.sarakiki006));
        images.put(number.get(6),new ImageHash(6,R.drawable.sarakiki007));
        images.put(number.get(7),new ImageHash(7,R.drawable.sarakiki008));
        images.put(number.get(8),new ImageHash(8,R.drawable.sarakiki009));
        return images;
    }

    public HashMap<Integer,ImageHash> getPintados(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.pintados001));
        images.put(number.get(1),new ImageHash(1,R.drawable.pintados002));
        images.put(number.get(2),new ImageHash(2,R.drawable.pintados003));
        images.put(number.get(3),new ImageHash(3,R.drawable.pintados004));
        images.put(number.get(4),new ImageHash(4,R.drawable.pintados005));
        images.put(number.get(5),new ImageHash(5,R.drawable.pintados006));
        images.put(number.get(6),new ImageHash(6,R.drawable.pintados007));
        images.put(number.get(7),new ImageHash(7,R.drawable.pintados008));
        images.put(number.get(8),new ImageHash(8,R.drawable.pintados009));
        return images;
    }

    public HashMap<Integer,ImageHash> getPintaflores(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.pintaflores001));
        images.put(number.get(1),new ImageHash(1,R.drawable.pintaflores002));
        images.put(number.get(2),new ImageHash(2,R.drawable.pintaflores003));
        images.put(number.get(3),new ImageHash(3,R.drawable.pintaflores004));
        images.put(number.get(4),new ImageHash(4,R.drawable.pintaflores005));
        images.put(number.get(5),new ImageHash(5,R.drawable.pintaflores006));
        images.put(number.get(6),new ImageHash(6,R.drawable.pintaflores007));
        images.put(number.get(7),new ImageHash(7,R.drawable.pintaflores008));
        images.put(number.get(8),new ImageHash(8,R.drawable.pintaflores009));
        return images;
    }

    public HashMap<Integer,ImageHash> getObando(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.obando001));
        images.put(number.get(1),new ImageHash(1,R.drawable.obando002));
        images.put(number.get(2),new ImageHash(2,R.drawable.obando003));
        images.put(number.get(3),new ImageHash(3,R.drawable.obando004));
        images.put(number.get(4),new ImageHash(4,R.drawable.obando005));
        images.put(number.get(5),new ImageHash(5,R.drawable.obando006));
        images.put(number.get(6),new ImageHash(6,R.drawable.obando007));
        images.put(number.get(7),new ImageHash(7,R.drawable.obando008));
        images.put(number.get(8),new ImageHash(8,R.drawable.obando009));
        return images;
    }

    public HashMap<Integer,ImageHash> getTuna(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.tuna001));
        images.put(number.get(1),new ImageHash(1,R.drawable.tuna002));
        images.put(number.get(2),new ImageHash(2,R.drawable.tuna003));
        images.put(number.get(3),new ImageHash(3,R.drawable.tuna004));
        images.put(number.get(4),new ImageHash(4,R.drawable.tuna005));
        images.put(number.get(5),new ImageHash(5,R.drawable.tuna006));
        images.put(number.get(6),new ImageHash(6,R.drawable.tuna007));
        images.put(number.get(7),new ImageHash(7,R.drawable.tuna008));
        images.put(number.get(8),new ImageHash(8,R.drawable.tuna009));
        return images;
    }

    public HashMap<Integer,ImageHash> getKadayawan(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.kadayawan001));
        images.put(number.get(1),new ImageHash(1,R.drawable.kadayawan002));
        images.put(number.get(2),new ImageHash(2,R.drawable.kadayawan003));
        images.put(number.get(3),new ImageHash(3,R.drawable.kadayawan004));
        images.put(number.get(4),new ImageHash(4,R.drawable.kadayawan005));
        images.put(number.get(5),new ImageHash(5,R.drawable.kadayawan006));
        images.put(number.get(6),new ImageHash(6,R.drawable.kadayawan007));
        images.put(number.get(7),new ImageHash(7,R.drawable.kadayawan008));
        images.put(number.get(8),new ImageHash(8,R.drawable.kadayawan009));
        return images;
    }

    public HashMap<Integer,ImageHash> getDinagyang(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.dinagyang001));
        images.put(number.get(1),new ImageHash(1,R.drawable.dinagyang002));
        images.put(number.get(2),new ImageHash(2,R.drawable.dinagyang003));
        images.put(number.get(3),new ImageHash(3,R.drawable.dinagyang004));
        images.put(number.get(4),new ImageHash(4,R.drawable.dinagyang005));
        images.put(number.get(5),new ImageHash(5,R.drawable.dinagyang006));
        images.put(number.get(6),new ImageHash(6,R.drawable.dinagyang007));
        images.put(number.get(7),new ImageHash(7,R.drawable.dinagyang008));
        images.put(number.get(8),new ImageHash(8,R.drawable.dinagyang009));
        return images;
    }

    public HashMap<Integer,ImageHash> getPahiyas(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.pahiyas001));
        images.put(number.get(1),new ImageHash(1,R.drawable.pahiyas002));
        images.put(number.get(2),new ImageHash(2,R.drawable.pahiyas003));
        images.put(number.get(3),new ImageHash(3,R.drawable.pahiyas004));
        images.put(number.get(4),new ImageHash(4,R.drawable.pahiyas005));
        images.put(number.get(5),new ImageHash(5,R.drawable.pahiyas006));
        images.put(number.get(6),new ImageHash(6,R.drawable.pahiyas007));
        images.put(number.get(7),new ImageHash(7,R.drawable.pahiyas008));
        images.put(number.get(8),new ImageHash(8,R.drawable.pahiyas009));
        return images;
    }

    public HashMap<Integer,ImageHash> getNaliyagan(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.naliyagan001));
        images.put(number.get(1),new ImageHash(1,R.drawable.naliyagan002));
        images.put(number.get(2),new ImageHash(2,R.drawable.naliyagan003));
        images.put(number.get(3),new ImageHash(3,R.drawable.naliyagan004));
        images.put(number.get(4),new ImageHash(4,R.drawable.naliyagan005));
        images.put(number.get(5),new ImageHash(5,R.drawable.naliyagan006));
        images.put(number.get(6),new ImageHash(6,R.drawable.naliyagan007));
        images.put(number.get(7),new ImageHash(7,R.drawable.naliyagan008));
        images.put(number.get(8),new ImageHash(8,R.drawable.naliyagan009));
        return images;
    }

    public HashMap<Integer,ImageHash> getAswang(){
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0; i < 9; ++i) number.add(i);
        Collections.shuffle(number);
        HashMap<Integer,ImageHash> images = new HashMap<Integer,ImageHash>();
        images.put(number.get(0),new ImageHash(0,R.drawable.aswang001));
        images.put(number.get(1),new ImageHash(1,R.drawable.aswang002));
        images.put(number.get(2),new ImageHash(2,R.drawable.aswang003));
        images.put(number.get(3),new ImageHash(3,R.drawable.aswang004));
        images.put(number.get(4),new ImageHash(4,R.drawable.aswang005));
        images.put(number.get(5),new ImageHash(5,R.drawable.aswang006));
        images.put(number.get(6),new ImageHash(6,R.drawable.aswang007));
        images.put(number.get(7),new ImageHash(7,R.drawable.aswang008));
        images.put(number.get(8),new ImageHash(8,R.drawable.aswang009));
        return images;
    }

    private Drawable d;
    private Integer imageId;

    private ArrayList<ImageView> list;

    public ArrayList<ImageView> getImagesList(){
        return null;
    }

    @Override
    public void onClick(View view) {
        ImageView curImage = (ImageView) findViewById(view.getId());
        switch (view.getId()) {
            case R.id.s1:
            case R.id.s2:
            case R.id.s3:
            case R.id.s4:
            case R.id.s5:
            case R.id.s6:
            case R.id.s7:
            case R.id.s8:
            case R.id.s9:
                d = curImage.getDrawable();
                imageId =  (int) curImage.getTag();
                break;
            case R.id.i1:
            case R.id.i2:
            case R.id.i3:
            case R.id.i4:
            case R.id.i5:
            case R.id.i6:
            case R.id.i7:
            case R.id.i8:
            case R.id.i9:
                if (d != null) {
                    curImage.setImageDrawable(d);
                    curImage.setTag(imageId);

                    for(int i = 0; i < selection.size(); i++){
                        if(imageId == Integer.parseInt(selection.get(i).getTag()+"")){
                            selection.remove(i);
                            break;
                        }
                    }
                    if(isCompleted()){
                        txtFinish.setText("Puzzle Completed!");
                        txtFinish.setVisibility(View.VISIBLE);
                    }
                    else {
                        txtFinish.setVisibility(View.INVISIBLE);
                    }
                }
                break;
        }
    }

    public boolean isCompleted() {
        boolean completed = true;
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for(int j = 0; j < 9; j++)
            ids.add(j);

        for(int i = 0; i < puzzle.size(); i++){

            if(puzzle.get(i).getTag() != null){
                int id = (int) puzzle.get(i).getTag();
                if(id != ids.get(i)){
                    completed = false;
                    break;
                }

            }
            else {
                completed = false;
                break;
            }
        }
        return completed;
    }
}