package com.example.finalhomework.ui.home;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.finalhomework.R;

public class MyDataBaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_DB = "CREATE TABLE IF NOT EXISTS recommend_info" + "("
            + "nickname VARCHAR, "
            + "icon int, "
            + "tag VARCHAR,"
            + "content VARCHAR,"
            + "img VARCHAR,"
            + "date VARVHAR"
            + ")";
    private Context mContext;

    public MyDataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
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
        db.execSQL("DROP TABLE IF EXISTS recommend_info");
        onCreate(db);
    }
}