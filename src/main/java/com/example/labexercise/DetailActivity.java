package com.example.labexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {


    boolean inWide;
    private DetailFragment fragmentA;
    private MainFragment fragmentB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        inWide = findViewById(R.id.rvList) != null;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        fragmentA = new DetailFragment();
        fragmentB = new MainFragment();

        int position = getIntent().getExtras().getInt(MainActivity.EXTRA_MESSAGE);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("inWide", inWide);
        bundle.putString("message", "Activated in Widescreen");
        fragment.setArguments(bundle);
        transaction.replace(R.id.scrollView, fragmentA);
        transaction.replace(R.id.scrollView2, fragmentB);
        transaction.commit();
    }
}

