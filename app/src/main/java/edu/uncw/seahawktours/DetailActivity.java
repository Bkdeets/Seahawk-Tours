package edu.uncw.seahawktours;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.Math;
import java.util.List;


public class DetailActivity extends AppCompatActivity {
    private ImageView buildingPhoto;
    private TextView buildingName;
    private TextView buildingInfo;
    private TextView buildingCaption;
    private TextView linkButton;
    private Building contextBuilding;
    private ShareActionProvider shareActionProvider;
    public static final String EXTRA_BUILDINGID = "id";
    public static final String EXTRA_BUILDING_DATA = "buildings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        long buildingId = intent.getIntExtra(EXTRA_BUILDINGID,0); //fixed
        contextBuilding = MainActivity.buildings.get((int)buildingId);

        //Fragment
        DetailActivityFragment frag = (DetailActivityFragment)
                getSupportFragmentManager().findFragmentById(R.id.activity_fragment);
        frag.setBuilding(buildingId);

        //Set toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Get all views
        buildingPhoto = findViewById(R.id.building_image);
        buildingName = findViewById(R.id.building_name);
        buildingInfo = findViewById(R.id.building_info);
        buildingCaption = findViewById(R.id.building_caption);
        linkButton = findViewById(R.id.linkButton);

        //Set view attributes based on building
        buildingName.setText(contextBuilding.getNameId());
        buildingInfo.setText(contextBuilding.getInfoId());
        buildingPhoto.setImageResource(contextBuilding.getImageId());
        buildingCaption.setText(contextBuilding.getCaptionId());


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the app bar.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider =
                (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Learn more about:" + R.id.building_name);
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
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


    public void onClickGoToURL(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        String url = getString(contextBuilding.getLink());
        browserIntent.setData(Uri.parse(url));
        startActivity(browserIntent);
    }

}
