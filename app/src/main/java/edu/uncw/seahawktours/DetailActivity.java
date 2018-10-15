package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String BuildingName = intent.getExtras().getString("building_name"); //Pull button text
        TextView title = findViewById(R.id.building_name); //Define text view from xml
        title.setText(BuildingName); //Set button text to textview

        //Fill building info corresponding to title
        if (BuildingName.equals(getResources().getString(R.string.dobo))) {
            TextView info = findViewById(R.id.building_info);
            info.setText(R.string.dobo_info);
        }
        if (BuildingName.equals(getResources().getString(R.string.cis))) {
            TextView info = findViewById(R.id.building_info);
            info.setText(R.string.cis_info);
        }
        if (BuildingName.equals(getResources().getString(R.string.csb))) {
            TextView info = findViewById(R.id.building_info);
            info.setText(R.string.csb_info);
        }
    }
}
