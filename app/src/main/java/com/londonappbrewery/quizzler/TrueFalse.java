package com.londonappbrewery.quizzler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TrueFalse extends AppCompatActivity {

    private int mQuestionId;
    private boolean mAnswer;

    public TrueFalse(int questionResourceID, boolean trueOrFalse  )
    {
        this.mQuestionId = questionResourceID;
        this.mAnswer= trueOrFalse;
    }

    public boolean ismAnswer() {
        return mAnswer;
    }

    public int getmQuestionId() {
        return mQuestionId;
    }

    public void setmAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }

    public void setmQuestionId(int mQuestionId) {
        this.mQuestionId = mQuestionId;
    }
}
