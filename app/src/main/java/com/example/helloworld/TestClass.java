package com.example.helloworld;

public class TestClass {
    private String stringF;
    private int intF;

    public String getStringF() {
        return stringF;
    }

    public void setStringF(String stringF) {
        this.stringF = stringF;
    }

    public int getIntF() {
        return intF;
    }

    public void setIntF(int intF) {
        this.intF = intF;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TestClass{");
        sb.append("stringF='").append(stringF).append('\'');
        sb.append(", intF=").append(intF);
        sb.append('}');
        return sb.toString();
    }
}
