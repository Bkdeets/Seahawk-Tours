package edu.uncw.seahawktours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.query.Query;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Box<Building> buildingBox;
    private Query<Building> buildingsQuery;
    public static List<Building> buildings;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CaptionedImagesAdapter adapter;
    private List<String> names = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //DB Stuff
        BoxStore boxStore = ((App) getApplication()).getBoxStore();
        buildingBox = boxStore.boxFor(Building.class);

        // query all notes, sorted a-z by their text (https://docs.objectbox.io/queries)
        buildingsQuery = buildingBox.query().build();
        buildings = buildingsQuery.find();

        setContentView(R.layout.activity_main);

        //Set toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Create recycle view
        int[] buildingNames = new int[MainActivity.buildings.size()];
        for (int i = 0; i < buildingNames.length; i++) {
            buildingNames[i] = MainActivity.buildings.get(i).getNameId();
        }
        int[] buildingImages = new int[MainActivity.buildings.size()];
        for (int i = 0; i < buildingImages.length; i++) {
            buildingImages[i] = MainActivity.buildings.get(i).getImageId();
        }
        recyclerView = findViewById(R.id.building_recycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new CaptionedImagesAdapter(buildingNames, buildingImages, names);
        recyclerView.setAdapter(adapter);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                /*Intent intent = new Intent(this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_BUILDINGID, position);
                startActivity(intent);*/
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the app bar.
        getMenuInflater().inflate(R.menu.menu_main_noshare, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);

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


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        String userInput = s.toLowerCase();
        List<String> newList = new ArrayList<>();

        for (String names : names) {
            if (names.toLowerCase().contains(userInput)) {
                newList.add(names);
            }
        }
        adapter.updateList(newList);
        return true;
    }
}
