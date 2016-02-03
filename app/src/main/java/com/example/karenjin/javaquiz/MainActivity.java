package com.example.karenjin.javaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);

        class MyListener implements View.OnClickListener{
            @Override
            public void onClick(View v) {
                Log.d("test log", "button pressed" );
            }
        }

        MyListener theListener = new MyListener();
        mTrueButton.setOnClickListener(theListener);
        mFalseButton.setOnClickListener(theListener);

    }



}
