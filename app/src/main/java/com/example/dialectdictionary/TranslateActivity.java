package com.example.dialectdictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



public class TranslateActivity extends AppCompatActivity implements Adapter.View {

        //boolean getEnglishDef = true;
        String wordToBeConverted = "";
        //Create word through textView7
        //EditText word = findViewById(R.id.textView7);
        private Adapter.Presenter presenter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_translate);
            //EditText word = findViewById(R.id.textView7);
            //Instantiate presenter as new MainPresenter constructor passing
            //in a view parameter referring to the view itself and
            // the context variable referring to the which page we are talking about.
            presenter = new TranslatePresenter(this, getApplicationContext());



        }

        public void onSubmitButtonClicked(View view) {
            EditText word = findViewById(R.id.textView7);
            wordToBeConverted = word.getText().toString();
            //Use presenter variable to access getTranslationWords function through MainPresenter.
            presenter.getTranslationWords(wordToBeConverted);

            //new DownloadURLTaskDef(this).execute(wordToBeConverted, getEnglishDef);

        }

        @Override
        public  void goToNextPage(Word s){
            Intent i = new Intent(this, Translation.class);
            //Add the string word to the value "wordToBeConverted"
            i.putExtra("word", wordToBeConverted);
            i.putExtra("new_word", s);
            startActivity(i);
        }
}
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
    }

    public void StartMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }*/

