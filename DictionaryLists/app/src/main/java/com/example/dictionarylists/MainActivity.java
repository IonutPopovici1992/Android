package com.example.dictionarylists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    private static final String[] WORDS = {
            "mediocre", "UC Berkeley",
            "underachiver", "Stanford A- student",
            "jerk", "Marty Stepp"
    };

    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dictionary = new HashMap<>();
        for (int i = 0; i < WORDS.length; i += 2) {
            dictionary.put(WORDS[i], WORDS[i + 1]);
        }

        ListView list = findViewById(R.id.word_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, // activity
                android.R.layout.simple_list_item_1, // layout
                new ArrayList<String>(dictionary.keySet()) // array
        );

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String word = parent.getItemAtPosition(position).toString();
                String definition = dictionary.get(word);
                Toast.makeText(MainActivity.this, definition, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
