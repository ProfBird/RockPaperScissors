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

        // Make Java objects from the fragment's XML elements
        View view = inflater.inflate(R.layout.first_fragment, container, false);

        // Set this fragment to listen for the Play button's click event
        Button b = (Button) view.findViewById(R.id.playButton);
        b.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.playButton) {
            // send an intent to start or resume the 2nd Activity
            Intent intent = new Intent(getActivity(), SecondActivity.class);
            startActivity(intent);
        }
    }
}
