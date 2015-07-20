package edu.uoregon.bbird.rps;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by Brian Bird on 7/15/2015.
 */

public class FirstActivity extends ActionBarActivity {

    private RpsGame game;   // Created and managed in FirstFragment
    SecondFragment fragment2;

    public RpsGame getGame() {
        return game;
    }

    public void setGame(RpsGame game) {
        this.game = game;
        fragment2.setGame(game);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.first_activity);

        fragment2 = (SecondFragment)getFragmentManager().findFragmentById(R.id.second_fragment);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id) {
            case R.id.action_settings:
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                return true;
            case R.id.action_about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    // Called by the FirstFragment to invoke game-play in the SecondFragment
    public void makeComputerMove() {
        SecondFragment fragment2 = (SecondFragment)getFragmentManager().findFragmentById(R.id.second_fragment);
        fragment2.makeComputerMove();
        fragment2.displayComputerMoveAndWinner();
    }

}
