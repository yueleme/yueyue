package com.example.yueme;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class AddNewActivity extends AppCompatActivity{

	private Toolbar toolbar;
	private ImageButton imgBtnAlbum;
	private Spinner spCategory,spTime;
	private EditText edtTitle,edtLocation,edtContact,edtDescription;
	static String  path;
	final int IMAGE_CODE = 0;

	private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        imgBtnAlbum = (ImageButton) findViewById(R.id.imgbtn_album);
        spCategory = (Spinner) findViewById(R.id.sp_category);
        spTime = (Spinner) findViewById(R.id.sp_time);
        edtTitle = (EditText) findViewById(R.id.et_title);
        edtLocation = (EditText) findViewById(R.id.et_location);
        edtContact = (EditText) findViewById(R.id.et_contact);
        edtDescription = (EditText) findViewById(R.id.edt_description);
    }
	
	public static void actionStart(Context context) {
    	Intent intent = new Intent(context,AddNewActivity.class);
    	context.startActivity(intent);
    }
	
	   private void setToolbar() {
	    	//设置Toolbar标题
	    	toolbar.setTitle("发布约单");
	    	//设置标题颜色
	        toolbar.setTitleTextColor(Color.parseColor("#000000")); 
	        //设置默认标题栏为toolbar
	        setSupportActionBar(toolbar);
	        //设置返回键可用
	        getSupportActionBar().setHomeButtonEnabled(true); 
	        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	        //设置返回键事件
//	        toolbar.setNavigationIcon(R.drawable.ic_action_back);
	        toolbar.setNavigationOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					finish();
				}
	        	
	        });
	    }
	   
	   private void setSpinner() {
	    	
	    	ArrayAdapter<CharSequence> adapterQuality = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);
			adapterQuality.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spCategory.setAdapter(adapterQuality);
			spCategory.setPrompt("活动类型");
			ArrayAdapter<CharSequence> adapterNum = ArrayAdapter.createFromResource(this, R.array.time, android.R.layout.simple_spinner_item);
			adapterNum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spTime.setAdapter(adapterNum);
			spTime.setPrompt("时间");

	    }
	   
	   @Override
	    protected void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	    	setContentView(R.layout.activity_addnew);
	    	findViews();
	    	setToolbar();
	    	setSpinner();
	    	imgBtnAlbum.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根

				}
			});
	    }
	   
	   @Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.add_product, menu);
			return true;
		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// Handle action bar item clicks here. The action bar will
			// automatically handle clicks on the Home/Up button, so long
			// as you specify a parent activity in AndroidManifest.xml.
			int id = item.getItemId();
			if (id == R.id.action_add) {
				

				return true;
			}
			return super.onOptionsItemSelected(item);
		}
}
