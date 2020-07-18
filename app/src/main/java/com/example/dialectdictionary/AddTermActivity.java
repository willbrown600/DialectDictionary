package com.example.dialectdictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

public class AddTermActivity extends AppCompatActivity {
    //Creates an Instance of the Dictionary Presenter Class
    DictionaryPresenter p = new DictionaryPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_term);
    }

    public void Submit(View view) throws IOException {
        //When Submit is clicked, start the Personal Dictionary Activity
        Intent intent = new Intent(this, PersonalDictionaryActivity.class);

        //Get Term from Text Input, save as string
        EditText term = findViewById(R.id.term);
        String message = term.getText().toString();

        //Get the definition from Definition Input, Save as a String
        EditText definition = findViewById(R.id.definition);
        String message2 = definition.getText().toString();

        //Submit Term and Definition to Dictionary Presenter
        p.submit(message, message2);

        //Start Personal Dictionary Activity
        startActivity(intent);


    }
}
