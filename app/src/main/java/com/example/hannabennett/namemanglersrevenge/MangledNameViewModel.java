package com.example.hannabennett.namemanglersrevenge;

import android.app.Activity;

/**
 * Created by HannaBennett on 11/21/17.
 */

public class MangledNameViewModel {
    private MangledName mMangledName;

    public MangledNameViewModel(MangledName mangledName) {
        mMangledName = mangledName;
    }

    public String getMangledName() {
        return mMangledName.getMangledName();
    }

//    public void resetButtonClicked() {
//        Activity activity = (Activity)getContext();
//        activity.finish();
//    }

//    public void remangleButtonClicked() {
//        mMangledName = new MangledName(inputName, randomLastName);
//    }
}
