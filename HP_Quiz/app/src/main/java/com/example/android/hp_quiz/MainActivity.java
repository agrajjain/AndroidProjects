package com.example.android.hp_quiz;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final int MAX_QUESTIONS = 5;
    public int TotalScore = 0;
    public int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void questionPicker(View view) {
        questionNumber += 1;
        switch (questionNumber) {
            case 1:
                setContentView(R.layout.question_1);
                break;
            case 2:
                setContentView(R.layout.question_2);
                break;
            case 3:
                setContentView(R.layout.question_3);
                break;
            case 4:
                setContentView(R.layout.question_4);
                break;
            case 5:
                setContentView(R.layout.question_5);
                break;
            default:
                displayResults(false);
        }
    }


    public void submit(View view) {

        boolean tempAnswer = false;
        switch (questionNumber) {
            case 1:
                RadioButton opt4button = findViewById(R.id.Q1opt4);
                tempAnswer = opt4button.isChecked();
                break;
            case 2:
                EditText editText = findViewById(R.id.q2Text);
                String answerText = editText.getText().toString();
                tempAnswer = answerText.equalsIgnoreCase(getString(R.string.q2Answer));
                break;
            case 3:
                CheckBox optBox = findViewById(R.id.Q3opt1);
                boolean opt1Box = optBox.isChecked();
                optBox = findViewById(R.id.Q3opt2);
                boolean opt2Box = optBox.isChecked();
                optBox = findViewById(R.id.Q3opt3);
                boolean opt3Box = optBox.isChecked();
                optBox = findViewById(R.id.Q3opt4);
                boolean opt4Box = optBox.isChecked();
                optBox = findViewById(R.id.Q3opt5);
                boolean opt5Box = optBox.isChecked();
                optBox = findViewById(R.id.Q3opt6);
                boolean opt6Box = optBox.isChecked();
                if (opt1Box && !opt2Box && opt3Box && opt4Box && !opt5Box && !opt6Box) {
                    tempAnswer=true;
                }
                break;
            case 4:
                RadioButton opt2button = findViewById(R.id.Q4opt2);
                tempAnswer = opt2button.isChecked();
                break;
            case 5:
                RadioButton opt3button = findViewById(R.id.Q5opt3);
                tempAnswer = opt3button.isChecked();
                break;
            default:
                tempAnswer = false;
        }

        if (tempAnswer) {
            TotalScore += 1;
            displayResults(true);
        } else {
            displayResults(false);
        }
    }

    public void displayResults(boolean answer) {
        setContentView(R.layout.result_page);
        TextView resultText = findViewById(R.id.resultText);
        TextView scoreText = findViewById(R.id.scoreText);

        if (questionNumber <= MAX_QUESTIONS) {
            if (answer) {
                resultText.setText(R.string.correctAnswer);
                resultText.setTextColor(Color.GREEN);
            } else {
                resultText.setText(R.string.wrongAnswer);
                resultText.setTextColor(Color.RED);
            }
        } else {
            resultText.setText(R.string.thankYou);
            resultText.setTextColor(Color.BLACK);
            Button continueButton = findViewById(R.id.continueButton);
            continueButton.setVisibility(View.INVISIBLE);
            Button shareButton = findViewById(R.id.share);
            shareButton.setVisibility(View.VISIBLE);
        }
        scoreText.setText(String.valueOf(TotalScore));
    }

public void shareCall(View view){
    String summary = "Congratulations!! Harry Potter Quiz Final Score: "+TotalScore;

    Intent sendIntent = new Intent();
    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_TEXT, summary);
    sendIntent.setType("text/plain");
    startActivity(sendIntent);
}
}