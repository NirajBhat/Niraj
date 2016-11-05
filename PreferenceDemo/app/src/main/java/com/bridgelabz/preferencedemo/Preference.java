package com.bridgelabz.preferencedemo;

import android.os.Bundle;
import android.preference.PreferenceActivity;


/**
 * Created by bridgeit on 26/10/16.
 */

public class Preference extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }




}
