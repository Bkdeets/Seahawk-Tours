package edu.uncw.seahawktours;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class BuildingListFragment extends ListFragment {

    //Add Listener
    static interface Listener {
        void itemClicked(long id);
    };
    private Listener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Array adapter
        ArrayAdapter<Building> listAdapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_1, Building.buildings);
        setListAdapter(listAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //Called when fragment is attached
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener)context;
    }

    //Tell listener when item is clicked
    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }
    }
}
