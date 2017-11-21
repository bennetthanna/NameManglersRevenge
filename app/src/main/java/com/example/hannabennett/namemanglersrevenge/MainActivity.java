package com.example.hannabennett.namemanglersrevenge;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mFirstNameEditText;
    private Button mMangleNicelyButton;
    private Button mMangleRudelyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstNameEditText = (EditText) findViewById(R.id.name_input);
        mMangleNicelyButton = (Button) findViewById(R.id.mangle_nicely_button);
        mMangleRudelyButton = (Button) findViewById(R.id.mangle_rudely_button);

        mMangleRudelyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = mFirstNameEditText.getText().toString();
                if(inputName.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "enter name", Toast.LENGTH_SHORT);
                } else {
                    FragmentManager fm = getSupportFragmentManager();
                    Fragment fragment = fm.findFragmentById(R.id.fragment_container);

                    if(fragment == null) {
                        fragment = MangledNameFragment.newInstance(inputName, "rudely");
                        fm.beginTransaction()
                                .add(R.id.fragment_container, fragment)
                                .commit();
                    }
                }
            }
        });
    }
}