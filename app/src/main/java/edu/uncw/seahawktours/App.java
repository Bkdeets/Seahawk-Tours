package edu.uncw.seahawktours;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;


public class App extends Application {

    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize the main data access object
        boxStore = MyObjectBox.builder().androidContext(App.this).build();

        // Get the wrapper (Box) for the Book table that lets us store Book objects
        Box<Building> bBox = boxStore.boxFor(Building.class);

        // Initialize with some data
        if (bBox.count() == 0) {
            List<Building> initialBuildings = new ArrayList<>();

            initialBuildings.add(new Building(
                    "DePaolo Hall",
                    R.string.depaolo_name,
                    R.string.depaolo_info,
                    R.drawable.depaolo,
                    R.string.depaolo_caption,
                    R.string.depaolo_link,
                    34.2267,
                    -77.8756

            ));

            initialBuildings.add(new Building(
                    "Dobo Hall",
                    R.string.dobo_name,
                    R.string.dobo_info,
                    R.drawable.dobo,
                    R.string.dobo_caption,
                    R.string.dobo_link,
                    34.2256,
                    -77.8682
            ));
            initialBuildings.add(new Building(
                    "James Hall",
                    R.string.james_name,
                    R.string.james_info,
                    R.drawable.james,
                    R.string.james_caption,
                    R.string.james_link,
                    34.2259,
                    -77.8775
            ));
            initialBuildings.add(new Building(
                    "Alderman Hall",
                    R.string.alderman_name,
                    R.string.alderman_info,
                    R.drawable.alderman,
                    R.string.alderman_caption,
                    R.string.alderman_link,
                    34.2269,
                    -77.8770
            ));
            initialBuildings.add(new Building(
                    "Computer Information Systems Building",
                    R.string.cis_name,
                    R.string.cis_info,
                    R.drawable.cis,
                    R.string.cis_caption,
                    R.string.cis_link,
                    34.2262,
                    -77.8718
            ));

            int c = 0;
            for(Building b: initialBuildings){
                b.id = c;
                c += 1;
            }
            // ObjectBox is smart enough to handle CRUD on Collections of entities
            bBox.put(initialBuildings);
        }
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }

}