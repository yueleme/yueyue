package com.example.yueme;


import cn.bmob.v3.Bmob;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {
	//声明相关变量
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView lvLeftMenu;
    private String[] lvLeftMenuContent = {"首页", "我的", "我的","设置","退出"};
    private ArrayAdapter ArrayAdapter;
	private ViewPager mPage;
	private Spinner spCategory,spTime;
//	private LinearLayout layoutLogin;


	
	
	public static void actionStart(Context context) {
    	Intent intent = new Intent(context,MainActivity.class);
    	context.startActivity(intent);
    }
    

    /**
     * 初始化控件
     */
    private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawerlayout);
        lvLeftMenu = (ListView) findViewById(R.id.lv_left_menu);
        spCategory = (Spinner) findViewById(R.id.sp_category);
        spTime = (Spinner) findViewById(R.id.sp_time);
    }
    
    /**
     * 设置标题栏
     */
    private void setToolbar() {
    	//设置Toolbar标题
    	toolbar.setTitle("约    么");
    	//设置标题颜色
        toolbar.setTitleTextColor(Color.parseColor("#000000")); 
        //设置默认标题栏为toolbar
        setSupportActionBar(toolbar);
        //设置返回键可用
        getSupportActionBar().setHomeButtonEnabled(true); 
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    
    /**
     * 设置drawerLayout
     */
    private void setDrawerLayout() {
    	
    	//创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setlvLeftMenu();
    }
    
    /**
     * 设置抽屉式菜单列表
     */
    private void setlvLeftMenu(){
        ArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lvLeftMenuContent);
        lvLeftMenu.setAdapter(ArrayAdapter);
        lvLeftMenu.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				switch(position){
				case 0:
					mPage.setCurrentItem(0); 
					mDrawerLayout.closeDrawer(Gravity.LEFT);
					break;
				case 1:
					mDrawerLayout.closeDrawer(Gravity.LEFT);
					break;
				case 2:
					mDrawerLayout.closeDrawer(Gravity.LEFT);
					break;
				case 3:
					mDrawerLayout.closeDrawer(Gravity.LEFT);
					break;
				case 4:
					finish();
					break;
					
				}
			}
        	
        });

        }
        
  
    
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViews(); 
		setToolbar();
		setSpinner();
		setDrawerLayout();
		Bmob.initialize(this, "f94e9f252af3504c549b0e96cd286fc8");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_add) {
			AddNewActivity.actionStart(MainActivity.this);
		}else if(id == R.id.action_message){
			MessageActivity.actionStart(MainActivity.this);
		}
//		if (id == R.id.action_event) {
//		}else if(id == R.id.action_search) {
//		}
		return super.onOptionsItemSelected(item);
	}
	

}
