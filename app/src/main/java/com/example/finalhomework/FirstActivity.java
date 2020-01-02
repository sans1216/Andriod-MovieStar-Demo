package com.example.finalhomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.finalhomework.ui.RegisterActivity;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private View view1,view2,view3;
    private List<View> viewList;
    private ViewPager vg_first;
    private Button btn_GotoMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
        btn_GotoMain.setOnClickListener(this);
    }

    private void initView() {
        vg_first = findViewById(R.id.vp_First);
        LayoutInflater inflater = getLayoutInflater().from(this);
        view1 = inflater.inflate(R.layout.firstpage_1,null);
        view2 = inflater.inflate(R.layout.firstpage_2,null);
        view3 = inflater.inflate(R.layout.firstpage_3,null);

        viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        btn_GotoMain = view3.findViewById(R.id.btn_GotoMain);
        vg_first.setAdapter(new MyViewPagerAdapter(viewList));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_GotoMain:
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
             default:
                 break;
        }
    }
}
