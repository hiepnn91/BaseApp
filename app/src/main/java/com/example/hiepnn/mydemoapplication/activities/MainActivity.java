package com.example.hiepnn.mydemoapplication.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.hiepnn.mydemoapplication.R;
import com.example.hiepnn.mydemoapplication.fragments.FirstFragment;
import com.example.hiepnn.mydemoapplication.fragments.SecondFragment;
import com.example.hiepnn.mydemoapplication.utils.FragmentUtil;

public class MainActivity extends AppCompatActivity {
    public Toolbar toolbar;
    public FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FragmentUtil.pushFragment(MainActivity.this, new FirstFragment(), null);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentUtil.pushFragment(MainActivity.this, new SecondFragment(), null);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
