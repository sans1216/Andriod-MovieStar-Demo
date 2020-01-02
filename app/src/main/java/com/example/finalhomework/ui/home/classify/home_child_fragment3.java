package com.example.finalhomework.ui.home.classify;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.finalhomework.R;
import com.example.finalhomework.ui.home.MyDataBaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


public class home_child_fragment3 extends Fragment {
    ListView listView;
    List<recommend> recommendList = new ArrayList<>();
    FloatingActionButton write;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_child_fragment3, container, false);
        write = view.findViewById(R.id.fab_write2);

        MyDataBaseHelper dbHelper=new MyDataBaseHelper(view.getContext(),"recommend_info.db",null,1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String sql = "SELECT * FROM recommend_info";
        Cursor cursor = db.rawQuery(sql , null);

        Log.d("mmmm",String.valueOf(cursor.getColumnCount()));
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            if (cursor.moveToPosition(i)) {

                String nickname1 = cursor.getString(0);
                int icon = cursor.getInt(1);
                String tag  = cursor.getString(2);
                String content1 = cursor.getString(3);
//                String img1 = cursor.getString(4);
                String date1 = cursor.getString(5);
                recommend recommend = new recommend(nickname1,icon,tag,content1,null,date1 );
                recommendList.add(recommend);
                Log.e("m_tag",recommend.getContent());
            }
        }



        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_child_fragment3.this.getContext(),write_activity.class);
                startActivity(intent);

            }
        });


        listView = view.findViewById(R.id.myRc);
        if (recommendList.isEmpty()){
            recommend recommend = new recommend("赶快去发新动态吧",0,"","",null,"");
            recommendList.add(recommend);
        }else {
            listView.setAdapter(new ListViewAdapter(view.getContext(), recommendList));
        }
        return view;

    }


}
