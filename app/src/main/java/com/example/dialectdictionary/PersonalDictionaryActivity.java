package com.example.dialectdictionary;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PersonalDictionaryActivity extends AppCompatActivity {
    DictionaryPresenter d = new DictionaryPresenter();
    ArrayList<VocabTerm> terms = new ArrayList<VocabTerm>();
    ArrayList<String> alphabeticKeys;
    ArrayAdapter adapter2;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_dictionary);
        terms = d.getArray();
        alphabeticKeys = d.getAlphabeticMapKeys();
        ListView pListView = (ListView) findViewById(R.id.listView);
        TermListAdapater adapter = new TermListAdapater(this, R.layout.adapter_view_layout, terms);
        EditText theFilter = (EditText) findViewById(R.id.searchFilter);
        pListView.setAdapter(adapter);
        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (PersonalDictionaryActivity.this).adapter2.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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

    public void alphabeticSort(View view) {
        terms= d.sortAlphabetically();
    }
    public void numericSort(View view) {
        terms= d.sortNumerically();
    }




    /*public void displayTerm(View view) {

    }*/

    /* We need a display map Function that will receive the map from the Dictionary Presenter
    and display to listview and will display oncreate of this activity */




}
