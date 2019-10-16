package com.f1reking.flib.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author F1ReKing
 * @date 2019/10/16 13:36
 * @Description
 */
public abstract class BaseLibActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onPreView();
        setContentView(getLayoutId());
        initView();
    }

    abstract void onPreView();

    abstract int getLayoutId();

    abstract void initView();
}
