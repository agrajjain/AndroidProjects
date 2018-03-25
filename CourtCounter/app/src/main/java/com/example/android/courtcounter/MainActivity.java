package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int points_for_3Pointer = 3;
    final int points_for_2Pointer = 2;
    final int points_for_freeThrow = 1;
    int team_a_score = 0;
    int team_b_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(team_a_score);
        displayForTeamB(team_b_score);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void threePointerForTeamA(View view) {
        team_a_score = team_a_score + points_for_3Pointer;
        displayForTeamA(team_a_score);
    }

    public void twoPointerForTeamA(View view) {
        team_a_score = team_a_score + points_for_2Pointer;
        displayForTeamA(team_a_score);
    }

    public void freeThrowForTeamA(View view) {
        team_a_score = team_a_score + points_for_freeThrow;
        displayForTeamA(team_a_score);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void threePointerForTeamB(View view) {
        team_b_score = team_b_score + points_for_3Pointer;
        displayForTeamB(team_b_score);
    }

    public void twoPointerForTeamB(View view) {
        team_b_score = team_b_score + points_for_2Pointer;
        displayForTeamB(team_b_score);
    }

    public void freeThrowForTeamB(View view) {
        team_b_score = team_b_score + points_for_freeThrow;
        displayForTeamB(team_b_score);
    }

    public void resetScores(View view) {
        team_a_score = 0;
        team_b_score = 0;
        displayForTeamA(team_a_score);
        displayForTeamB(team_b_score);
    }
}
