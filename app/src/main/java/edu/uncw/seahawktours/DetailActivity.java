package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {
    String BuildingName;
    ImageView buildingPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Creates off saved state?
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        buildingPhoto = findViewById(R.id.building_image);
        BuildingName = intent.getExtras().getString("building_name"); //Pull button text
        TextView title = findViewById(R.id.building_name); //Define text view from xml
        title.setText(BuildingName); //Set selection text to textview

        //Fill building info corresponding to title
        //Each if statement assigns correct strings and image src depending on selection


        //Put this if block in a function
        if (BuildingName.equals(getResources().getString(R.string.dobo))) {
            TextView info = findViewById(R.id.building_info);
            info.setText(R.string.dobo_info);
            int image = R.drawable.dobo;
            String description = "Dobo Hall Image";
            buildingPhoto.setImageResource(image);
            buildingPhoto.setContentDescription(description);
            TextView caption = findViewById(R.id.building_caption);
            caption.setText(R.string.dobo_caption);
        }

        if (BuildingName.equals(getResources().getString(R.string.cis))) {
            TextView info = findViewById(R.id.building_info);
            info.setText(R.string.cis_info);
            int image = R.drawable.cis;
            String description = "CIS Image";
            buildingPhoto.setImageResource(image);
            buildingPhoto.setContentDescription(description);
            TextView caption = findViewById(R.id.building_caption);
            caption.setText(R.string.cis_caption);
        }

        if (BuildingName.equals(getResources().getString(R.string.depaolo))) {
            TextView info = findViewById(R.id.building_info);
            info.setText(R.string.depaolo_info);
            int image = R.drawable.depaolo;
            String description = "Depaolo Hall Image";
            buildingPhoto.setImageResource(image);
            buildingPhoto.setContentDescription(description);
            TextView caption = findViewById(R.id.building_caption);
            caption.setText(R.string.depalo_caption);
        }
    }
}
