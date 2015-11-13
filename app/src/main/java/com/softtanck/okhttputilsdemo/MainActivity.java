package com.softtanck.okhttputilsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.callback.ResultCallback;
import com.zhy.http.okhttp.request.OkHttpRequest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        new OkHttpRequest.Builder()
                .url("http://www.baidu.com")
                .get(new MyResultCallBack());
    }


    private class MyResultCallBack extends ResultCallback<String> {

        @Override
        public void onError(Request request, Exception e) {
        }

        @Override
        public void onResponse(String response) {
            Log.d("Tanck", response);
        }
    }
}
