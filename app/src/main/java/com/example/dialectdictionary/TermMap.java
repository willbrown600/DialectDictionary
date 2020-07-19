package com.example.dialectdictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TermMap extends HashMap {


    /*Maybe some of this code needs to go into the Dictionary Presenter Java, we can take a look
    at moving that over if you guys think that would be better
     */


    int KEY = 0;
    //save Key into a separate file in Json, and every time the map is created, open that file to get the refreshed key value

    //Map that stores values with Keys that are the first Letter in the term
    static Map<String, Object> alphabeticMap = new HashMap<>();

    //Map that stores values with Keys that are the index in order received
    static Map<Integer, Object> numericMap = new HashMap<>();

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

    public static void sortByNumericKey(){

        //Create an Array list that contains the keys
        ArrayList<Integer> sortedKeys = new ArrayList<Integer>(numericMap.keySet());

        //Sort the Array list Alphabetically
        Collections.sort(sortedKeys);

        /* Display the TreeMap which is naturally sorted
        for (String x : sortedKeys)
            System.out.println("Key = " + x +
                    ", Value = " + numericMap.get(x));*/
    }

    public void addTerm(String letter, Object term){

        //Upon receiving the Object, save the term with appropriate Key into Maps
        KEY += 1;
        numericMap.put(KEY, term);
        alphabeticMap.put(letter, term);
    }



}
