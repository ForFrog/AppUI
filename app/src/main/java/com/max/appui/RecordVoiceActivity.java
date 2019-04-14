package com.max.appui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RecordVoiceActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnRecord;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_record_voice);


        btnRecord = (Button) findViewById(R.id.btn_record);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:


                break;
        }
    }


}



