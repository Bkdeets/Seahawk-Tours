package edu.uncw.seahawktours;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivityFragment extends Fragment {

    private long buildingId;

    public DetailActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_activity, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            buildingId = savedInstanceState.getLong("workoutId");
        }
    }

    public void setBuilding(long id) {
        this.buildingId = id;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            //Build the info for the fragment
            Building building = Building.buildings[(int) buildingId];
            TextView title = (TextView) view.findViewById(R.id.building_name);
            TextView caption = (TextView) view.findViewById(R.id.building_caption);
            TextView description = (TextView) view.findViewById(R.id.building_info);
            ImageView image = (ImageView) view.findViewById(R.id.building_image);
            title.setText(building.getNameId());
            caption.setText(building.getCaptionId());
            description.setText(building.getInfoId());
            image.setImageResource(building.getImageId());
        }
    }

}
