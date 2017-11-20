package com.example.hannabennett.namemanglersrevenge;

/**
 * Created by HannaBennett on 11/20/17.
 */

public class MangledName {
    private String mFirstName;
    private String mLastName;

    public MangledName(String firstName, String lastName) {
        mFirstName = firstName;
        mLastName = lastName;
    }

    public String getMangledName() {
        return mFirstName + " " + mLastName;
    }
}
