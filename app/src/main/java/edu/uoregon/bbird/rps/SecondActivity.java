package edu.uoregon.bbird.rps;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by Brian Bird on 7/15/2015.
 */

public class SecondActivity extends Activity {

    private RpsGame game;
    SharedPreferences savedValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);
        savedValues = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // Save new intents so they can be gotten in onResume
        setIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // If the intent contains a new move from the human,
        // use it. Otherwise restore the saved state

        // Get the game state sent from the FirstActivity
        Intent intent = getIntent();
        int handNum = intent.getExtras().getInt("humanHand", 0);
        Hand humanHand = Hand.values()[handNum];
        if(humanHand == Hand.none) {
            humanHand = Hand.values()[savedValues.getInt("humanHand", 0)];
        }
        Hand computerHand = Hand.values()[savedValues.getInt("computerHand", 0)];
        game = new RpsGame(computerHand, humanHand);

        // Pass the fragment a game ref
        SecondFragment secondFragment = (SecondFragment)getFragmentManager().findFragmentById(R.id.second_fragment);
        secondFragment.setGame(game);
        // Make the computer's move if there was a new intent
        if(handNum != 0) {
            secondFragment.makeComputerMove();
            intent.putExtra("humanHand", 0); // reset the value so we won't move again for rotation, etc.
        }
        secondFragment.displayComputerMoveAndWinner();
    }

    @Override
    protected void onPause() {
        super.onPause();

        //save state
        SharedPreferences.Editor editor = savedValues.edit();
        editor.putInt("computerHand", game.getComputerHand().ordinal());
        editor.putInt("humanHand", game.getHumanHand().ordinal());
        editor.commit();
    }

}
