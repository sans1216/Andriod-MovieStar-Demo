package com.example.finalhomework.ui.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.finalhomework.R;
import com.example.finalhomework.ui.home.MyDataBaseHelper;
import com.example.finalhomework.ui.home.classify.ListViewAdapter;
import com.example.finalhomework.ui.home.classify.recommend;

import java.util.ArrayList;
import java.util.List;

public class MyCommentsListActivity extends AppCompatActivity {

    ListView listView;
    List<recommend> recommendList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_comments_list);
        listView = findViewById(R.id.my_rcList);
        MyDataBaseHelper dbHelper=new MyDataBaseHelper(this,"recommend_info.db",null,1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();



        String sql = "SELECT * FROM recommend_info WHERE nickname = 'Sans'";
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


        listView.setAdapter(new ListViewAdapter(this,recommendList));
    }
}
