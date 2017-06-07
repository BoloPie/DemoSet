package com.example.demoset.ui.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demoset.R;
import com.example.demoset.util.TelNumMatch;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @Bind(R.id.activity_register_tel_et)
    EditText telET;
    @Bind(R.id.activity_register_msg_et)
    EditText msgET;
    @Bind(R.id.activity_register_password_et)
    EditText passwordET;

    @Bind(R.id.activity_register_send_msg_btn)
    Button sendBtn;

    CountDownTimer mTimer;
    private int TIME = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);


        mTimer = new CountDownTimer(60000,1000) {

            @Override
            public void onTick(long l) {
                sendBtn.setEnabled(false);
                sendBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_corner_solid_gray));
                sendBtn.setClickable(false);
                double time =  l/1000;
                int timeInt = (int)time;
                sendBtn.setText(""+timeInt);
                Log.e("CountDown",l+""+ timeInt);
            }

            @Override
            public void onFinish() {
                sendBtn.setEnabled(true);
                sendBtn.setClickable(true);
                sendBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_corner_solid_teal));
                sendBtn.setText("获取验证码");
            }
        };
    }


    @OnClick(R.id.activity_register_send_msg_btn)
    void sendMsg(){
        mTimer.start();
    }

    @OnClick(R.id.activity_register_sign_up_button)
    void register(){

        if (telET.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
        }else if (msgET.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
        }else if (passwordET.getText().toString().trim().isEmpty() ){
            Toast.makeText(this, "请设置登陆密码", Toast.LENGTH_SHORT).show();
        }else if (passwordET.getText().toString().trim().length()<6){
            Toast.makeText(this, "密码不得少于6位数", Toast.LENGTH_SHORT).show();
        }else if (TelNumMatch.isExistPhoneNumber(telET.getText().toString().trim())){
            Toast.makeText(this, "请输入正确手机号", Toast.LENGTH_SHORT).show();
        }else{
            SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=preferences.edit();
            editor.putString("username", telET.getText().toString().trim());
            editor.putString("password", passwordET.getText().toString().trim());
            editor.commit();

            finish();
        }



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTimer != null) {
            mTimer.cancel();
        }
    }
}
