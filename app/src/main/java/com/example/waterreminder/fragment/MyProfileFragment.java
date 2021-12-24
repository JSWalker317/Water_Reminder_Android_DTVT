package com.example.waterreminder.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.waterreminder.MainActivity;
import com.example.waterreminder.ProfileActivity;
import com.example.waterreminder.R;

public class MyProfileFragment extends Fragment {
    private TextView tv_name, tv_age, tv_heigh, tv_weight;
    private Button btn_edit;
    private MainActivity mainActivity;
    public static final String SAVEPERSONAL = "savePersonal";

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        tv_name = view.findViewById(R.id.tv_name);
        tv_age = view.findViewById(R.id.tv_age);
        tv_heigh = view.findViewById(R.id.tv_heigh);
        tv_weight = view.findViewById(R.id.tv_weight);
        btn_edit = view.findViewById(R.id.btn_edit);
        mainActivity = (MainActivity) getActivity();
//        settext
        tv_name.setText(mainActivity.getName());
        tv_age.setText(mainActivity.getAge());
        tv_heigh.setText(mainActivity.getHeigh());
        tv_weight.setText(mainActivity.getWeight());

        SharedPreferences sharedpreferences;
        sharedpreferences = getActivity().getSharedPreferences(SAVEPERSONAL, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("TAG_NAME", tv_name.getText().toString());
        editor.putString("TAG_AGE", tv_age.getText().toString());
        editor.putString("TAG_HEIGH", tv_heigh.getText().toString());
        editor.putString("TAG_WEIGHT", tv_weight.getText().toString());
        editor.commit();

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ProfileActivity.class));
            }
        });
        return view;
    }
}
