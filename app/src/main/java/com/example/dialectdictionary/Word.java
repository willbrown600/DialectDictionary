package com.example.dialectdictionary;

import java.io.Serializable;


public class Word implements Serializable {

        private String translatedWord;
        private String definitionWord;

        public String getTranslatedWord() {
            return translatedWord;
        }

        public void setTranslatedWord(String translatedWord) {
            this.translatedWord = translatedWord;
        }

        public String getDefinitionWord() {
            return definitionWord;
        }

        public void setDefinitionWord(String definitionWord) {
            this.definitionWord = definitionWord;
        }

}
