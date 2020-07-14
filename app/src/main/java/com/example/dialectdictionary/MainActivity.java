package com.example.dialectdictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Upon clicking the Personal Dictionary Button, start Personal Dictionary Activity
    public void StartPersonalDictionary(View view) {
        Intent intent = new Intent(this, PersonalDictionaryActivity.class);
        startActivity(intent);
    }

    //Upon clicking the Translate button, start Translate Activity
    public void StartTranslate(View view) {
        Intent intent = new Intent(this, TranslateActivity.class);
        startActivity(intent);
    }
}
