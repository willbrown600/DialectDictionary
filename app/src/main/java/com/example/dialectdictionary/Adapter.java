package com.example.dialectdictionary;

public interface Adapter {
    //So I got this from Stack Overflow as a way to access other classes through an
    //interface wrapped inside another interface, which I though was pretty cool.
    interface View{

        void goToNextPage(Word result);
    }

    interface Presenter{

        void getTranslationWords(String wordToBeConverted);
    }
}
