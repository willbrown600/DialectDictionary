package com.example.dialectdictionary;

import org.json.JSONArray;

public class InternetAPI {
    //My key to Merriam-Webster's Dictionary API
    final String myKey = "7df01050-d79d-4ccd-b9cf-a8d8f179f27b";

    public String convertEnglishToSpanish(String word) {
        //Merriam-Webster's Dictionary URL.
        final String Url = "https://www.dictionaryapi.com/api/v3/references/spanish/json/" + word + "?key=" + myKey;


        HTTPHelper httpHelper = new HTTPHelper();
        String result = httpHelper.readHTTP(Url);
        System.out.println(result);

        try {
            JSONArray array = new JSONArray(result);

            String word1 = array.getJSONObject(0).getJSONArray("shortdef").getString(0);
            System.out.println(word1);
            return word1;

        } catch (Throwable t) {
            return "Word not available";
        }
    }

    /*public String convertSpanishToEnglish(String word){
        final String Url = "https://www.dictionaryapi.com/api/v3/references/english/json/" + word + "?key=" + myKey;


        HTTPHelper httpHelper = new HTTPHelper();
        String result = httpHelper.readHTTP(Url);
        System.out.println(result);

        try {
            JSONArray array = new JSONArray(result);

            String word1 = array.getJSONObject(0).getJSONArray("shortdef").getString(0);
            System.out.println(word1);
            return word1;

        } catch (Throwable t) {
            return "Word not available";
        }
    }*/


}

