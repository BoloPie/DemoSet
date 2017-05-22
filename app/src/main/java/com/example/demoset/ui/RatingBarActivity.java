package com.example.demoset.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;

import com.example.demoset.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RatingBarActivity extends AppCompatActivity {

    @Bind(R.id.activity_rating_bar_rb)
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        ButterKnife.bind(this);

        ratingBar.setRating(2.5f);


    }
}
