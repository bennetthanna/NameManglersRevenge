package com.example.hannabennett.namemanglersrevenge;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hannabennett.namemanglersrevenge.databinding.FragmentMangledNameBinding;

import java.util.Random;

/**
 * Created by HannaBennett on 11/20/17.
 */

public class MangledNameFragment extends Fragment {
    private static final String ARG_INPUT_NAME = "input_name";
    private static final String ARG_FRIENDLINESS = "friendliness";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String TAG = "MangledNameFragment";

    private String mInputName;
    private String mFriendliness;
    private TextView mMangledNameText;
    private Button mResetButton;
    private Button mRemangleButton;
    private String mRandomLastName;

    public static MangledNameFragment newInstance(String inputName, String friendliness) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_INPUT_NAME, inputName);
        args.putSerializable(ARG_FRIENDLINESS, friendliness);

        MangledNameFragment fragment = new MangledNameFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInputName = (String) getArguments().getSerializable(ARG_INPUT_NAME);
        mFriendliness = (String) getArguments().getSerializable(ARG_FRIENDLINESS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentMangledNameBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_mangled_name, container, false);
//        View v = inflater.inflate(R.layout.fragment_mangled_name, container, false);
//
//        mMangledNameText = (TextView) v.findViewById(R.id.mangled_name);
//        mResetButton = (Button) v.findViewById(R.id.reset_button);
//        mRemangleButton = (Button) v.findViewById(R.id.remangle_button);
//
        if (savedInstanceState != null) {
            mRandomLastName = savedInstanceState.getString(KEY_LAST_NAME);
        } else {
            mRandomLastName = getRandomWord();
        }
        MangledName mangledName = new MangledName(mInputName, mRandomLastName);
        binding.setViewModel(new MangledNameViewModel(mangledName));
        binding.executePendingBindings();
        return binding.getRoot();
//
//        mResetButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                getActivity().finish();
//            }
//        });
//
//        mRemangleButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                mMangledNameText.setText(getMangledName(mInputName, getRandomWord()));
//            }
//        });
//        return v;
    }

    private String getMangledName(String firstName, String lastName) {
        MangledName mangledName = new MangledName(firstName, lastName);
        return mangledName.getMangledName();
    }

    private String getRandomWord() {
        Resources res = getResources();
        String[] randomWords;
        if (mFriendliness.equals("nicely")) {
            randomWords = res.getStringArray(R.array.random_nice_word_array);
        } else {
            randomWords = res.getStringArray(R.array.random_rude_word_array);
        }
        int randomIndex = new Random().nextInt(randomWords.length);
        mRandomLastName = randomWords[randomIndex];
        return mRandomLastName;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_LAST_NAME, mRandomLastName);
    }
}
