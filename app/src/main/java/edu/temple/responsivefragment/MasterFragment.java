package edu.temple.responsivefragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment {

    ListView listView;

    Context parent;

    public MasterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.parent = context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_master, container, false);
        listView = v.findViewById(R.id.listView);

        listView.setAdapter(new ArrayAdapter<>(parent, android.R.layout.simple_list_item_1,
                parent.getResources().getStringArray(R.array.planets)));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View view, int position, long id) {
                String planetName = (String) parentView.getItemAtPosition(position);
                ((GetPlanetInterface) parent).planetSelected(planetName);
            }
        });

        return v;
    }


    interface GetPlanetInterface{
        void planetSelected(String planetName);
    }

}
