package com.example.finalhomework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class MyDataBaseHelper_comment extends SQLiteOpenHelper {
    public static final String CREATE_DB = "CREATE TABLE IF NOT EXISTS comment_info" + "("
            + "username VARCHAR,"
            + "title VARCHAR, "
            + "content VARCHAR, "
            + "score DOUBLE,"
            + "icon int"
            + ")";
    private Context mContext;

    public MyDataBaseHelper_comment(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
        Toast.makeText(mContext, "数据库建立成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS comment_info");
        onCreate(db);
    }

}
