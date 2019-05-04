package com.example.jmy.toy_me_message;

public class ContentBean {
    private boolean zanFocus, shoucanFocus;
    private int zanNum, shoucanNum;
    int data1;
    public boolean isShoucanFocus() {
        return shoucanFocus;
    }
    public void setShoucanFocus(boolean shoucanFocus) {
        this.shoucanFocus = shoucanFocus;
    }
    public int getShoucanNum() {
        return shoucanNum;
    }
    public void setShoucanNum(int shoucanNum) {
        this.shoucanNum = shoucanNum;
    }
    public boolean isZanFocus() {
        return zanFocus;
    }
    public void setZanFocus(boolean zanFocus) {

        this.zanFocus = zanFocus;

    }
    public int getZanNum() {

        return zanNum;

    }
    public void setZanNum(int zanNum) {

        this.zanNum = zanNum;

    }
}
