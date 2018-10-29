package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {

    private Spinner mainSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getBuildings();




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<Building> buildingAdapter = new ArrayAdapter<>(
            this,
                android.R.layout.simple_spinner_item,
                Building.buildings
        );

        mainSpinner.setAdapter(buildingAdapter);

        //Create an OnItemClickListener
        AdapterView.OnItemSelectedListener itemSelectedListener =

                new AdapterView.OnItemSelectedListener() {

                    public void onItemSelected(
                            AdapterView<?> listView,
                            View itemView,
                            int position,
                            long id) {

                        if (position == 0) {
                            Intent intent = new Intent(
                                    MainActivity.this,
                                    DetailActivity.class);

                            intent.putExtra(DetailActivity.EXTRA_BUILDINGID, (int) id);
                            startActivity(intent);
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        // Another interface callback
                    }
                };

        //Add the listener to the spinner
        mainSpinner.setOnItemSelectedListener(itemSelectedListener);
    }

    public void onClickDisplay(View view) {
        //Launch the DisplayActivity with building data
        String spinnerText = mainSpinner.getSelectedItem().toString(); //get text from button pushed
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("building_name", spinnerText);  //pass button text to new intent
        startActivity(intent);
    }

    public Building[] getBuildings() {


        Building[] buildings;

        for()
        new Building(
                R.string.dobo_name,
                R.string.dobo_info,
                R.drawable.dobo),
                new Building(
                        getString(R.string.depaolo_name),
                        getString(R.string.depaolo_info),
                        R.drawable.depaolo),
                new Building(
                        getString(R.string.cis_name),
                        getString(R.string.cis_info),
                        R.drawable.cis),
    }
}
