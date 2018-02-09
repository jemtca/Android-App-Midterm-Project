package com.bignerdranch.android.midtermapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //private static final String KEY_INDEX = "index";

    private Spinner mSpinner;
    private Button mTestButton;

    private ProvincesTerritoriesArray mProvincesTerritoriesArray;

    //private int mCurrentIndex = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization of the territories/provinces in Canada
        mProvincesTerritoriesArray = new ProvincesTerritoriesArray();

        mSpinner = (Spinner) findViewById(R.id.spinner);
        //Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner, android.R.layout.simple_spinner_item);
        //Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //Apply the adapter to the spinner
        mSpinner.setAdapter(adapter);

        //method to go to the second activity once a item was selected
        mSpinner.setOnItemSelectedListener(this);



        mTestButton = (Button) findViewById(R.id.test_button); //getting the reference
        mTestButton.setOnClickListener(new View.OnClickListener() { //setting the listener
            @Override
            public void onClick(View v) {

                //start second activity
                int index = getProvinceTerritoryIndex("Quebec");
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

    //method from AdapterView.OnItemSelectedListener interface
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){

        // On selecting a spinner item
        String item = parent.getItemAtPosition(pos).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item + "(" +id + " " + pos + ")", Toast.LENGTH_LONG).show();

        int index;
        Intent intent;

        switch(pos){
            case 0:

                break;

            case 1:

                index = getProvinceTerritoryIndex("Alberta");
                intent = SecondActivity.newIntent(MainActivity.this, index);
                startActivity(intent);

                break;

            case 2:

                index = getProvinceTerritoryIndex("British Columbia");
                intent = SecondActivity.newIntent(MainActivity.this, index);
                startActivity(intent);

                break;

            case 3:

                index = getProvinceTerritoryIndex("Manitoba");
                intent = SecondActivity.newIntent(MainActivity.this, index);
                startActivity(intent);

                break;

            case 4:

                index = getProvinceTerritoryIndex("New Brunswick");
                intent = SecondActivity.newIntent(MainActivity.this, index);
                startActivity(intent);

                break;

            case 5:

                index = getProvinceTerritoryIndex("Newfoundland and Labrador");
                intent = SecondActivity.newIntent(MainActivity.this, index);
                startActivity(intent);

                break;

            case 6:

                index = getProvinceTerritoryIndex("Nova Scotia");
                intent = SecondActivity.newIntent(MainActivity.this, index);
                startActivity(intent);

                break;

            case 7:

                index = getProvinceTerritoryIndex("Ontario");
                intent = SecondActivity.newIntent(MainActivity.this, index);
                startActivity(intent);

                break;

            case 8:

                index = getProvinceTerritoryIndex("Prince Edward Island");
                intent = SecondActivity.newIntent(MainActivity.this, index);
                startActivity(intent);

                break;

            case 9:

                index = getProvinceTerritoryIndex("Quebec");
                intent = SecondActivity.newIntent(MainActivity.this, index);
                startActivity(intent);

                break;

            case 10:

                index = getProvinceTerritoryIndex("Saskatchewan");
                intent = SecondActivity.newIntent(MainActivity.this, index);
                startActivity(intent);

                break;

            case 11:

                index = getProvinceTerritoryIndex("Northwest Territories");
                intent = SecondActivity.newIntent(MainActivity.this, index);
                startActivity(intent);

                break;

            case 12:

                index = getProvinceTerritoryIndex("Nunavut");
                intent = SecondActivity.newIntent(MainActivity.this, index);
                startActivity(intent);

                break;

            case 13:

                index = getProvinceTerritoryIndex("Yukon");
                intent = SecondActivity.newIntent(MainActivity.this, index);
                startActivity(intent);

                break;

        }


    }

    //method from AdapterView.OnItemSelectedListener interface
    @Override
    public void onNothingSelected(AdapterView<?> parent) {



    }

    //method to reset the view when the user returns to the main activity
    @Override
    public void onResume(){

        super.onResume();
        mSpinner.setSelection(0); //show first option: select your province/territory


    }

    //method to find the index of a specific province (name) inside the array of provinces
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
