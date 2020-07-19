package com.example.dialectdictionary;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.renderscript.ScriptGroup;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.GenericLifecycleObserver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DictionaryPresenter {

    Context context;

    /*Get Path Directory to Files
    //Get Path to Key.txt and save to keyPath
    Class classname = getClass();
    URL resource = classname.getResource("key.txt");
    File f = new File(context.getFilesDir(), "key.txt");

    URL keyUrl = getClass().getClassLoader().getResource("key.txt");
    File keyPath = new File(String.valueOf(keyUrl));

    //Get Path to alphabeticMap.txt and save to alphabeticMapPath
    URL alphabeticMapUrl = getClass().getResource("/app/resources/alphabetic_map.txt");
    File alphabeticMapPath = new File(String.valueOf(alphabeticMapUrl));

    //Get Path to numericMap.txt and save to numericMapPath
    URL numericMapUrl = getClass().getResource("/app/resources/numeric_map.txt");
    File numericMapPath = new File(String.valueOf(numericMapUrl));*/
    //Map that stores values with Keys that are the first Letter in the term
    static Map<String, VocabTerm> alphabeticMap = new HashMap<>();
    //Map that stores values with Keys that are the index in order received
    static Map<Integer, VocabTerm> numericMap = new HashMap<>();
    int KEY = alphabeticMap.size();

    //Create Header in ArrayList
    VocabTerm header = new VocabTerm("Term", "Definition");
    ArrayList<VocabTerm> terms = new ArrayList<VocabTerm>(Arrays.asList(header));
    //ArrayList<VocabTerm> terms = new ArrayList<VocabTerm>();
    //@RequiresApi(api = Build.VERSION_CODES.O)
    public ArrayList<VocabTerm> getArray() {
        /*//initialize map
        Map<Integer, VocabTerm> map;
        //Set Map equal to numeric Map*/
        //numericMap = loadNumericMap();
        //Create an Array list that contains the keys
        ArrayList<Integer> numericKeys = new ArrayList<Integer>(numericMap.keySet());
        /*if (numericKeys.size() > 0){
            KEY = numericKeys.get(numericKeys.size()-1);
        } else {
            KEY = 0;
        }*/
        Object term = null;
        for (Integer x : numericKeys) {
            term = numericMap.get(x);
            terms.add((VocabTerm) term);
        }
        return terms;
    }
    /*void submit(final String term, final String definition) {
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
    }*/
    void submit(String term, String definition) throws IOException {
        /*//Get the First Initial from the Term
        char firstInitial = term.charAt(0);

        //Convert the First Initial to a String
        String letter = Character.toString(firstInitial);*/

        String wordKey = term;

        //Create a new Vocab Term Object
        VocabTerm newTerm = new VocabTerm(term, definition);

        //Send the Alphabetical Key and Term Object to be saved to Map
        KEY = incrementKey(KEY);
        numericMap.put(KEY, newTerm);
        alphabeticMap.put(wordKey, newTerm);
        //saveMap(alphabeticMap, numericMap, KEY);
    }
    //There needs to be a Display Map function in Personal Dictionary Activity to display the map

    //Create Map structure with oncreate of main activity (pull from file on device)

    //Populate text field (?) with the map on personal dictionary activity

    //On closing app, save Map to file (maybe save with every iteration of submit?)
    /*//Starts a New Thread to Load Words
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
    }*/
    //Load words reads a file and loads into a Map
    /*(private Map<Integer, VocabTerm> loadNumericMap() throws IOException {
        File numericFile = numericMapPath.getAbsoluteFile();
        int length = (int) numericFile.length();
        byte[] bytes = new byte[length];
        InputStream input = getClass().getResourceAsStream("numeric_map.txt");
        try {
            input.read(bytes);
        } finally {
            input.close();
        }
        String contents = new String(bytes);
        if (contents == "") {
            VocabTerm header = new VocabTerm("Term", "Definition");
            numericMap.put(KEY, header);
            return numericMap;
        } else {
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<Integer, VocabTerm>>(){}.getType();
            numericMap = gson.fromJson(contents, type);
            return numericMap;
        }
    }*/
    /*private Map<String, VocabTerm> loadAlphabeticMap() throws IOException {
        File alphabeticFile = alphabeticMapPath.getAbsoluteFile();
        int length = (int) alphabeticFile.length();
        byte[] bytes = new byte[length];
        InputStream input = getClass().getResourceAsStream("/app/resources/alphabetic_map.txt");
        try {
            input.read(bytes);
        } finally {
            input.close();
        }
        String contents = new String(bytes);
        if (contents == "") {
            VocabTerm header = new VocabTerm("Term", "Definition");
            alphabeticMap.put(header.term, header);
            return alphabeticMap;
        } else {
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<Integer, VocabTerm>>(){}.getType();
            alphabeticMap = gson.fromJson(contents, type);
            return alphabeticMap;
        }
    }*/
    /*@RequiresApi(api = Build.VERSION_CODES.O)
    private int loadKey() throws IOException {
        File file = keyPath.getAbsoluteFile();
        int length = (int) file.length();
        byte[] bytes = new byte[length];
        InputStream input = getClass().getResourceAsStream("key.txt");
        try {
            input.read(bytes);
        } finally {
            input.close();
        }
        String contents = new String(bytes);
        if (contents == "") {
            contents = "0";
        }
        int key = Integer.parseInt(contents);
        return key;
    }*/
    public ArrayList<VocabTerm> sortAlphabetically() {
        ArrayList<String> keys = sortByAlphabeticKey();
        Object term = null;
        ArrayList<VocabTerm> sortedTerms = new ArrayList<VocabTerm>();
        for (String x : keys) {
            term = alphabeticMap.get(x);
            sortedTerms.add((VocabTerm) term);
        }
        return sortedTerms;
    }
    public static ArrayList<String> sortByAlphabeticKey(){
        //Create an Array list that contains the keys
        ArrayList<String> alphabetizedKeys = new ArrayList<String>(alphabeticMap.keySet());
        //Sort the Array list Alphabetically
        Collections.sort(alphabetizedKeys);
        return alphabetizedKeys;
    }
    public ArrayList<VocabTerm> sortNumerically() {
        ArrayList<Integer> keys = sortByNumericKey();
        ArrayList<VocabTerm> sortedTerms = new ArrayList<VocabTerm>();
        Object term = null;
        for (Integer x : keys) {
            term = numericMap.get(x);
            sortedTerms.add((VocabTerm) term);
        }
        return sortedTerms;
    }
    public static ArrayList<Integer> sortByNumericKey(){
        //Create an Array list that contains the keys
        ArrayList<Integer> sortedKeys = new ArrayList<Integer>(numericMap.keySet());
        //Sort the Array list Alphabetically
        Collections.sort(sortedKeys);
        return sortedKeys;
    }
    /*public void saveMap(Map<String, VocabTerm> alphabeticMap, Map<Integer, VocabTerm> numericMap, int KEY) throws IOException {
        // Convert the Maps to JSON strings.
        Gson gson = new Gson();
        Type gsonType = new TypeToken<HashMap>(){}.getType();
        String alphabeticMapGsonString = gson.toJson(alphabeticMap,gsonType);
        String numericMapGsonString = gson.toJson(numericMap,gsonType);
        String stringKey = Integer.toString(KEY);
        writeToAlphabeticMap(alphabeticMapGsonString);
        writeToNumericMap(numericMapGsonString);
        writeToKeyFile(stringKey);
    }*/
    /*private void writeToNumericMap(String data) throws IOException {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("numericMap.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        //Create File Object
        File file = numericMapPath.getAbsoluteFile();
        //Write String to File
        FileOutputStream stream = new FileOutputStream(file);
        try {
            stream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stream.close();
        }
    }*/
    /*private void writeToAlphabeticMap(String data) throws IOException {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("alphabeticMap.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        //Create File Object
        File file = alphabeticMapPath.getAbsoluteFile();

        //Write String to File
        FileOutputStream stream = new FileOutputStream(file);
        try {
            stream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stream.close();
        }
    }*/
    /*private void writeToKeyFile(String data) throws IOException {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("key.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        //Create File Object
        File file = keyPath.getAbsoluteFile();
        //Write String to File
        FileOutputStream stream = new FileOutputStream(file);
        try {
            stream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stream.close();
        }
    }*/

    int incrementKey(int key){
        key++;
        return key;
    }

    ArrayList<String> getAlphabeticMapKeys(){
        ArrayList<String> alphabeticMapKeys = new ArrayList<String>(alphabeticMap.keySet());
        return alphabeticMapKeys;
    }

}





