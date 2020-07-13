package com.example.dialectdictionary;

public interface Adapter {

    interface View{

        void goToNextPage(Word result);
    }

    interface Presenter{

        void getTranslationWords(String wordToBeConverted);
    }
}
