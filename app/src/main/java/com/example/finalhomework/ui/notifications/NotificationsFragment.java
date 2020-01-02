package com.example.finalhomework.ui.notifications;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.finalhomework.R;
import com.example.finalhomework.ui.dashboard.MyDataBaseHelper_Movie;
import com.example.finalhomework.ui.dashboard.bean.movie;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class NotificationsFragment extends Fragment {
    TextView gotoMyMovie,BackUp,Restore,myComments,check;
    List<movie> movieList = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        Bmob.initialize(root.getContext(), "2f3ba93bd3be68a95b6572d4b1cf456a");
        MyDataBaseHelper_Movie dbHelper = new MyDataBaseHelper_Movie(root.getContext(), "movie_info.db", null, 1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql3 = "SELECT * FROM movie_info";
        Cursor cursor = db.rawQuery(sql3, null);
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            if (cursor.moveToPosition(i)) {
                String name1 = cursor.getString(0);
                String intro = cursor.getString(1);
                String date = cursor.getString(2);
                double score = cursor.getDouble(3);
                int poster = cursor.getInt(4);

                movie movie = new movie(name1, intro, date, score, poster);
                movieList.add(movie);

            }
        }
        gotoMyMovie = root.findViewById(R.id.myMovies);

        myComments = root.findViewById(R.id.myComments);
        gotoMyMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(root.getContext(),MyMovieListActivity.class);
                startActivity(intent);
            }
        });
        myComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(v.getContext(),MyCommentsListActivity.class);
            startActivity(intent);

            }
        });


        BackUp = root.findViewById(R.id.backUp);
        BackUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < movieList.size(); i++) {
                    movie movie = movieList.get(i);
                    Log.d("backUp", movieList.get(i).getName());
                    movie.save(root.getContext(), new SaveListener() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(root.getContext(), "已备份您的电影清单", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Toast.makeText(root.getContext(), "备份失败", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });



        Restore = root.findViewById(R.id.restore);
        Restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobQuery<movie> query = new BmobQuery<>("movie");
                query.findObjects(v.getContext(), new FindListener<movie>() {
                    @Override
                    public void onSuccess(List<movie> list) {
                        MyDataBaseHelper_Movie dbHelper = new MyDataBaseHelper_Movie(root.getContext(), "movie_info.db", null, 1);
                        SQLiteDatabase db = dbHelper.getReadableDatabase();
                        db.execSQL("DROP TABLE IF EXISTS movie_info");
                        db.execSQL("CREATE TABLE IF NOT EXISTS movie_info" + "("
                                + "m_name VARCHAR, "
                                + "intro VARCHAR, "
                                + "date VARCHAR,"
                                + "score DOUBLE,"
                                + "poster int"
                                + ")");

                        for (int i = 0; i < list.size(); i++) {
                            ContentValues values = new ContentValues();
                            values.put("m_name",list.get(i).getName());
                            values.put("intro",list.get(i).getIntro());
                            values.put("date",list.get(i).getDate());
                            values.put("score",list.get(i).getScore());
                            values.put("poster",list.get(i).getPoster());

                            db.insert("movie_info",null,values);

                        }

                        // Log.e("e_tag",mBinder.getList().get(1).getAllType());
                        Toast.makeText(root.getContext(),"恢复成功",Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onError(int i, String s) {
                        Toast.makeText(root.getContext(),"恢复失败",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        check = root.findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("hoho 你好").setMessage("这是M1A的Android大作业").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                         //确定按钮的点击事件
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    //取消按钮的点击事件
                    }
                }).show();
            }
        });

        return root;
    }
}