package com.example.finalhomework.ui.home.classify;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalhomework.MainActivity;
import com.example.finalhomework.R;
import com.example.finalhomework.ui.home.MyDataBaseHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class write_activity extends AppCompatActivity implements View.OnClickListener {
    Button send;

    ImageButton close;
    private MyDataBaseHelper dbHelper;
    EditText content,tag;
    TextView nickname;
    ImageView icon,img,showimg;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend_write_activity);
        initView();
    }

    private void initView() {
        send = findViewById(R.id.btn_send);
        close = findViewById(R.id.btn_close);
        nickname = findViewById(R.id.rc_nickname);
        content =  findViewById(R.id.content);
        tag = findViewById(R.id.tag);
        icon = findViewById(R.id.rc_icon);

        img = findViewById(R.id.rc_img);
        send.setOnClickListener(this);
        close.setOnClickListener(this);
        showimg = findViewById(R.id.showImg);
        showimg.setDrawingCacheEnabled(true);
        showimg.setOnClickListener(this);
        close = findViewById(R.id.btn_close);
        close.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.showImg:
                selectPhoto();
                break;
            case R.id.btn_close:
                write_activity.this.finish();
                break;
            case R.id.btn_send:
                sendText();
                Intent i = new Intent();
                i.setClass(write_activity.this,MainActivity.class);
                i.putExtra("id",1);
                startActivity(i);
                break;
        }
    }

    private void sendText() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(System.currentTimeMillis());
        String date1 = simpleDateFormat.format(date);
        dbHelper=new MyDataBaseHelper(this,"recommend_info.db",null,1);
        SQLiteDatabase DB = dbHelper.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put("nickname","Sans");
        values.put("icon",R.drawable.icon);
        if (uri==null){
            values.put("img","");
        }else {
            values.put("img", uri.toString());
        }
        values.put("tag",tag.getText().toString());
        values.put("content",content.getText().toString());
        values.put("date",date1);
        DB.insert("recommend_info",null,values);


        Toast.makeText(this,"已保存数据",Toast.LENGTH_SHORT).show();
        Log.d("sjk",values.get("content").toString());

    }
    private void selectPhoto(){
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");
        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");
        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});
        startActivityForResult(chooserIntent, 100);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(requestCode==100){
            if (resultCode==RESULT_OK){
                uri=data.getData();
                showimg.setImageURI(uri);

            }
        }
    }
}

