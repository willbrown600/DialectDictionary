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

    public void StartPersonalDictionary(View view) {
        Intent intent = new Intent(this, PersonalDictionaryActivity.class);
        startActivity(intent);
    }

    public void StartTranslate(View view) {
        Intent intent = new Intent(this, TranslateActivity.class);
        startActivity(intent);
    }
}
