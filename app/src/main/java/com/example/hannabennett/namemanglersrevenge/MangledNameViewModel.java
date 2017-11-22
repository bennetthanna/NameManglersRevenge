package com.example.hannabennett.namemanglersrevenge;

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
}
