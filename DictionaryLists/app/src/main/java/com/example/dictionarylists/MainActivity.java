package com.example.dictionarylists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    // a dictionary of {word -> definition} pairs for lookup
    private Map<String, String> dictionary;
    private List<String> words;

    private void readFileData() {
        Scanner scanner = new Scanner(getResources().openRawResource(R.raw.grewords));
        while (scanner.hasNextLine()) {
            // "abate -> to lessen to subside"
            String line = scanner.nextLine();
            String[] parts = line.split("\t");
            dictionary.put(parts[0], parts[1]);
            words.add(parts[0]);
        }
    }

    // pick the word;
    // pick 5 random defns for that word (1 is correct)
    // show all of that on screen
    private void chooseWords() {
        Random randomNumber = new Random();
        int randomIndex = randomNumber.nextInt(words.size());
        String theWord = words.get(randomIndex);
        String theDefinition = dictionary.get(theWord);

        // pick 4 other (wrong) definitions at random
        List<String> defns = new ArrayList<>(dictionary.values());
        defns.remove(theDefinition);
        Collections.shuffle(defns);
        defns = defns.subList(0, 4);
        defns.add(theDefinition);
        Collections.shuffle(defns);

        // weird stuff ...
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dictionary = new HashMap<>();
        words = new ArrayList<>();

        readFileData();
        chooseWords();

        // put the dictionary words into an Adapter so they can be seen in List
        ListView list = findViewById(R.id.word_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, // activity
                android.R.layout.simple_list_item_1, // layout
                new ArrayList<String>(dictionary.keySet()) // array
        );

        list.setAdapter(adapter);

        // this is the code that should run when the user taps items in the list
        list.setOnItemClickListener( (parent, view, position, id) -> {
                String word = parent.getItemAtPosition(position).toString();
                String definition = dictionary.get(word);
                Toast.makeText(MainActivity.this, definition, Toast.LENGTH_SHORT).show();
            }
        );
    }

}
