package com.example.dialectdictionary;

import android.content.Context;
import android.os.AsyncTask;

public class DownloadURLTask extends AsyncTask<Object, String, Word> {

        private Context context;
        //word object to contain the URL data
        private String wordToBeConverted = "";
        //Empty string for data to be placed into.

        //Constructor
        public DownloadURLTask(Context context) {
            this.context = context;
        }
        //Need to use multi-threading to achieve program result.
        //Use of doInBackground function as part of AsyncTask thread.
        @Override
        protected Word doInBackground(Object... voids) {
            wordToBeConverted = (String) voids[0];
            //boolean convertEnglishToSpanish = (boolean) voids[0];
            //Create InternetApi object to provide access to convertingEnglishToSpanish function.
            InternetAPI i = new InternetAPI();
            //Create new i2 for definition.
            InternetAPIDef i2 = new InternetAPIDef();
            //must return a string.

            String translatedWord = i.convertEnglishToSpanish(wordToBeConverted);
            String definition = i2.getEnglishDef(wordToBeConverted);

            /*if(translatedWord){
                return i2.convertEnglishToSpanish(wordToBeConverted);
            }
            else
            {return i.convertSpanishToEnglish(wordToBeConverted);}}*/

            Word word = new Word();
            word.setTranslatedWord(translatedWord);
            word.setDefinitionWord(definition);

            return word;

        }


}


