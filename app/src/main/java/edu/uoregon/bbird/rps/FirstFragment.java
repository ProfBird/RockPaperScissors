package edu.uoregon.bbird.rps;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Created by Brian Bird on 7/15/2015.
 */
public class FirstFragment extends Fragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate the layout for this fragment
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        // Set this fragment to listen for the Play button's click event
        Button b = (Button) view.findViewById(R.id.playButton);
        b.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.playButton:
                startActivity(new Intent(getActivity(), SecondActivity.class));
                break;
        }
    }
}
