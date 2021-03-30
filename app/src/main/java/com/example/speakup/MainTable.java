package com.example.speakup;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "MainTable")
public class MainTable extends Model {

    public MainTable() {
        super();
    }

    @Column(name = "AlphabetWord")
    public String alphaWord;

    @Column(name = "AlphabetSentence")
    public String alphaSentence;

    @Column(name = "AlphabetIcon")
    public String alphaIcon;

    public void insertRecordsAlphabets(String alphaWord, String alphaSentence, String alphaIcon) {
        MainTable mainTable = new Select()
                .from(MainTable.class)
                .where("AlphabetWord = ?", alphaWord)
                .executeSingle();

        if (mainTable == null) {
            mainTable = new MainTable();
        }

        mainTable.alphaWord = alphaWord;
        mainTable.alphaSentence = alphaSentence;
        mainTable.alphaIcon = alphaIcon;
        mainTable.save();
    }

    public List<MainTable> getAlphaRecords() {
        return new Select()
                .from(MainTable.class)
                .execute();
    }

    public String getAlphaWord() {
        return alphaWord;
    }

    public void setAlphaWord(String alphaWord) {
        this.alphaWord = alphaWord;
    }

    public String getAlphaSentence() {
        return alphaSentence;
    }

    public void setAlphaSentence(String alphaSentence) {
        this.alphaSentence = alphaSentence;
    }

    public String getAlphaIcon() {
        return alphaIcon;
    }

    public void setAlphaIcon(String alphaIcon) {
        this.alphaIcon = alphaIcon;
    }
}
