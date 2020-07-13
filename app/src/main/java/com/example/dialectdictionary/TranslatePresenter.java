package com.example.dialectdictionary;

import android.content.Context;

import java.util.concurrent.ExecutionException;

public class TranslatePresenter implements Adapter.Presenter {

        private Adapter.View view;
        private Context context;
        boolean convertEnglishToSpanish = true;



        public TranslatePresenter(Adapter.View view, Context context) {
            this.view = view;
            this.context = context;
        }

        @Override
        public void getTranslationWords(String wordToBeConverted) {
            try {
                Word result =  new DownloadURLTask(context).execute(wordToBeConverted, convertEnglishToSpanish).get();
                view.goToNextPage(result);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

}
