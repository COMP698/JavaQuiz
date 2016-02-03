package com.example.karenjin.javaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    QuestionBank mQuestionBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_textView);

        mQuestionBank = new QuestionBank();
        mQuestionBank.generateQuestion();
        mQuestionTextView.setText(mQuestionBank.questionTextID());

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
                if (mQuestionBank.hasMoreQuetion()) {
                    mQuestionBank.generateQuestion();
                    mQuestionTextView.setText(mQuestionBank.questionTextID());
                } else {
                    mQuestionTextView.setText(R.string.no_more_question);
                    mFalseButton.setEnabled(false);
                    mTrueButton.setEnabled(false);
                    mNextButton.setEnabled(false);
                }
            }
        });
    }

    private void checkAnswer(boolean userPressed) {
        if (userPressed == mQuestionBank.questionAnswer()) {
            Toast.makeText(this, R.string.correct_toast,Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }
    }
}


