package edu.temple.responsivefragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    ImageView imageView;
    String planetName = "";

    public static final String PLANET_KEY = "planet_name";

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance (String planetName) {
        DetailFragment df = new DetailFragment();

        Bundle bundle = new Bundle();
        bundle.putString(PLANET_KEY, planetName);

        df.setArguments(bundle);

        return df;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
            planetName = getArguments().getString(PLANET_KEY);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        imageView = v.findViewById(R.id.imageView);

        change(planetName);

        return v;
    }

    public void changePlanet(String planetName) {
        change(planetName);
    }

    private void change (String planetName) {
        switch (planetName) {
            case "Earth": Picasso.get().load(R.drawable.earth).into(imageView); break;
            case "Venus": Picasso.get().load(R.drawable.venus).into(imageView); break;
            case "Planet 9": Picasso.get().load(R.drawable.planet9).into(imageView); break;
        }
    }

}
