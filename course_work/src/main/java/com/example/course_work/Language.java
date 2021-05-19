package com.example.course_work;

import java.util.ArrayList;

public class Language {
    private static int counter = 0;
    private int id;
    private String name;
    private ArrayList<Word> words = new ArrayList<>();

    public Language(String name) {
        id = ++counter;
        this.name = name;
    }

    public void addWord(String strWord, int languageId){
        Word word = new Word(strWord, languageId);
        words.add(word);
    }

    public void deleteWord(int wordId){
        this.words.removeIf(w -> w.getId() == wordId);
    }

    public void addWord(Word word){
        words.add(word);
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
