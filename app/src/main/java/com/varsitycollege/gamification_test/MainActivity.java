package com.varsitycollege.gamification_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private ProgressBar mProgressBar;
    private TextView mLoadingText;
    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) (findViewById(R.id.progressbar));
        mLoadingText = (TextView) (findViewById(R.id.ProgressbarCompleted));

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(mProgressStatus < 100){
                mProgressStatus++;
                android.os.SystemClock.sleep(50);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                      mProgressBar.setProgress(mProgressStatus);
                    }
                });

                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                    mLoadingText.setVisibility(View.VISIBLE);
                    }
                });
            }
        }) .start();



    }
}