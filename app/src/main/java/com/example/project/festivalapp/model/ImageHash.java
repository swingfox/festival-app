package com.example.project.festivalapp.model;

import android.app.Activity;

import com.example.project.festivalapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class ImageHash extends Activity {
    private int resId;
    private int imageId;

    public ImageHash(Integer imageId, Integer resId){
        this.imageId = imageId;
        this.resId = resId;
    }
    public int getResourceId(){
        return resId;
    }
    public int getImageId(){
        return imageId;
    }
}
