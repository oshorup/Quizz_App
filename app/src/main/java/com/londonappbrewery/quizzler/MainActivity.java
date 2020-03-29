package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends Activity {




    // TODO: Declare member variables here:
       Button mTrueButton;
       Button mFalseButton;
       TextView mText;
       TextView mScoreTextView;
       ProgressBar mProgressBar;
       int mIndex=0; // index value for getting the item of mQuestionBank array
       int mScore = 0; // for incrementing the score

    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    // TODO: Declare constants here
      final int PROGRESS_BAR_INCREMENT = (int)Math.ceil(100.0/ mQuestionBank.length);
      // above constant defines by what amount progress bar will increment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mText =  findViewById(R.id.question_text_view);
        mProgressBar = findViewById(R.id.progress_bar);
        mScoreTextView=findViewById(R.id.score);

        // now setting of question printing text to respective question
        mText.setText(mQuestionBank[mIndex].getmQuestionId());


        // applying onClickListener() for true button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            newQuestionMovement();
            checkAnswer(true);

            }
        });

        // applying onClickListener() for false button
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newQuestionMovement();
                checkAnswer(false);
            }
        });

    }

    public void newQuestionMovement()
    {
        //incrementing mIndex
        mIndex = (mIndex+1)%mQuestionBank.length;  // % operator is used just for avoiding indexOutOfBondException
        if(mIndex==0)
        {
             new AlertDialog.Builder(this).setTitle("Game over").setCancelable(false)
                     .setMessage("You score "+ mScore+ " points out of "+mQuestionBank.length+ " points")
                     .setPositiveButton("Close app", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                           finish(); // for closing app after game is over
                         }
                     })
                     .show();
        }

        mText.setText(mQuestionBank[mIndex].getmQuestionId());
        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
    }

    public void checkAnswer(boolean answer)
    {
        boolean correctAnswer = mQuestionBank[mIndex].ismAnswer();
        if(correctAnswer==answer)
        {
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
            mScore = mScore+1;
            mScoreTextView.setText("score"+ mScore+"/"+mQuestionBank.length); // for updating score
        }
        else {
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }
    }



}

