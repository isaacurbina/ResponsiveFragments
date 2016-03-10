package com.mobileappsco.training.responsivefragments;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;


public class SecondFragment extends Fragment {

    private SecondFragmentListener mListener;
    ImageView imageView;
    TextView textView;
    private String name, age, url;

    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);
        textView = (TextView) v.findViewById(R.id.textView);
        imageView = (ImageView) v.findViewById(R.id.imageView);
        if (savedInstanceState != null
                && savedInstanceState.getString("name")!= null
                && savedInstanceState.getString("age") != null
                && savedInstanceState.getString("url")!= null) {
            textView.setText("Receiving "+savedInstanceState.getString("name")+
                    " ("+savedInstanceState.getString("age")+"years old)");
            Glide.with(getContext())
                    .load(savedInstanceState.getString("url"))
                    .into(imageView);
        } else {
            Glide.with(getContext())
                    .load("http://www.veryicon.com/icon/ico/System/Icons8%20Metro%20Style/Emoticons%20Sleeping.ico")
                    .into(imageView);
        }
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onSecondFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SecondFragmentListener) {
            mListener = (SecondFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement SecondFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void updateUI(String name, String age, String url) {
        this.name = name;
        this.age = age;
        this.url = url;
        Glide.with(this)
                .load(url)
                .into(imageView);
        textView.setText("Receiving "+name+" ("+age+"years old)");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", name);
        outState.putString("age", age);
        outState.putString("url", url);
    }

    public interface SecondFragmentListener {
        void onSecondFragmentInteraction(Uri uri);
    }
}
