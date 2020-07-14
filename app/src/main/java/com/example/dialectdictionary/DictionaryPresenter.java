package com.example.dialectdictionary;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

import static android.util.Log.*;

public class DictionaryPresenter {

    Context context;

    void submit(String term, String definition) {

        VocabTerm newTerm = new VocabTerm(term, definition);


        //Send newTerm to Map (datastructure) with Key

        //Sort - map of different keys to a single value. Pull array of keys based on how you want to sort, use .sort() on the array
        //order the elements of the map based on the order of the array (how?)

        //Create Map structure with oncreate of main activity (pull from file on device)

        //Populate text field (?) with the map on personal dictionary activity

        //On closing app, save Map to file (maybe save with every iteration of submit?)




    }
}





