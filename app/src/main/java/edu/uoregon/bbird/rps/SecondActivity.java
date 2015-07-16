package edu.uoregon.bbird.rps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Brian Bird on 7/15/2015.
 */
public class SecondActivity extends Activity {

    private RpsGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);
    }
}
