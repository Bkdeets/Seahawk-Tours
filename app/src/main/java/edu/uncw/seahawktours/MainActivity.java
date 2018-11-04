package edu.uncw.seahawktours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView mainList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Array adapter
        ArrayAdapter<Building> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, Building.buildings);
        mainList = findViewById(R.id.main_list);
        mainList.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(
                    AdapterView<?> listView,
                    View itemView,
                    int position,
                    long id) {

                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_BUILDINGID, (int) id);
                    startActivity(intent);

            }
        };

        mainList.setOnItemClickListener(itemClickListener);

    }


    /*public void onClickDisplay(View view) {
        //Launch the DisplayActivity with building data
        String spinnerText = mainList.getSelectedItem().toString(); //get text from button pushed
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("building_name", spinnerText);  //pass button text to new intent
        startActivity(intent);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the app bar.
        getMenuInflater().inflate(R.menu.menu_main_noshare, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    //Set up button for about intent
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.go_about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
