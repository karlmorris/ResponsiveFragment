package edu.temple.responsivefragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MasterFragment.GetPlanetInterface {

    DetailFragment df;
    FragmentManager fm;

    boolean singlePane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singlePane = findViewById(R.id.container_2) == null;
        df = new DetailFragment();


        fm = getSupportFragmentManager();

        fm.beginTransaction()
                .replace(R.id.container_1, new MasterFragment())
                .commit();

        if (!singlePane) {
            fm.beginTransaction()
                    .replace(R.id.container_2, df)
                    .commit();
        }

    }

    @Override
    public void planetSelected(String planetName) {


        if (singlePane) {

            DetailFragment newFragment = DetailFragment.newInstance(planetName);
            fm.beginTransaction()
                    .replace(R.id.container_1, newFragment)
                    .addToBackStack(null)
                    .commit();
        } else {
            df.changePlanet(planetName);
        }
    }
}
