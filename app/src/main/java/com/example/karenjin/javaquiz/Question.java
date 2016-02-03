package com.example.karenjin.javaquiz;

/**
 * Created by karenjin on 2/3/16.
 */
public class Question {
    private int mTextResID;
    private boolean mAnswer;

    public Question(int testResId, boolean answer) {
        mTextResID = testResId;
        mAnswer = answer;
    }

    public int getTextResID() {
        return mTextResID;
    }

    public void setTextResID(int textResID) {
        mTextResID = textResID;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
