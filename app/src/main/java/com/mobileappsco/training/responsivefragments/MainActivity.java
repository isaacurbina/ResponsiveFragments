package com.mobileappsco.training.responsivefragments;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements FirstFragment.FirstFragmentListener, SecondFragment.SecondFragmentListener {

    FirstFragment firstFragment;
    SecondFragment secondFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            firstFragment = new FirstFragment();
            secondFragment = new SecondFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.first_container, firstFragment, "fragment_first")
                    .commit();
            fragmentManager.beginTransaction()
                    .replace(R.id.second_container, secondFragment, "fragment_second")
                    .commit();
        } else {
            firstFragment = (FirstFragment) fragmentManager.findFragmentByTag("fragment_first");
            secondFragment = (SecondFragment) fragmentManager.findFragmentByTag("fragment_second");
        }
    }

    @Override
    public void onFirstFragmentInteraction(String name, String age) {
        secondFragment.updateUI(name, age, "http://www.blogcdn.com/www.engadget.com/media/2011/03/sonos-rocks.jpg");
    }

    @Override
    public void onSecondFragmentInteraction(Uri uri) {

    }
}
