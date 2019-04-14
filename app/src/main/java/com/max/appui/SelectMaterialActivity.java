package com.max.appui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SelectMaterialActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnStart;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_material);


        btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                Intent intent = new Intent(this, RecordVoiceActivity.class);
                Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(this, btnStart, "btn_record").toBundle();
                startActivity(intent, bundle);

                break;
        }
    }
}
