package edu.uncw.seahawktours;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.GridLayoutManager;
import android.content.Intent;


public class BuildingListFragment extends Fragment {


    //Add Listener
    static interface Listener {
        void itemClicked(long id);
    };
    private Listener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView buildingRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_buildings, container, false);

        int[] buildingNames = new int[MainActivity.buildings.size()];
        for (int i = 0; i < buildingNames.length; i++) {
            buildingNames[i] = MainActivity.buildings.get(i).getNameId();
        }

        int[] buildingImages = new int[MainActivity.buildings.size()];
        for (int i = 0; i < buildingImages.length; i++) {
            buildingImages[i] = MainActivity.buildings.get(i).getImageId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(buildingNames, buildingImages);
        buildingRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        buildingRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_BUILDINGID, position);
                getActivity().startActivity(intent);
            }
        });

        return buildingRecycler;
    }

}
