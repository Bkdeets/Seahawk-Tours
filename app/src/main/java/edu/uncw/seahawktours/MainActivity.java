package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickDisplay(View view) {
        //Launch the DisplayActivity with building data
        Button button = (Button)view;
        String buttonText = button.getText().toString(); //get text from button pushed
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("building_name", buttonText);  //pass button text to new intent
        startActivity(intent);
    }
}
