package com.bignerdranch.android.midtermapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_INDEX = "index";

    private Spinner mSpinner;

    private ProvinceTerritory[] mProvinceTerritories = new ProvinceTerritory[]{

            new ProvinceTerritory("Alberta", 0.0f,0.0f),
            new ProvinceTerritory("British Columbia", 7.0f,0.0f),
            new ProvinceTerritory("Manitoba", 8.0f,0.0f),
            new ProvinceTerritory("New Brunswick", 0.0f,15.0f),
            new ProvinceTerritory("Newfoundland and Labrador", 0.0f, 15.0f),
            new ProvinceTerritory("Nova Scotia", 0.0f, 15.0f),
            new ProvinceTerritory("Ontario", 0.0f, 13.0f),
            new ProvinceTerritory("Prince Edward Island", 0.0f, 15.0f),
            new ProvinceTerritory("Quebec", 9.975f, 0.0f),
            new ProvinceTerritory("Saskatchewan", 6.0f, 0.0f),
            new ProvinceTerritory("Northwest Territories", 0.0f, 0.0f),
            new ProvinceTerritory("Nunavut", 0.0f, 0.0f),
            new ProvinceTerritory("Yukon", 0.0f, 0.0f)

    };

    private int mCurrentIndex = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = (Spinner) findViewById(R.id.spinner);
        //Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner, android.R.layout.simple_spinner_item);
        //Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //Apply the adapter to the spinner
        mSpinner.setAdapter(adapter);

        if(savedInstanceState != null){ //if it exists, update mCurrentIndex with the value saved before

            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0); //read data from the bundle

        }

    }

    //Save the value of mCurrentIndex across rotation
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){

        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex); //method to save additional data to the bundle

    }

}
