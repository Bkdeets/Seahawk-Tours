package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class Building {

    private String name;
    private String info;
    private int imageId;

    public Building(String name, String info, int imageId){
        this.name = name;
        this.info = info;
        this.imageId = imageId;
    };


    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
