package com.example.course_work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Word {
    private static int counter = 0;
    private int id;
    private String name;
    private int languageId;

    public Map<Integer, Word> translations = new HashMap<>();

    public Word(String name, int languageId) {
        id = ++counter;
        this.languageId = languageId;
        this.name = name;
    }

    public void addTranstalion(Integer languageId, Word transtation){
        translations.put(languageId, transtation);
        Word tmpWord = new Word(this.getName(), this.getLanguageId());
        transtation.translations.put(this.getLanguageId(), this);
        DictionaryData.getInstance().addWord(transtation, languageId);
    }

    public Word getTranslationFromLanguage(Integer languageId){

        if(translations.containsKey(languageId)) {
            return translations.get(languageId);
        } else{
            Word error = new Word("error", 404);
            return error;
        }
    }

    public Set<Integer> getTranslationLanguages(){
        return translations.keySet();
    }

    public int getId() {
        return id;
    }

    public String getLanguage(int idToFind){return DictionaryData.getInstance().getLanguageById(idToFind).getName();}

    public String getName() {
        return name;
    }

    public Map<Integer, Word> getTranslations() {
        return translations;
    }

    public int getLanguageId() {
        return languageId;
    }
}
