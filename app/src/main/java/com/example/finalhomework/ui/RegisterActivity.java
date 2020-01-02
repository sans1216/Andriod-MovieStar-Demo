package com.example.finalhomework.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.PointerIcon;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalhomework.R;
import com.example.finalhomework.ui.base.BaseAcitivity;

public class RegisterActivity extends BaseAcitivity implements TextWatcher, View.OnClickListener {
    private ImageView icon;
    private EditText edtName;
    private EditText edtEmail;
    private EditText edtPwd;
    private  Button btnRegister;
    private TextView GoToLogin;
    private String name;
    private String email;
    private String pwd;
    private Uri uri;
    private PointerIcon icon2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }

    private void initView() {
        icon = findViewById(R.id.icon_register);
        edtName = findViewById(R.id.et_name);
        edtEmail = findViewById(R.id.et_Email);
        edtPwd = findViewById(R.id.et_pwd);
        btnRegister = findViewById(R.id.btn_Register);
        GoToLogin = findViewById(R.id.GoToLogin);

        edtName.addTextChangedListener(this);
        edtEmail.addTextChangedListener(this);
        edtPwd.addTextChangedListener(this);
        GoToLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        icon.setOnClickListener(this);
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
                        icon.setImageURI(uri);
                    }
                }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        name=edtName.getText().toString().trim();
        email = edtEmail.getText().toString().trim();
        pwd = edtPwd.getText().toString().trim();
        icon2 = icon.getPointerIcon();
        if(name.length()>0&&email.length()>0&&pwd.length()>=6){
            btnRegister.setEnabled(true);
        }else if(isExistUserName(name)) {
            showToast("该用户名已经被占用");
        }else if(isExistUserEmail(email)){
            showToast("该邮箱已经被占用");
        }else{
            btnRegister.setEnabled(false);
            showToast("输入不得为空");
        }
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.GoToLogin:
                showToast("前往登陆");
                startActivity(new Intent(this,LoginActivity.class));
                break;
            case R.id.btn_Register:
                saveRegisterInfo(name,email,pwd,icon2);
                showToast("注册成功");
                //TODO 调用注册接口
                break;
            case  R.id.icon_register:
                showToast("选择头像");
                selectPhoto();
                break;
             default:
                 break;
        }
    }


    private void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
    private boolean isExistUserName(String userName){
        boolean has_userName=false;
        //mode_private SharedPreferences sp = getSharedPreferences( );
        // "loginInfo", MODE_PRIVATE
        SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
        //获取密码
        String spPsw=sp.getString(userName, "");//传入用户名获取密码
        //如果密码不为空则确实保存过这个用户名
        if(!TextUtils.isEmpty(spPsw)) {
            has_userName=true;
        }
        return has_userName;
    }
    private boolean isExistUserEmail(String email) {
        boolean has_userName=false;
        //mode_private SharedPreferences sp = getSharedPreferences( );
        // "loginInfo", MODE_PRIVATE
        SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
        //获取密码
        String spPsw=sp.getString(email, "");//传入用户名获取密码
        //如果密码不为空则确实保存过这个用户名
        if(!TextUtils.isEmpty(spPsw)) {
            has_userName=true;
        }
        return has_userName;
    }
    //保存用户数据到sharedPreference中
    private void saveRegisterInfo(String userName, String psw, String email, PointerIcon icon2){
        String md5Psw = MD5pwd.md5(psw);//把密码用MD5加密
        //loginInfo表示文件名, mode_private SharedPreferences sp = getSharedPreferences( );
        SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
        //获取编辑器， SharedPreferences.Editor  editor -> sp.edit();
        SharedPreferences.Editor editor=sp.edit();
        //以用户名为key，密码为value保存在SharedPreferences中
        //key,value,如键值对，editor.putString(用户名，密码）;
        editor.putString(userName, md5Psw);
        editor.putString(email,userName);
        editor.putString(userName+"email",email);
        editor.putString(userName+"icon", String.valueOf(icon2));
        //提交修改 editor.commit();
        editor.commit();
    }

}
