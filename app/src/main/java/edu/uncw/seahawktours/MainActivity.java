package edu.uncw.seahawktours;

import android.content.Intent;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.location.Location;
import android.support.v4.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.query.Query;



public class MainActivity extends AppCompatActivity {

    GoogleApiClient.Builder googleApiClient = null;

    public static Location currentLocation;
    private Box<Building> buildingBox;
    private Query<Building> buildingsQuery;
    public static List<Building> buildings;
    private CaptionedImagesAdapter adapter;
    private List<SearchListItem> searchListItems;
    private FusedLocationProviderClient mFusedLocationClient;
    private static final int PERMISSIONS_ACCESS_FINE_LOCATION = 0;



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

        fillSearchList();
        setUpRecyclerView();

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        getDeviceLocation();

    }

    //Check if device needs to download google play services
    @Override
    protected  void onResume() {
        super.onResume();
        int response = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        if (response != ConnectionResult.SUCCESS) {
            GoogleApiAvailability.getInstance().getErrorDialog(this, response, 1).show();
        } else {
        }
    }

    //Creates a search list that can be filtered
    private void fillSearchList() {
        ArrayList<Integer> buildingNames = new ArrayList<>();
        for (int i = 0; i < buildings.size(); i++) {
            buildingNames.add(MainActivity.buildings.get(i).getNameId());
        }
        ArrayList<Integer> buildingImages = new ArrayList<>();
        for (int i = 0; i < buildings.size(); i++) {
            buildingImages.add(MainActivity.buildings.get(i).getImageId());
        }
        ArrayList<Long> buildingId = new ArrayList<>();
        for (int i = 0; i < buildings.size(); i++) {
            buildingId.add(MainActivity.buildings.get(i).getId());
        }
        //Use SearchListItem to create custom Array List
        //Wanted single input for adapter
        searchListItems = new ArrayList<>();
        for (int i = 0; i < buildings.size(); i++) {
            //Insert each building and picture name into searchList item
            searchListItems.add(new SearchListItem(MainActivity.buildings.get(i).getImageId(), MainActivity.buildings.get(i).getName(),
                    MainActivity.buildings.get(i).getId()));
        }


    }
    private void setUpRecyclerView() {
        //Set up recycle view
        RecyclerView recyclerView = findViewById(R.id.building_recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new CaptionedImagesAdapter(searchListItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //Creates new intent when clicked
        adapter.setOnItemClickListener(new CaptionedImagesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(long id) {
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
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_BUILDINGID, (int)id);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the app bar.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_noshare, menu);

        //Create search view
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        //Input Listener changes the filtered adapter with input
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) { return false; }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
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

   public void getDeviceLocation(){
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        PERMISSIONS_ACCESS_FINE_LOCATION);

        } else {
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                Building nearestBuilding = findNearestBuilding(location);
                                final long id = nearestBuilding.getId();
                                Button nearButton = (Button) findViewById(R.id.nearest);
                                nearButton.setText("Nearest Building: " + nearestBuilding.getName());
                                nearButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
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
                                            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                                            intent.putExtra(DetailActivity.EXTRA_BUILDINGID, (int)id);
                                            startActivity(intent);
                                        }
                                    }
                                });
                            }
                        }
                    });
        }
   }

    public Building findNearestBuilding(Location location){
        Building nearest = new Building("Fake",0,0,0,0,0,0,0);
        Double min = 999999999999.0;
        for(Building b: buildings){
            Double dist = calcDistance(b,location);
            if(dist<min){
                min = dist;
                nearest = b;
            }
        }
        return nearest;
    }

    public double calcDistance(Building building, Location location){
        double currentLat = location.getLatitude();
        double currentLon = location.getLongitude();
        double buildingLat = building.getLatitude();
        double buildingLon = building.getLongitude();

        return Math.sqrt(
                ((currentLat - buildingLat)*(currentLat - buildingLat))
                +((currentLon-buildingLon)*(currentLon-buildingLon)));
    }
}
