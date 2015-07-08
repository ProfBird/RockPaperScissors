package edu.uoregon.bbird.rockpaperscissors;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends ActionBarActivity {

    RpcGame game = new RpcGame();
    ImageView rpsImage;
    EditText rpsText;
    TextView winnerText;
    TextView compMoveText;

    public void play(View v) {
        Hand compHand = game.computerMove();
        compMoveText.setText(compHand.toString());
        displayImage(compHand);
        Hand humanHand = Hand.valueOf(rpsText.getText().toString().toLowerCase());
        winnerText.setText( game.whoWon(compHand, humanHand).toString());
    }

    private void displayImage(Hand hand) {
        int id = 0;

        switch(hand)
        {
            case rock:
                id = R.drawable.rock;
                break;
            case paper:
                id = R.drawable.paper;
                break;
            case scissors:
                id = R.drawable.scissors;
                break;
        }
        rpsImage.setImageResource(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        rpsImage = (ImageView)findViewById(R.id.rpsImage);
        rpsText = (EditText)findViewById(R.id.rpsEditText);
        winnerText = (TextView)findViewById(R.id.winnerLabel);
        compMoveText = (TextView)findViewById(R.id.compMoveTextView);
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
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
