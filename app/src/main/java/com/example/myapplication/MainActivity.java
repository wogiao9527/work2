package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Fragment fragment1, fragment2, fragment3, fragment4;
    FragmentManager fm;
    LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        fragment1 = new Fragment1();
        fragment2 = new Wechat2Fragment();
        fragment3 = new Wechat3Fragment();
        fragment4 = new Wechat2Fragment();

        fm = getSupportFragmentManager();

        linearLayout1 = findViewById(R.id.LinearLayout1);
        linearLayout2 = findViewById(R.id.LinearLayout2);
        linearLayout3 = findViewById(R.id.LinearLayout3);
        linearLayout4 = findViewById(R.id.LinearLayout4);

        // 初始化: 将所有的fragment添加到main中
        inital();
        // 隐藏所有fragment
        fragmenthide();
        // 默认显示第一个fragment
        fragmentshow(fragment1);
        // 设置监听器
        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
    }


    // 隐藏所有fragment
    private void fragmenthide() {
        FragmentTransaction ft = fm.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4);
        ft.commit();
    }

    // 初始化: 将所有的fragment添加到main中
    public void inital() {

        FragmentTransaction ft = fm.beginTransaction()
                .add(R.id.id_content, fragment1)
                .add(R.id.id_content, fragment2)
                .add(R.id.id_content, fragment3)
                .add(R.id.id_content, fragment4);
        ft.commit();

    }


    // 默认显示第一个fragment1
    private void fragmentshow(Fragment fragment) {
        FragmentTransaction transaction = fm.beginTransaction()
                .show(fragment);
        transaction.commit();
    }

    //  点击事件
    @Override
    public void onClick(View view) {
        fragmenthide();
        if (view == linearLayout1) {
            fragmentshow(fragment1);
        } else if (view == linearLayout2) {
            fragmentshow(fragment2);
        } else if (view == linearLayout3) {
            fragmentshow(fragment3);
        } else if (view == linearLayout4) {
            fragmentshow(fragment4);
        }
    }
}