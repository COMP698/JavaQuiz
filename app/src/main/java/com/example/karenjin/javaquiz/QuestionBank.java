package com.example.karenjin.javaquiz;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by karenjin on 2/3/16.
 */
public class QuestionBank {

    private List<Question> mQuestionList = new ArrayList<>();
    private int mCur = -1;

    public QuestionBank() {
        mQuestionList.add(new Question(R.string.java_quiz_question1, true));
        mQuestionList.add(new Question(R.string.java_quiz_question2, false));
        mQuestionList.add(new Question(R.string.java_quiz_question3, true));
        mQuestionList.add(new Question(R.string.java_quiz_question4, false));
    }

    public boolean hasMoreQuetion(){
        return mCur < mQuestionList.size()-1;
    }

    public void generateQuestion(){
       if (hasMoreQuetion())
           mCur++;
    }

    public int questionTextID() {
        return mQuestionList.get(mCur).getTextResID();
    }

    public boolean questionAnswer() {
        return mQuestionList.get(mCur).isAnswer();
    }
}

class Question {
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