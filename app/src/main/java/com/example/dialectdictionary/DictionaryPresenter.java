package com.example.dialectdictionary;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DictionaryPresenter {

    Context context;

    //save Key into a separate file in Json, and every time the map is created, open that file to get the refreshed key value
    int KEY = 0;

    //Map that stores values with Keys that are the first Letter in the term
    static Map<String, Object> alphabeticMap = new HashMap<>();

    //Map that stores values with Keys that are the index in order received
    static Map<Integer, Object> numericMap = new HashMap<>();

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
        String letter = Character.toString(firstInitial);

        //Create a new Vocab Term Object
        VocabTerm newTerm = new VocabTerm(term, definition);

        //Send the Alphabetical Key and Term Object to be saved to Map
        KEY += 1;
        numericMap.put(KEY, newTerm);
        alphabeticMap.put(letter, newTerm);
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

    public ArrayList<VocabTerm> sortAlphabetically() {
        ArrayList<String> keys = sortByAlphabeticKey();
        Object term = null;
        ArrayList<VocabTerm> terms = null;
        for (String x : keys) {
            term = alphabeticMap.get(x);
            terms.add((VocabTerm) term);
        }
        return terms;
    }

    public ArrayList<VocabTerm> sortNumerically() {
        ArrayList<Integer> keys = sortByNumericKey();
        ArrayList<VocabTerm> terms = null;
        Object term = null;
        for (Integer x : keys) {
            term = numericMap.get(x);
            terms.add((VocabTerm) term);
        }
        return terms;
    }

    public static ArrayList<String> sortByAlphabeticKey(){

        //Create an Array list that contains the keys
        ArrayList<String> alphabetizedKeys = new ArrayList<String>(alphabeticMap.keySet());

        //Sort the Array list Alphabetically
        Collections.sort(alphabetizedKeys);

        return alphabetizedKeys;

        /* Display the TreeMap which is naturally sorted
        for (String x : sortedKeys)
            System.out.println("Key = " + x +
                    ", Value = " + alphebeticMap.get(x));*/
    }

    public static ArrayList<Integer> sortByNumericKey(){

        //Create an Array list that contains the keys
        ArrayList<Integer> sortedKeys = new ArrayList<Integer>(numericMap.keySet());

        //Sort the Array list Alphabetically
        Collections.sort(sortedKeys);

        return sortedKeys;

        /* Display the TreeMap which is naturally sorted
        for (String x : sortedKeys)
            System.out.println("Key = " + x +
                    ", Value = " + numericMap.get(x));*/
    }

}





