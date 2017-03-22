package com.example.zf.retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zf.retrofit.Api.ApiUtils;
import com.example.zf.retrofit.pojo.User;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    private EditText et_paaword;
    private EditText et_username;
    private Button btn_login;
    private String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_paaword = (EditText) findViewById(R.id.et_password);
        et_username = (EditText) findViewById(R.id.et_username);
        btn_login = (Button) findViewById(R.id.btn_login);
        onClick();

    }
    private void onClick(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = et_username.getText().toString();
                password = et_paaword.getText().toString();
                final Map<String,String> maps = new HashMap<String,String>();
                Log.i("map",username+"||||111");
                maps.put("username",username);
                maps.put("password",password);

                Log.i("map",maps.toString());
                login(maps);
            }
        });
    }
    public void login(Map<String,String> maps){
        ApiUtils.getApiService().login(maps)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                    }

                    @Override
                    public void onCompleted() {
                        Log.i("onCompleted","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("onError","onError"+e.toString());
                    }

                    @Override
                    public void onNext(User user) {
                        Log.i("onNext","onNext"+user.toString());
                        success();
                    }
                });
    }
    private void success(){
        Intent i =new Intent(MainActivity.this,Main2Activity.class);
        startActivity(i);
    }
}
