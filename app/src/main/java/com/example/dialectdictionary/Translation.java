package com.example.dialectdictionary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Translation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translation);

        //Create intents to link MainActivity to TranslationActivity.
        String wordToBeConverted = getIntent().getStringExtra("word");

        Word w = (Word) getIntent().getSerializableExtra("new_word");

        // String translatedWord = getIntent().getStringExtra("new_word");
        //String definition = getIntent().getStringExtra("def_word");

        TextView SmallView = findViewById(R.id.textView);
        SmallView.setText(wordToBeConverted);

        TextView LargeView = findViewById(R.id.textView4);
        LargeView.setText(w.getTranslatedWord());

        TextView DefinitionView = findViewById(R.id.textView5);
        DefinitionView.setText(w.getDefinitionWord());


    }

    public void StartMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
