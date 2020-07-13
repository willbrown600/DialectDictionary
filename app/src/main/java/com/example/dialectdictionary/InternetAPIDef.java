package com.example.dialectdictionary;

import org.json.JSONArray;

public class InternetAPIDef {

    //Use same code for definition dictionary.
    //Although believe maybe using a HashMap is better than using array to access individual index.
    //My key to Merriam-Webster's Dictionary Definition API
    final String myTKey = "d66eefd1-2e4c-4661-8658-a273d7eb9c98";

    public String getEnglishDef(String word) {
        //Merriam-Webster's Thesaurus URL.
        final String Url = "https://www.dictionaryapi.com/api/v3/references/thesaurus/json/" + word + "?key=" + myTKey;

        //Object httpHelper to access httpHelper functions.
        HTTPHelper httpHelper = new HTTPHelper();

        String result = httpHelper.readHTTP(Url);
        System.out.println(result);

        try {
            JSONArray array = new JSONArray(result);

            String def = array.getJSONObject(0).getJSONArray("shortdef").getString(0);
            System.out.println(def);
            return def;

        } catch (Throwable t) {
            return "Definition not available";
        }
    }

}
