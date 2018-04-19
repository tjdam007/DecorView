package com.dev4solutions.decorview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created By: Manoj Singh Rawal
 * Email : manoj.rawal@svam.com
 * Project : DecorView
 * Copyright (c) 2018 North Shore Technologies Pvt. Ltd.
 * on 4/17/18.
 */
public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle bundle = getIntent().getExtras();
        LaminateData laminateData = (LaminateData) bundle.getSerializable(MainActivity.DATA);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(laminateData.details);
    }
}
