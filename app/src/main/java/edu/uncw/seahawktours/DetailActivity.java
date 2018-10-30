package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;


public class DetailActivity extends Activity {
    private ImageView buildingPhoto;
    private TextView buildingName;
    private TextView buildingInfo;
    private TextView buildingCaption;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        //Get all views
        buildingPhoto = findViewById(R.id.building_image);
        buildingName = findViewById(R.id.building_name);
        buildingInfo = findViewById(R.id.building_info);
        buildingCaption = findViewById(R.id.building_caption);

        //Pull button text
        String buttonText = intent.getExtras().getString("building_name");

        //Hire a building builder
        CampusExpert ce = new CampusExpert();


        //Set view attributes based on building
        buildingName.setText(ce.buildings.get(buttonText).getName());
        buildingInfo.setText(ce.buildings.get(buttonText).getInfo());
        buildingPhoto.setImageResource(ce.buildings.get(buttonText).getImageId());
        buildingCaption.setText(ce.buildings.get(buttonText).getCaption());


    }

}
