package com.example.yueme;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity{
	
	private Toolbar toolbar;
    private EditText edtUser ;
    private EditText edtPassword ;
    private TextView tvSubmit;
	
     @Override
     protected void onCreate(Bundle savedInstanceState){
    	 super.onCreate(savedInstanceState);
    	 setContentView(R.layout.activity_login);
    	 initView();
    	 initToolbar();
     }
     
     private void  initView(){
    	 toolbar = (Toolbar) findViewById(R.id.main_toolbar);
    	 edtUser = (EditText) findViewById(R.id.edt_user);
    	 edtPassword = (EditText) findViewById(R.id.edt_password);
    	 tvSubmit = (TextView) findViewById(R.id.sp_category);
     }
     
     private void initToolbar(){
    	//设置Toolbar标题
	    	toolbar.setTitle("登录");
	    	//设置标题颜色
	        toolbar.setTitleTextColor(Color.parseColor("#000000")); 
	        //设置默认标题栏为toolbar
	        setSupportActionBar(toolbar);
	        //设置返回键可用
	        getSupportActionBar().setHomeButtonEnabled(true); 
	        getSupportActionBar().setDisplayHomeAsUpEnabled(true);    	
	        
	        toolbar.setNavigationOnClickListener(new OnClickListener(){
	        	@Override
	        	public void onClick(View v){
	        		finish();
	        	}
	        });
     }
     
    @Override
 	public boolean onCreateOptionsMenu(Menu menu) {
 		// Inflate the menu; this adds items to the action bar if it is present.
 		getMenuInflater().inflate(R.menu.menu_login, menu);
 		return true;
 	}

 	@Override
 	public boolean onOptionsItemSelected(MenuItem item) {
 		// Handle action bar item clicks here. The action bar will
 		// automatically handle clicks on the Home/Up button, so long
 		// as you specify a parent activity in AndroidManifest.xml.
 		int id = item.getItemId();
 		if (id == R.id.action_register) {
 			startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
 		}
 		return super.onOptionsItemSelected(item);
 	}
}
