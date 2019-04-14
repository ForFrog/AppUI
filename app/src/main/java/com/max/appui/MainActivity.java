package com.max.appui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LoginF.OnLoginFragmentListener, ConfigInfoF.OnConfigInfoFragmentListener {

    private LoginF loginFragment;
    private ConfigInfoF configInfoF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = new Bundle();
        loginFragment = LoginF.newInstance(bundle);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fl_content, loginFragment);
        ft.show(loginFragment);
        ft.commit();
    }

    @Override
    public void toConfigInfo() {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Bundle b = new Bundle();
        b.putString("name", "张三");
        b.putString("sex", "男");
        configInfoF = ConfigInfoF.newInstance(b);
        ft.replace(R.id.fl_content, configInfoF);

        ft.commit();
    }

    @Override
    public void onPositiveClick() {
        Intent intent = new Intent(this,SelectMaterialActivity.class);

        startActivity(intent);

        finish();
    }

    @Override
    public void onNegativeClick() {

    }
}
