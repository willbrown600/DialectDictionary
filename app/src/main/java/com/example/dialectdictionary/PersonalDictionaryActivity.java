package com.example.dialectdictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PersonalDictionaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_dictionary);

    }

    //Upon Clicking Home Button, start Main Activity
    public void StartMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Upon clicking the Plus Button, start the Add Term Activity
    public void AddNewTerm(View view) {
        Intent intent = new Intent(this, AddTermActivity.class);
        startActivity(intent);
    }

    /* We need a display map Function that will receive the map from the Dictionary Presenter
    and display to listview and will display oncreate of this activity */
}
