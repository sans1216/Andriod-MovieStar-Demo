package com.example.finalhomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalhomework.MainActivity;
import com.example.finalhomework.R;
import com.example.finalhomework.ui.base.BaseAcitivity;

public class LoginActivity extends BaseAcitivity implements TextWatcher,View.OnClickListener {
    private Button Login;
    private EditText edtName_Login;
    private EditText edtPwd_Login;
    private TextView GoToRegister;
    private String userName,userPwd,spPWD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        Login = findViewById(R.id.btn_login);
        edtName_Login = findViewById(R.id.edt_name_login);
        edtPwd_Login = findViewById(R.id.edt_pwd_login);
        GoToRegister = findViewById(R.id.GoToRegister);

        edtName_Login.addTextChangedListener(this);
        edtPwd_Login.addTextChangedListener(this);
        GoToRegister.setOnClickListener(this);
        Login.setOnClickListener(this);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
       userName=edtName_Login.getText().toString().trim();
       userPwd = edtPwd_Login.getText().toString().trim();
        if(userName.length()>0&&userPwd.length()>=6){
            Login.setEnabled(true);
        }else
        { showToast("输入不得为空");}

    }
    private void Login() {
        String md5Psw = MD5pwd.md5(userPwd);
        // md5Psw ; spPsw 为 根据从SharedPreferences中用户名读取密码
        // 定义方法 readPsw为了读取用户名，得到密码
        spPWD = readPsw(userName);

        if (md5Psw.equals(userPwd)) {
            showToast("登陆成功");
            saveLoginStatus(true, userName);
            Intent data=new Intent();
            data.putExtra("isLogin",true);
            setResult(RESULT_OK,data);
            LoginActivity.this.finish();
            startActivity(new Intent(this, MainActivity.class));
        }else if(spPWD!=null&&!md5Psw.equals(userPwd)&&!userPwd.isEmpty()){
            showToast("密码错误");
        }else {
            showToast("此用户不存在");
        }
    }

    private void saveLoginStatus(boolean b, String userName) {
        SharedPreferences sp = getSharedPreferences("loginInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isLogin",b);
        editor.putString("loginUserName",userName);
        editor.commit();
    }

    //从sharedPreference中读取用户名和密码
    private String readPsw(String userName) {
        SharedPreferences sp = getSharedPreferences("loginInfo",MODE_PRIVATE);
        return sp.getString(userName,"");
    }

    private void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_login:
                Login();
                Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.GoToRegister:
                Toast.makeText(this,"返回注册",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,RegisterActivity.class));
                break;
        }
    }
//显示注册号的用户名信息
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(data!=null){
            String userName = data.getStringExtra("userName");
            if(!userName.isEmpty()){
                edtName_Login.setText(userName);
                edtName_Login.setSelection(userName.length());
            }
        }
    }
}
