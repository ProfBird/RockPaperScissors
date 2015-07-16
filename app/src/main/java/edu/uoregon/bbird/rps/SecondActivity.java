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

    // We need to override this life-cycle method so that we can use
    // getIntent() to get any intent sent while this Activity is still in memory
    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        super.onNewIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Get the game state sent from the FirstActivity (we only care about the user's hand choice)
        Intent intent = getIntent();
        int handNum = intent.getExtras().getInt("humanHand");
        Hand humanHand = Hand.values()[handNum];
        if (game == null)   // If this Activity already exists, we'll already have a game object
            game = new RpsGame();   // otherwise we'll make a new one
        game.setHumanHand(humanHand);

        // Pass the fragment a game ref while calling the method that invokes game play
        SecondFragment secondFragment =
                (SecondFragment)getFragmentManager().findFragmentById(R.id.second_fragment);
        secondFragment.computerMove(game);
    }
}
