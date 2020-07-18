package com.example.dialectdictionary;

import android.content.Context;

import java.io.IOException;

public class DictionaryPresenter {

    Context context;

    //Instantiate Map
    TermMap map = new TermMap();

    void submit(final String term, final String definition) {
        //Start a new Thread to not slow the UI
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    //Calls the Add Item Function
                    addItem(term, definition);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    void addItem(String term, String definition) throws IOException {
        //Get the First Initial from the Term
        char firstInitial = term.charAt(0);

        //Convert the First Initial to a String
        String key = Character.toString(firstInitial);

        //Create a new Vocab Term Object
        VocabTerm newTerm = new VocabTerm(term, definition);

        //Send the Alphabetical Key and Term Object to be saved to Map
        map.addTerm(key, newTerm);
    }

    //There needs to be a Display Map function in Personal Dictionary Activity to display the map

    //Create Map structure with oncreate of main activity (pull from file on device)

    //Populate text field (?) with the map on personal dictionary activity

    //On closing app, save Map to file (maybe save with every iteration of submit?)

    //Starts a New Thread to Load Words
    private void loadDictionary() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    loadWords();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    //Load words reads a file and loads into a Map
    private void loadWords() throws IOException {
        /* Some code to read the Json in the file, and to parse it into Java Objects
        and save them to the map
        try {

        } finally {

        }*/
    }

}





