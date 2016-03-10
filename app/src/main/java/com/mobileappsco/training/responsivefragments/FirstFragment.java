package com.mobileappsco.training.responsivefragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class FirstFragment extends Fragment implements View.OnClickListener {

    EditText etName;
    EditText etAge;
    Button btnGo;

    private FirstFragmentListener mListener;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
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
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        etName = (EditText) v.findViewById(R.id.et_name);
        etAge = (EditText) v.findViewById(R.id.et_age);
        btnGo = (Button) v.findViewById(R.id.btn_go);
        btnGo.setOnClickListener(this);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FirstFragmentListener) {
            mListener = (FirstFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FirstFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        mListener.onFirstFragmentInteraction(etName.getText().toString(), etAge.getText().toString());
    }

    public interface FirstFragmentListener {
        void onFirstFragmentInteraction(String name, String age);
    }
}
