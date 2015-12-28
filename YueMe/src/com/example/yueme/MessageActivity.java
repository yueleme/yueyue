package com.example.yueme;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class MessageActivity extends AppCompatActivity {

	private Toolbar toolbar;
	private ListView lv_message;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		findview();
		setToolbar();
	}
	
	public static void actionStart(Context context) {
    	Intent intent = new Intent(context,MessageActivity.class);
    	context.startActivity(intent);
    }
	
	public void findview(){
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		lv_message = (ListView) findViewById(R.id.lv_message);
	}

	private void setToolbar() {
    	//设置Toolbar标题
    	toolbar.setTitle("我的消息");
    	//设置标题颜色
        toolbar.setTitleTextColor(Color.parseColor("#000000")); 
        //设置默认标题栏为toolbar
        setSupportActionBar(toolbar);
        //设置返回键可用
        getSupportActionBar().setHomeButtonEnabled(true); 
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //设置返回键事件
        toolbar.setNavigationOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				finish();			
				MainActivity.actionStart(MessageActivity.this);
				}
			
        	
        });
    }
}
