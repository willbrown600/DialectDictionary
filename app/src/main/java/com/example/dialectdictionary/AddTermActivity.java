package com.example.dialectdictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddTermActivity extends AppCompatActivity {
    DictionaryPresenter p = new DictionaryPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_term);
    }

    public void Submit(View view) {
        Intent intent = new Intent(this, PersonalDictionaryActivity.class);
        EditText definition = findViewById(R.id.definition);
        String message = definition.getText().toString();
        EditText term = findViewById(R.id.term);
        String message2 = term.getText().toString();
        p.submit(message, message2);
        startActivity(intent);

        ?
        /*EditText cityText = (EditText)findViewById(R.id.editText);
            String city = cityText.getText().toString(); */
    }
}
