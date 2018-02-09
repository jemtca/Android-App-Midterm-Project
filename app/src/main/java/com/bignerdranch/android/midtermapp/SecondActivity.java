package com.bignerdranch.android.midtermapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SecondActivity extends AppCompatActivity {

    private static final String EXTRA_GET_TAXES = "com.bignerdranch.android.midtermapp.get_taxes";

    private ProvincesTerritoriesArray mProvincesTerritoriesArray;
    private ProvinceTerritory mProvinceTerritory;

    private TextView mNameTextView;
    private EditText mEditText;
    private TextView mPstTextView;
    private TextView mGstTextView;
    private TextView mHstTextView;
    private TextView mTotalTextView;

    //only this activity needs to know the implementation details of what expects as extras on its intent
    public static Intent newIntent(Context packageContext, int index) {

        Intent intent = new Intent(packageContext, SecondActivity.class);
        intent.putExtra(EXTRA_GET_TAXES, index);

        return intent;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mProvincesTerritoriesArray = new ProvincesTerritoriesArray();

        //retrieve the extra from the intent
        int index = (int) getIntent().getSerializableExtra(EXTRA_GET_TAXES);
        mProvinceTerritory = findProvinceTerritory(index);

        //getting references and setting text
        mNameTextView = (TextView) findViewById(R.id.province_territory);
        mNameTextView.setText(mProvinceTerritory.getName());

        mPstTextView = (TextView) findViewById(R.id.pst);
        mPstTextView.setText(String.valueOf(mProvinceTerritory.getPst()));
        //mPstTextView.setText("" + mProvinceTerritory.getPst()); //another option

        mGstTextView = (TextView) findViewById(R.id.gts);
        mGstTextView.setText(String.valueOf(mProvinceTerritory.getGst()));

        mHstTextView = (TextView) findViewById(R.id.hts);
        mHstTextView.setText(String.valueOf(mProvinceTerritory.getHst()));

        mTotalTextView = (TextView) findViewById(R.id.total);

        mEditText = (EditText) findViewById(R.id.amount);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                //no need to implement anything

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if (!s.toString().isEmpty()) {

                    float amount = Float.parseFloat(s.toString());
                    float tax = calculateTotal(amount);
                    mTotalTextView.setText(String.valueOf(tax));

                } else {

                    mTotalTextView.setText("");

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

                //no need to implement anything

            }
        });


    }

    private ProvinceTerritory findProvinceTerritory(int index) {

        return mProvincesTerritoriesArray.getProvincesTerritories()[index];

    }

    private float calculateTotal(float amount) { //show only two or three decimals

        //check if gts or gts and pst or hst

        float gts = (amount * mProvinceTerritory.getGst()) / 100;
        float pst = (amount * mProvinceTerritory.getPst()) / 100;

        return amount + gts + pst;

    }

}
