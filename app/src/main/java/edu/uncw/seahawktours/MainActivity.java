package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Spinner mainSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainSpinner = findViewById(R.id.main_spinner);

        //Set toolbar
       Toolbar toolbar = findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
    }

    public void onClickDisplay(View view) {
        //Launch the DisplayActivity with building data
        String spinnerText = mainSpinner.getSelectedItem().toString(); //get text from button pushed
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("building_name", spinnerText);  //pass button text to new intent
        startActivity(intent);
    }
}
