package com.example.biggernumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // fields - live throughout the lifetime of the activity
    private int random1;
    private int random2;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // when app loads up
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        points = 0;

        pickRandomNumbers();
    }

    private void pickRandomNumbers() {
        // pick random numbers
        Random randomNumber = new Random();
        random1 = randomNumber.nextInt(10);
        while (true) {
            random2 = randomNumber.nextInt(10);
            if (random2 != random1)
                break;
        }

        Button leftButton = findViewById(R.id.left_button);
        leftButton.setText(Integer.toString(random1));
        Button rightButton = findViewById(R.id.right_button);
        rightButton.setText(Integer.toString(random2));
    }

    public void leftButtonClick(View view) {
        if (random1 >= random2) {
            // correct
            points++;
            Toast.makeText(this, "Great job!", Toast.LENGTH_SHORT).show();
        } else {
            // incorrect
            points--;
            Toast.makeText(this, "You suck!", Toast.LENGTH_SHORT).show();
        }

        // update display of points
        TextView textView = findViewById(R.id.points_field);
        textView.setText("Points: " + points);

        pickRandomNumbers();
    }

    public void rightButtonClick(View view) {
        if (random2 >= random1) {
            // correct
            points++;
            Toast.makeText(this, "Great job!", Toast.LENGTH_SHORT).show();
        } else {
            // incorrect
            points--;
            Toast.makeText(this, "You suck!", Toast.LENGTH_SHORT).show();
        }

        // update display of points
        TextView textView = findViewById(R.id.points_field);
        textView.setText("Points: " + points);

        pickRandomNumbers();
    }

}
