package com.example.hannabennett.namemanglersrevenge;

import android.content.Intent;
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

        final String emptyNameText = getResources().getString(R.string.empty_edit_text_toast);

        mMangleRudelyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = mFirstNameEditText.getText().toString();
                if(inputName.isEmpty()) {
                    Toast.makeText(getApplicationContext(), emptyNameText, Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = MangledNameActivity.newIntent(getApplicationContext(), inputName, "rudely");
                    startActivity(intent);
                }
            }
        });

        mMangleNicelyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = mFirstNameEditText.getText().toString();
                if(inputName.isEmpty()) {
                    Toast.makeText(getApplicationContext(), emptyNameText, Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = MangledNameActivity.newIntent(getApplicationContext(), inputName, "nicely");
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        resetEditText();
    }

    private void resetEditText() {
        EditText nameInput = (EditText) findViewById(R.id.name_input);
        nameInput.setText("");
    }
}