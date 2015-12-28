package com.example.yueme;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity{
	
	private Toolbar toolbar;
    private EditText edtUser ;
    private EditText edtPassword ;
    private EditText edtConfirmPassword ;
    private TextView tvRegister;
	
	
	 @Override
     protected void onCreate(Bundle savedInstanceState){
    	 super.onCreate(savedInstanceState);
    	 setContentView(R.layout.activity_register);
    	 initView();
    	 initToolbar();
     }
     
	 private void  initView(){
    	 toolbar = (Toolbar) findViewById(R.id.main_toolbar);
    	 edtUser = (EditText) findViewById(R.id.edt_user);
    	 edtPassword = (EditText) findViewById(R.id.edt_password);
    	 edtPassword = (EditText) findViewById(R.id.edt_confirm_password);
    	 tvRegister = (TextView) findViewById(R.id.tv_register);
     }
	 
	 private void initToolbar(){
	    	//����Toolbar����
		    	toolbar.setTitle("ע��");
		    	//���ñ�����ɫ
		        toolbar.setTitleTextColor(Color.parseColor("#000000")); 
		        //����Ĭ�ϱ�����Ϊtoolbar
		        setSupportActionBar(toolbar);
		        //���÷��ؼ�����
		        getSupportActionBar().setHomeButtonEnabled(true); 
		        getSupportActionBar().setDisplayHomeAsUpEnabled(true);    	
		        
		        toolbar.setNavigationOnClickListener(new OnClickListener(){
		        	@Override
		        	public void onClick(View v){
		        		finish();
		        	}
		        });
	     }
}
