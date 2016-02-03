package com.example.karenjin.javaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private int mCurIndex = 0;

    private List<Question> mQuestionBank= new ArrayList<Question>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_textView);

        mQuestionBank.add(new Question(R.string.java_quiz_question1, true));
        mQuestionBank.add(new Question(R.string.java_quiz_question2, false));
        mQuestionBank.add(new Question(R.string.java_quiz_question3, true));
        mQuestionBank.add(new Question(R.string.java_quiz_question4, false));

        mQuestionTextView.setText(mQuestionBank.get(mCurIndex).getTextResID());

        // now using anonymous class
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });


        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurIndex == mQuestionBank.size()-1)
                    mCurIndex = 0;
                else
                    mCurIndex = mCurIndex+1;

                mQuestionTextView.setText(mQuestionBank.get(mCurIndex).getTextResID());
            }
        });

    }
    private void checkAnswer(boolean userPressed) {
        if (userPressed == mQuestionBank.get(mCurIndex).isAnswer()) {
            Toast.makeText(this, R.string.correct_toast,Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }
    }






}


