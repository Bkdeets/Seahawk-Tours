package edu.uncw.seahawktours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements BuildingListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

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

    //Check what to display depending on device
    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.detail_container);
        if (fragmentContainer != null) {
            //Update and commit fragment changes
            DetailActivityFragment details = new DetailActivityFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setBuilding(id);
            ft.replace(R.id.detail_container, details);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_BUILDINGID, (int)id);
            startActivity(intent);
        }
    }
}
