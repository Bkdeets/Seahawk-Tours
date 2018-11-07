package edu.uncw.seahawktours;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



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

}
