package com.example.twentyquestions;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by shayl on 2/21/2017.
 */

public class Rounds extends Fragment {
    Button yesButton;
    Button noButton;
    clickerManager manager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rounds,container,false);
        yesButton = (Button) view.findViewById(R.id.yesButton);
        noButton = (Button) view.findViewById(R.id.noButton);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesButtonClicked();
            }
        });
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noButtonClicked();
            }
        });
        return view;
    }


    public interface clickerManager {
        public void moveLeft();
        public void moveRight();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            manager = (clickerManager) context;
        } catch (ClassCastException e) {

        }
    }

    public void yesButtonClicked() {
        manager.moveLeft();
    }

    public void noButtonClicked() {
        manager.moveRight();
    }
}
