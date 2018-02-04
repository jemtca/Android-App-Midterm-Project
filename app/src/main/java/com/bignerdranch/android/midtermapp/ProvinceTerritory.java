package com.bignerdranch.android.midtermapp;

public class ProvinceTerritory {

    private static final float GST = 5.0f; //same pst for all provinces/territories

    private String mName; //name of the province/territory
    private float mGst; //good and services tax
    private float mPst; //provincial sales tax
    private float mHst; //harmonized sales tax

    public ProvinceTerritory(String name, float pst, float hst){

        if(pst != 0 && hst == 0){

            setName(name);
            setPst(pst);
            setGst();

        }
        else if(pst == 0 && hst == 0){

            setName(name);
            setGst();

        }
        else{

            setName(name);
            setHst(hst);

        }

    }

    public final String getName(){

        return this.mName;

    }

    public final void setName(String name){

        this.mName = name;

    }

    public final float getGst(){

        return this.mGst;

    }

    public final void setGst(){

        this.mGst = GST;

    }

    public final float getPst(){

        return this.mPst;

    }

    public final void setPst(float pst){

        this.mPst = pst;

    }


    public final float getHst(){

        return this.mHst;

    }

    public final void setHst(float hst){

        this.mHst = hst;

    }

}
