package com.bridgelabz.progressbar;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button button;
    ProgressDialog mProgressBar;

    Handler progressBarHandler = new Handler();


    private int progressBarStatus = 0;
    private long fileSize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButtonClick();
    }

    public void addListenerOnButtonClick() {
        Button btnStartProgress = (Button) findViewById(R.id.button);
        btnStartProgress.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // creating progress bar dialog
                mProgressBar = new ProgressDialog(v.getContext());
                mProgressBar.setCancelable(true);
                mProgressBar.setMessage("File downloading ...");
                mProgressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressBar.setProgress(0);
                mProgressBar.setMax(100);
                mProgressBar.show();
                //reset progress bar and filesize status
                progressBarStatus = 0;

                new Thread(new Runnable() {
                    public void run() {
                        while (progressBarStatus < 100) {
                            // performing operation
                            progressBarStatus = doOperation();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            // Updating the progress bar
                            progressBarHandler.post(new Runnable() {
                                public void run() {
                                    mProgressBar.setProgress(progressBarStatus);
                                }
                            });
                        }
                        // performing operation if file is downloaded,
                        if (progressBarStatus >= 100) {
                            // sleeping for 1 second after operation completed
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            // close the progress bar dialog
                            mProgressBar.dismiss();
                        }
                    }
                }).start();
            }//end of onClick method
        });
    }

    // checking how much file is downloaded and updating the filesize
    public int doOperation() {
        //The range of ProgressDialog starts from 0 to 10000
        while (fileSize <= 100000) {
            fileSize++;
            if (fileSize == 10000) {
                Log.i(TAG, "doOperation: inside 10000");
                return 10;
            } else if (fileSize == 20000) {
                Log.i(TAG, "doOperation: inside 20000");
                return 20;
            } else if (fileSize == 30000) {
                Log.i(TAG, "doOperation: inside 30000");
                return 30;
            } else if (fileSize == 50000) {
                Log.i(TAG, "doOperation: inside 50000");
                return 50;

            } else if (fileSize == 60000){
                Log.i(TAG, "doOperation: inside 60000");
                return 60;
            } else if (fileSize == 70000){
                Log.i(TAG, "doOperation: inside 70000");
                return 70;
            }

               else { //you can add more else if
                return 100;
            }
        }//end of while
        return 100;
    }//end of doOperation


}