package com.example.jmy.toy_me_message;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

public class User  {
    //第一种布局的字段
    private String item1_str;
    //第二种布局的字段
    private String item2_str;
    //第三种布局的字段
    private String item3_str;
    private String item4_str;
    private int avatarId;
    private int productDrawbleId;


    //导入contentbean内容
    private boolean zanFocus, shoucanFocus;
    private int zanNum, shoucanNum;
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
    //导入完毕

    public User(String item1_str, String item2_str, String item3_str , String item4_str,int
            item5_str,int item6_str) {
        this.item1_str = item1_str;
        this.item2_str = item2_str;
        this.item3_str = item3_str;
        this.item4_str = item4_str;
        this.avatarId = item5_str;
        this.productDrawbleId= item6_str;
    }

    public String getItem1_str() {
        return item1_str;
    }

    public String getItem2_str() {
        return item2_str;
    }

    public String getItem3_str() {
        return item3_str;
    }

    public String getItem4_str() {
        return item4_str;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public int getProductDrawbleId() {
        return productDrawbleId;
    }

    public void setItem1_str(String item1_str) {
        this.item1_str = item1_str;
    }

    public void setItem2_str(String item2_str) {
        this.item2_str = item2_str;
    }

    public void setItem3_str(String item3_str) {
        this.item3_str = item3_str;
    }

    public void setItem4_str(String item4_str) {
        this.item4_str = item4_str;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public void setProductDrawbleId(int item6_str) {
        this.productDrawbleId = item6_str;
    }

    @Override
    public String toString() {
        return "User{" +
                "item1_str='" + item1_str + '\'' +
                ",item2_str='" + item1_str + '\'' +
                ", item3_str='" + item2_str + '\'' +
                ", item4_str='" + item3_str + '\'' +
                '}';
    }
}