package com.example.bailaco;

public class ClassCo {
    private int anh;
    private  String text1;
    private String text2;

    public ClassCo(int anh, String text1, String text2) {
        this.anh = anh;
        this.text1 = text1;
        this.text2 = text2;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}
