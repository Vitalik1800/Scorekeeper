package com.lab3.scorekeeper;

import androidx.annotation.*;
import androidx.appcompat.app.*;
import android.annotation.*;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mScore1, mScore2;
    TextView score_1, score_2;
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score_1 = findViewById(R.id.score_1);
        score_2 = findViewById(R.id.score_2);
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);
            score_1.setText(String.valueOf(mScore1));
            score_2.setText(String.valueOf(mScore2));
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode (AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(getString(R.string.night_mode));
        }
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){
            case R.id.decreaseTeam1:
                mScore1--;
                score_1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                mScore2--;
                score_2.setText(String.valueOf(mScore2));
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){
            case R.id.increaseTeam1:
                mScore1++;
                score_1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                mScore2++;
                score_2.setText(String.valueOf(mScore2));
        }
    }
}