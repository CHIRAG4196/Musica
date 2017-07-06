package com.example.chirag.musica;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.chirag.musica.databinding.ActivityMain2Binding;

public class Main2Activity extends AppCompatActivity {

    private ActivityMain2Binding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main2);
    }

}
