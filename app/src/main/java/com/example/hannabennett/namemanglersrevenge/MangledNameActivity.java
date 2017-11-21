package com.example.hannabennett.namemanglersrevenge;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by HannaBennett on 11/21/17.
 */

public class MangledNameActivity extends AppCompatActivity {
    public static final String EXTRA_INPUT_NAME = "com.example.hannabennett.namemanglersrevenge.input_name";
    public static final String EXTRA_FRIENDLINESS = "com.example.hannabennett.namemanglersrevenge.friendliness";

    public static Intent newIntent(Context packageContext, String inputName, String friendliness) {
        Intent intent = new Intent(packageContext, MangledNameActivity.class);
        intent.putExtra(EXTRA_INPUT_NAME, inputName);
        intent.putExtra(EXTRA_FRIENDLINESS, friendliness);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangled_name);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            String inputName = (String) getIntent().getSerializableExtra(EXTRA_INPUT_NAME);
            String friendliness = (String) getIntent().getSerializableExtra(EXTRA_FRIENDLINESS);
            fragment = MangledNameFragment.newInstance(inputName, friendliness);
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

        if (getIntent().getSerializableExtra(EXTRA_FRIENDLINESS).equals("rudely")) {
            ImageView niceHeaderImage = (ImageView) findViewById(R.id.header_nice_image);
            niceHeaderImage.setVisibility(View.GONE);
        } else {
            ImageView rudeFooterImage = (ImageView) findViewById(R.id.footer_rude_image);
            rudeFooterImage.setVisibility(View.GONE);
        }

    }
}
