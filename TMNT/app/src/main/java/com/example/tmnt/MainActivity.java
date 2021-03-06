package com.example.tmnt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void radioClick(View view) {
        ImageView myImageView = findViewById(R.id.turtle_image);

        int id = view.getId();

        if (id == R.id.don_button) {
            myImageView.setImageResource(R.drawable.tmntdon);
        } else if (id == R.id.leo_button) {
            myImageView.setImageResource(R.drawable.tmntleo);
        } else if (id == R.id.mike_button) {
            myImageView.setImageResource(R.drawable.tmntmike);
        } else if (id == R.id.raph_button) {
            myImageView.setImageResource(R.drawable.tmntraph);
        }
    }

}
