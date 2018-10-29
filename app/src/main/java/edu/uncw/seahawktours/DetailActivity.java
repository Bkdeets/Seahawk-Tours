package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class DetailActivity extends Activity {
    private ImageView buildingPhoto;
    private TextView title;
    private TextView info;
    private HashMap<String, String> buildingMappings;


    public static final String EXTRA_BUILDINGID = "buildingId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Get the building from the intent
        int buildingId = (Integer)getIntent().getExtras().get(EXTRA_BUILDINGID);
        Building building = Building.buildings[buildingId];

        TextView name = (TextView)findViewById(R.id.building_name);
        name.setText(building.getName());

        TextView description = (TextView)findViewById(R.id.building_info);
        description.setText(building.getInfo());

        ImageView photo = (ImageView)findViewById(R.id.building_image);
        photo.setImageResource(building.getImageId());
        photo.setContentDescription(building.getName());
    }

/*    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();


        makeBuildingHash();

        //Creates off saved state?


        buildingPhoto = findViewById(R.id.building_image);
        title = findViewById(R.id.building_name);
        info = findViewById(R.id.building_info);

        String buildingName = intent.getExtras().getString("building_name"); //Pull button text

        title.setText(buildingName); //Set selection text to textview

        Building buildingToDisplay = new Building();
        buildingToDisplay.setName(BuildingName);

        findViewById(R.id.building_info);


        buildingToDisplay.setInfo();

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
    }*/






    private void makeBuildingHash(){
        buildingMappings.put("Dobo Hall", "dobo");
        buildingMappings.put("DePaolo Hall", "depaolo");
        buildingMappings.put("Computer Information Systems Building", "cis");
    }

    /*private Building mapBuilding(String displayName) {

        Building building = new Building();

        building.setName(displayName);
        String

        return building;
    }*/
}
