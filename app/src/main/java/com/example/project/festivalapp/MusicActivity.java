package com.example.project.festivalapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.project.festivalapp.utils.TranslateAnim;


public class MusicActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    private ImageView circle1;
    private ImageView circle2;
    private ImageView circle3;
    private ImageView imgPlay;
    private ImageView imgPause;
    private TranslateAnim tCircle1;
    private TranslateAnim tCircle2;
    private TranslateAnim tCircle3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        final ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);



        circle1 = (ImageView) findViewById(R.id.circle1);
        circle2 = (ImageView) findViewById(R.id.circle2);
        circle3 = (ImageView) findViewById(R.id.circle3);
        imgPlay = (ImageView) findViewById(R.id.imgPlay);
        imgPause = (ImageView) findViewById(R.id.imgPause);

       // circle1.setOnClickListener(this);
      //  circle2.setOnClickListener(this);
      //  circle3.setOnClickListener(this);
        circle1.setOnTouchListener(this);
        circle2.setOnTouchListener(this);
        circle3.setOnTouchListener(this);

        imgPlay.setOnClickListener(this);
        imgPause.setOnClickListener(this);
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

    public TranslateAnim getTranslateAnimation(int duration, final ImageView circle){
        final TranslateAnim anim = new TranslateAnim(0, 0, 0, 1200);
        anim.setDuration(duration);
        //    tCircle3.setRepeatCount(10);
        anim.setFillEnabled(false);
        anim.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation arg0) {
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {
            }
            @Override
            public void onAnimationEnd(Animation arg0) {
                anim.reset();
                anim.start();
               // circle.setVisibility(View.GONE);
                circle.animate()
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                             //   super.onAnimationEnd(animation);
                            //    circle.setVisibility(View.GONE);
                            }
                        });
                // circle3.setTop(-20);
                //   tCircle3.start();
                //    Toast.makeText(MusicActivity.this, "X: " + circle1.getLeft() + "Y: " + circle1.getTop(), Toast.LENGTH_SHORT).show();
            }
        });
        return anim;
    }
    private MediaPlayer mp = null;
    private boolean pause = false;
    private int musicPosition = 0;
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case R.id.imgPlay:
                if(mp==null) {
                    mp = MediaPlayer.create(MusicActivity.this, R.raw.sinulog);
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            circle1.setVisibility(View.INVISIBLE);
                            circle2.setVisibility(View.INVISIBLE);
                            circle3.setVisibility(View.INVISIBLE);
                        }
                    });
                    mp.start();
                    tCircle1 = getTranslateAnimation(1500,circle1);
                    tCircle2 = getTranslateAnimation(1000,circle2);
                    tCircle3 = getTranslateAnimation(1200,circle3);
                    circle1.startAnimation(tCircle1);
                    circle2.startAnimation(tCircle2);
                    circle3.startAnimation(tCircle3);
                }
                resume();
                break;
            case R.id.imgPause:
                pause();
                break;
        }
    }

    private void resume(){
        if(pause){
            tCircle1.resume();
            tCircle2.resume();
            tCircle3.resume();
            mp.seekTo(musicPosition);
            mp.start();
            pause = false;
        }
    }

    private void pause(){
        if(!pause){
            tCircle1.pause();
            tCircle2.pause();
            tCircle3.pause();
            mp.pause();
            musicPosition = mp.getCurrentPosition();
            pause = true;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            switch(view.getId()){
                case R.id.circle1:
                    circle1.setVisibility(View.INVISIBLE);
                    break;
                case R.id.circle2:
                    circle2.setVisibility(View.INVISIBLE);
                    break;
                case R.id.circle3:
                    circle3.setVisibility(View.INVISIBLE);
                    break;
            }
            return true;
        }
        return false;
    }
}
