package com.cay.ziyourenapp.Activity;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.cay.ziyourenapp.R;


/**
 * 登录界面
 *
 * @author Administrator
 */
public class LoginActivity extends Activity {

    private Button btnLogin;
    private EditText et_name;
    private EditText et_password;
    private CheckBox cb_ischeck;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 不显示标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 引入布局界面
        setContentView(R.layout.activity_login);

        initView();//初始化控件
        initSp();//进行密码本地提取和初始化SP
        initLogin();//进行登录逻辑判断
    }


    /**
     * 初始化SP和密码本地提取
     */
    private void initSp() {
        //初始化sp
        // 使用sharPerferences去保存数据
        //name 会自动生成一个XML文件  mode 自己选择模式
        sp = getSharedPreferences("password", 0);
        //把SharedPreferences数据调出来
        String name = sp.getString("name", "");
        String pwd = sp.getString("pwd", "");
        //把name和pwd显示到 edittext
        et_name.setText(name);
        et_password.setText(pwd);
        boolean result = sp.getBoolean("ischecked", false);
        if (result) {
            cb_ischeck.setChecked(true);

        }
    }

    /**
     * 进行登录逻辑判断
     */
    private void initLogin() {
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // 获取用户名和密码
                String name = et_name.getText().toString().trim();
                String pwd = et_password.getText().toString().trim();
                // 判断账户和密码是否为空调
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
                    Toast.makeText(LoginActivity.this, "账号或密码不能为空", Toast.LENGTH_LONG).show();
                } else {

                    if ("1911".equals(name) && "123".equals(pwd)) {
                        if (cb_ischeck.isChecked()) {
                            // 获取SP的编辑器
                            Editor edit = sp.edit();
                            edit.putString("name", name);
                            edit.putString("pwd", pwd);
                            //存储checkbpox的状态
                            edit.putBoolean("ischecked", true);
                            // 记得edit的提交
                            edit.commit();

                        } else {
                            Editor edit = sp.edit();
                            edit.putString("name", "");
                            edit.putString("pwd", "");
                            //存储checkbpox的状态
                            edit.putBoolean("ischecked", false);
                            // 记得edit的提交
                            edit.commit();


                        }
                        // activity的跳转
                        Intent intent = new Intent(LoginActivity.this,
                                MainActivity1.class);
                        startActivity(intent);
                        // 结束本activity
                        finish();

                    } else {
                        Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_LONG)
                                .show();
                    }
                }

            }
        });
    }

    /**
     * 初始化控件
     */
    private void initView() {
        btnLogin = (Button) findViewById(R.id.btn_Login);
        et_name = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_userpassword);
        cb_ischeck = (CheckBox) findViewById(R.id.cb_login_ischeck);
    }


}
