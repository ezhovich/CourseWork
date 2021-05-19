package com.example.course_work;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DictionaryData {
    private static DictionaryData instance;
    private static Set<Language> languages = new HashSet<>();



    private DictionaryData() {
    }


    public static DictionaryData getInstance() {
        if (instance == null) {
            instance = new DictionaryData();
            Language ukrainian = new Language("Ukrainian");
            Language english = new Language("English");
            Word w = new Word("Країна", ukrainian.getId());
            Word w1 = new Word("Country", english.getId());

            w.addTranstalion(english.getId(), w1);
            ukrainian.addWord(w);
            english.addWord(w1);

            languages.add(ukrainian);
            languages.add(english);


        }
        return instance;
    }

    public Set<Language> getLanguages() {
        return languages;
    }



    public String translateWord(String word, int fromLanguageId, int toLanguageId){
        Word res = new Word("No translation", 404);
        for(Word w: getLanguageById(fromLanguageId).getWords()){
            if (word.equals(w.getName())){
                res = w.getTranslationFromLanguage(toLanguageId);
            }
        }
        return res.getName();
    }


    public void addLanguage(Language languageToAdd) {
        for (Language lan : languages) {
            if (lan.getName().equals(languageToAdd.getName())) {
                return;
            }
        }
        languages.add(languageToAdd);
    }

    public void addWord(String wordToAdd, int languageId) {
        for (Language lan : languages) {
            if (lan.getId() == languageId) {
                getLanguageById(languageId).addWord(wordToAdd, languageId);
            }
        }
    }

    public void addWord(Word wordToAdd, int languageId) {
        for (Language lan : languages) {
            if (lan.getId() == languageId) {
                getLanguageById(languageId).addWord(wordToAdd);
            }
        }
    }

    public boolean hasLanguage(String languageName){
        for (Language lan: languages) {
            if (lan.getName().equals(languageName)){
                return true;
            }
        }
        return false;
    }

    public void deleteLanguage(Language lan){
        languages.remove(lan);
    }

    public Language getLanguageById(int id) {
        for (Language lan : languages) {
            if (lan.getId() == id) {
                return lan;
            }
        }
        return null;
    }

    public ArrayList<Word> getWordsByLanguageId(int lanId){
        for (Language l: languages) {
            if (l.getId() == lanId){
                return l.getWords();
            }
        }
        return null;
    }

    public boolean hasWord(int lanid, String word){
        ArrayList<Word> words = getWordsByLanguageId(lanid);
        for (Word w: words) {
            if (w.getName().equals(word)){
                return true;
            }
        }
        return false;
    }

    public void deleteWord(Language lanToDel, int wordToDel) {
        lanToDel.deleteWord(wordToDel);
    }

    public void addTranslation(int lanId, int wordId, int transLanId, String translation){
        for (Word w:
             getWordsByLanguageId(lanId)){
                if (w.getId() == wordId){
                    Word t = new Word(translation, transLanId);
                    w.addTranstalion(transLanId, t);
            }

        }
    }
}
