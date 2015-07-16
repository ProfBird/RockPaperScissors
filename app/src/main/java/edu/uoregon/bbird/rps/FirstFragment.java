package edu.uoregon.bbird.rps;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Brian Bird on 7/15/2015.
 */

public class FirstFragment extends Fragment implements OnClickListener {

    EditText rpsEditText;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

         View view = inflater.inflate(R.layout.first_fragment, container, false);

        // Set this fragment to listen for the Play button's click event
        Button b = (Button) view.findViewById(R.id.playButton);
        b.setOnClickListener(this);

        rpsEditText = (EditText)view.findViewById(R.id.rpsEditText);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.playButton) {
            String hand = rpsEditText.getText().toString().toLowerCase();
            // convert string to Hand enum
            if (hand.equals("")) {
                hand = "none";
            }
            Hand humanHand = Hand.valueOf(hand);

            // send an intent containing the human's Hand choice
            Intent intent = new Intent(getActivity(), SecondActivity.class);
            int humanHandNum = humanHand.ordinal();
            intent.putExtra("humanHand", humanHandNum);  // send state to 2nd activity
            startActivity(intent);
        }
    }
}
