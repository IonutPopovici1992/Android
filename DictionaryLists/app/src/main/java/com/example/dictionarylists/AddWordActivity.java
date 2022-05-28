package com.example.dictionarylists;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        Intent intent = getIntent();
        String text = intent.getStringExtra("initialtext");
        TextView textView = findViewById(R.id.new_word);
        textView.setText(text);
    }

    public void addThisWordClick(View view) {
        // add the given word/defn to dictionary
        EditText editText1 = findViewById(R.id.new_word);
        String newWord = editText1.getText().toString();
        EditText editText2 = findViewById(R.id.new_defn);
        String newDefn = editText2.getText().toString();
    }

}
