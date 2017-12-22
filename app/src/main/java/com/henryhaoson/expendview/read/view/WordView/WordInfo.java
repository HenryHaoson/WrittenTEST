package com.henryhaoson.expendview.read.view.WordView;

/**
 * Created by zhuhao on 17/7/2017.
 */

public class WordInfo {
    private String word;
    private float start;
    private float end;

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public float getStart() {
        return start;
    }

    public void setStart(float start) {
        this.start = start;
    }

    public void setEnd(float end) {
        this.end = end;
    }

    public float getEnd() {
        return end;
    }
}