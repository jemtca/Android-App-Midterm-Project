package com.bignerdranch.android.midtermapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    //private static final String KEY_INDEX = "index";

    private Spinner mSpinner;
    private Button mTestButton;

    private ProvincesTerritoriesArray mProvincesTerritoriesArray;

    //private int mCurrentIndex = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization of the
        mProvincesTerritoriesArray = new ProvincesTerritoriesArray();

        mSpinner = (Spinner) findViewById(R.id.spinner);
        //Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner, android.R.layout.simple_spinner_item);
        //Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //Apply the adapter to the spinner
        mSpinner.setAdapter(adapter);

        mTestButton = (Button) findViewById(R.id.test_button); //getting the reference
        mTestButton.setOnClickListener(new View.OnClickListener() { //setting the listener
            @Override
            public void onClick(View v) {

                //start second activity
                int index = getProvinceTerritoryIndex("British Columbia");
                Intent intent = SecondActivity.newIntent(MainActivity.this, index);
                startActivity(intent);

            }
        });

        /*if(savedInstanceState != null){ //if it exists, update mCurrentIndex with the value saved before

            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0); //read data from the bundle

        }*/

    }

    //Save the value of mCurrentIndex across rotation
    /*@Override
    public void onSaveInstanceState(Bundle savedInstanceState){

        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex); //method to save additional data to the bundle

    }*/

    private int getProvinceTerritoryIndex(String name){

        int index = 0;
        boolean found = false;

        for(int i = 0; i < mProvincesTerritoriesArray.getProvincesTerritories().length && !found; i++){

            if(name.equalsIgnoreCase(mProvincesTerritoriesArray.getProvincesTerritories()[i].getName())){

                index = i;
                found = true;

            }

        }

        return index;

    }

}
